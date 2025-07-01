package com.divine.code.interpreter.version02;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ExpressionInterpreterTest {

    private ExpressionInterpreter interpreter = new ExpressionInterpreter();

    @Test
    public void testAddition() {

        assertEquals(5, interpreter.interpret("2 3 +"));
    }

    @Test
    public void testSubtraction() {

        assertEquals(-1, interpreter.interpret("2 3 -"));
    }

    @Test
    public void testMultiplication() {

        assertEquals(6, interpreter.interpret("2 3 *"));
    }

    @Test
    public void testDivision() {

        assertEquals(2, interpreter.interpret("6 3 /"));
    }

    @Test
    public void testInvalidExpression() {

        assertThrows(RuntimeException.class, () -> interpreter.interpret("2 3 + 4"));
    }

    @Test
    public void testDivisionByZero() {

        assertThrows(RuntimeException.class, () -> interpreter.interpret("2 0 /"));
    }

}