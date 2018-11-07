package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.common.HttpUtils;
import com.apsd.hspcloud.common.JsonUtils;
import com.apsd.hspcloud.service.HospitalService;
import com.apsd.hspcloud.vo.Hospital;
import com.apsd.hspcloud.vo.HospitalDataVo;
import com.apsd.hspcloud.vo.HospitalVo;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    private final String host = "http://route.showapi.com";
    private final String showapi_appid = "50997";
    private final String showapi_sign = "f8053ec44d484ecca71e31ae105dfcb5";

    @GetMapping("/search_hos")
    public Object SearchHospital() {
        String path = "/87-60";
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("showapi_appid",showapi_appid);
        querys.put("showapi_sign",showapi_sign );
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            EntityUtils.toString(response.getEntity());
            return  EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    //腾讯的搜索医院
    @GetMapping("/getHospital")
    public List<Hospital> getHospital(String latitude ,String longitude){
        String host = "http://apis.map.qq.com";
        String path = "/ws/place/v1/search";
        String method = "GET";
        String boundary = "";
        boundary = "nearby("+latitude+","+longitude+",1000)";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> querys = new HashMap<>();
        querys.put("boundary",boundary);
        querys.put("page_size","20");
        querys.put("page_index","1");
        querys.put("keyword","医院");
        querys.put("orderby","_distance");
        querys.put("key","JGQBZ-APURG-U7QQX-IYAZI-ZR643-7WBKJ");

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            String s = EntityUtils.toString(response.getEntity());
            HospitalDataVo hospitalData = JsonUtils.jsonToPojo(s, HospitalDataVo.class);
            List<HospitalVo> hospitalList = hospitalData.getData();
            List<Hospital> hospitalList1 = hospitalService.getHospitalList(hospitalList);
            return hospitalList1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
