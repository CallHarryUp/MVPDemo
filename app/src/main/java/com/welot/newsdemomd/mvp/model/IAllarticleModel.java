package com.welot.newsdemomd.mvp.model;

import android.content.Context;

import com.welot.newsdemomd.mvp.presenter.callback.OnAllarticleListener;


/**
 * 名人名句
 */
public interface IAllarticleModel {

    void loadArticle(Context context, String type, String page, OnAllarticleListener listener);

}
