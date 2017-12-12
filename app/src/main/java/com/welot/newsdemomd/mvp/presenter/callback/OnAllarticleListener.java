package com.welot.newsdemomd.mvp.presenter.callback;


import com.welot.newsdemomd.mvp.model.bean.SentenceSimple;

import java.util.List;

public interface OnAllarticleListener {

    void onSuccess(List<SentenceSimple> sentenceSimples);

    void onError(Throwable e);

}
