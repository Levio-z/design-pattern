package com.divine.code.interpreter.version02;

public class NumberExpression implements Expression {

    private long number;

    public NumberExpression(long number) {

        this.number = number;
    }

    public NumberExpression(String number) {

        this.number = Long.parseLong(number);
    }

    @Override
    public long interpret() {

        return this.number;
    }

}