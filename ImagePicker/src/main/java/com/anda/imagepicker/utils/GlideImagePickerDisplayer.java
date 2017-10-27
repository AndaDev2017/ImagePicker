package com.anda.imagepicker.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Glide实现的图片加载
 */
public class GlideImagePickerDisplayer implements IImagePickerDisplayer {
    @Override
    public void display(Context context, String url, ImageView imageView, int maxWidth, int maxHeight) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(new RequestOptions()
                        .override(maxWidth, maxHeight)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
                .into(imageView);
    }

    @Override
    public void display(Context context, String url, ImageView imageView, int placeHolder, int errorHolder, int maxWidth, int maxHeight) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(placeHolder)
                        .error(errorHolder)
                        .override(maxWidth, maxHeight)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
                .into(imageView);
    }
}
