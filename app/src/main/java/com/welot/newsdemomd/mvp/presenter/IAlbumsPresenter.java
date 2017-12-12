package com.welot.newsdemomd.mvp.presenter;

import android.content.Context;

/**
 * 句集
 */
public interface IAlbumsPresenter {

    void loadAlbums(Context context, String type, String page);
}
