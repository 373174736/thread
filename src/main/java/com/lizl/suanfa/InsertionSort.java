package com.lizl.suanfa;

/**
 * 插入排序
 *
 * @author lizl
 * @date 2018/8/28 14:52
 */
public class InsertionSort {

    /**
     * asc
     * @param ints
     */
    public static void insertionSotr(int[] ints){

        for(int i = 1;i< ints.length;i++){
            int j = i-1;
            int now = ints[i];
           while(j >= 0 && ints[j]> now){
              ints[j + 1] = ints[j];
              j=j-1;
            }
            ints[j + 1] = now;
        }

        for(int i :ints){
            System.out.println(i);
        }
    }

    /**
     * asc
     * @param ints
     */
    public static void insertionSotrOrderbyDesc(int[] ints){

        for(int i = 1;i< ints.length;i++){
            int j = i-1;
            int now = ints[i];
            while(j >= 0 && ints[j] < now){
                ints[j + 1] = ints[j];
                j=j-1;
            }
            ints[j + 1] = now;
        }

        for(int i :ints){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        int[] ints = {10,2,7,1,100,4,3,7,2,9,10};

        insertionSotrOrderbyDesc(ints);
    }
}
