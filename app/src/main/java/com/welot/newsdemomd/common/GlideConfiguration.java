package com.welot.newsdemomd.common;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;
//1.自定义glide 重写方法改变Glide的配置  继承自Glide都是Public的
//2.需要在Mainifest中定义meta_data
public class GlideConfiguration implements GlideModule {

    public static final int IMAGE_DISK_CACHE_MAX_SIZE = 300 * 1024 * 1024; //图片缓存文件最大值为300Mb

    @Override
    public void applyOptions(final Context context, GlideBuilder builder) {

        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);

        builder.setMemoryCache(new LruResourceCache(IMAGE_DISK_CACHE_MAX_SIZE));
        builder.setBitmapPool(new LruBitmapPool(IMAGE_DISK_CACHE_MAX_SIZE));

    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}