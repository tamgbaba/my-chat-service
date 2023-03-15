package com.my.modules.chatbox.service.impl;


import cn.hutool.core.util.StrUtil;
import com.my.commons.mybatis.service.impl.BaseServiceImpl;
import com.my.modules.chatbox.dao.ChatIpDao;
import com.my.modules.chatbox.entity.ChatIpEntity;
import com.my.modules.chatbox.service.ChatIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author kejie
 * @Date 2023/3/11 20:05
 * @PackageName:com.my.service.impl
 * @ClassName: ChatIpServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class ChatIpServiceImpl extends BaseServiceImpl<ChatIpDao, ChatIpEntity> implements ChatIpService {

    @Autowired
    private ChatIpDao chatIpDao;

    /**
     * 记录ip地址，如果数据库中存在该数据则不进行插入
     */
    @Override
    public void existNotInsert(ChatIpEntity entity) {
        String exist = chatIpDao.exist(entity.getUserIp());
        if (!StrUtil.isNotEmpty(exist)) {
            insert(entity);
        }
    }
}
