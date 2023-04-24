package org.example.tinyspringpro.factory;

import org.example.tinyspringpro.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("ALL")
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        var bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        return beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (var propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            var declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
