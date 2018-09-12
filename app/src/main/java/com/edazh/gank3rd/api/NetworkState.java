package com.edazh.gank3rd.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:
 */
public class NetworkState {
    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    private NetworkState(@NonNull Status status, @Nullable String message) {
        this.status = status;
        this.message = message;
    }

    public static NetworkState success() {
        return new NetworkState(Status.SUCCESS, null);
    }

    public static NetworkState loading() {
        return new NetworkState(Status.LOADING, null);
    }

    public static NetworkState error(String msg) {
        return new NetworkState(Status.ERROR, msg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkState that = (NetworkState) o;

        if (status != that.status) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NetworkState{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
