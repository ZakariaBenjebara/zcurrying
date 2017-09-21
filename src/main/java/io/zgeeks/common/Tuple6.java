package io.zgeeks.common;

import java.util.Objects;

public class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple5<T1, T2, T3, T4, T5> {

    private final T6 t6;

    public Tuple6(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        super(t1, t2, t3, t4, t5);
        this.t6 = t6;
    }

    public T6 t6() {
        return t6;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tuple6) {
            Tuple6<?, ?, ?, ?, ?, ?> that = (Tuple6<?, ?, ?, ?, ?, ?>) o;
            return super.equals(that)
                && this.t6.equals(that.t6);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
            + Objects.hash(t6);
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder(super.toString());
        return string.deleteCharAt(string.length() - 1)
            .append(", ")
            .append(t6.toString())
            .toString();
    }
}
