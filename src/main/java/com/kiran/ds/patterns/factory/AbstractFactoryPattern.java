package com.kiran.ds.patterns.factory;

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        System.out.println(NumberFactory.createNumber(new OneFactory()));
        System.out.println(NumberFactory.createNumber(new TwoFactory()));
    }
}

interface AbstractNumberFactory {

    Zero createNumber();
}

class OneFactory implements AbstractNumberFactory {

    public Zero createNumber() {
        return new One();
    }
}

class TwoFactory implements AbstractNumberFactory {

    public Zero createNumber() {
        return new Two();
    }
}

class NumberFactory {

    static Zero createNumber(AbstractNumberFactory factory) {
        return factory.createNumber();
    }
}