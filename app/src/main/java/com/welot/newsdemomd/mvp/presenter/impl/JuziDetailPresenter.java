package com.welot.newsdemomd.mvp.presenter.impl;

import android.content.Context;

import com.welot.newsdemomd.mvp.model.IJuziDetailModel;
import com.welot.newsdemomd.mvp.model.bean.SceneListDetail;
import com.welot.newsdemomd.mvp.model.impl.JuziDetailModelImpl;
import com.welot.newsdemomd.mvp.presenter.IJuziDetailPresenter;
import com.welot.newsdemomd.mvp.presenter.callback.OnJuziDetailListener;
import com.welot.newsdemomd.mvp.ui.view.IJuziDetailView;


public class JuziDetailPresenter implements IJuziDetailPresenter, OnJuziDetailListener {

    private IJuziDetailView mIJuziDetailView;

    private IJuziDetailModel mIJuziDetailModel;

    public JuziDetailPresenter(IJuziDetailView mIJuziDetailView) {
        this.mIJuziDetailView = mIJuziDetailView;
        this.mIJuziDetailModel = new JuziDetailModelImpl();
    }

    @Override
    public void onSuccess(SceneListDetail sceneListDetail) {
        mIJuziDetailView.onSuccess(sceneListDetail);
    }

    @Override
    public void onError(Throwable e) {
        mIJuziDetailView.onError(e);
    }

    @Override
    public void loadJuziDetail(Context context, boolean isFrist, String url) {
        mIJuziDetailModel.loadOriginal(context, isFrist, url, this);
    }
}
