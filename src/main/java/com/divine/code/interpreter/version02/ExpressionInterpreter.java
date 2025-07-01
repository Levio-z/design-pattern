package com.divine.code.interpreter.version02;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionInterpreter {

    private Deque<Expression> numbers = new LinkedList<>();

    public long interpret(String expression) {

        String[] elements = expression.split(" ");
        int length = elements.length;

        // 将操作数存入队列
        for (int i = 0; i < (length + 1) / 2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        // 依次处理操作符
        for (int i = (length + 1) / 2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator) || "-".equals(operator)
                    || "*".equals(operator) || "/".equals(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }

            Expression exp1 = numbers.pollFirst();
            Expression exp2 = numbers.pollFirst();
            Expression combinedExp = null;

            switch (operator) {
                case "+":
                    combinedExp = new AdditionExpression(exp1, exp2);
                    break;
                case "-":
                    combinedExp = new SubtractionExpression(exp1, exp2);
                    break;
                case "*":
                    combinedExp = new MultiplicationExpression(exp1, exp2);
                    break;
                case "/":
                    combinedExp = new DivisionExpression(exp1, exp2);
                    break;
            }

            long result = combinedExp.interpret();
            numbers.addFirst(new NumberExpression(result));
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }

        return numbers.pop().interpret();
    }

}