package com.lizl.suanfa;

import java.util.Arrays;

/**
 * @author lizl
 * @date 2018/9/3 14:32
 */
public class QuickSort {
    private static void quickSort(int a[], int low, int high){
        int pivot;
        if(low < high){
            pivot = partition1(a, low, high);
            quickSort(a,low ,pivot -1);
            quickSort(a,pivot+1, high);
        }

        System.out.println(Arrays.toString(a));
    }

    private static int partition(int a[],int low, int high){
        int pivotkey;

        pivotkey = a[low];

        while (low < high){
            while(low<high && a[high]>=pivotkey){
                high--;
            }
            swap(a, low, high);

            while (low<high && a[low]<=pivotkey){
                low++;
            }
            swap(a,low,high);
        }
        return  low;
    }

    private static int partition1(int a[],int low, int high){
        int x = a[high];
        int i= low;
        // 
        for(int j=low;j<high;j++){
            if(a[j]<= x){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,high);
        return i;
    }

    private static void swap(int[] a,int low, int high){
        int tmp ;
        tmp = a[low];
        a[low] = a[high];
        a[high] = tmp;

    }

    public static void main(String[] args) {
//        int[] a = {50,10,20};
        int[] a = {50,10,90,30,70,40,80,60,20};

        quickSort(a,0,a.length -1);
    }
}
