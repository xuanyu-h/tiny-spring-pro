package org.example.tinyspringpro;

import org.example.tinyspringpro.factory.AutowireCapableBeanFactory;
import org.junit.jupiter.api.Test;

public class BeanFactoryTest {

    @Test
    public void test() {
        var beanFactory = new AutowireCapableBeanFactory();

        var beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("org.example.tinyspringpro.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        var helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
