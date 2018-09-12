package com.edazh.gank3rd.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/12 0012
 * project : Gank3rd
 * description:
 */
public class BindingAdapters {
    @BindingAdapter("bindSrc")
    public static void bindUrl2Image(ImageView imageView, String src) {
        Glide.with(imageView.getContext()).load(src).into(imageView);
    }
}