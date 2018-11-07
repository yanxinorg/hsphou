package com.apsd.hspcloud.service.impl;

import com.apsd.hspcloud.common.HttpUtils;
import com.apsd.hspcloud.common.JsonUtils;
import com.apsd.hspcloud.service.HospitalService;
import com.apsd.hspcloud.vo.ApiBody;
import com.apsd.hspcloud.vo.ApiResult;
import com.apsd.hspcloud.vo.Hospital;
import com.apsd.hspcloud.vo.HospitalVo;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class HospitalServiceImpl implements HospitalService{
    private final String host = "http://route.showapi.com";
    private final String showapi_appid = "50997";
    private final String showapi_sign = "f8053ec44d484ecca71e31ae105dfcb5";
    @Override
    public List<Hospital> getHospitalList(List<HospitalVo> hospitalList) {
        List<Hospital> hospitals = new ArrayList<>();
        for (HospitalVo hospitalVo:hospitalList) {
            String title = hospitalVo.getTitle();
            String path = "/87-60";
            String method = "GET";
            Map<String, String> headers = new HashMap<>();
            Map<String, String> querys = new HashMap<>();
            querys.put("showapi_appid",showapi_appid);
            querys.put("showapi_sign",showapi_sign );
            querys.put("hosName",title);
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                String s = EntityUtils.toString(response.getEntity());
                ApiResult apiResult = JsonUtils.jsonToPojo(s, ApiResult.class);
                ApiBody apiBody = apiResult.getShowapi_res_body();
                if(apiBody.getRet_code()=="0"){
                    List<Hospital> hospitalList1 = apiBody.getHospitalList();
                    hospitals.addAll(hospitalList1);
                }else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hospitals;
    }
}
