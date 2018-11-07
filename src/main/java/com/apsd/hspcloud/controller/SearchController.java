package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.common.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SearchController {
    private final String host = "http://apis.map.qq.com";
    private final String path = "/ws/place/v1/search";
    private final String method = "GET";
    private String boundary = "";

    @GetMapping("/getSearch")
    public Object getSerch(String latitude ,String longitude ,String keyword){
        boundary = "nearby("+latitude+","+longitude+",1000)";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("boundary",boundary);
        querys.put("page_size","20");
        querys.put("page_index","1");
        querys.put("keyword",keyword);
        querys.put("orderby","_distance");
        querys.put("key","JGQBZ-APURG-U7QQX-IYAZI-ZR643-7WBKJ");

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
