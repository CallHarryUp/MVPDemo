package com.welot.newsdemomd.mvp.presenter.impl;

import android.content.Context;

import com.welot.newsdemomd.mvp.model.IImgTextModel;
import com.welot.newsdemomd.mvp.model.bean.SceneListDetail;
import com.welot.newsdemomd.mvp.model.impl.ImgTextModelImpl;
import com.welot.newsdemomd.mvp.presenter.IMeituPresenter;
import com.welot.newsdemomd.mvp.presenter.callback.OnImgTextListener;
import com.welot.newsdemomd.mvp.ui.view.IMeituMeijuView;


public class ImgTextPresenter implements IMeituPresenter, OnImgTextListener {

    private IMeituMeijuView iMeituMeijuView;//将网络请求的数据类，重新返回给View层

    private IImgTextModel iImgTextModel;//因为用户的操作 ，进行数据的改变，通知Model类进行重新的数据请求

    public ImgTextPresenter(IMeituMeijuView iMeituMeijuView) {
        this.iMeituMeijuView = iMeituMeijuView;
        this.iImgTextModel = new ImgTextModelImpl();
    }

    @Override
    public void loadImgText(Context context, boolean isFirst, String type, String page) {
        iImgTextModel.loadMeiju(context, isFirst, type, page, this);
    }

    @Override
    public void loadImgText(Context context, boolean isFirst, String page) {
        iImgTextModel.loadMeiju(context, isFirst, page, this);
    }
    //实体类监听
    @Override
    public void onSuccess(SceneListDetail sceneListDetail) {
        iMeituMeijuView.onSuccess(sceneListDetail);
    }

    @Override
    public void onError(Throwable e) {
        iMeituMeijuView.onError(e);
    }
}
