package com.edazh.gank3rd.api;

import com.edazh.gank3rd.vo.Gank;
import com.edazh.gank3rd.vo.GankResponse;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Response;
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
    Call<GankResponse<Gank>> getRandomGank(@Path("category") String category, @Path("count") int count);
}
