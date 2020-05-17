package org.utcn.streams;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operators {
    public static void main(String[] args) {
        /**
         * *********************************************************************************************************
         * Intermediate Operations
         * *********************************************************************************************************
         */
        // multiplied by 2
        final Stream<Integer> multipliedByTwoStream = Stream.of(1, -5, 3, 3, -1)
                .map(integer -> {
                    System.out.println("[MultipliedByTwoStream] Received input: " + integer);
                    return integer * 2;
                });

        // positive numbers stream
        final Stream<Integer> positiveNumbersStream = Stream.of(1, -5, 3, 3, -1)
                .filter(integer -> {
                    System.out.println("[PositiveNumbersStream] Received input: " + integer);
                    return integer > 0;
                });

        // peek
        final Stream<Integer> peekNumbersStream = Stream.of(1, -5, 3, 3, -1)
                .peek(integer -> System.out.println("[PeekNumbersStream] Received input: " + integer));

        /**
         * *********************************************************************************************************
         * Final Operations
         * *********************************************************************************************************
         */
        // collect
        final List<Integer> multipliedByTwoCollect = multipliedByTwoStream.collect(Collectors.toList());
        System.out.println("Multiplied by two = " + multipliedByTwoCollect);

        System.out.println();

        final List<Integer> positiveNumbersCollect = positiveNumbersStream.collect(Collectors.toList());
        System.out.println("Positive numbers = " + positiveNumbersCollect);

        System.out.println();

        // forEach
        peekNumbersStream.forEach(integer -> System.out.println("Peek Numbers = " + integer));

        System.out.println();

        // count
        final Long nrOfNegativeElements = Stream.of(1, 2, 3, 4, -1)
                .filter(x -> x < 0)
                .count();
        System.out.println("Nr of negative elements = " + nrOfNegativeElements);

        System.out.println();

        // any match, none match, all match
        final boolean areAllNrPositive = Stream.of(2, 2, 3, 4)
                .allMatch(integer -> integer > 0);
        System.out.println("All are numbers positive = " + areAllNrPositive);

        System.out.println();

        final boolean isAtLeastOnePositive = Stream.of(-1, -2, -3, 1, -9)
                .anyMatch(integer -> integer > 0);
        System.out.println("At least one positive number = " + isAtLeastOnePositive);

        System.out.println();

        final boolean isNoPositiveNumber = Stream.of(-1, -2, -3, -4)
                .noneMatch(integer -> integer > 0);
        System.out.println("No positive number = " + isNoPositiveNumber);

        System.out.println();

        // find findFirst
        final Optional<Integer> firstPositiveNumber = Stream.of(-4, -2, -1, 2, 5)
                .filter(integer -> integer > 0)
                .findFirst();
        System.out.println("Found value = " + firstPositiveNumber);

        final Integer firstPositiveNumberOrDefault = Stream.of(-4, -2, -8, -3, -2)
                .filter(integer -> integer > 0)
                .findFirst()
                .orElse(-1);
        System.out.println("Found value = " + firstPositiveNumberOrDefault);

        // lazy operators
        final List<Double> positivePowerOfTwoNumbers = Stream.of(1, 2, -1, -2)
                .map(integer -> {
                    System.out.println("[First MAP] value = " + integer);
                    return integer * 2;
                })
                .filter(integer -> {
                    System.out.println("[First FILTER] value = " + integer);
                    return integer > 0;
                })
                .map(integer -> {
                    System.out.println("[Second MAP] value = " + integer);
                    return Math.pow(integer, 2);
                })
                .collect(Collectors.toList());
        System.out.println("Result of positive power of two numbers = " + positivePowerOfTwoNumbers);

        System.out.println();
    }
}
