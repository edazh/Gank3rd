package com.edazh.gank3rd;

import android.app.Application;

import com.edazh.gank3rd.api.GankService;
import com.edazh.gank3rd.api.LiveDataCallAdapterFactory;
import com.edazh.gank3rd.util.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:
 */
public class GankApp extends Application {
    private AppExecutors mExecutors;
    private static GankService mService;

    @Override
    public void onCreate() {
        super.onCreate();
        mExecutors = new AppExecutors();
    }

    public GankService getService() {
        if (mService == null) {
            synchronized (GankService.class) {
                if (mService == null) {
                    mService = new Retrofit.Builder()
                            .baseUrl(Constant.Network.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                            .build()
                            .create(GankService.class);
                }
            }
        }
        return mService;
    }
}
