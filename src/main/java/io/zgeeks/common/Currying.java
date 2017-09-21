package io.zgeeks.common;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

public abstract class Currying<R, T> {

    public interface Fun3<U1, U2, U3, R> extends Function<U1, Function<U2, Function<U3, R>>> {

        default <V> Fun3<U1, U2, U3, V> doAfter(Function<? super R, ? extends V> after) {
            requireNonNull(after);
            return u1 -> u2 -> u3 -> after.apply(apply(u1).apply(u2).apply(u3));
        }
    }

    public interface Fun4<U1, U2, U3, U4, R> extends Function<U1, Function<U2, Function<U3, Function<U4, R>>>> {

        default <V> Fun4<U1, U2, U3, U4, V> doAfter(Function<? super R, ? extends V> after) {
            requireNonNull(after);
            return u1 -> u2 -> u3 -> u4 -> after.apply(apply(u1).apply(u2).apply(u3).apply(u4));
        }
    }

    public interface Fun5<U1, U2, U3, U4, U5, R> extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, R>>>>> {

        default <V> Fun5<U1, U2, U3, U4, U5, V> doAfter(Function<? super R, ? extends V> after) {
            requireNonNull(after);
            return u1 -> u2 -> u3 -> u4 -> u5 -> after.apply(apply(u1).apply(u2).apply(u3).apply(u4).apply(u5));
        }
    }

    public interface Fun6<U1, U2, U3, U4, U5, U6, R> extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, Function<U6, R>>>>>> {

        default <V> Fun6<U1, U2, U3, U4, U5, U6, V> doAfter(Function<? super R, ? extends V> after) {
            requireNonNull(after);
            return u1 -> u2 -> u3 -> u4 -> u5 -> u6 -> after.apply(apply(u1).apply(u2).apply(u3).apply(u4).apply(u5).apply(u6));
        }
    }

    public interface Fun7<U1, U2, U3, U4, U5, U6, U7, R> extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, Function<U6, Function<U7, R>>>>>>> {

        default <V> Fun7<U1, U2, U3, U4, U5, U6, U7, V> doAfter(Function<? super R, ? extends V> after) {
            requireNonNull(after);
            return u1 -> u2 -> u3 -> u4 -> u5 -> u6 -> u7 -> after.apply(apply(u1).apply(u2).apply(u3).apply(u4).apply(u5).apply(u6).apply(u7));
        }
    }

    public interface Fun8<U1, U2, U3, U4, U5, U6, U7, U8, R> extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, Function<U6, Function<U7, Function<U8, R>>>>>>>> {

        default <V> Fun8<U1, U2, U3, U4, U5, U6, U7, U8, V> doAfter(Function<? super R, ? extends V> after) {
            requireNonNull(after);
            return u1 -> u2 -> u3 -> u4 -> u5 -> u6 -> u7 -> u8 -> after.apply(apply(u1).apply(u2).apply(u3).apply(u4).apply(u5).apply(u6).apply(u7).apply(u8));
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

    public static <U1, U2, U3, U4, U5, R> Currying<R, Tuple4> of(Fun5<U1, U2, U3, U4, U5, R> function) {
        return new Currying5(function);
    }

    public static <U1, U2, U3, U4, U5, U6, R> Currying<R, Tuple4> of(Fun6<U1, U2, U3, U4, U5, U6, R> function) {
        return new Currying6(function);
    }

    public static <U1, U2, U3, U4, U5, U6, U7, R> Currying<R, Tuple4> of(Fun7<U1, U2, U3, U4, U5, U6, U7, R> function)  {
        return new Currying7(function);
    }

    public static <U1, U2, U3, U4, U5, U6, U7, U8, R> Currying<R, Tuple4> of(Fun8<U1, U2, U3, U4, U5, U6, U7, U8, R> function)  {
        return new Currying8(function);
    }

    private final static class Currying2<U1, U2, R> extends Currying<R, Tuple2> {

        final BiFunction<U1, U2, R> function;

        public Currying2(BiFunction<U1, U2, R>  function) {
            this.function = requireNonNull(function, "function == null");
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
            this.function = requireNonNull(function, "function == null");
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
            this.function = requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple4> supplier) {
            final Tuple4<U1, U2, U3, U4> tuple = supplier.get();
            return function.apply(tuple.t1()).apply(tuple.t2()).apply(tuple.t3()).apply(tuple.t4());
        }
    }

    private final static class Currying5<U1, U2, U3, U4, U5, R,
            F extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, R>>>>>>
            extends Currying<R, Tuple5> {

        final F function;

        public Currying5(F function) {
            this.function = requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple5> supplier) {
            final Tuple5<U1, U2, U3, U4, U5> tuple = supplier.get();
            return function.apply(tuple.t1()).apply(tuple.t2()).apply(tuple.t3()).apply(tuple.t4()).apply(tuple.t5());
        }
    }

    private final static class Currying6<U1, U2, U3, U4, U5, U6, R,
            F extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, Function<U6, R>>>>>>>
            extends Currying<R, Tuple6> {

        final F function;

        public Currying6(F function) {
            this.function = requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple6> supplier) {
            final Tuple6<U1, U2, U3, U4, U5, U6> tuple = supplier.get();
            return function.apply(tuple.t1()).apply(tuple.t2()).apply(tuple.t3()).apply(tuple.t4()).apply(tuple.t5()).apply(tuple.t6());
        }

    }

    private final static class Currying7<U1, U2, U3, U4, U5, U6, U7, R,
            F extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, Function<U6, Function<U7, R>>>>>>>>
            extends Currying<R, Tuple7> {

        final F function;

        public Currying7(F function) {
            this.function = requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple7> supplier) {
            final Tuple7<U1, U2, U3, U4, U5, U6, U7> tuple = supplier.get();
            return function.apply(tuple.t1()).apply(tuple.t2()).apply(tuple.t3()).apply(tuple.t4()).apply(tuple.t5()).apply(tuple.t6()).apply(tuple.t7());
        }

    }

    private final static class Currying8<U1, U2, U3, U4, U5, U6, U7, U8, R,
            F extends Function<U1, Function<U2, Function<U3, Function<U4, Function<U5, Function<U6, Function<U7, Function<U8, R>>>>>>>>>
            extends Currying<R, Tuple8> {

        final F function;

        public Currying8(F function) {
            this.function = requireNonNull(function, "function == null");
        }

        @Override
        public R apply(Supplier<Tuple8> supplier) {
            final Tuple8<U1, U2, U3, U4, U5, U6, U7, U8> tuple = supplier.get();
            return function.apply(tuple.t1()).apply(tuple.t2()).apply(tuple.t3()).apply(tuple.t4()).apply(tuple.t5()).apply(tuple.t6()).apply(tuple.t7()).apply(tuple.t8());
        }

    }

    private Currying() {}
}
