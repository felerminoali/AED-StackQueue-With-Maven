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
        
       
        
        String expression = "{[(A+b)*D]}";
        
                
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        
     
    }

    public static void reverso(LinkedListStack s) throws StackFullException, StackEmptyException {
        String str = "ESTE EXERCICIO E MUITO FACIL";
        str = str.trim();
        
        String[] words = str.split(" ");
       
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
          
            for (int j = 0; j < chars.length; j++) {
                //System.out.print(chars[j]);
                s.push(chars[j]);
            }
            String temp = "";
            while(!s.isEmpty()){
                temp+=(char)s.pop();
            }
            result.append(temp);
            result.append(" ");
        }
        
        System.out.println(result.toString());
        
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        
//        System.out.println(s.peek());
//        System.out.println(s);
//        
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
    }
}
