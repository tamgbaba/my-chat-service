package com.my.modules.chatbox.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.my.commons.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Author kejie
 * @Date 2023/3/11 20:09
 * @PackageName:com.my.modules.chatbox.entity
 * @ClassName: ChatEntity
 * @Description: TODO
 * @Version 1.0
 */
@TableName(value = "chat_ip")
@Data
@EqualsAndHashCode(callSuper = false)
public class ChatIpEntity extends BaseEntity {
    /**
     * 用户ip
     */
    private String userIp;
    /**
     * 修改时间
     */
    private LocalDateTime updateDate;
    /**
     * ip所属国家
     */
    private String country;

    /**
     * ip 所属省份
     */
    private String province;

    /***/
    /**
     * IPS所属城市
     */
    private String city;

    /**
     * 经度
     */
    private String latitude;

    /**
     * 纬度
     */
    private String longitude;

    /**
     * ip版本
     */
    private String version;

    /**
     *所属网络服务提供者
     */
    private String isp;
}
