package ru.geekbrains.java1.lesson6.animals.limit2;

import ru.geekbrains.java1.lesson6.animal.Animal;

/* ******************************************************************
       вариант, когда у всех собак уникальные ограничения
 *******************************************************************/
public class Dog extends Animal {
    private final double limitRun;
    private final double limitSwim;
    private final double limitJump;
    private static int counter = 0; //счётчик собак

    public Dog(String name, String color, int age, double limitRun, double limitJump, double limitSwim) {
        super(name, color, age);
        counter++; //подсчёт созданных собак
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
    }

    public Dog(String name, String color, int age) {
        this(name, color, age, 500.0, 0.5, 10.0);
    }

    @Override
    public boolean run(double length) {
        if (length <= limitRun) {
            System.out.printf("Пёс %s пробежал %.2fм%n", getName(), length);
            return true;
        }
        System.out.printf("Пёс %s не может пробежать %.2fм%n", getName(), length);
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (height <= limitJump) {
            System.out.printf("Пёс %s подпрыгнул на %.2fм%n", getName(), height);
            return true;
        }
        System.out.printf("Пёс %s не может подпрыгнуть на %.2fм%n", getName(), height);
        return false;
    }

    @Override
    public boolean swim(double length) {
        if (length <= limitSwim) {
            System.out.printf("Пёс %s проплыл %.2fм%n", getName(), length);
            return true;
        }
        System.out.printf("Пёс %s не может проплыть %.2fм%n", getName(), length);
        return false;
    }

    @Override
    public String toString() {
        return "Пёс {" + super.toString() + "}, ограничения: " + getLimits();
    }

    public String getLimits() {
        return String.format("бег %.2fм, прыжок %.2fм, плавание %.2fм", limitRun, limitJump, limitSwim);
    }

    public static int getCounter() {
        return counter;
    }
}
