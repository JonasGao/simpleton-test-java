package com.jonas.test.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017/5/16.
 */
public class Copy {
    public static void main(String[] args) {
        List<Model> list1 = new ArrayList<>();
        list1.add(new Model("A"));
        list1.add(new Model("B"));
        list1.add(new Model("C"));

        List<Model> list2 = new ArrayList<>(list1);

        assert list1.get(0) == list2.get(0);
    }

    static class Model {
        String value;

        Model(String value) {
            this.value = value;
        }
    }
}
