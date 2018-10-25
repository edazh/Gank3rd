package com.edazh.gank3rd.db;

import com.edazh.gank3rd.AppExecutors;
import com.edazh.gank3rd.api.GankService;
import com.edazh.gank3rd.api.Listing;
import com.edazh.gank3rd.vo.Gank;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/15 0015
 * project : Gank3rd
 * description:
 */
public class GankRepository {
    private static GankRepository sInstance;
    private final AppExecutors mExecutors;
    private final GankService mGankService;
    private final GankDatabase mGankDatabase;


    private GankRepository(GankDatabase database, @NonNull GankService service, AppExecutors executors) {
        mExecutors = executors;
        mGankService = service;
        mGankDatabase = database;
    }

    public static GankRepository getInstance(GankDatabase database, GankService service, AppExecutors executors) {
        if (sInstance == null) {
            synchronized (GankRepository.class) {
                if (sInstance == null) {
                    sInstance = new GankRepository(database, service, executors);
                }
            }
        }

        return sInstance;
    }

    public Listing<Gank> getRandomGanks() {
        GankBoundaryCallback boundryCallback = new GankBoundaryCallback(mExecutors, mGankService, mGankDatabase.gankDao());
        DataSource.Factory<Integer, Gank> gankFactory = mGankDatabase.gankDao().loadAll();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        LiveData<PagedList<Gank>> pagedList = new LivePagedListBuilder<>(gankFactory, config)
                .setFetchExecutor(mExecutors.diskIO())
                .setInitialLoadKey(0)
                .setBoundaryCallback(boundryCallback)
                .build();
        return new Listing<Gank>(pagedList, boundryCallback.getNetworkState());

    }

    public void refresh(){
       mExecutors.diskIO().execute(new Runnable() {
           @Override
           public void run() {
               mGankDatabase.gankDao().removeAll();
           }
       });
    }
}
