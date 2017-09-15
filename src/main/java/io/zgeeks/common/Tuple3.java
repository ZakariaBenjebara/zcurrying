package io.zgeeks.common;

import java.util.Objects;

public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> {

    private final T3 t3;

    public Tuple3(T1 t1, T2 t2, T3 t3) {
        super(t1, t2);
        this.t3 = t3;
    }

    public T3 t3() {
        return t3;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tuple3) {
            Tuple3<?, ?, ?> that = (Tuple3<?, ?, ?>) o;
            return super.equals(that)
                && this.t3.equals(that.t3);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
            + Objects.hash(t3);
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder(super.toString());
        return string.deleteCharAt(string.length() - 1)
            .append(", ")
            .append(t3.toString())
            .toString();
    }
}
