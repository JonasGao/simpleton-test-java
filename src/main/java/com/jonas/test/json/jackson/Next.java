package com.jonas.test.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Random;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

interface MyContext {
    String getCreator();
    String getModifier();
}

class Next {
    public static void main(String[] args) {
        try {
            String json = Model1.toJson();
            System.out.println(json);
            Model1 model1 = Model1.fromJson(json);
            System.out.println(model1.getModifier());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Model1 implements MyContext {

    String modifier;

    private Model1() {
        modifier = String.valueOf(new Random().nextInt());
    }

    public static Model1 fromJson(String json) throws IOException {
        return new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(json, Model1.class);
    }

    public static String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new Model1());
    }

    @Override
    public String getCreator() {
        return "Model1";
    }

    @Override
    public String getModifier() {
        return modifier;
    }
}