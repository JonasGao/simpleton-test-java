package com.jonas.test.json.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;

import java.io.IOException;

/**
 * Test Jackson
 * Created by jonas on 2017/6/8.
 */
public class MixIn {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.
        B b = new B("Hello World");
        try {
            String json = objectMapper.writeValueAsString(b);
//            objectMapper.addMixIn(B.class, In.class);
//            objectMapper.enableDefaultTyping();
            B b1 = objectMapper.readValue(json, B.class);
            System.out.println(b1.getStr());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

abstract class A {
    private String str;

    A(String str) {
        this.str = str;
    }

    String getStr() {
        return str;
    }
}

class B extends A {
    B(String str) {
        super(str);
    }
}

class D extends DefaultDeserializationContext {

    protected D(DeserializerFactory df, DeserializerCache cache) {
        super(df, cache);
    }

    @Override
    public DefaultDeserializationContext with(DeserializerFactory factory) {
        return null;
    }

    @Override
    public DefaultDeserializationContext createInstance(DeserializationConfig config, JsonParser jp, InjectableValues values) {
        return null;
    }
}