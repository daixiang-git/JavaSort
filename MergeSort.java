package com.sort;

/**
 * Created by 祥少 on 2017/7/28.
 */
public class MergeSort {

    //自底向上
    public static void mergeBU(int a[]) {
        long begin1 = System.currentTimeMillis();


        for(int sz=1;sz<a.length;sz+=sz){
            for(int i=0;i<a.length;i+=sz+sz){
                __merge(a,i,i+sz-1,Math.min(i+sz+sz-1,a.length-1));
            }
        }

        System.out.println("MergeSort time:" + (System.currentTimeMillis() - begin1));
        if (!TestUtil.isSort(a)) {
            System.out.println("排序失败");
        }
    }


    public static void merge(int a[]) {
        long begin1 = System.currentTimeMillis();
        mergeSort(a, 0, a.length - 1);

        System.out.println("MergeSort time:" + (System.currentTimeMillis() - begin1));
        if (!TestUtil.isSort(a)) {
            System.out.println("排序失败");
        }
    }

    public static void mergeSort(int a[], int l, int r) {
        if (l >= r) {
            return;
        }
        //优化2   l-r小于15 改为插入排序
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        //优化1
        if (a[mid] > a[mid + 1])
            __merge(a, l, mid, r);
    }

    private static void __merge(int[] a, int l, int mid, int r) {
        int buff[] = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            buff[i - l] = a[i];
        }

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                a[k] = buff[j - l];
                j++;
            } else if (j > r) {
                a[k] = buff[i - l];
                i++;
            } else if (buff[i - l] > buff[j - l]) {
                a[k] = buff[j - l];
                j++;
            } else {
                a[k] = buff[i - l];
                i++;
            }
        }
    }
}
