package com.lizl.suanfa;

/**
 * @author lizl
 * @date 2018/6/15 14:47
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return  null;
    }

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
//        System.out.println(reverse("9646324351"));
        System.out.println(isPalindrome(1234329));
    }

    public static int reverse(int x) {
        Long a = Long.valueOf(x);
        StringBuilder result = new StringBuilder();
        for(int i = a.toString().length(); i >=1 ;i-- ){
            result.append(a.toString().substring(i -1, i));
        }
        boolean isNegatice = a < 0 ;
        if(isNegatice){
            a = a * -1;
        }
        long re = isNegatice? Long.parseLong(result.toString()) * -1 : Long.parseLong(result.toString());
        if(re > Integer.MAX_VALUE || re< Integer.MIN_VALUE){
            return 0;
        }
        return Long.valueOf(re).intValue();
    }

    /**
     * 判断是否是回文数
     * 首先 负数 肯定是false 个位数肯定是true
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return  false;
        }
        int a [] = new int[String.valueOf(x).length()];
        int i = 0;
        while (x>=1){
            a[i++] = x%10;
            x/=10;
        }

        for(int j=1;j<=a.length;j++){
            if(a[j-1] != a[a.length-j]){
                return false;
            }
        }
        return true;
    }
}
