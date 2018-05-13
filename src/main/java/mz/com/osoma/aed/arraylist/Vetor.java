/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed.arraylist;

/**
 *
 * @author feler
 */
public class Vetor implements Operacoes, Ordenacao, Busca {

    private int[] theArray = new int[100];
    private int totalDeElementos = 0;

    @Override
    public void adiciona(int elemento) {
        this.theArray[this.totalDeElementos] = elemento;
        this.totalDeElementos++;
    }

    @Override
    public void adiciona(int posicao, int elemento) {

        for (int i = this.totalDeElementos - 1; i >= posicao; i--) {
            this.theArray[i + 1] = this.theArray[i];
        }
        this.theArray[posicao] = elemento;
        this.totalDeElementos++;

        this.theArray[posicao] = elemento;
    }

    @Override
    public int pega(int posicao) {
        return this.theArray[posicao];
    }


    @Override
    public int remove(int posicao) {
        int temp =  this.theArray[posicao];
        for (int i = posicao; i < this.totalDeElementos - 1; i++) {
            this.theArray[i] = this.theArray[i + 1];
        }
        this.totalDeElementos--;
        return temp;
    }

    @Override
    public int tamanho() {
        return this.totalDeElementos;
    }

    @Override
    public String toString() {
        if (this.totalDeElementos == 0) {
            return " [] ";
        }

        StringBuilder builder = new StringBuilder();

        builder.append("[");

        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(this.theArray[i]);
            builder.append(", ");
        }
        builder.append(this.theArray[this.totalDeElementos - 1]);
        builder.append("]");
        return builder.toString();
    }

    private void troca(int indexOne, int indexTwo) {
        int aux = this.theArray[indexOne];
        this.theArray[indexOne] = this.theArray[indexTwo];
        this.theArray[indexTwo] = aux;
    }

    @Override
    public void bubbleSort() {

        System.out.println("\n\n\n --- Bubble Sort");

        int length = this.totalDeElementos;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.theArray[j] > this.theArray[j + 1]) {
                    troca(j, j + 1);
                    printHorzArray(i, j);
                }
            }
        }
    }

    @Override
    public void insertionSort() {

        System.out.println("\n\n\n --- Insertion Sort");

        for (int out = 1; out < this.totalDeElementos; out++) {  // out is dividing line
            int temp = this.theArray[out];                   // remove marked line
            int in = out;                                       // Start shifts marked item

            // Until one is smaller
            while (in > 0 && this.theArray[in - 1] > temp) {
                this.theArray[in] = this.theArray[in - 1];        // Shift item right
                --in;
            }
            this.theArray[in] = temp;

            printHorzArray(out, in);
        }

    }

    @Override
    public void selectionSort() {

        System.out.println("\n\n\n --- Selection Sort");

        int min;

        for (int out = 0; out < this.totalDeElementos - 1; out++) {    // outer loop
            min = out;                                              // minimum
            for (int in = out + 1; in < this.totalDeElementos; in++) { // inner loop
                if (this.theArray[in] < this.theArray[min]) { // if min is greater
                    min = in;                                       // We have a new Min
                    this.troca(out, min);
                    this.printHorzArray(out, -1);
                }
            }
        }
    }

    public void printHorzArray(int i, int j) {

        for (int n = 0; n < this.totalDeElementos; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int k = 0; k < this.totalDeElementos; k++) {
            System.out.print("| " + k + " ");
        }

        System.out.println("|");

        for (int k = 0; k < this.totalDeElementos; k++) {
            System.out.print("-");
        }

        System.out.println();

        for (int k = 0; k < this.totalDeElementos; k++) {
            System.out.print("| " + this.theArray[k] + " ");
        }

        System.out.println("|");

        for (int k = 0; k < this.totalDeElementos; k++) {
            System.out.print("-");
        }

        System.out.println();

        // End of first part 
        // Added for bubble sort 
        if (j != -1) {
            // Add the +2 to fix spacing
            for (int k = 0; k < ((j * 5) + 2); k++) {
                System.out.print(" ");
            }

            System.out.print(j);
        }

        // Then add this code
        if (i != -1) {

            // Add the -1 to fox spacing
            for (int k = 0; k < (5 * (i - j) - 1); k++) {
                System.out.print(" ");
            }
            System.out.print(i);
        }

        System.out.println();

    }

    @Override
    public void quickSort() {

        System.out.println("\n\n\n --- Quick Sort");
        this.recQuickSort(0, this.totalDeElementos - 1);
    }

    private void recQuickSort(int left, int right) {

        if (right - left <= 0) {      // if size  <= 1
            return;             // already sorted
        } else {                  // size is 2 or larger

            // rightmost item
            int pivot = this.theArray[right];

            // partitio range
            int partition = partitionIt(left, right, pivot);

            recQuickSort(left, partition - 1);    // sort left side
            recQuickSort(partition + 1, right);   // sort right side
        }
    }

    private int partitionIt(int left, int right, int pivot) {

        int leftPtr = left - 1; // left after ++
        int rightPtr = right; // right after --

        while (true) {

            // Find bigger item
            while (this.theArray[++leftPtr] < pivot)
                ; // nop

            // Find smaller item
            while (rightPtr > 0 && this.theArray[--rightPtr] > pivot)
                ; // nop

            if (leftPtr >= rightPtr) {          // if pointers cross,
                break;                          // partion done
            } else {                            // not crossed, so
                troca(leftPtr, rightPtr);       // Swap elements
            }   // end while(true)
        }
        troca(leftPtr, right);   // restore pivot
        return leftPtr;             // return pivot location 
    }

    @Override
    public boolean linearSearch(int searchKey) {
        for (int i = 0; i < this.totalDeElementos; i++) {
            if (theArray[i] == searchKey) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean binarySearch(int searchKey) {
        int lowIndex = 0;
        int highIndex = this.totalDeElementos - 1;

        while (lowIndex <= highIndex) {

            int middleIndex = (highIndex + lowIndex) / 2;

            if (theArray[middleIndex] < searchKey) {
                lowIndex = middleIndex + 1;
            } else if (theArray[middleIndex] > searchKey) {
                highIndex = middleIndex - 1;
            } else {

                lowIndex = highIndex + 1;
                return true;

            }

        }

        return false;

    }

}
