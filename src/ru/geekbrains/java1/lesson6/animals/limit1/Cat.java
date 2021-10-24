package ru.geekbrains.java1.lesson6.animals.limit1;

import ru.geekbrains.java1.lesson6.animal.Animal;
/* *****************************************************************
        вариант, когда у всех котов одинаковые ограничения
 ******************************************************************/
public class Cat extends Animal {
    private static final double LIMIT_RUN = 200.0;
    private static final double LIMIT_JUMP = 2.0;
    private static int counter = 0; //счётчик котов

    public Cat(String name, String color, int age) {
        super(name, color, age);
        counter++; //подсчёт созданных котов
    }

    @Override
    public boolean run(double length) {
        if (length <= LIMIT_RUN) {
            System.out.printf("Кот %s пробежал %.2fм%n", getName(), length);
            return true;
        }
        System.out.printf("Кот %s не может пробежать %.2fм%n", getName(), length);
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (height <= LIMIT_JUMP) {
            System.out.printf("Кот %s подпрыгнул на %.2fм%n", getName(), height);
            return true;
        }
        System.out.printf("Кот %s не может подпрыгнуть на %.2fм%n", getName(), height);
        return false;
    }

    @Override
    public boolean swim(double length) {
        System.out.printf("Кот %s не может проплыть %.2fм, он не умеет плавать%n", getName(), length);
        return false;
    }

    @Override
    public String toString() {
        return "Кот {" + super.toString() + '}';
    }

    public static String getLimits() {
        return String.format("бег %.2fм, прыжок %.2fм, не умеет плавать", LIMIT_RUN, LIMIT_JUMP);
    }

    public static int getCounter() {
        return counter;
    }
}
