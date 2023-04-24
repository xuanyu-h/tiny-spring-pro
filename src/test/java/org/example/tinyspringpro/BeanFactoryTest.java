package org.example.tinyspringpro;

import org.example.tinyspringpro.factory.AutowireCapableBeanFactory;
import org.junit.jupiter.api.Test;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        var beanFactory = new AutowireCapableBeanFactory();

        var beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("org.example.tinyspringpro.HelloWorldService");

        var propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("foo", "Hello"));
        propertyValues.addPropertyValue(new PropertyValue("bar", "World!"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        var helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
