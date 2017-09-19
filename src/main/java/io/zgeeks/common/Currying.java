package io.zgeeks.common;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Currying<R, T> {

    public interface Fun3<U1, U2, U3, R> extends Function<U1, Function<U2, Function<U3, R>>> {

        default <V> Fun3<U1, U2, U3, V> doAfter(Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return u1 -> u2 -> u3 -> after.apply(apply(u1).apply(u2).apply(u3));
        }
    }

    public interface Fun4<U1, U2, U3, U4, R> extends Function<U1, Function<U2, Function<U3, Function<U4, R>>>> {

        default <V> Fun4<U1, U2, U3, U4, V> doAfter(Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return u1 -> u2 -> u3 -> u4 -> after.apply(apply(u1).apply(u2).apply(u3).apply(u4));
        }
    }

    public abstract R apply(Supplier<T> supplier);

    public static <U1, U2, R> Currying<R, Tuple2> of(BiFunction<U1, U2, R> function) {
        return new Currying2(function);
    }

    public static <U1, U2, U3, R> Currying<R, Tuple3> of(Fun3<U1, U2, U3, R> function) {
        return new Currying3(function);
    }

    public static <U1, U2, U3, U4, R> Currying<R, Tuple4> of(Fun4<U1, U2, U3, U4, R> function) {
        return new Currying4(function);
    }

    private final static class Currying2<U1, U2, R> extends Currying<R, Tuple2> {

        final BiFunction<U1, U2, R> function;

        public Currying2(BiFunction<U1, U2, R>  function) {
            this.function = Objects.requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple2> supplier) {
            final Tuple2<U1, U2> tuple = supplier.get();
            return function.apply(tuple.t1(), tuple.t2());
        }
    }

    private final static class Currying3<U1, U2, U3, R,
                                        F extends Function<U1, Function<U2, Function<U3, R>>>>
                                        extends Currying<R, Tuple3> {
        final F function;

        public Currying3(F function) {
            this.function = Objects.requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple3> supplier) {
            final Tuple3<U1, U2, U3> tuple = supplier.get();
            return function.apply(tuple.t1()).apply(tuple.t2()).apply(tuple.t3());
        }
    }

    private final static class Currying4<U1, U2, U3, U4, R,
                                        F extends Function<U1, Function<U2, Function<U3, Function<U4, R>>>>>
                                        extends Currying<R, Tuple4> {
        final F function;

        public Currying4(F function) {
            this.function = Objects.requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple4> supplier) {
            final Tuple4<U1, U2, U3, U4> tuple = supplier.get();
            return function.apply(tuple.t1()).apply(tuple.t2()).apply(tuple.t3()).apply(tuple.t4());
        }
    }

    private Currying() {}
}
