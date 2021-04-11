package com.lxyz.redis.utils;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

/**
 * 枚举类
 *
 * @author lbf
 * @date 2021/4/10
 */
@Getter
public enum ExpireEnum {


    //未读消息的有效期为30天
    UNREAD_MSG(30L, TimeUnit.DAYS)
    ;


    private Long time;

    private TimeUnit timeUnit;

    ExpireEnum(Long time, TimeUnit timeUnit) {
        this.time = time;
        this.timeUnit = timeUnit;
    }
}
