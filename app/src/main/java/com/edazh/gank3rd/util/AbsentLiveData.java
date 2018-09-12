package com.edazh.gank3rd.util;

import androidx.lifecycle.LiveData;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:空LiveData
 */
public class AbsentLiveData<T> extends LiveData<T> {

    private AbsentLiveData() {
        super();
        postValue(null);
    }

    public static <T> LiveData<T> create() {
        return new AbsentLiveData<>();
    }
}
