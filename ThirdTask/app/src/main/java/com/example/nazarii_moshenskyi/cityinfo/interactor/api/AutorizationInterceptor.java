package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AutorizationInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder requestBuilder = originalRequest.newBuilder()
                .header("x-api-key", BuildConfig.API_KEY);

        Request requestWithKey = requestBuilder.build();

        return chain.proceed(requestWithKey);
    }
}
