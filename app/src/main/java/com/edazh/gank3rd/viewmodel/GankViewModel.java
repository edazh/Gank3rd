package com.edazh.gank3rd.viewmodel;

import android.app.Application;

import com.edazh.gank3rd.GankApp;
import com.edazh.gank3rd.api.Listing;
import com.edazh.gank3rd.api.NetworkState;
import com.edazh.gank3rd.db.GankRepository;
import com.edazh.gank3rd.vo.Gank;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.PagedList;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/15 0015
 * project : Gank3rd
 * description:
 */
public class GankViewModel extends AndroidViewModel {
    private final Listing<Gank> gankListing;
    private final GankRepository mRepository;
    public GankViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((GankApp) application).getRepository();
        gankListing = mRepository.getRandomGanks();
    }

    public LiveData<PagedList<Gank>> getGankList() {
        return gankListing.pagedList;
    }

    public LiveData<NetworkState> getNetWorState(){
        return gankListing.networkState;
    }

    public void refresh(){
        mRepository.refresh();
    }
}
