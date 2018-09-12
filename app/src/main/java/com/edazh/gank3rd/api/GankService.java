package com.edazh.gank3rd.api;

import com.edazh.gank3rd.vo.Gank;

import androidx.lifecycle.LiveData;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:
 */
public interface GankService {

    //random/data/分类/个数
    @GET("random/data/{category}/{count}")
    LiveData<ApiResponse<Gank>> getRandomGank(@Path("category") Category category, @Path("count") int count);
}
