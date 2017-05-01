package com.company;

/**
 * Created by Waylon on 4/27/2017.
 */
public class QuickSort {

    private int[] arr;
    private int length;

    public void sort(int[] values){
        if (values == null || values.length == 0)
            return;
        this.arr = values;
        length = values.length;
        quickSort(0, length - 1);

    }


    private void quickSort(int low, int high) {
        if (low >= high){
            return;
        }
        int pivot = arr[low];                   //changed mid to low

        int i = low + 1, j = high;                  //sort through to find i and j indexes
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
