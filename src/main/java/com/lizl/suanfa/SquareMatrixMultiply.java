package com.lizl.suanfa;

/**
 * 矩阵乘法
 *
 * @author lizl
 * @date 2018/8/29 18:34
 */
public class SquareMatrixMultiply {

    public static void squareMatrixMultiply(int a[][],int b[][]){
        int c[][]={};
        for(int i=0;i<a.length;i++){
            for(int j= 0;j<a.length;j ++){
                int sum = 0;
                for(int k=0;k <a.length;k++){
                    sum +=a[i][k]*b[k][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println("");
        }

        System.out.println(c.toString());
    }
    public static void main(String[] args) {
        int a[][] = {{1,2,3},
                     {4,5,6},
                     {7,8,9}};
        int b[][] = {{7,8,9},
                     {6,5,4},
                     {3,2,1}};

        squareMatrixMultiply(a,b);

    }
}
