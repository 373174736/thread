package com.lizl.thread.t1;

public class Main {

    public static void main(String []args){

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        Singleton s4 = Singleton.getInstance();
        Singleton s5 = Singleton.getInstance();


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);


        Singleton2 s21 = Singleton2.getInstance();
        Singleton2 s22 = Singleton2.getInstance();
        Singleton2 s23 = Singleton2.getInstance();
        Singleton2 s24 = Singleton2.getInstance();
        Singleton2 s25 = Singleton2.getInstance();


        System.out.println(s21);
        System.out.println(s22);
        System.out.println(s23);
        System.out.println(s24);
        System.out.println(s25);
    }
}
