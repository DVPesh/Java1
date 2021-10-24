package ru.geekbrains.java1.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite > 0 ? appetite : 0;
        satiety = false;
    }

    public void eat(Plate value) {
        if (satiety) return;
        satiety = value.decreaseFood(appetite);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    @Override
    public String toString() {
        return String.format("Кот %s %s", name, satiety ? "сыт" : "голодный");
    }
}
