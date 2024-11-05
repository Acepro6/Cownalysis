package com.example.demo.DataClasses;

public class PassableFieldValuePair {
    private String field;
    private String value;
    public PassableFieldValuePair(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }

    public static void test_passableFieldValuePair(){
        PassableFieldValuePair test1 = new PassableFieldValuePair("FieldTest1", "1234");

        if(!test1.getField().equals("FieldTest1")){
            System.out.println("getField failed on PassableFieldValuePair, got" +
                    test1.getField());
        }

        if(!test1.getValue().equals("1234")){
            System.out.println("getValue failed on PassableFieldValuePair, got" +
                    test1.getValue());
        }


        System.out.println("PassableFieldValuePair tests done\n");

    }


    public static void main(String[] args){



    }
}
