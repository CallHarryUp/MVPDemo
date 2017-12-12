package com.welot.newsdemomd.mvp.ui.view;


import com.welot.newsdemomd.mvp.model.bean.SentenceDetail;

import java.util.List;

/**
 * 原创句子
 */
public interface IOrignalView {

    void onSuccess(List<SentenceDetail> sentenceDetails);

    void onError(Throwable e);
}
