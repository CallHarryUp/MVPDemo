package com.welot.newsdemomd.mvp.presenter.callback;


import com.welot.newsdemomd.mvp.model.bean.SceneListDetail;

public interface OnImgTextListener {

    void onSuccess(SceneListDetail sceneListDetail);

    void onError(Throwable e);

}
