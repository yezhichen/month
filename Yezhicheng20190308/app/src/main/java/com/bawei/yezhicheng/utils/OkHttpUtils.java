package com.bawei.yezhicheng.utils;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 叶至成 on 2019/3/8.
 */
public class OkHttpUtils {
    //封装单例模式
    private static OkHttpUtils okHttpUtils = null;

    public OkHttpUtils() {
    }
    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }
    private static OkHttpClient okHttpClient = null;
    public static synchronized OkHttpClient getOkHttp(){
        //创建日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("ss", "log: "+message);
            }
        });
        if (okHttpClient==null){
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                          Request request= chain.request().newBuilder()
                                  .addHeader("source","android")
                                  .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();
        }
        return okHttpClient;
    }
    //get
    public static void getData(String url, Callback callback){
        OkHttpClient okHttp = getOkHttp();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttp.newCall(request);
        call.enqueue(callback);
    }
    //post
    public static void postDat(String url, Map<String,String> map,Callback callback){
        OkHttpClient okHttp = getOkHttp();
        FormBody.Builder builder = new FormBody.Builder();
        for (String key:map.keySet()){
            builder.add(key,map.get(key));
        }
        FormBody build = builder.build();
        Request request = new Request.Builder().post(build).url(url).build();
        Call call = okHttp.newCall(request);
        call.enqueue(callback);
    }
}
