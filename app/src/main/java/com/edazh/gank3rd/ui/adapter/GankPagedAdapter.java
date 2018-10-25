package com.edazh.gank3rd.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.edazh.gank3rd.databinding.ItemGankBinding;
import com.edazh.gank3rd.vo.Gank;

import java.util.Objects;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class GankPagedAdapter extends SingleLayoutPagedAdapter<Gank> {

    public GankPagedAdapter(@LayoutRes int layoutId) {
        super(DIFF_CALLBACK, layoutId);
    }

    /**
     * 对比item
     */
    private static final DiffUtil.ItemCallback<Gank> DIFF_CALLBACK = new DiffUtil.ItemCallback<Gank>() {
        @Override
        public boolean areItemsTheSame(@NonNull Gank oldItem, @NonNull Gank newItem) {
            return Objects.equals(oldItem.id, newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Gank oldItem, @NonNull Gank newItem) {
            return Objects.equals(oldItem, newItem);
        }
    };
}
