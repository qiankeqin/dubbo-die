package com.dubbowork.qrz.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author 邱润泽 bullock
 */
public class ConsumerBeanDefinitionParser implements BeanDefinitionParser, org.springframework.beans.factory.xml.BeanDefinitionParser {

    private final Class<?> beanClass;

    public ConsumerBeanDefinitionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        beanDefinition.getPropertyValues().add("ip", element.getAttribute("ip"));
        beanDefinition.getPropertyValues().add("port", element.getAttribute("port"));
        beanDefinition.getPropertyValues().add("interfaceClass", element.getAttribute("interfaceClass"));
        beanDefinition.getPropertyValues().add("retries", element.getAttribute("retries"));
        BeanDefinitionRegistry beanDefinitionRegistry = parserContext.getRegistry();
        beanDefinitionRegistry.registerBeanDefinition(element.getAttribute("id"),beanDefinition);
        //注册bean到BeanDefinitionRegistry中
        return beanDefinition;
    }
}
