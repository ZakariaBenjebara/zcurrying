package io.zgeeks.common;

import java.util.Objects;

public class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3> {

    private final T4 t4;

    public Tuple4(T1 t1, T2 t2, T3 t3, T4 t4) {
        super(t1, t2, t3);
        this.t4 = t4;
    }

    public T4 t4() {
        return t4;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tuple4) {
            Tuple4<?, ?, ?, ?> that = (Tuple4<?, ?, ?, ?>) o;
            return super.equals(that)
                && this.t4.equals(that.t4);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
            + Objects.hash(t4);
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder(super.toString());
        return string.deleteCharAt(string.length() - 1)
            .append(", ")
            .append(t4.toString())
            .toString();
    }
}
