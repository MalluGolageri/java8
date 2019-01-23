package com.java8.lambda;


import java.awt.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

interface Java8Interface {
    default void test(){
        System.out.println("I am test method");
    }

    //void test1(String s,String string);

    int add(int i,int j);

}

class TEst{
    public static void main(String[] args) {
        System.out.println(op((i, j) -> i + j, 10, 20));
        System.out.println(op((i, j) -> i * j, 10, 20));

        //System.out.println(add(operation,20,20));
    }

    static int op(BiFunction<Integer,Integer,Integer> operation,int i,int j) {
        return operation.apply(i, j);
    }

}



