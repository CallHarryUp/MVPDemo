package com.welot.newsdemomd.mvp.model;

import android.content.Context;

import com.welot.newsdemomd.mvp.presenter.callback.OnJuziDetailListener;


public interface IJuziDetailModel {

    void loadOriginal(Context context, boolean isFrist, String url, OnJuziDetailListener listener);
}
