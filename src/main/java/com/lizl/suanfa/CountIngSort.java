package com.lizl.suanfa;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author lizl
 * @date 2018/9/4 15:02
 */
public class CountIngSort {

    private static void countIngSort(int a[], int max){
        int[] c = new int[max];
        for(int i = 0 ; i< c.length ; i++){
            c[i] = 0;
        }
        for(int i =0 ;i<a.length ; i++){
            c[a[i]] = c[a[i]] +1;
        }

        for(int i=1;i<c.length;i++){
            c[i] = c[i] +c[i-1];
        }

        int[] b = new int[a.length];
        for(int i=a.length -1;i >=0;i--){
            b[c[a[i]]-1] = a[i];
            c[a[i]] --;
        }
        System.out.println(Arrays.toString(b));
    }


    public static void main(String[] args) {
        int[] a = {50,10,90,30,70,40,80,60,20,80};
        countIngSort(a, 91);
    }
}
