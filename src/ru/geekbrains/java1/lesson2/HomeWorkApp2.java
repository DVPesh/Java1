package ru.geekbrains.java1.lesson2;

public class HomeWorkApp2 {
    //решение задачи №1
    public static boolean testRange10To20(int x1,int x2){
        int sum=x1+x2;
        return sum>=10 && sum<=20;
    }
    //решение задачи №2
    public static void printPositiveOrNegative(int x){
        if(x<0) System.out.println("отрицательное число");
        else System.out.println("положительное число");
    }
    //решение задачи №3
    public static boolean testNegative(int x){
        return x<0;
    }
    //решение задачи №4
    public static void printStringNTimes(String string, int times){
        for(int i=0;i<times;i++) System.out.println(string);
    }
    //решение задачи №5
    public static boolean testLeapYear(int year){
        return year%400==0 || year%4==0 && year%100!=0;
    }
}
