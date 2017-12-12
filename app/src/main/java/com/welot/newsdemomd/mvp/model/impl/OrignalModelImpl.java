package com.welot.newsdemomd.mvp.model.impl;

import android.content.Context;

import com.welot.newsdemomd.http.Api;
import com.welot.newsdemomd.http.ServiceFactory;
import com.welot.newsdemomd.http.service.SentenceService;
import com.welot.newsdemomd.mvp.model.IOrignalModel;
import com.welot.newsdemomd.mvp.model.bean.SentenceDetail;
import com.welot.newsdemomd.mvp.presenter.callback.OnOrinalListener;
import com.welot.newsdemomd.util.DocParseUtil;
import com.welot.newsdemomd.util.StringUtil;

import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrignalModelImpl implements IOrignalModel {

    private SentenceService mSentenceService;

    private OnOrinalListener mListener;

    private Context mContext;

    @Override
    public void loadOriginal(Context context, String type, String page, OnOrinalListener listener) {

        this.mContext = context;
        this.mListener = listener;

        this.mSentenceService = ServiceFactory.getInstance().createService(SentenceService.class, Api.BASE_URL_ORIGINAL);

        loadOriginal(type, page);
    }

    private void loadOriginal(String type, String page) {

        Call<ResponseBody> call = mSentenceService.loadOrignal(type, page);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                InputStream inputStream = response.body().byteStream();

                String result = StringUtil.inToString(inputStream);

                List<SentenceDetail> sentenceDetails = null;
                try {
                    sentenceDetails = DocParseUtil.parseOrignal(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mListener.onSuccess(sentenceDetails);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mListener.onError(t);
            }
        });

    }
}
