package io.zgeeks.common;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.scalb;

public class CurryingTest {

    @Test
    public void test_currying_with_two_parameters() {
        double result = Currying.<Double, Integer, Double>from((u, d) -> scalb(u, d)).apply(() -> new Tuple2(1.2, 2));
        Assert.assertEquals(4.8, result, 0);
    }

    @Test
    public void test_currying_with_three_parameters() {
        String result = Currying.<Integer, Integer, Double, String>from(u1 -> u2 -> u3 -> Integer.toString(u1 + (int) scalb(u3, u2))).apply(() -> new Tuple3(2, 5, 1.2));
        Assert.assertEquals("40", result);
    }
}