package ru.geekbrains.java1.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task3 {
    private static final int SIZE=5; //размер игрового поля
    private static final int DOTS_TO_WIN=4; //длина выигрышной комбинации

    private static final char EMPTY_SIGN='•';
    private static final char GAMER_SIGN='X';
    private static final char AI_SIGN='0';

    private static char[][] map=new char[SIZE][SIZE];
    private static Random random=new Random();
    private static Scanner scanner=new Scanner(System.in);
    private static char[][] array=new char[DOTS_TO_WIN][DOTS_TO_WIN];

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
/*******************************************************************************
 условие победы для любого размера игрового поля и длины выигрышной комбинации
*******************************************************************************/
    private static boolean isWin(char sign){
        for(int i=0;i<=SIZE-DOTS_TO_WIN;i++){
            for(int j=0;j<=SIZE-DOTS_TO_WIN;j++){
                copyPartOfMap(i,j);
                if(isDotsToWin(sign)) return true;
            }
        }
        return false;
    }

    private static boolean isDotsToWin(char sign){
        int counterDiagonal1=0;
        int counterDiagonal2=0;
        for(int i = 0; i< DOTS_TO_WIN; i++){
            int counterColumn=0;
            int counterRow=0;
            for(int j = 0; j< DOTS_TO_WIN; j++){
                if(i==j && array[i][j]==sign && ++counterDiagonal1==DOTS_TO_WIN) return true;
                if(DOTS_TO_WIN-1==j+i && array[i][j]==sign && ++counterDiagonal2==DOTS_TO_WIN) return true;
                if(array[i][j]==sign && ++counterColumn==DOTS_TO_WIN) return true;
                if(array[j][i]==sign && ++counterRow==DOTS_TO_WIN) return true;
            }
        }
        return false;
    }

    private static void copyPartOfMap(int originRow,int originColumn){
        for(int i=0;i<DOTS_TO_WIN;i++){
            System.arraycopy(map[i+originRow],originColumn,array[i],0,DOTS_TO_WIN);
        }
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
