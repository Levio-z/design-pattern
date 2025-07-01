package com.divine.code.interpreter.version02;

public class DivisionExpression implements Expression {

    private Expression exp1;

    private Expression exp2;

    public DivisionExpression(Expression exp1, Expression exp2) {

        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public long interpret() {

        long number2 = exp2.interpret();
        if (number2 == 0) {
            throw new RuntimeException("Division by zero");
        }
        return exp1.interpret() / number2;
    }

}