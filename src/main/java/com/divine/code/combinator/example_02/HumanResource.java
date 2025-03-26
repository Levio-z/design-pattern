package com.divine.code.combinator.example_02;

public abstract class HumanResource {

    protected long id;

    protected double salary;

    public HumanResource(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public abstract double calculateSalary();

}
