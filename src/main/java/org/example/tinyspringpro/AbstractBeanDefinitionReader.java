package org.example.tinyspringpro;

import org.example.tinyspringpro.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final Map<String, BeanDefinition> registry;

    private final ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
