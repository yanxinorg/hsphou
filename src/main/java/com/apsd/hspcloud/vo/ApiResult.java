package com.apsd.hspcloud.vo;

public class ApiResult {
    private ApiBody showapi_res_body;

    public void setShowapi_res_body(ApiBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public ApiBody getShowapi_res_body() {
        return showapi_res_body;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "showapi_res_body=" + showapi_res_body +
                '}';
    }
}
