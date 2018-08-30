package com.lizl.invocation;

import com.google.common.collect.Maps;
import com.lizl.invocation.impl.SubjectImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lizl
 * @date 2018/6/13 11:47
 */
public class Client {
//    public static void main(String[] args) {
//        Subject realSubject = new SubjectImpl();
//
//        InvocationHandler handler = new DynamicProxy(realSubject);
//
//        Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces()
//        , handler);
//
//        System.out.println(subject.getClass().getName());
//        subject.rent();
//        subject.hello("world");
//    }
    public static void main(String[] args) {
        int [] nums = { -3, 4, 3, 90 };
        int target = 0;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int [] result = {0,0};
        Map<Integer, Integer> sum = new HashMap<>();
        for(int i = 0  ; i< nums.length ;i++){
            if(sum.containsKey(target - nums[i])){
                if(sum.get(target - nums[i]) > i ){
                    result[0] = i;
                    result[1] = sum.get(target - nums[i]);
                }else {
                    result[0] = sum.get(target - nums[i]);
                    result[1] = i;
                }
                break;
            }else {

                sum.put(nums[i], i);
            }
        }
        return result;
    }
}
