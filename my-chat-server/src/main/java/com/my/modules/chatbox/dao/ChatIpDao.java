package com.my.modules.chatbox.dao;


import com.my.commons.mybatis.dao.BaseDao;
import com.my.modules.chatbox.entity.ChatIpEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author kejie
 * @Date 2023/3/11 13:54
 * @PackageName:com.my.modules.chatbox.dao
 * @ClassName: ChatIpDao
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface ChatIpDao extends BaseDao<ChatIpEntity> {
    String exist(String userIp);
}
