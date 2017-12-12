package com.welot.newsdemomd.mvp.presenter.callback;


import com.welot.newsdemomd.mvp.model.bean.SentenceCollection;

import java.util.List;

public interface OnAlbumsListener {

    void onSuccess(List<SentenceCollection> sentenceCollections);

    void onError(Throwable e);

}
