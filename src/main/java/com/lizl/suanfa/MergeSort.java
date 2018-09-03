package com.lizl.suanfa;

import java.util.Arrays;

/**
 * @author lizl
 * @date 2018/8/30 17:02
 */
public class MergeSort {

    public static void sort(int a[],int start , int end,int tmp[]){
        //分解

        if(start < end){
            int mid = (start + end)/2;
            sort(a,start,mid,tmp);
            sort(a,mid+1,end,tmp);
            merge(a,start,mid,end,tmp);
        }
    }

    public static void merge(int a[], int start, int mid, int end, int tmp[]){
        int i = start;//左序列起点
        int j = mid +1;//右序列起点
        int t = 0;//tmp 起点

        while (i <= mid && j <=end){
            if(a[i] <= a[j]){
                tmp[t++] = a[i++];
            }else {
                tmp[t++] = a[j++];
            }
        }
        while (i <= mid){
            tmp[t++] = a[i++];
        }
        while (j <=end){
            tmp[t++] = a[j++];
        }

        t = 0;

        while (start <= end){
            a[start++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int a[] = {7,3,5,6};
        int tmp[] = new int[a.length];
        sort(a,0,a.length-1,tmp);
        System.out.println(Arrays.toString(a));
    }
}
