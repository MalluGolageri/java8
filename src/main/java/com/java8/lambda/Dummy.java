package com.java8.lambda;

import java.util.function.Function;

public class Dummy {

    public static void main(String args[]) {
        Function<Integer, Function<Integer, Integer>> curryAdder = u -> v -> u + v;
        Function<Integer, Function<Integer, Integer>> test = new Function<Integer, Function<Integer, Integer>>() {
            @Override
            public Function<Integer, Integer> apply(Integer integer) {
                return new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer1) {
                        return integer + integer1;
                    }
                };
            }
        };

        System.out.println(test.apply(10).apply(10));
        System.out.println("Add 2, 3 :" + curryAdder.apply(2).apply(3));
    }

}

