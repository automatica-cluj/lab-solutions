package org.utcn.defaultmethods;

public class Main {
    public static void main(String[] args) {
        // call static method
        InterfaceDefaultMethods.generateRandomNrGreaterThan100Java8().ifPresent(System.out::println);

        // call default method
        final InterfaceDefaultMethods interfaceDefaultMethods = new InterfaceDefaultMethodsImpl();
        interfaceDefaultMethods.sayHelloWorld();
    }
}
