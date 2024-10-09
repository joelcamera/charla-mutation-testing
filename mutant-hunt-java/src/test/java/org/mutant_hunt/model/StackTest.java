package org.mutant_hunt.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testConstructorWithSpecifiedCapacity() {
        assertDoesNotThrow(() -> new Stack(5));
    }

    @Test
    void testDefaultConstructor() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testConstructorWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Stack(-1));
    }

    @Test
    void testSizeIncreasesByOne() {
        Stack stack = new Stack();
        assertEquals(0, stack.size());
        stack.push(42);
        assertEquals(1, stack.size());
    }

    @Test
    void testIsEmptyMethod() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(42);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsFullMethod() {
        Stack stack = new Stack(1);
        assertFalse(stack.isFull());
        stack.push(42);
        assertTrue(stack.isFull());
        stack.pop();
        assertFalse(stack.isFull());
    }

    @Test
    void testToStringMethod() {
        Stack stack = new Stack(2);
        assertEquals("[]", stack.toString());
        stack.push(42);
        assertEquals("[42]", stack.toString());
        stack.push(43);
        assertEquals("[42,43]", stack.toString());
    }
}