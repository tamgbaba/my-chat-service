package com.my;


import com.my.commons.tools.utils.IpUtils;
import com.my.modules.chatbox.entity.ChatIpEntity;
import com.my.modules.chatbox.service.ChatIpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author kejie
 * @Date 2023/3/11 20:07
 * @PackageName:com.my
 * @ClassName: ChatBoxTest
 * @Description: TODO
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChatApplication.class)
public class ChatBoxTest {
    @Autowired
    private ChatIpService service;

    @Test
    public void test(){
        ChatIpEntity chatIpEntity = new ChatIpEntity();
        service.insert(chatIpEntity);

    }
}
