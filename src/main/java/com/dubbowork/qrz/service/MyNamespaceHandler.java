package com.dubbowork.qrz.service;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author 邱润泽
 *
 * 自定义 扩展 schemas流程
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}
