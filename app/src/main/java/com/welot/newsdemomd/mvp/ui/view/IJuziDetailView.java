package com.welot.newsdemomd.mvp.ui.view;


import com.welot.newsdemomd.mvp.model.bean.SceneListDetail;

/**
 * 句子详情
 */
public interface IJuziDetailView {

    void onSuccess(SceneListDetail sceneListDetail);

    void onError(Throwable e);
}
