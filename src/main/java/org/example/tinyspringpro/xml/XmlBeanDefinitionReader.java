package org.example.tinyspringpro.xml;

import org.example.tinyspringpro.AbstractBeanDefinitionReader;
import org.example.tinyspringpro.BeanDefinition;
import org.example.tinyspringpro.PropertyValue;
import org.example.tinyspringpro.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;


public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        var inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        var factory = DocumentBuilderFactory.newInstance();
        var docBuilder = factory.newDocumentBuilder();
        var doc = docBuilder.parse(inputStream);

        registerBeanDefinitions(doc);
        inputStream.close();
    }

    public void registerBeanDefinitions(Document doc) {
        var root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root) {
        var nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            var node = nl.item(i);
            if (node instanceof Element) {
                var ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element ele) {
        var name = ele.getAttribute("name");
        var className = ele.getAttribute("class");
        var beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        var propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            var node = propertyNode.item(i);
            if (node instanceof Element) {
                var propertyEle = (Element) node;
                var name = propertyEle.getAttribute("name");
                var value = propertyEle.getAttribute("value");
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
            }
        }
    }
}
