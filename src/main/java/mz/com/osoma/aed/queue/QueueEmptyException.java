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
public class QueueEmptyException extends RuntimeException{
    
        public QueueEmptyException(String message){
            System.out.println(message);
        }
}
