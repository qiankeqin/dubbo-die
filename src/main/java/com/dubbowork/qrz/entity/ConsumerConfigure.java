package com.dubbowork.qrz.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 邱润泽 bullock
 */
@Setter
@Getter
public class ConsumerConfigure {
    /**
     * IP地址
     */
    private String ip;
    /**
     * 端口
     */
    private Integer port;
    /**
     * 接口类别
     */
    private String interfaceClass;
    /**
     * 重试次数
     */
    private Integer retries;
}
