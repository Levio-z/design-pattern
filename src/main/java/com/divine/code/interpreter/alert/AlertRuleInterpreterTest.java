package com.divine.code.interpreter.alert;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class AlertRuleInterpreterTest {

    @Test
    public void testAlertRuleInterpreter() {

        String rule = "key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88";
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        Map<String, Long> stats = new HashMap<>();
        stats.put("key1", 101L);
        stats.put("key3", 121L);
        stats.put("key4", 88L);
        boolean alert = interpreter.interpret(stats);
        assertTrue(alert);
    }

    @Test
    public void testInvalidExpression() {

        String rule = "key1 > 100 && key2 < 30 || key3 < 100 || key4 = 88";
        assertThrows(RuntimeException.class, () -> new AlertRuleInterpreter(rule));
    }

}