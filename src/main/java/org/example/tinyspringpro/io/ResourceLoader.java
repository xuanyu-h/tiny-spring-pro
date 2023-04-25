package org.example.tinyspringpro.io;

public class ResourceLoader {

    public Resource getResource(String location){
        var resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
