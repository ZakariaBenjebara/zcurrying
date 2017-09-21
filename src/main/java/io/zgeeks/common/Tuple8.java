package io.zgeeks.common;

import java.util.Objects;

public class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> extends Tuple7<T1, T2, T3, T4, T5, T6, T7> {

    private final T8 t8;

    public Tuple8(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        super(t1, t2, t3, t4, t5, t6, t7);
        this.t8 = t8;
    }

    public T8 t8() {
        return t8;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tuple8) {
            Tuple8<?, ?, ?, ?, ?, ?, ?, ?> that = (Tuple8<?, ?, ?, ?, ?, ?, ?, ?>) o;
            return super.equals(that)
                && this.t8.equals(that.t8);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
            + Objects.hash(t8);
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder(super.toString());
        return string.deleteCharAt(string.length() - 1)
            .append(", ")
            .append(t8.toString())
            .toString();
    }
}
