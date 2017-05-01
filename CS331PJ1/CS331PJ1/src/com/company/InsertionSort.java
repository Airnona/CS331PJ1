package com.company;

/**
 * Created by Waylon on 4/27/2017.
 */
public class InsertionSort {
    private int[] arr;
    private int length;

    public void sort(int[] values){
        this.arr = values;
        length = values.length;

        insertionSort();
    }

    private void insertionSort(){
        int checker;
        int j;
        for(int i = 1; i < length; i++){
            checker = arr[i];
            j = i-1;
            while (j >= 0 && checker < arr[j]){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = checker;
        }
    }

}
