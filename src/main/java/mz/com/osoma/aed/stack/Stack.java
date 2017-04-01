/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.stack;

/**
 *
 * @author feler
 */
public interface Stack {

    public int size();

    public boolean isEmpty();

    public int peek() throws StackEmptyException;

    public void push(int value) throws StackFullException;

    public int pop() throws StackEmptyException;

}
