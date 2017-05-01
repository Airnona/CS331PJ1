package com.company;

/**
 * Created by Waylon on 4/27/2017.
 */
public class MergeSort {
    private int[] arr;
    private int[] helper;


    public void sort(int[] values) {
        this.arr = values;
        int length = values.length;
        this.helper = new int[length];
        mergeSort(0, length - 1);
    }

    public void mergeSort(int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(low, mid);            //sort left . right
            mergeSort(mid + 1, high);

            merge(low, mid, high);          //combine them BOTH
        }
    }
    private void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                arr[k] = helper[i];
                i++;
            } else {
                arr[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = helper[i];
            k++;
            i++;
        }

    }
}
