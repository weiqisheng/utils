package com.example.demo.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiqisheng
 * @Title: Test
 * @ProjectName utils
 * @Description: TODO
 * @date 2020/12/2315:48
 */
public class Test {

    private static String url = "http://localhost:8082/api/test";
    private static String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE2MDg3MTA0MjkwNDEsImV4cCI6MTYwOTMxNTIyOX0.pl7szh15BMBQixm_2Ich3rovXhfFlAmnz7dWcgkhSZtYYcrfwfh5ll38oMZOwyoRCBJ7b-UdK91M7GhqCKRgeg";

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Authorization",token);
        System.out.println(HttpClientUtils.doGet(url, map));

        System.out.println(OkHttpClientUtil.doGet(url, token));
        System.out.println(RestTemplateUItil.doGet(url, token));
    }
}
