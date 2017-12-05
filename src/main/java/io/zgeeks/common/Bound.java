package io.zgeeks.common;

import java.util.Comparator;

abstract class Bound<C extends Comparable<?>> implements Comparable<Bound<C>> {
    final C value;

    Bound(C value) {
        this.value = value;
    }

    abstract boolean isClosed();

    abstract boolean isLessThan(Bound<C> that);

    @Override
    public int compareTo(Bound<C> that) {
        return ((Comparator<C>) Comparator.naturalOrder())
                .compare(this.value, that.value);
    }

    final class Below<C extends Comparable<?>> extends Bound<C> {

        Below(C value) {
            super(value);
        }

        @Override
        boolean isClosed() {
            return false;
        }

        @Override
        boolean isLessThan(Bound<C> that) {
            return false;
        }
    }
}
