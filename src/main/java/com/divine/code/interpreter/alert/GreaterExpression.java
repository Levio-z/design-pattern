package com.divine.code.interpreter.alert;

import java.util.Map;

public class GreaterExpression implements Expression {

    private String key;

    private long value;

    public GreaterExpression(String strExpression) {
        // 去除两边的空白字符，然后根据一个或多个空白字符分割
        String[] elements = strExpression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals(">")) {
            throw new RuntimeException("Expression is invalid: " + strExpression);
        }
        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());
    }

    public GreaterExpression(String key, long value) {

        this.key = key;
        this.value = value;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {

        if (!stats.containsKey(key)) {
            return false;
        }
        long statValue = stats.get(key);
        return statValue > value;
    }

}