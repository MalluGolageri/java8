package com.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class Dummy {

    public static void main(String args[]) {

        Function<Integer, Function<Integer, Function<Integer, Integer>>> curryAdder = u -> v -> w -> u + v + w;

        Function<Integer, Function<Integer, Function<Integer, Integer>>> test = new Function<Integer, Function<Integer, Function<Integer, Integer>>>() {
            @Override
            public Function<Integer, Function<Integer, Integer>> apply(Integer integer) {
                return new Function<Integer, Function<Integer, Integer>>() {
                    @Override
                    public Function<Integer, Integer> apply(Integer integer1) {
                        return new Function<Integer, Integer>(){
                            @Override
                            public Integer apply(Integer integer2) {
                                return integer + integer1 + integer2;
                            }
                        };
                    };
                };
            }
        };

        System.out.println(test.apply(10).apply(10).apply(30));
        System.out.println("Add 2, 3, 100 :" + curryAdder.apply(2).apply(3).apply(100));


        List<String> l=new ArrayList<>();
        System.out.println(l.contains(null));;
    }

}

