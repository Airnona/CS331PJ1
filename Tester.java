package com.company;

import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Aniratak on 4/28/2017.
 */
public class Tester {

    public Tester() throws IOException{
        File file1 = new File("C:\\Users\\Aniratak\\Desktop\\iTimeResults.txt");
        file1.createNewFile();
        File file2 = new File("C:\\Users\\Aniratak\\Desktop\\mTimeResults.txt");
        file2.createNewFile();
        File file3 = new File("C:\\Users\\Aniratak\\Desktop\\q1TimeResults.txt");
        file3.createNewFile();
        File file4 = new File("C:\\Users\\Aniratak\\Desktop\\q2TimeResults.txt");
        file4.createNewFile();
        File file5 = new File("C:\\Users\\Aniratak\\Desktop\\q3TimeResults.txt");
        file5.createNewFile();
        fw1 = new FileWriter(file1);
        fw2 = new FileWriter(file2);
        fw3 = new FileWriter(file3);
        fw4 = new FileWriter(file4);
        fw5 = new FileWriter(file5);
    }
    private FileWriter fw1, fw2, fw3, fw4, fw5;

    QuickSort qSort1 = new QuickSort();
    QuickSort2 qSort2 = new QuickSort2();
    QuickSort3 qSort3 = new QuickSort3();
    MergeSort mSort = new MergeSort();
    InsertionSort iSort = new InsertionSort();

    final double REPEAT = 20.0;     //How many times each sort will be tested for each array size
    private Random rand;
    private Double length;
    private int[] arr;

    private double iniTime, finTime;
    private double iTimeTot = 0.0, mTimeTot = 0.0, q1TimeTot = 0.0, q2TimeTot = 0.0, q3TimeTot = 0.0;

    private int n = 16;          //exponent it will go to

    public void generator() throws IOException{
        for(int x = 1; x <= n; x++) {
            length = Math.pow(2.0, ((double)x));                //Makes arr length = 2^x
            for (int i = 0; i < 5 * REPEAT; i++) {

                arr = new int[length.intValue()];               //makes array
                rand = new Random(100);
                for(int m = 0; m < length.intValue(); m++){     //assigns random values (seeded)
                    arr[m] = rand.nextInt() % 100;
                }

                timeTester(i);                                 //calls sorts
            }
            averageTimes(REPEAT, x);
        }
        fw1.close();
        fw2.close();
        fw3.close();
        fw4.close();
        fw5.close();
    }
    private void timeTester(int choose) throws IOException{
        if(choose < 20)
            choose = 0;
        if(choose >19 && choose < 40)
            choose = 1;
        if(choose > 39 && choose < 60)
            choose = 2;
        if(choose > 59 && choose < 80)
            choose = 3;
        if(choose > 79 && choose < 100)
            choose = 4;
        if(choose < 0 && choose > 99)
            choose = 200;

        switch (choose) {
            case 0:                 //INSERTION SORT
                iniTime = System.nanoTime();
                iSort.sort(arr);
                finTime = System.nanoTime();
                iTimeTot += finTime - iniTime;
                break;
            case 1:                 //MERGE SORT
                iniTime = System.nanoTime();
                mSort.sort(arr);
                finTime = System.nanoTime();
                mTimeTot += finTime - iniTime;
                break;
            case 2:                 //QUICK SORT 1
                iniTime = System.nanoTime();
                qSort1.sort(arr);
                finTime = System.nanoTime();
                q1TimeTot += finTime - iniTime;
                break;
            case 3:                 //QUICK SORT 2
                iniTime = System.nanoTime();
                qSort2.sort(arr);
                finTime = System.nanoTime();
                q2TimeTot += finTime - iniTime;
                break;
            case 4:                 //QUICK SORT 3
                iniTime = System.nanoTime();
                qSort3.sort(arr);
                finTime = System.nanoTime();
                q3TimeTot += finTime - iniTime;
                break;
            default:
                System.out.println("I don't even know how the hell this would be reached");
        }

    }

    private void averageTimes(double repeat, int expo) throws IOException{
        Double iTime = iTimeTot / repeat;
        Double mTime = mTimeTot / repeat;
        Double q1Time = q1TimeTot / repeat;
        Double q2Time = q2TimeTot / repeat;
        Double q3Time = q3TimeTot / repeat;
        fw1.write(iTime.toString() + "\r\n");
        fw1.flush();
        fw2.write(mTime.toString() + "\r\n");
        fw2.flush();
        fw3.write(q1Time.toString() + "\r\n");
        fw3.flush();
        fw4.write(q2Time.toString() + "\r\n");
        fw4.flush();
        fw5.write(q3Time.toString() + "\r\n");
        fw5.flush();
        System.out.println("Finished with array length 2^" + expo);
    }
}
