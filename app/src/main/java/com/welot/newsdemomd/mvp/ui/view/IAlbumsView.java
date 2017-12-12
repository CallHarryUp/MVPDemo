package com.welot.newsdemomd.mvp.ui.view;


import com.welot.newsdemomd.mvp.model.bean.SentenceCollection;

import java.util.List;

/**
 * 句集
 */
public interface IAlbumsView {
    void onSuccess(List<SentenceCollection> sentenceCollections);

    void onError(Throwable e);
}
