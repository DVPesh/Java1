package ru.geekbrains.java1.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    private static final int SIZE=5;

    private static final char EMPTY_SIGN='•';
    private static final char GAMER_SIGN='X';
    private static final char AI_SIGN='0';

    private static char[][] map=new char[SIZE][SIZE];
    private static Random random=new Random();
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        createEmptyGameField();
        printGameField();
        while (true){
            gamerMakesMove();
            printGameField();
            if(checkGameEnd(GAMER_SIGN)){
                break;
            }
            aiMakesMove();
            printGameField();
            if(checkGameEnd(AI_SIGN)){
                break;
            }
        }
        System.out.println("Игра окончена.");
    }
    // условие победы для любой размерности игрового поля
    private static boolean isWin(char sign){
        int counterDiagonal1=0;
        int counterDiagonal2=0;
        for(int i=0;i<SIZE;i++){
            int counterColumn=0;
            int counterRow=0;
            for(int j=0;j<SIZE;j++){
                if(i==j && map[i][j]==sign && ++counterDiagonal1==SIZE) return true;
                if(SIZE-1==j+i && map[i][j]==sign && ++counterDiagonal2==SIZE) return true;
                if(map[i][j]==sign && ++counterColumn==SIZE) return true;
                if(map[j][i]==sign && ++counterRow==SIZE) return true;
            }
        }
        return false;
    }

    private static boolean checkGameEnd(char sign){
        if(isWin(sign)){
            System.out.println(sign==GAMER_SIGN?"Поздравляем! Вы выиграли!":"Вы проиграли.");
            return true;
        }
        if(checkNoEmptyFieldPositions()){
            System.out.println("Ничья.");
            return true;
        }
        return false;
    }

    private static void createEmptyGameField(){
        for(char[]array:map){
            Arrays.fill(array,EMPTY_SIGN);
        }
    }

    private static void printGameField(){
        System.out.print(" ");

        for(int i=1;i<=map.length;i++){
            System.out.print(" "+i);
        }
        System.out.println();
        for(int i=0;i<map.length;i++){
            System.out.print(i+1);
            for(int j=0;j<map.length;j++){
                System.out.print(" "+map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void aiMakesMove(){
        int line,column;
        do {
            line = random.nextInt(3)+1;
            column = random.nextInt(3)+1;
        } while(!isEmptyFieldPosition(line,column));
        map[line-1][column-1]=AI_SIGN;
    }

    private static void gamerMakesMove(){
        int line,column;
        do {
            System.out.println("Делайте ход. Укажите сначала строку, затем столбец.");
            line = readValue();
            column = readValue();
            if (!(checkValue(line) && checkValue(column))) {
                printErrorValueMessage();
                continue;
            }
            if(isEmptyFieldPosition(line,column)) break;
            System.out.println("Эта клетка уже занята.");
        } while(true);
        System.out.printf("Вы сделали ход: %s %s\n",line,column);
        map[line-1][column-1]=GAMER_SIGN;
    }

    private static boolean checkNoEmptyFieldPositions(){
        for(char[]array:map){
            for(char cell:array){
                if(cell==EMPTY_SIGN) return false;
            }
        }
        return true;
    }

    private static boolean isEmptyFieldPosition(int line, int column){
        return map[line-1][column-1]==EMPTY_SIGN;
    }

    private static boolean checkValue(int value){
        return value>0 && value<=SIZE;
    }

    private static int readValue(){
        while (!scanner.hasNextInt()){
            printErrorValueMessage();
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void printErrorValueMessage(){
        System.out.printf("Введено ошибочное значение. Вводите только целые числа в диапазоне [1,%s]\n",SIZE);
    }
}
