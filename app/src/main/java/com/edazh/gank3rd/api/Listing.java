package com.edazh.gank3rd.api;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public class Listing<T> {
    public final LiveData<PagedList<T>> pagedList;
    public final LiveData<NetworkState> networkState;
    private RetryListener retryListener = null;
    private RefreshListener refreshListener = null;

    public Listing(LiveData<PagedList<T>> pagedList, LiveData<NetworkState> networkState) {
        this.pagedList = pagedList;
        this.networkState = networkState;
    }

    public void setRetryListener(RetryListener retryListener) {
        this.retryListener = retryListener;
    }

    public void setRefreshListener(RefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }

    public interface RetryListener {
        void onRetry();
    }

    public interface RefreshListener {
        void onRefresh();
    }
}
