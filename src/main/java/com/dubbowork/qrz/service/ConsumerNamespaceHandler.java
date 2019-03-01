package com.dubbowork.qrz.service;

import com.dubbowork.qrz.entity.ConsumerConfigure;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author 邱润泽 bullock
 */
public class ConsumerNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("consumer", new ConsumerBeanDefinitionParser(ConsumerConfigure.class));
    }
}
