package com.edazh.gank3rd.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.edazh.gank3rd.BR;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/12 0012
 * project : Gank3rd
 * description:
 */
public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,viewType,parent,false);
        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Object item = getItemForPosition(position);
        holder.bind(item);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }


    /**
     * 通过position获取对应的Item
     * @param position list中的positon
     * @return  对应的item
     */
    protected  abstract Object getItemForPosition(int position);

    /**
     * 通过position获取对应的layoutID
     * @param position list中的positon
     * @return 对应的layoutID
     */
    protected abstract int getLayoutIdForPosition(int position);

    static class BaseViewHolder extends RecyclerView.ViewHolder{
        private final ViewDataBinding mBinding;
        BaseViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
        }
        void bind(Object item){
            mBinding.setVariable(BR.item,item);
            mBinding.executePendingBindings();
        }
    }
}

