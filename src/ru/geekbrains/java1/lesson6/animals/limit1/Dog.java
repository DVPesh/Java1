package ru.geekbrains.java1.lesson6.animals.limit1;

import ru.geekbrains.java1.lesson6.animal.Animal;
/* ******************************************************************
       вариант, когда у всех собак одинаковые ограничения
 *******************************************************************/
public class Dog extends Animal {
    private static final double LIMIT_RUN = 500.0;
    private static final double LIMIT_SWIM = 10.0;
    private static final double LIMIT_JUMP = 0.5;
    private static int counter = 0; //счётчик собак

    public Dog(String name, String color, int age) {
        super(name, color, age);
        counter++; //подсчёт созданных собак
    }

    @Override
    public boolean run(double length) {
        if (length <= LIMIT_RUN) {
            System.out.printf("Пёс %s пробежал %.2fм%n", getName(), length);
            return true;
        }
        System.out.printf("Пёс %s не может пробежать %.2fм%n", getName(), length);
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (height <= LIMIT_JUMP) {
            System.out.printf("Пёс %s подпрыгнул на %.2fм%n", getName(), height);
            return true;
        }
        System.out.printf("Пёс %s не может подпрыгнуть на %.2fм%n", getName(), height);
        return false;
    }

    @Override
    public boolean swim(double length) {
        if (length <= LIMIT_SWIM) {
            System.out.printf("Пёс %s проплыл %.2fм%n", getName(), length);
            return true;
        }
        System.out.printf("Пёс %s не может проплыть %.2fм%n", getName(), length);
        return false;
    }

    @Override
    public String toString() {
        return "Пёс {" + super.toString() + '}';
    }

    public static String getLimits() {
        return String.format("бег %.2fм, прыжок %.2fм, плавание %.2fм"
                , LIMIT_RUN, LIMIT_JUMP, LIMIT_SWIM);
    }

    public static int getCounter() {
        return counter;
    }
}
