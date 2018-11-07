package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.common.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodeController {

    @GetMapping("/code")
    public Object getOpenid(String code){
        System.out.println(code);
        String host = "https://api.weixin.qq.com";
        String path = "/sns/jscode2session";
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("appid","wx24bbd076cf5e8984");
        querys.put("secret","fe78eaf18a20621c4099d562bb0d1875" );
        querys.put("js_code",code);
        querys.put("grant_type","authorization_code");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            return  EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/getMyAddress")
    public Object getAddress(String latitude,String longitude){
        String location = latitude+","+longitude;
        String host = "http://api.map.baidu.com";
        String path = "/geocoder/v2/";
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("ak","LClVsCTaW2aH8MzuviP1YMymrHWOIVvg");
        querys.put("coordtype","gcj02ll");
        querys.put("location",location);
        querys.put("output","json");
        querys.put("pois","0");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            return  EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
