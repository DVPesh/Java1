package ru.geekbrains.java1.lesson1;
public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = -6, b = 5;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Суммая отрицательная");
        }
    }

    public static void printColor(){
        int value=15;
        if(value<=0){
            System.out.println("Красный");
        }
        if(value>0 && value<=100){
            System.out.println("Жёлтый");
        }
        if(value>100) {
            System.out.println("Зелёный");
        }
    }
    public static void compareNumbers(){
        int a=-8,b=-2;
        if(a>=b){
            System.out.println("a>=b");
        } else{
            System.out.println("a<b");
        }
    }
}