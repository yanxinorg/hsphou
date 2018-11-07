package com.apsd.hspcloud.controller;


import com.apsd.hspcloud.common.JsonUtils;
import com.apsd.hspcloud.service.UserService;
import com.apsd.hspcloud.vo.SocketMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{id}")
@Component
public class WebSocketServer {
    @Autowired
    private UserService userService;

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet =
            new CopyOnWriteArraySet<WebSocketServer>();

    //用来记录Id和该session进行绑定
    private static Map<String,Session> map = new HashMap<String,Session>();
    private Session session;
    private String id;
    @OnOpen
    public void onOpen(Session session,
                       @PathParam("id") String id) throws IOException {
        this.session = session;
        this.id = id;

        map.put(id,session);
        webSocketSet.add(this);
        System.out.println("id:"+id);
        onlineAdd();
        if(!id.contains("+")){
            List<String> slist = new ArrayList<>();
            System.out.println("======");
            for (String key :map.keySet()) {
                if(key.endsWith(id) && !key.equals(id)){
                    String uid = key.substring(0,key.indexOf("+"));
                    System.out.println(uid);
                    slist.add(uid);
                }
            }
            this.session.getAsyncRemote().sendText(JsonUtils.objectToJson(slist));
        }
    }
    //收到客户端消息后调用的方法
    @OnMessage
    public void onMessage(String message,Session session) throws IOException {

        System.out.println("来自--的消息"+message);

        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsg socketMsg;
        try {
            socketMsg = objectMapper.readValue(message,SocketMsg.class);
            Session fromSession = map.get(id);
            Session toSession = map.get(socketMsg.getTo());
            //发送给发送者
//            fromSession.getAsyncRemote().sendText(socketMsg.getMsg());
            //发送给接收者
            toSession.getAsyncRemote().sendText(socketMsg.getMsg());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @OnClose
    public void close(){

        webSocketSet.remove(this);
        onlineSub();
    }
    @OnError
    public void onError(Session session,Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }
    public synchronized  void onlineAdd(){
        onlineCount++;
    }
    public synchronized void onlineSub(){
        onlineCount--;
    }
    //发生错误时调用的方法

}