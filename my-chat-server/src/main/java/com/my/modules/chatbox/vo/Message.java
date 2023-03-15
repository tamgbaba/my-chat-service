package com.my.modules.chatbox.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author kejie
 * @Date 2023/3/13 16:57
 * @PackageName:com.my.modules.chatbox.vo
 * @ClassName: Message
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class Message {
    //时间
    private String time;
    //接收方
    private String to;
    //发送方
    private String from;
    //消息
    private String msg;
    //登录用户名
    private List<String> userIps;
}
