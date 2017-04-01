/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.queue.array;

import mz.com.osoma.aed.queue.Queue;
import mz.com.osoma.aed.queue.QueueEmptyException;

/**
 *
 * @author feler
 */
public class ArrayQueue implements Queue{
    
    private int[] theQueue;
    private int maxSize;
    
    int front; 
    int rear;
    int nItems;
    
    
    public ArrayQueue(int size){
        theQueue = new int[size];
        maxSize = size;
        front = 0;
        rear = -1;
        nItems = 0;
        
    }

    @Override
    public int size() {
        return nItems;
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }


    public boolean isFull() {
        return (nItems == maxSize);
    }

    @Override
    public int front() throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException("Queue Emplty");
        }
        
        return theQueue[front];
    }

    @Override
    public void insert(int value) {
        if(rear+1 > maxSize){
            rear = -1;
        }
        theQueue[rear] = value;
        rear++;
        nItems++;
    }

    @Override
    public int remove() throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException("Queue Emplty");
        }
        
        int temp = theQueue[front++];
        
        if(front == maxSize) front = 0;
        
        nItems--;
        return temp;
    }
    
    
    
}
