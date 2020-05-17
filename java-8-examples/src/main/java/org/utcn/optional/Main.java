package org.utcn.optional;

import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // java 7
        final Integer generatedValueJava7 = generateRandomNrGreaterThan100Java7();

        if (generatedValueJava7 != null) {
            System.out.println("Generated value = " + generatedValueJava7);
        }

        // java 8
        final Optional<Integer> generatedValueJava8 = generateRandomNrGreaterThan100Java8();
        System.out.println("Do we have a value? = " + generatedValueJava8.isPresent());
        System.out.println("Let's get the value or a default one = " + generatedValueJava8.orElse(-1));
        System.out.println("Let's throw an exception if value not found = " + generatedValueJava8.orElseThrow(() -> new RuntimeException("No generated value")));
        System.out.println("Get value(assume is present) = " + generatedValueJava8.get());
        // let's do something if value is provided
        generatedValueJava8.ifPresent(value -> System.out.println("Value is generated, let's print it = " + value));
    }

    /**
     * Generate random value > 100 or null if not
     *
     * @return
     */
    private static Integer generateRandomNrGreaterThan100Java7() {
        final Random random = new Random();
        final Integer generatedValue = random.nextInt(200);

        return generatedValue > 100 ? generatedValue : null;
    }

    /**
     * Generate a random value > 100 or Optional.empty if not
     *
     * @return
     */
    private static Optional<Integer> generateRandomNrGreaterThan100Java8() {
        final Random random = new Random();
        final Integer generatedValue = random.nextInt(200);

        return generatedValue > 100 ? Optional.of(generatedValue) : Optional.empty();
    }
}
