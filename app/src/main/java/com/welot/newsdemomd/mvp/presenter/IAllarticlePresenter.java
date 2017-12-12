package com.welot.newsdemomd.mvp.presenter;

import android.content.Context;

/**
 * 名人名句
 */
public interface IAllarticlePresenter {

    void loadAllarticle(Context context, String type, String page);

}
