package com.edazh.gank3rd.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/15 0015
 * project : Gank3rd
 * description:一个通用类，它描述具有状态的数据
 */
public class Resource<T> {
    @NonNull
    public final Status status;
    @Nullable
    public final T data;

    @Nullable public final String message;
    private Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(Status.ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.LOADING, data, null);
    }
}
