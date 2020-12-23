package com.example.demo.http;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.MediaType;
import org.apache.http.client.methods.HttpPost;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author weiqisheng
 * @Title: RestTemplateUItil
 * @ProjectName utils
 * @Description: TODO
 * @date 2020/12/2314:23
 */
public class RestTemplateUItil {

    private static final String Authorization = "Authorization";

    private static final MediaType type = MediaType.parse("application/json");

    public static String doGet(String url,String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(Authorization,token);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
        return responseEntity.getBody();
    }

    public static String doPost(String url, String token, JSONObject jsonObject){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(Authorization,token);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(url,
                HttpMethod.POST, entity, String.class);
        return exchange.getBody();
    }
}
