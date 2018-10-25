package com.edazh.gank3rd.ui.adapter;

import androidx.annotation.LayoutRes;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/13 0013
 * project : Gank3rd
 * description:单一布局adapter基类
 */
public abstract class SingleLayoutAdapter extends BaseAdapter {
    @LayoutRes
    private final  int layoutId;



    public SingleLayoutAdapter(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }
}