package com.welot.newsdemomd.mvp.presenter.impl;

import android.content.Context;

import com.welot.newsdemomd.mvp.model.IOrignalModel;
import com.welot.newsdemomd.mvp.model.bean.SentenceDetail;
import com.welot.newsdemomd.mvp.model.impl.OrignalModelImpl;
import com.welot.newsdemomd.mvp.presenter.IOrignalPresenter;
import com.welot.newsdemomd.mvp.presenter.callback.OnOrinalListener;
import com.welot.newsdemomd.mvp.ui.view.IOrignalView;

import java.util.List;


public class OrignalPresenter implements IOrignalPresenter, OnOrinalListener {

    private IOrignalView iOrignalView;

    private IOrignalModel iOrignalModel;

    public OrignalPresenter(IOrignalView iOrignalView) {
        this.iOrignalView = iOrignalView;
        this.iOrignalModel = new OrignalModelImpl();
    }

    @Override
    public void loadOriginal(Context context, String type, String page) {
        iOrignalModel.loadOriginal(context, type, page, this);
    }

    @Override
    public void onSuccess(List<SentenceDetail> sentenceDetails) {
        iOrignalView.onSuccess(sentenceDetails);
    }

    @Override
    public void onError(Throwable e) {
        iOrignalView.onError(e);
    }
}
