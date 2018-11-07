package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.pojo.ChatResult;
import com.apsd.hspcloud.pojo.WxLoginResult;
import com.apsd.hspcloud.utils.FastJsonUtils;
import com.apsd.hspcloud.utils.HttpRequestUtil;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("chat")
public class ChatController {
    private Integer count;
    private String SECRET = "fe78eaf18a20621c4099d562bb0d1875";
    private String APPID = "wx24bbd076cf5e8984";
    private String JS_CODE;
    @RequestMapping(value = "/random",method = RequestMethod.POST)
    public ChatResult randomChat(){

        //用户随机分配聊天室
        Random random  = new Random();
        int i = random.nextInt(3);
        return new ChatResult(100,"分配成功",i);

    }
    @PostMapping("/login/{code}")
    public ChatResult auth(@PathVariable("code")String code){
        WxLoginResult wxLoginResult = null;
        JS_CODE = code;
        String msg;
        String loginValidURL = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+JS_CODE+"&grant_type=authorization_code";
        try {
            wxLoginResult = FastJsonUtils.toBean(HttpRequestUtil.get(loginValidURL), WxLoginResult.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(wxLoginResult.getOpenid());
        return new ChatResult(200,"success",wxLoginResult.getOpenid());
    }

}
