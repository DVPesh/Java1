package ru.geekbrains.java1.lesson7;

public class Plate {
    private int food;

    public Plate() {
        food = 0;
    }

    public Plate(int food) {
        this();
        if (food > 0) this.food = food;
    }

    public boolean decreaseFood(int value) {
        if (food < value) return false;
        food -= value;
        return true;
    }

    public void increaseFood(int value) {
        if (value > 0) food += value;
    }

    @Override
    public String toString() {
        return "Количество еды в тарелке: " + food;
    }
}
