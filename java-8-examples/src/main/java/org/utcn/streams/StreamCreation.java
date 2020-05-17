package org.utcn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        // Stream creation
        // M1: using Stream.of()
        final Stream<Integer> firstStream = Stream.of(1, 2, 3, 4);

        // M2:
        final Stream<Integer> secondStream = Stream.of(new Integer[]{1, 2, 3, 4});

        // M3: using stream builder
        final Stream<Integer> thirdStream = Stream.<Integer>builder()
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .build();

        // M4: calling stream() method
        final List<Integer> fourthList = Arrays.asList(1, 2, 3, 4);
        final Stream<Integer> fourthStream = fourthList.stream();
        final Stream<Integer> fourthStreamWithFirstAggregationFunction = fourthStream
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return null;
                    }
                });
    }
}
