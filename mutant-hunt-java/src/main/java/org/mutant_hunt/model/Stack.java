package org.mutant_hunt.model;

import java.util.Arrays;

public class Stack {

    private static final int DEFAULT_CAPACITY = 10;

    private final Object[] elems;

    private int readIndex = -1;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) throws IllegalArgumentException {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.elems = new Object[capacity];
    }

    public int size() {
        return readIndex+1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == elems.length;
    }

    public void push(Object o) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException();
        }
        this.readIndex++;
        this.elems[readIndex] = o;
    }

    public Object pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Object rv = this.elems[readIndex];
        readIndex--;
        return rv;
    }

    public Object top() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Object rv = this.elems[readIndex];
        return rv;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + Arrays.hashCode(elems);
        result = prime * result + readIndex;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Stack other = (Stack) obj;
        if (!Arrays.equals(elems, other.elems))
            return false;
        if (readIndex != other.readIndex)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();
        b.append("[");
        for (int i = 0; i <= readIndex; i++) {
            if (i > 0) {
                b.append(",");
            }
            Object o = elems[i];
            String s = String.valueOf(o);
            b.append(s);
        }
        b.append("]");
        return b.toString();
    }
}
