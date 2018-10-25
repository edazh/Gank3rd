package com.edazh.gank3rd.ui.adapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public abstract class SingleLayoutPagedAdapter<T> extends BasePagedAdapter<T> {
    @LayoutRes
    private final  int layoutId;

    protected SingleLayoutPagedAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback, int layoutId) {
        super(diffCallback);
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }
}
