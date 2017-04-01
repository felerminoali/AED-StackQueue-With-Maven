/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.queue;

/**
 *
 * @author feler
 */
public interface Queue {

    public int size(); // retorna o tamanho da pilha

    public boolean isEmpty(); // retorna true se a fila estiver vazia

    public int front() throws QueueEmptyException; // retorna o valor no inicio da fila

    public void insert(int o); // adiciona um novo item no final da fila

    public int remove() throws QueueEmptyException; // retorna o valor no inicio da fila

}
