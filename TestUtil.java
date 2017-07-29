package com.sort;

import java.util.Arrays;

/**
 * Created by 祥少 on 2017/7/28.
 */
public class TestUtil {

    public static void main(String[] args) {
        int a[] = getA(100000, 100000);

        System.out.println();
        System.out.println("--------------------------");

//        SelectSort.select(copyArray(a));
//        InsertSort.insert(copyArray(a));
//        InsertSort.insert1(copyArray(a));
//        MergeSort.merge(copyArray(a));
//        QuickSort.quick(copyArray(a));
        MaxHeap maxHeap = new MaxHeap(a,100000);
        maxHeap.sout();

//        long be=System.currentTimeMillis();
//        Arrays.sort(copyArray(a));
//        System.out.println("Arrayssort:"+(System.currentTimeMillis()-be));
    }


    public static int[] getA(int num, int size) {
        int a[] = new int[num];
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < num; i++) {
            a[i] = r.nextInt(size);
        }
        return a;
    }

    public static int[] getOrderA(int num, int size) {
        int a[] = new int[num];
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < num; i++) {
            a[i] = i;
        }
        for (int i = 0; i < size; i++) {
            swap(a, r.nextInt(size), r.nextInt(size));
        }
        return a;
    }

    public static void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public static boolean isSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int a[]) {
        return Arrays.copyOf(a, a.length);
    }
}
