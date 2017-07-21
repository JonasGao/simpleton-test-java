package com.jonas.test.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Set<String> keys = new HashSet<>(Arrays.asList("A","B","C"));
        Stream<String> stream = keys.stream();

        String value = stream
                .filter(s -> s.equals("B"))
                .map(s -> (String) null)
                .findFirst()
                .orElse("0");

        System.out.println(value);
    }
}
