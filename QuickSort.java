package com.sort;

import java.util.Random;

/**
 * Created by 祥少 on 2017/7/28.
 */
public class QuickSort {
    public static void quick(int a[]) {
        long begin1 = System.currentTimeMillis();

        __quickSort1(a, 0, a.length - 1);

        System.out.println("QuickSort time:" + (System.currentTimeMillis() - begin1));
        if (!TestUtil.isSort(a)) {
            System.out.println("排序失败");
        }
    }

    private static void __quickSort1(int[] a, int l, int r) {
        //三路快速排序 解决等于的情况
        if (l >= r) {
            return;
        }

        Random rand = new Random();
        TestUtil.swap(a, l, rand.nextInt(r - l + 1) + l);
        int v = a[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while (i < gt) {
            if (a[i] < v) {
                TestUtil.swap(a,i, lt+1);
                i++;
                lt++;
            } else if (a[i] > v) {
                TestUtil.swap(a,i, gt-1);
                gt--;
            } else {
                i++;
            }
        }
        TestUtil.swap(a,l, lt);

        __quickSort1(a, l, lt-1);
        __quickSort1(a, gt, r);
    }

    private static void __quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = __partition(a, l, r);
        __quickSort(a, l, p - 1);
        __quickSort(a, p + 1, r);

    }

    private static int __partition2(int[] a, int l, int r) {
        //大量重复数据
        //针对顺序数组排序
        Random rand = new Random();
        TestUtil.swap(a, l, rand.nextInt(r - l + 1) + l);
        int v = a[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && a[i] < v) i++;
            while (j >= l && a[j] > v) j--;
            if (i > j) break;
            TestUtil.swap(a, i, j);
            i++;
            j--;
        }
        TestUtil.swap(a, l, j);
        return j;
    }

    private static int __partition(int[] a, int l, int r) {
        //针对顺序数组排序
        Random rand = new Random();
        TestUtil.swap(a, l, rand.nextInt(r - l + 1) + l);
        int v = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < v) {
                TestUtil.swap(a, j + 1, i);
                j++;
            }
        }
        TestUtil.swap(a, l, j);
        return j;
    }
}
