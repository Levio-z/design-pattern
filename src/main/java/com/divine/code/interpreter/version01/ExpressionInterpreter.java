package com.divine.code.interpreter.version01;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionInterpreter {

    private Deque<Long> numbers = new LinkedList<>();

    public long interpret(String expression) {

        String[] elements = expression.split(" ");
        int length = elements.length;

        // 将操作数存入队列
        for (int i = 0; i < (length + 1) / 2; ++i) {
            numbers.addLast(Long.parseLong(elements[i]));
        }

        // 依次处理操作符
        for (int i = (length + 1) / 2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator) || "-".equals(operator)
                    || "*".equals(operator) || "/".equals(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }

            long number1 = numbers.pollFirst();
            long number2 = numbers.pollFirst();
            long result = 0;

            switch (operator) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0) {
                        throw new RuntimeException("Division by zero in expression: " + expression);
                    }
                    result = number1 / number2;
                    break;
            }

            numbers.addFirst(result);
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }

        return numbers.pop();
    }

}