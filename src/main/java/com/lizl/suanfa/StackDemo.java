package com.lizl.suanfa;

/**
 * 数据结构-栈
 *
 * @author lizl
 * @date 2018/9/4 18:32
 */
public class StackDemo {

    Object[] data;
    int top;
    private boolean empty(){
        return top == 0;
    }

    private void push(Object e){
        top ++;
        data[top] = e;
    }

    private Object pop(){
        if(empty()){
            return "";
        }
        Object e = data[top];
        top--;
        return e;
    }
}
