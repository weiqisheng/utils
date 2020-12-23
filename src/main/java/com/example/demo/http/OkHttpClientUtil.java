package com.example.demo.http;


import com.squareup.okhttp.*;

import java.io.IOException;


/**
 * @author weiqisheng
 * @Title: OkHttpClientUtil
 * @ProjectName utils
 * @Description: TODO
 * @date 2020/12/2311:39
 */
public class OkHttpClientUtil {

    private static final String Authorization = "Authorization";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * get
     * @param url
     * @param token
     * @return
     */
    public static String doGet(String url,String token){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).addHeader(Authorization, token).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post
     * @param url
     * @param token
     * @param json
     * @return
     */
    public static String doPost(String url,String token,String json){
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body =RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader(Authorization, token)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
