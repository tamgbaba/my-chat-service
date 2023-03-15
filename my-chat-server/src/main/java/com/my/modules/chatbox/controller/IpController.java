package com.my.modules.chatbox.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.my.commons.tools.utils.IpUtils;
import com.my.commons.tools.utils.ResponseUtils;
import com.my.commons.tools.utils.Result;
import com.my.modules.chatbox.entity.ChatIpEntity;
import com.my.modules.chatbox.service.ChatIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @Author kejie
 * @Date 2023/3/11 21:49
 * @PackageName:com.my.modules.chatbox.controller
 * @ClassName: TestController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/ip")
public class IpController {
    @Autowired
    private ChatIpService ipService;

    private static final String UNKNOWN = "unknown";
    private static final String LOCALHOST_IP = "127.0.0.1";
    // 客户端与服务器同为一台机器，获取的 ip 有时候是 ipv6 格式
    private static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
    private static final String SEPARATOR = ",";

    @GetMapping("/local")
    public String localIp(HttpServletRequest request) {
        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCALHOST_IP.equalsIgnoreCase(ip) || LOCALHOST_IPV6.equalsIgnoreCase(ip)) {
                // 根据网卡取本机配置的 IP
                InetAddress iNet = null;
                try {
                    iNet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                if (iNet != null)
                    ip = iNet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，分割出第一个 IP
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(SEPARATOR) > 0) {
                ip = ip.substring(0, ip.indexOf(SEPARATOR));
            }
        }

        return LOCALHOST_IPV6.equals(ip) ? LOCALHOST_IP : ip;
    }


    @GetMapping("/network")
    public String network() {
        return IpUtils.getIpv4IP();
    }


    @GetMapping("/address")
    public Result<ChatIpEntity> address(HttpServletRequest request) {
        String ip = IpUtils.getIpAddr(request).trim();
        ResponseUtils info = IpUtils.getInfo(ip, "ey=ccd3c4e983a611ed96cf00163e25360e");
        Map<String, String> data = info.getData();
        ChatIpEntity chatIpEntity = BeanUtil.copyProperties(data, ChatIpEntity.class);
        chatIpEntity.setUserIp(ip);
        ipService.existNotInsert(chatIpEntity); //将请求信息放入数据库中
        return Result.ok(chatIpEntity);
    }

    private void getBean(){
        ChatIpService bean = SpringUtil.getBean(ChatIpService.class);
    }
}
