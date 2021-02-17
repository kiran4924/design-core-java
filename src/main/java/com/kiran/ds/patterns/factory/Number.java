package com.kiran.ds.patterns.factory;

public class Number {
}

class Three extends Two {

}

abstract class Zero {
}

class One extends Zero {

    @Override
    public String toString() {
        return "One";
    }
}

class Two extends Zero {

    @Override
    public String toString() {
        return "Two";
    }
}