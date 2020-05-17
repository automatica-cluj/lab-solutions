package org.utcn.defaultmethods;

public class InterfaceDefaultMethodsImpl implements InterfaceDefaultMethods {
    @Override
    public void sayHelloWorld() {
//        InterfaceDefaultMethods.super.sayHelloWorld();
        System.out.println("Hello hello also from overriden method");
    }
}
