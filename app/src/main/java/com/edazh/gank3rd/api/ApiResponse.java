package com.edazh.gank3rd.api;

import androidx.annotation.Nullable;
import retrofit2.Response;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:
 */
public class ApiResponse<T> {
    public final int code;

    @Nullable
    public final T body;

    @Nullable
    public final String errorMessage;

    public ApiResponse(Throwable error) {
        code = 500;
        body = null;
        errorMessage = error.getMessage();
    }

    public ApiResponse(Response<T> response) {
        code = response.code();
        body = response.body();
        errorMessage = null;
    }

    public boolean isSuccessful() {
        return code >= 200 && code < 300;
    }
}
