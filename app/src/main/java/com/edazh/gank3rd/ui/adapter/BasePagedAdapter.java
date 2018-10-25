package com.edazh.gank3rd.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.edazh.gank3rd.BR;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BasePagedAdapter<T> extends PagedListAdapter<T, BasePagedAdapter.BaseViewHolder> {

    protected BasePagedAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,viewType,parent,false);
        return new BasePagedAdapter.BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

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
