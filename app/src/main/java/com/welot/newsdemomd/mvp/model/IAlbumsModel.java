package com.welot.newsdemomd.mvp.model;

import android.content.Context;

import com.welot.newsdemomd.mvp.presenter.callback.OnAlbumsListener;


/**
 * 原创句子
 */
public interface IAlbumsModel {

    void loadAlbums(Context context, String type, String page, OnAlbumsListener listener);

}
