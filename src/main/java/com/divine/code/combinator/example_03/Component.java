package com.divine.code.combinator.example_03;

public abstract class Component {

    protected String name;

    abstract void display(int depth);

    public Component(String name) {

        this.name = name;
    }

}
