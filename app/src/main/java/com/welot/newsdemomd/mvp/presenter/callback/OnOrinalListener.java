package com.welot.newsdemomd.mvp.presenter.callback;


import com.welot.newsdemomd.mvp.model.bean.SentenceDetail;

import java.util.List;

public interface OnOrinalListener {

    void onSuccess(List<SentenceDetail> sentenceDetails);

    void onError(Throwable e);

}
