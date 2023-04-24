package org.example.tinyspringpro;

public class HelloWorldService {

    private String foo;
    private String bar;

    public void helloWorld() {
        System.out.println(foo + " " + bar);
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
