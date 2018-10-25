package com.edazh.gank3rd.db;

import android.util.Log;

import com.edazh.gank3rd.AppExecutors;
import com.edazh.gank3rd.api.ApiResponse;
import com.edazh.gank3rd.api.GankService;
import com.edazh.gank3rd.api.NetworkState;
import com.edazh.gank3rd.db.dao.GankDao;
import com.edazh.gank3rd.vo.Gank;
import com.edazh.gank3rd.vo.GankResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.PagedList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/18 0018
 * project : Gank3rd
 * description:
 */
public class GankBoundaryCallback extends PagedList.BoundaryCallback<Gank> {
    private final AppExecutors mExecutors;
    private final GankService mService;
    private final GankDao mGankDao;

    private final MutableLiveData<NetworkState> mNetworkState;

    public GankBoundaryCallback(AppExecutors appExecutors, GankService service, GankDao gankDao) {
        super();
        mExecutors = appExecutors;
        mService = service;
        mGankDao = gankDao;
        mNetworkState = new MutableLiveData<>();
    }

    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        fetchAndSaveData();
    }

    @Override
    public void onItemAtEndLoaded(@NonNull Gank itemAtEnd) {
        super.onItemAtEndLoaded(itemAtEnd);
        fetchAndSaveData();
    }

    private void fetchAndSaveData() {
        mNetworkState.setValue(NetworkState.loading());
        mService.getRandomGank("Android", 20).enqueue(new Callback<GankResponse<Gank>>() {
            @Override
            public void onResponse(@NonNull Call<GankResponse<Gank>> call,@NonNull final Response<GankResponse<Gank>> response) {
                if(!response.isSuccessful()){
                    mNetworkState.setValue(NetworkState.error("unknown error"));
                    return;
                }
                if(response.body()!=null&&!response.body().error){
                    final List<Gank> ganks = response.body().results;
                    if(ganks.size()==0){
                        mNetworkState.setValue(NetworkState.error("no content"));
                        return;
                    }
                    mNetworkState.setValue(NetworkState.success());
                    mExecutors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            mGankDao.insertAll(ganks);
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call<GankResponse<Gank>> call,@NonNull Throwable t) {
                mNetworkState.setValue(NetworkState.error(t.getMessage()));
            }
        });
    }

    public LiveData<NetworkState> getNetworkState() {
        return mNetworkState;
    }
}
