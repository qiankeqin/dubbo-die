package com.dubbowork.qrz.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author 邱润泽 bullock
 */
public interface BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext);
}
