package com.jonas.test.list;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by jonas on 2017/5/16.
 */
public class Clone {
    public static void main(String[] args) {
        List<Model> list1 = new ArrayList<>();
        list1.add(new Model("A"));
        list1.add(new Model("B"));
        list1.add(new Model("C"));

        List<Model> list2 = list1.stream().map(model -> {
            try {
                return (Model) model.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(toList());

        assert list1.get(0) != list2.get(0);
    }

    static class Model implements Cloneable {
        String value;

        Model(String value) {
            this.value = value;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
