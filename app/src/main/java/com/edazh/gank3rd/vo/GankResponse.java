package com.edazh.gank3rd.vo;

import java.util.List;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/15 0015
 * project : Gank3rd
 * description:
 */
public class GankResponse<T> {
    public final boolean error;
    public final List<T> results;

    public GankResponse(boolean error, List<T> results) {
        this.error = error;
        this.results = results;
    }
}
