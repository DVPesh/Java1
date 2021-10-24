package ru.geekbrains.java1.lesson6.animal;

public abstract class Animal {
    private final String name;
    private final String color;
    private final int age;
    private static int counter = 0; //счётчик животных

    protected Animal(String name, String color, int age) {
        counter++; //подсчёт созданных животных
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public abstract boolean run(double length);

    public abstract boolean swim(double length);

    public abstract boolean jump(double height);

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return String.format("имя: %s, цвет: %s, возраст: %d", name, color, age);
    }
}
