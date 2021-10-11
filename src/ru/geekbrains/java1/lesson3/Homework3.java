package ru.geekbrains.java1.lesson3;

import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {
//решение задачи №1
        int[] array1 ={1,1,0,0,1,0,1,1,0,0,1,0,1};
//        print(array1);
        for(int i=0; i<array1.length; i++){
            array1[i]^=1;
        }
//        print(array1);
//решение задачи №2
        array1=new int[100];
//        print(array1);
        for(int i=0; i<array1.length; ++i){
            array1[i]=i+1;
        }
//        print(array1);
//решение задачи №3
        array1 = new int[]{1,5,3,2,11,4,5,2,4,8,9,1};
//        print(array1);
        for(int i=0; i<array1.length; i++){
            if(array1[i]<6){
                array1[i]*=2;
            }
        }
//        print(array1);
//решение задачи №4
        final int N=8;
        int[][] array2=new int[N][N];
        for(int i=0; i<array2.length; i++){
            array2[i][i]=1;
            array2[i][array2.length-i-1]=1;
        }
//        print(array2);
//вызов метода задачи №5
        array1=createArray(7,-8);
//        print(array1);
//решение задачи №6
        double[] array3={-12.0, -89.12, 34.45, 18, 102.23, 0, -5.12, 48.24, 8.9};
        if(array3.length>0) {
            double min, max;
            min = max = array3[0];
            for (int i = 1; i < array3.length; i++) {
                if (min > array3[i]) min = array3[i];
                if (max < array3[i]) max = array3[i];
            }
            System.out.printf("array3: %s   min = %g   max = %g\n", Arrays.toString(array3), min, max);
        } else {
            System.out.println("array3: нет значений");
        }
//вызов метода задачи №7
        array1=new int[]{2,2,2,1,2,2,10,2,1,17,1,-1,1};
        System.out.print(Arrays.toString(array1));
        System.out.println(checkBalance(array1)?" сбалансированный массив":" несбалансированный массив");
//вызов метода задачи №8
        array1=new int[]{-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
        print(array1);
        shiftArray(array1,-32);
        print(array1);
    }
//решение задачи №5
    private static int[] createArray(int len,int initialValue){
        int[] array=new int[len];
        for(int i=0; i<array.length; i++){
            array[i]=initialValue;
        }
        return array;
    }
//решение задачи №7
    private static boolean checkBalance(int[] array){
        int sum=0,sumLeft=0,i=0;
        for(int value:array){
            sum+=value;
        }
        if(sum%2!=0) return false;
        do {
            sumLeft+=array[i++];
        } while(sumLeft<sum/2);
        if(sumLeft==sum/2) return true;
        return false;
    }
//решение задачи №8
    private static void shiftArray(int[] array, int n){
        if(array.length==0) return;
        n%=array.length;
        for(;n<0;n++){
            for(int i=array.length-1,previousValue=array[0]; i>=0; i--){
                int value=array[i];
                array[i]=previousValue;
                previousValue=value;
            }
        }
        for(;n>0;n--){
            for(int i=0,previousValue=array[array.length-1]; i< array.length; i++){
                int value=array[i];
                array[i]=previousValue;
                previousValue=value;
            }
        }
    }
/**********************************************************************
         вспомогательные методы для проверки решений
**********************************************************************/
    private static void print(int[] array){
        System.out.printf("array1: %s\n", Arrays.toString(array));
    }
    private static void print(int[][] array){
        System.out.println();
        for(int i=0; i<array.length; i++){
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
    }
}
