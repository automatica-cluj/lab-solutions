package org.utcn.defaultmethods;

import java.util.Optional;
import java.util.Random;

public interface InterfaceDefaultMethods {

    /**
     * Say hello world static method
     */
    default void sayHelloWorld() {
        System.out.println("Hello World");
    }

    /**
     * Default method that returns a value
     *
     * @return
     */
    static Optional<Integer> generateRandomNrGreaterThan100Java8() {
        final Random random = new Random();
        final Integer generatedValue = random.nextInt(200);

        return generatedValue > 100 ? Optional.of(generatedValue) : Optional.empty();
    }
}
