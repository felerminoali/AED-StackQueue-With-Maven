/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.queue.linkedlist;

import mz.com.osoma.aed.queue.Queue;
import mz.com.osoma.aed.queue.QueueEmptyException;

/**
 *
 * @author feler
 */
public class LinkQueque implements Queue {

    private DoubleEndedList theList;

    public LinkQueque() {
        theList = new DoubleEndedList();
    }

    @Override
    public int size() {
        return theList.tamanho();
    }

    @Override
    public boolean isEmpty() {
        return theList.isEmpty();
    }

    @Override
    public int front() throws QueueEmptyException {
        if (theList.isEmpty()) {
            throw new QueueEmptyException("Empty Queue");
        }

        return theList.pega(0);
    }

    @Override
    public void insert(int elemento) {
        theList.adicionaNoFim(elemento);
    }

    @Override
    public int remove() throws QueueEmptyException {
        if (theList.isEmpty()) {
            throw new QueueEmptyException("Empty Queue");
        }
        return theList.removeDoComeco();
    }

    public static void main(String[] args) {

        LinkQueque theQueque = new LinkQueque();

        theQueque.insert(20);
        theQueque.insert(40);
        theQueque.insert(60);
        theQueque.insert(80);

        System.out.println(theQueque.theList);
        System.out.println(theQueque.front());

        System.out.println(theQueque.remove());
        System.out.println(theQueque.theList);

    }
}
