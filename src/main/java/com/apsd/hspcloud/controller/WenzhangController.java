package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.common.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WenzhangController {
    private final String host = "http://route.showapi.com";
    private final String showapi_appid = "50997";
    private final String showapi_sign = "f8053ec44d484ecca71e31ae105dfcb5";

    @PostMapping("/search")
    public Object search(@RequestParam(name = "tid" ,defaultValue = "")String tid ,
                         @RequestParam(name = "key",defaultValue = "")String key,
                         @RequestParam(name = "page",defaultValue = "1")String page){
        String path = "/90-87";
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
        querys.put("tid",tid);
        querys.put("key",key);
        querys.put("page",page);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            String s = EntityUtils.toString(response.getEntity());
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/category")
    public Object category(){
        String path = "/90-86";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            String s = EntityUtils.toString(response.getEntity());
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/details")
    public Object details(@RequestParam("detailsId")String detailsId){
        String path = "/90-88";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
        querys.put("id",detailsId);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            String s = EntityUtils.toString(response.getEntity());
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
