package org.example.tinyspringpro;

import org.junit.jupiter.api.Test;

public class BeanFactoryTest {

    @Test
    public void test() {
        var beanFactory = new BeanFactory();

        var beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        var helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
