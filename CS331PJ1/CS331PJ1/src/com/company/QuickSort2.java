package com.company;

/**
 * Created by Waylon on 4/27/2017.
 */
public class QuickSort2 {
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
        if((high - low) < 16){
            insertionSort(low, high);
        }
        else {
            if (low >= high)
                return;
            int pivot = arr[low];

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
    private void insertionSort(int low, int high){
        int checker;
        int j;
        for(int i = low + 1; i < high + 1; i++){
            checker = arr[i];
            j = i-1;
            while (j >= low && checker < arr[j]){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = checker;
        }
    }
}
