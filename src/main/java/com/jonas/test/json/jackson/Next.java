package com.jonas.test.json.jackson;

class Next {
    public static void main(String[] args) {

    }
}

interface MyContext {
    String getCreator();
    String getModifier();
}

class Model1 implements MyContext {

    @Override
    public String getCreator() {
        return "Model1";
    }

    @Override
    public String getModifier() {
        return null;
    }
}