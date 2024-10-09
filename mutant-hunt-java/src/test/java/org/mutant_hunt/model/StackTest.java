package org.mutant_hunt.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void sePuedeCrearUnStackDeTamanioCero() {
        assertDoesNotThrow(() -> new Stack(0));
    }

    @Test
    void siLaPilaEstaLlenaNoSePuedePushearNada() {
        var stack = new Stack(1);
        stack.push(1);
        assertThrows(IllegalStateException.class ,() -> stack.push(2));
    }

    @Test
    void siLaPilaEstaVaciaNoSePuedeHacerPop() {
        var stack = new Stack();
        assertThrows(IllegalStateException.class , stack::pop);
    }

    @Test
    void popRetornaElElementoQueEstabaEnElTopeDeLaPila() {
        var stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    void noSePuedePedirElTopeDeLaPilaSiNoTieneElementos() {
        var stack = new Stack();
        assertThrows(IllegalStateException.class , stack::top);
    }

    @Test
    void topDevuelveElElementoDelTopeDeLaPila() {
        var stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.top());
    }

    @Test
    void unaInstanciaDeStackEsIgualASiMisma() {
        var stack = new Stack();
        assertEquals(stack, stack);
    }

    @Test
    void unaInstanciaDeStackEsDistintaDeNull() {
        assertNotEquals(new Stack(), null);
    }

    @Test
    void siSonClasesDistintasEntoncesNoSonIguales() {
        assertNotEquals(new Stack(), "");
    }

    @Test
    void siLosTamaniosDeLosStackSonDistintosEntoncesNoSonIguales() {
        assertNotEquals(new Stack(), new Stack(1));
    }

    @Test
    void siLosArraysSonIgualesPeroLosIndicesNoEntoncesNoSonIguales() {
        var stack = new Stack();
        var otroStack = new Stack();
        stack.push(1);
        otroStack.push(1);
        stack.pop();
        assertNotEquals(stack, otroStack);
    }

    @Test
    void siLosStackTienenLaMismaCapacidadYMismaCantidadDeCosasEntoncesSonIguales() {
        assertEquals(new Stack(), new Stack());
    }

    @Test
    void devuelveElHashDelStack() {
        var prime = 31;
        var result = 1;
        result = prime + Arrays.hashCode(new Object[10]);
        result = prime * result + -1;
        assertEquals(result, new Stack().hashCode());
    }
}