package com.kiran.ds.patterns.factory;

public class FactoryPattern {

    public static void main(String[] args) {
        System.out.println(Factory.getInstance("one"));
        System.out.println(Factory.getInstance("two"));
        System.out.println(Factory.getInstance("three"));
    }
}

class Factory {

    public static Zero getInstance(String type) {
        if(type.equalsIgnoreCase("one")) {
            return new One();
        } else if(type.equalsIgnoreCase("two")) {
            return new Two();
        } else {
            return null;
        }
    }
}

