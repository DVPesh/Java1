package ru.geekbrains.java1.lesson6.animals.limit2;

import ru.geekbrains.java1.lesson6.animal.Animal;

/* *****************************************************************
       вариант, когда у всех котов уникальные ограничения
 ******************************************************************/
public class Cat extends Animal {
    private final double limitRun;
    private final double limitJump;
    private static int counter = 0; //счётчик котов

    public Cat(String name, String color, int age, double limitRun, double limitJump) {
        super(name, color, age);
        counter++; //подсчёт созданных котов
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }

    public Cat(String name, String color, int age) {
        this(name, color, age, 200.0, 2.0);
    }

    @Override
    public boolean run(double length) {
        if (length <= limitRun) {
            System.out.printf("Кот %s пробежал %.2fм%n", getName(), length);
            return true;
        }
        System.out.printf("Кот %s не может пробежать %.2fм%n", getName(), length);
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (height <= limitJump) {
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
        return "Кот {" + super.toString() + "}, ограничения: " + getLimits();
    }

    public String getLimits() {
        return String.format("бег %.2fм, прыжок %.2fм, не умеет плавать", limitRun, limitJump);
    }

    public static int getCounter() {
        return counter;
    }
}
