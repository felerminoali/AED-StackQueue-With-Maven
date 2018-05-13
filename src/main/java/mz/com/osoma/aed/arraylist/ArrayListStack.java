/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.arraylist;

import mz.com.osoma.aed.stack.Stack;
import mz.com.osoma.aed.stack.StackEmptyException;
import mz.com.osoma.aed.stack.StackFullException;
import mz.com.osoma.aed.stack.array.ArrayStack;

/**
 *
 * @author felermino
 */
public class ArrayListStack implements Stack {

    private Vetor stackArray;


    // define a pilha com vazia
    private int topOfStack = -1;

    public ArrayListStack() {
        this.stackArray = new Vetor();
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
            return this.stackArray.pega(topOfStack);
        } else {
            throw new StackEmptyException("Stack Empty");
        }
    }

    @Override
    public void push(int value) throws StackFullException {

        if (topOfStack + 1 > stackArray.tamanho()) {
            throw new StackFullException("Stack Overflow");
        }

        topOfStack++;
        stackArray.adiciona(value);
    }

    @Override
    public int pop() throws StackEmptyException {
        if (topOfStack < 0) {
            throw new StackEmptyException("Stack Empty");
        }

        return stackArray.remove(topOfStack--);

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
