/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.arraylist;

import mz.com.osoma.aed.*;

/**
 *
 * @author feler
 */
public interface Operacoes {
   
    public void adiciona(int elemento);
    
    public void adiciona(int posicao, int elemento);
    
    public int pega(int posicao);
    
    public int remove(int posicao);
    
    public int tamanho();
}
