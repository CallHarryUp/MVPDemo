package com.welot.newsdemomd.mvp.presenter.impl;

import android.content.Context;

import com.welot.newsdemomd.mvp.model.IAlbumsModel;
import com.welot.newsdemomd.mvp.model.bean.SentenceCollection;
import com.welot.newsdemomd.mvp.model.impl.AlbumsModelImpl;
import com.welot.newsdemomd.mvp.presenter.IAlbumsPresenter;
import com.welot.newsdemomd.mvp.presenter.callback.OnAlbumsListener;
import com.welot.newsdemomd.mvp.ui.view.IAlbumsView;

import java.util.List;


public class AlbumsPresenter implements IAlbumsPresenter, OnAlbumsListener {

    private IAlbumsView iAlbumsView;

    private IAlbumsModel iAlbumsModel;

    public AlbumsPresenter(IAlbumsView iAlbumsView) {
        this.iAlbumsView = iAlbumsView;
        this.iAlbumsModel = new AlbumsModelImpl();
    }

    @Override
    public void onSuccess(List<SentenceCollection> sentenceCollections) {
        iAlbumsView.onSuccess(sentenceCollections);
    }

    @Override
    public void onError(Throwable e) {
        iAlbumsView.onError(e);
    }

    @Override
    public void loadAlbums(Context context, String type, String page) {
        iAlbumsModel.loadAlbums(context, type, page, this);
    }
}
