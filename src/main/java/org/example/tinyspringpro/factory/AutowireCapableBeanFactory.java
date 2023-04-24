package org.example.tinyspringpro.factory;

import org.example.tinyspringpro.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("ALL")
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            var bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
            return bean;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
