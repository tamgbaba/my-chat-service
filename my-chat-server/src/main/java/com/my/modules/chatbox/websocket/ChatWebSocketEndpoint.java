package com.my.modules.chatbox.websocket;


import com.alibaba.fastjson.JSONObject;
import com.my.commons.tools.utils.IpUtils;
import com.my.modules.chatbox.entity.ChatIpEntity;
import com.my.modules.chatbox.vo.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author kejie
 * @Date 2023/3/11 21:22
 * @PackageName:com.my.modules.chatbox.websocket
 * @ClassName: ChatWebSocket
 * @Description: TODO
 * @Version 1.0
 */
@ServerEndpoint("/share/{userIp}")
@Component
public class ChatWebSocketEndpoint {

    private static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    private Session session;

    private HttpSession httpSession;

    /**
     * 把登录的用户，我们使用ip作为本次session 的key
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config, @PathParam("userIp") String userIp) {
        sessionMap.put(userIp, session);
        //发送登录人员消息给所有的客户端
        sendAllMessage(userIp);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println(message);
        sendAllMessage(message);

    }

    @OnClose
    public void onClose(Session session, @PathParam("userIp") String userIp) {
        sessionMap.remove(userIp);
        sendAllMessage(setUserList());
    }

    private String setUserList() {
        ArrayList<String> list = new ArrayList<>();
        sessionMap.keySet().forEach(a -> {
            list.add(a);
        });
        Message message = new Message();
        message.setUserIps(list);
        return JSONObject.toJSONString(message);
    }


    private void sendMessage(String message, Session toSession) {
        try {
            toSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void sendAllMessage(String message) {
        sessionMap.values().forEach(userSession -> {
            try {
                userSession.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
