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
public class ArrayQueue implements Queue {

    private int[] theQueue;
    private int maxSize;

    int front;
    int rear;

    public ArrayQueue(int size) {
        theQueue = new int[size];
        maxSize = size;
        front = 0;
        rear = -1;

    }

    @Override
    public int size() {
        if (rear >= front) // contiguous sequence
        {
            return rear - front + 1;
        } else // broken sequence
        {
            return (maxSize - front) + (rear + 1);
        }
    }

    @Override
    public boolean isEmpty() {
        return (rear + 1 == front || 
                (front + maxSize - 1 == rear));
    }

    public boolean isFull() {
        return (rear + 2 == front || 
                (front + maxSize - 2 == rear));
    }

    @Override
    public int front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue Emplty");
        }

        return theQueue[front];
    }

    @Override
    public void insert(int value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        theQueue[++rear] = value;
    }

    @Override
    public int remove() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue Emplty");
        }

        int temp = theQueue[front++];

        if (front == maxSize) {
            front = 0;
        }

        return temp;
    }
    
}
