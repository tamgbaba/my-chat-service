package com.my.modules.chatbox.service;

import com.my.commons.mybatis.service.BaseService;
import com.my.commons.mybatis.service.impl.BaseServiceImpl;
import com.my.modules.chatbox.dao.ChatIpDao;
import com.my.modules.chatbox.entity.ChatIpEntity;


/**
 * @Author kejie
 * @Date 2023/3/11 13:55
 * @PackageName:com.my.modules.chatbox.service.impl
 * @ClassName: ChatIpService
 * @Description: TODO
 * @Version 1.0
 */
public interface ChatIpService extends BaseService<ChatIpEntity> {

    void existNotInsert(ChatIpEntity entity);
}
