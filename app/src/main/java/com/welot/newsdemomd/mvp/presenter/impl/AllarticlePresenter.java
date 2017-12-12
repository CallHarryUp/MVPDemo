package com.welot.newsdemomd.mvp.presenter.impl;

import android.content.Context;

import com.welot.newsdemomd.mvp.model.IAllarticleModel;
import com.welot.newsdemomd.mvp.model.bean.SentenceSimple;
import com.welot.newsdemomd.mvp.model.impl.AllarticleModelImpl;
import com.welot.newsdemomd.mvp.presenter.IAllarticlePresenter;
import com.welot.newsdemomd.mvp.presenter.callback.OnAllarticleListener;
import com.welot.newsdemomd.mvp.ui.view.IAllarticleView;

import java.util.List;


public class AllarticlePresenter implements IAllarticlePresenter, OnAllarticleListener {

    private IAllarticleView iAllarticleView;

    private IAllarticleModel iAllarticleModel;

    public AllarticlePresenter(IAllarticleView iAllarticleView) {
        this.iAllarticleView = iAllarticleView;
        this.iAllarticleModel = new AllarticleModelImpl();
    }

    @Override
    public void loadAllarticle(Context context, String type, String page) {
        iAllarticleModel.loadArticle(context, type, page, this);
    }

    @Override
    public void onSuccess(List<SentenceSimple> sentenceSimples) {
        iAllarticleView.onSuccess(sentenceSimples);
    }

    @Override
    public void onError(Throwable e) {
        iAllarticleView.onError(e);
    }
}
