package org.example.tinyspringpro.factory;

import org.example.tinyspringpro.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
