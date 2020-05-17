package org.utcn.functionalinterfaces;

public class Main {
    public static void main(String[] args) {
        // instantiations

        // M1 - using impl class
        final MyFunctionalInterface firstObject = new MyFunctionalInterfaceImpl();
        firstObject.sayHello("John");

        // M2 - using anonymous class
        final MyFunctionalInterface secondObject = new MyFunctionalInterface() {
            @Override
            public void sayHello(String name) {
                System.out.println(String.format("Hello %s", name));
            }
        };
        secondObject.sayHello("John");

        // M3 - starting with java 8 (lambda expression)
        final MyFunctionalInterface thirdObject = name -> System.out.println(String.format("Hello %s", name));
        thirdObject.sayHello("John");
    }
}
