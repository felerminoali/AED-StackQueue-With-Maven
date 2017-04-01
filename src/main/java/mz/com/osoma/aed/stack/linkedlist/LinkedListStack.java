/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.stack.linkedlist;

import mz.com.osoma.aed.stack.Stack;
import mz.com.osoma.aed.stack.StackEmptyException;
import mz.com.osoma.aed.stack.StackFullException;

/**
 *
 * @author feler
 */
public class LinkedListStack implements Stack{
    
    private LinkList theList;
    
    
    public LinkedListStack(){
        theList = new LinkList();
    }

    @Override
    public int size() {
        return theList.tamanho();
    }

    @Override
    public boolean isEmpty() {
        return (theList.isEmpty());
    }

    @Override
    public int peek() throws StackEmptyException {
        
        if(theList.isEmpty()){
            throw new StackEmptyException("Stack Empty");
        }
        
        return theList.pega(0);
    }

    @Override
    public void push(int value) throws StackFullException {
        theList.adiciona(value);
    }

    @Override
    public int pop() throws StackEmptyException {
        
        if(theList.isEmpty()){
            throw new StackEmptyException("Stack Empty");
        }
        return theList.remove();
    }
    
    @Override
    public String toString(){
        return theList.toString();
    }
    
    
    public static void main(String[] args) {

        LinkedListStack s = new LinkedListStack();
        
        s.push(1);
        s.push(2);
        s.push(3);
        
        System.out.println(s.peek());
        System.out.println(s);
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

       
    }
}
