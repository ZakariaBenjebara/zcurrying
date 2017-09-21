package io.zgeeks.common;

import java.util.Objects;

public class Tuple5<T1, T2, T3, T4, T5> extends Tuple4<T1, T2, T3, T4> {

    private final T5 t5;

    public Tuple5(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        super(t1, t2, t3, t4);
        this.t5 = t5;
    }

    public T5 t5() {
        return t5;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tuple5) {
            Tuple5<?, ?, ?, ?, ?> that = (Tuple5<?, ?, ?, ?, ?>) o;
            return super.equals(that)
                && this.t5.equals(that.t5);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
            + Objects.hash(t5);
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder(super.toString());
        return string.deleteCharAt(string.length() - 1)
            .append(", ")
            .append(t5.toString())
            .toString();
    }
}
