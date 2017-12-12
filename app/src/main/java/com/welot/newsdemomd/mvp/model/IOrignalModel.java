package com.welot.newsdemomd.mvp.model;

import android.content.Context;

import com.welot.newsdemomd.mvp.presenter.callback.OnOrinalListener;


/**
 * 原创句子
 */
public interface IOrignalModel {

    void loadOriginal(Context context, String type, String page, OnOrinalListener listener);

}
