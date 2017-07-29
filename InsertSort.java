package com.sort;

/**
 * Created by 祥少 on 2017/7/28.
 */
public class InsertSort {
    public static void insert(int a[]){
        long begin1=System.currentTimeMillis();
        for(int i=1;i<a.length;i++){
            for (int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    TestUtil.swap(a,j-1,j);
                }else{
                    break;
                }
            }
        }
        System.out.println("InsertSort time:"+(System.currentTimeMillis()-begin1));
        if(!TestUtil.isSort(a)){
            System.out.println("排序失败");
        }
    }

    public static void insert1(int a[]){
        long begin1=System.currentTimeMillis();
        for(int i=1;i<a.length;i++){

            int e=a[i];
            int j;
            for (j=i;j>0&&a[j-1]>e;j--){
                a[j]=a[j-1];
            }
            a[j]=e;
        }
        System.out.println("InsertSort1 time:"+(System.currentTimeMillis()-begin1));
        if(!TestUtil.isSort(a)){
            System.out.println("排序失败");
        }
    }
}
