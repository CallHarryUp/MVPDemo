package com.welot.newsdemomd.mvp.model.impl;

import android.content.Context;
import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;
import com.welot.newsdemomd.http.Api;
import com.welot.newsdemomd.http.ServiceFactory;
import com.welot.newsdemomd.http.service.SentenceService;
import com.welot.newsdemomd.mvp.model.IImgTextModel;
import com.welot.newsdemomd.mvp.model.bean.SceneListDetail;
import com.welot.newsdemomd.mvp.presenter.callback.OnImgTextListener;
import com.welot.newsdemomd.util.DocParseUtil;
import com.welot.newsdemomd.util.StringUtil;

import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//实现类进行真正的数据请求的操作
public class ImgTextModelImpl implements IImgTextModel {
    //服务接口
    private SentenceService mSentenceService;
    //请求完数据的监听
    private OnImgTextListener mListener;

    private Context mContext;
   //两个构造参数  区别主要是在于 默认加载第一页时候是不需要添加类型的
    @Override
    public void loadMeiju(Context context, boolean isFirst, String type, String page, OnImgTextListener listener) {

        this.mContext = context;
        this.mListener = listener;
        // 实例化Service
        this.mSentenceService = ServiceFactory.getInstance().createService(SentenceService.class, Api.BASE_URL_MEITUMEIJU);

        loadMeiju(isFirst, type, page);

    }

    @Override
    public void loadMeiju(Context context, boolean isFirst, String page, OnImgTextListener listener) {

        this.mContext = context;
        this.mListener = listener;

        this.mSentenceService = ServiceFactory.getInstance().createService(SentenceService.class, Api.BASE_URL_MEITUMEIJU);

        loadMeiju(isFirst, null, page);
    }

    private void loadMeiju(final boolean isFirst, String type, String page) {

        Call<ResponseBody> call = null;
        //默认加载第一个页面
        if (TextUtils.isEmpty(type)) {

            String url = Api.BASE_URL_MEITUMEIJU;

            if (!TextUtils.isEmpty(page)) {
                url = url + "?page=" + page;
            }

            call = mSentenceService.loadMeiju(url);
        } else {

            call = mSentenceService.loadMeiju(type, page);
        }

       //网络数据请求
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response != null && response.body() != null) {
                    InputStream inputStream = response.body().byteStream();

                    String result = StringUtil.inToString(inputStream);

                    SceneListDetail sceneListDetail = DocParseUtil.parseMeiju(isFirst, result);
                    //数据请求成功，通知View层进行数据更新
                    mListener.onSuccess(sceneListDetail);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                LogUtils.e(t);
                mListener.onError(t);
            }
        });

    }


}
