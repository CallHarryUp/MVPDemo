package com.welot.newsdemomd.http;

import com.apkfuns.logutils.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * retrofit拦截  方便查看数据 更便捷的查找错误
 */
public class HttpLoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        String requestStartMessage = request.method() + ' ' + request.url();

        LogUtils.e(requestStartMessage);

        long startNs = System.nanoTime();//输出时间 精度到达纳秒级别
        Response response = chain.proceed(request);//产生响应应答请求
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        LogUtils.e(response.code() + ' ' + response.message() + " (" + tookMs + "ms" + ')');

        return response;
    }
}
