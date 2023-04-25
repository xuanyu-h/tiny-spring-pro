package org.example.tinyspringpro;

import org.example.tinyspringpro.factory.AutowireCapableBeanFactory;
import org.example.tinyspringpro.io.ResourceLoader;
import org.example.tinyspringpro.xml.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeanFactoryTest {

    @Test
    public void testWithoutResourceLoader() throws Exception {
        var beanFactory = new AutowireCapableBeanFactory();

        var beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("org.example.tinyspringpro.HelloWorldService");

        var propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("foo", "Hello"));
        propertyValues.addPropertyValue(new PropertyValue("bar", "World!"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        var helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        Assertions.assertEquals("Hello World!", helloWorldService.helloWorld());
    }

    @Test
    public void testWithResourceLoader() throws Exception {
        var beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        var beanFactory = new AutowireCapableBeanFactory();
        for (var beanDefinitionEntry : beanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        var helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        Assertions.assertEquals("Hello World!", helloWorldService.helloWorld());
    }
}
