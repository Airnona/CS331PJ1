package com.company;

import java.util.Random;

/**
 * Created by Aniratak on 4/28/2017.
 */
public class QuickSort3 {
    private int[] arr;
    private int length;
    private int pivot;
    private int nextRand;
    private Random rand = new Random(System.currentTimeMillis());

    public void sort(int[] values){
        if (values == null || values.length == 0)
            return;
        this.arr = values;
        length = values.length;
        quickSort(0, length - 1);
    }


    private void quickSort(int low, int high) {
        for(int s = 0; s < length; s++){
        }
        if (low >= high){
            return;
        }
        if((high-low)+1 >=16){
            nextRand = low + rand.nextInt(((high-low)+1));
            pivot = arr[nextRand];
            arr[nextRand] = arr[low];
            arr[low] = pivot;
        }
        else {
            pivot = arr[low];                   //changed mid to low]
        }
        pivot = arr[low];

        int i = low + 1, j = high;              //sort through to find i and j indexes
        while (i <= j) {
            while (i <= j && arr[i] < pivot) {
                i++;
            }

            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = this.arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        if (low < j)
            quickSort(low, j);
        if (high > i)
            quickSort(i, high);
    }
}
