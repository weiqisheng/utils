package com.example.demo.http;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author weiqisheng
 * @Title: HttpClientUtils
 * @ProjectName utils
 * @Description: TODO httpClient工具类实现
 * @date 2020/12/2310:50
 */
public class HttpClientUtils {

    /**
     * 调用get方法
     * @param url
     * @param headMap
     * @return
     */
    public static String doGet(String url, Map<String,String> headMap){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        try {
            if (!headMap.isEmpty()){
                for (Map.Entry<String, String> entry : headMap.entrySet()) {
                    get.setHeader(entry.getKey(),entry.getValue());
                }
            }
            HttpResponse response = httpClient.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String resultStr = EntityUtils.toString(response.getEntity());
                return  resultStr;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post方法
     * @param url
     * @param paramMap
     * @param headMap
     * @return
     */
    public static String doPost(String url,Map<String,String> paramMap,Map<String,String> headMap){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost();
        try {
            if (!headMap.isEmpty()){
                for (Map.Entry<String, String> entry : headMap.entrySet()) {
                    post.setHeader(entry.getKey(),entry.getValue());
                }
            }
            //表单提交
//            List<NameValuePair> valuePairs = new ArrayList<>();
//            if (!paramMap.isEmpty()){
//                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
//                    valuePairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
//                }
//            }
//            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairs);
            //实体提交
            StringEntity stringEntity = new StringEntity(new Gson().toJson(paramMap));
            post.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String resultStr = EntityUtils.toString(response.getEntity());
                return resultStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
