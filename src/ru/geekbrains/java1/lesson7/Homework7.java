package ru.geekbrains.java1.lesson7;

import java.util.Random;
import java.util.Scanner;

public class Homework7 {
    private static final int NUMBER_OF_CATS = 9;
    private static final int MIN_APPETITE = 5;
    private static final int MAX_APPETITE = 20;

    private static final String[] nicknames = {
            "Барсик", "Мурзик", "Рекардо", "Борис", "Кузя", "Артур", "Тимофей", "Васька", "Пушок"};
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Plate plate = new Plate();
        Cat[] cats = new Cat[NUMBER_OF_CATS];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(nicknames[random.nextInt(nicknames.length)]
                    , MIN_APPETITE + random.nextInt(MAX_APPETITE - MIN_APPETITE + 1));
        }
        for (Cat cat : cats) {
            System.out.printf("Кот %s, аппетит %d%n", cat.getName(), cat.getAppetite());
        }
        System.out.println(plate);
        System.out.println("Положите какое-то количество еды в тарелку.");
        plate.increaseFood(readValue());
        System.out.println(plate);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
        System.out.println("Положите какое-то количество еды в тарелку."); //для проверки, что сытый кот больше не ест
        plate.increaseFood(readValue());
        System.out.println(plate);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }

    private static int readValue() {
        while (!scanner.hasNextInt()) {
            System.out.println("Следует вводить только целое значение!");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
