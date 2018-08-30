package com.lizl.suanfa;

/**
 * 查找最大子数组
 *
 * @author lizl
 * @date 2018/8/29 16:05
 */
public class FindMaxCorssingSubarray {


    public static void findMaxCorssingSubarray(int[] a){
        int mid = a.length/2;
        int max = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int tmp = 0;
        for(int i = mid ; i >=0; i--){
            tmp  += a[i];
            if(tmp > max){
                max = tmp;
                leftIndex = i;
            }
        }
        max = 0;
        tmp=0;
        for(int i= mid+ 1; i< a.length; i++){
            tmp  +=a[i];
            if(tmp > max){
                max =tmp;
                rightIndex = i;
            }
        }
        System.out.println("leftIndex=" + leftIndex +", rightIndex=" + rightIndex);
    }

    public static void main(String[] args) {
        int a[]={13, -3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

        findMaxCorssingSubarray(a);
    }
}
