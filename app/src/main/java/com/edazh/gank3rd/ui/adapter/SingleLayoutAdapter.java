package com.edazh.gank3rd.ui.adapter;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/13 0013
 * project : Gank3rd
 * description:单一布局adapter基类
 */
public abstract class SingleLayoutAdapter extends BaseAdapter {
    private final  int layoutId;

    public SingleLayoutAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }
}