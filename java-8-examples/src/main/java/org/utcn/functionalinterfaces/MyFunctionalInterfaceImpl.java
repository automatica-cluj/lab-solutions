package org.utcn.functionalinterfaces;

public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void sayHello(String name) {
        System.out.println(String.format("Hello %s!", name));
    }
}
