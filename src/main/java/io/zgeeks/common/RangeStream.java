package io.zgeeks.common;

import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

interface RangeStream<C extends Comparable<? super C>> extends BaseStream<C, RangeStream<C>> {

    static <C extends Comparable<? super C>> Stream<C> range(C upperBound, C lowerBound) {
        return StreamSupport.stream(new RangeSpliterator<>(new Bound<>(upperBound),
                                                           new Bound<>(lowerBound)), false);
    }

    static IntStream range(int upperBound, int lowerBound) {
        return IntStream.range(upperBound, lowerBound);
    }
}
