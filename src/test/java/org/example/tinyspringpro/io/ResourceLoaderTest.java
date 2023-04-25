package org.example.tinyspringpro.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        var resourceLoader = new ResourceLoader();
        var resource = resourceLoader.getResource("tinyioc.xml");
        var inputStream = resource.getInputStream();
        Assertions.assertNotNull(inputStream);
    }
}
