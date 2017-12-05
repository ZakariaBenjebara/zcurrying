package io.zgeeks.common;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final class RangeSpliterator<C extends Comparable<?>> implements Spliterator<C> {

    final Bound<C> lowerBound, upperBound;

    public RangeSpliterator(Bound<C> lowerBound, Bound<C> upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean tryAdvance(Consumer<? super C> action) {
        return false;
    }

    @Override
    public Spliterator<C> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
