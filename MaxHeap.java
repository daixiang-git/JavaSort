package com.sort;

/**
 * Created by 祥少 on 2017/7/29.
 */
public class MaxHeap {
    static int[] a;
    static int count;

    public MaxHeap(int n) {
        this.a = new int[n + 1];
        this.count = 0;
    }

    public MaxHeap(int arr[], int n) {
        this.a = new int[n + 1];
        this.count = n;
        for (int i = 0; i < n; i++) {
            a[i + 1] = arr[i];
        }
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public static void sout() {
        for (int i = 0; i < count; i++) {
            System.out.print(getMax() + " ");
        }
    }

    public static void insert(int k) {
        a[count + 1] = k;
        count++;
        shitUp(count);

    }

    private static void shitUp(int k) {
        while (k > 1 && a[k / 2] < a[k]) {
            TestUtil.swap(a, k / 2, k);
            k /= 2;
        }
    }

    public static int getMax() {
        int max = a[1];
        TestUtil.swap(a, 1, count);
        count--;
        shiftDown(1);
        return max;
    }

    private static void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && a[j + 1] > a[j]) {
                j += 1;
            }
            if (a[k] >= a[j]) {
                break;
            }
            TestUtil.swap(a, k, j);
            k = j;
        }
    }
}
