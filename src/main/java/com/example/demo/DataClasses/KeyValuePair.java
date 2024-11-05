package com.example.demo.DataClasses;

public class KeyValuePair {
    String key;
    Number value;
public KeyValuePair(String key, Number value) {
    this.key = key;
    this.value = value;
}

    public String getKey() {
        return key;
    }

    public Number getValue() {
        return value;
    }
}
