package com.jonas.test.functional.nullable;

import java.util.function.Supplier;

/**
 * 测试在传递 lambada 引用时，源实例是否可以为 null
 * Created by jonas on 2017/3/31.
 */
public class Tester {
    public static void main(String[] args) {
        Model model = null;
        System.out.println(getIfNotNull(model, model::getName));
    }

    public static <T> String getIfNotNull(T object, Supplier<String> supplier) {
        return object != null ? supplier.get() : null;
    }
}

class Model {
    String getName() {
        return "World";
    }
}