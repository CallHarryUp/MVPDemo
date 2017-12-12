package com.welot.newsdemomd.mvp.ui.view;


import com.welot.newsdemomd.mvp.model.bean.SceneListDetail;

/**
 * 美图美句
 */
public interface IMeituMeijuView {

    void onSuccess(SceneListDetail sceneListDetail);

    void onError(Throwable e);
}
