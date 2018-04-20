/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.stack.array;

import java.util.Arrays;
import mz.com.osoma.aed.stack.Stack;
import mz.com.osoma.aed.stack.StackEmptyException;
import mz.com.osoma.aed.stack.StackFullException;

/**
 *
 * @author feler
 */
public class ArrayStack implements Stack {

    private int[] stackArray;
    private int stackSize;

    // define a pilha com vazia
    private int topOfStack = -1;

    public ArrayStack(int size) {

        this.stackSize = size;
        this.stackArray = new int[size];
        this.topOfStack = -1;
    }

    @Override
    public int size() {
        return this.topOfStack+1;
    }

    @Override
    public boolean isEmpty() {
        return (topOfStack == -1);
    }

    public boolean isFull() {
        return (topOfStack == size() - 1);
    }

    @Override
    public int peek() throws StackEmptyException {

        if (topOfStack >= 0) {
            return this.stackArray[topOfStack];
        } else {
            throw new StackEmptyException("Stack Empty");
        }
    }

    @Override
    public void push(int value) throws StackFullException {

        if (topOfStack + 1 > stackSize) {
            throw new StackFullException("Stack Overflow");
        }

        topOfStack++;
        stackArray[topOfStack] = value;
    }

    @Override
    public int pop() throws StackEmptyException {
        if (topOfStack < 0) {
            throw new StackEmptyException("Stack Empty");
        }

        return stackArray[topOfStack--];

    }

    public static void main(String[] args) {

        ArrayStack s = new ArrayStack(3);

        s.push(1);
        s.push(2);
        s.push(3);

        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.pop());
        }

        System.out.println(s.peek());
    }
}
