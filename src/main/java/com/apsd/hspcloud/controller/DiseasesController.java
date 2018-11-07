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
public class DiseasesController {
    private final String host = "http://route.showapi.com";
    private final String showapi_appid = "50997";
    private final String showapi_sign = "f8053ec44d484ecca71e31ae105dfcb5";

    @GetMapping("/subject")
    public Object getSubject(){
        String path = "/546-1";
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
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

    @GetMapping("/key")
    public Object getDiseaseByKey(String key){
        String path = "/546-2";
        String method = "GET";
//        String appcode = "你自己的AppCode";
        Map<String, String> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
//        querys.put("id","55bf04dac5479fa8da1ea2db");
        querys.put("key",key);
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);

            //获取response的body

            return  EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/info")
    public Object getDiseaseInfoById(String id){
        String path = "/546-3";
        String method = "GET";
//        String appcode = "你自己的AppCode";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
        querys.put("id",id);
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);

            //获取response的body

            return  EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //资讯分类
    @GetMapping("/in_category")
    public Object getCategory(){
        String path = "/96-108";
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
    @PostMapping("/getInfoById")
    public Object getInfoById(@RequestParam("tid")String tid ,@RequestParam(name="page",defaultValue = "1")String page){
        String path = "/96-109";
        String method = "POST";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
        querys.put("tid",tid);
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

    @GetMapping("/getInfo")
    public Object getInfo(String id){
        String path = "/96-36";
        String method = "POST";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
        querys.put("id",id);

        try {
            HttpResponse response = HttpUtils.doPost(host,path,method,headers,querys,"");
            String s = EntityUtils.toString(response.getEntity());
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
