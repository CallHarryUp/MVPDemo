package com.welot.newsdemomd.mvp.model.impl;

import android.content.Context;

import com.welot.newsdemomd.http.Api;
import com.welot.newsdemomd.http.ServiceFactory;
import com.welot.newsdemomd.http.service.SentenceService;
import com.welot.newsdemomd.mvp.model.IJuziDetailModel;
import com.welot.newsdemomd.mvp.model.bean.SceneListDetail;
import com.welot.newsdemomd.mvp.presenter.callback.OnJuziDetailListener;
import com.welot.newsdemomd.util.DocParseUtil;
import com.welot.newsdemomd.util.StringUtil;

import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JuziDetailModelImpl implements IJuziDetailModel {

    private SentenceService mSentenceService;

    private OnJuziDetailListener mListener;

    private Context mContext;

    @Override
    public void loadOriginal(Context context, boolean isFrist, String url, OnJuziDetailListener listener) {
        this.mContext = context;
        this.mListener = listener;

        this.mSentenceService = ServiceFactory.getInstance().createService(SentenceService.class, Api.BASE_URL_ORIGINAL);

        loadData(isFrist, url);
    }

    private void loadData(final boolean isFrist, String url) {

        Call<ResponseBody> call = mSentenceService.loadJuziDetail(url);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                SceneListDetail sceneListDetail = null;

                if (response != null && response.body() != null) {
                    InputStream inputStream = response.body().byteStream();

                    String result = StringUtil.inToString(inputStream);
//                    System.out.println(result);

                    try {
                        sceneListDetail = DocParseUtil.parseJuziDetail(isFrist, result);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                mListener.onSuccess(sceneListDetail);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mListener.onError(t);
            }
        });

    }


}
