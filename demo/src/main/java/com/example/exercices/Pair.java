package com.example.exercices;

public class Pair<A, B> {
    private final A attributeA;
    private final B attributeB;

    public Pair(A a, B b){
        attributeA = a;
        attributeB = b;
    }

    public A getFirst(){
        return attributeA;
    }

    public B getSecond(){
        return attributeB;
    }
}
