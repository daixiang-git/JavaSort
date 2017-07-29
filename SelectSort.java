package com.sort;

import java.util.Arrays;

/**
 * Created by 祥少 on 2017/7/28.
 */
public class SelectSort {
    public static int[] select(int a[]){
        long begin=System.currentTimeMillis();
        for(int i=0;i<a.length;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min=j;
                }
            }
            TestUtil.swap(a,i,min);
        }
        System.out.println("SelectSort time:"+(System.currentTimeMillis()-begin));
        if(!TestUtil.isSort(a)){
            System.out.println("排序失败");
        }
        return a;
    }
}
