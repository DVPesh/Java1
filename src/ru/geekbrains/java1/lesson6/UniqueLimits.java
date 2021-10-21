package ru.geekbrains.java1.lesson6;

import ru.geekbrains.java1.lesson6.animal.Animal;
import ru.geekbrains.java1.lesson6.animals.limit2.Cat;
import ru.geekbrains.java1.lesson6.animals.limit2.Dog;

import java.util.Random;

/* *****************************************************************
       вариант, когда у всех животных уникальные ограничения
 ******************************************************************/

public class UniqueLimits {
    private static final Random random = new Random();
    private static Cat[] cats = new Cat[6];
    private static Dog[] dogs = new Dog[4];

    public static void main(String[] args) {
        //одинаковые ограничения задаются по умолчанию конструктором с тремя параметрами
        cats[0] = new Cat("Василий", "чёрный", 2);
        cats[1] = new Cat("Мурзик", "серый", 1);
        cats[2] = new Cat("Рекардо", "рыжий", 4);
        dogs[0] = new Dog("Шарик", "коричневый", 5);
        dogs[1] = new Dog("Мухтар", "чёрный", 3);

        cats[0].jump(1.2);
        cats[1].run(150);
        cats[2].swim(3);
        dogs[0].swim(10);
        dogs[1].run(400);
        dogs[0].jump(1);

        //уникальные ограничения для каждого животного
        cats[3] = new Cat("Кузя", "белый", 6, getUniqueLimit(500), getUniqueLimit(2));
        cats[4] = new Cat("Барсик", "серый", 1, getUniqueLimit(500), getUniqueLimit(2));
        cats[5] = new Cat("Маркиз", "рыжий", 5, getUniqueLimit(500), getUniqueLimit(2));
        dogs[2] = new Dog("Бобик", "белый", 7
                , getUniqueLimit(500), getUniqueLimit(2), getUniqueLimit(10));
        dogs[3] = new Dog("Арктур", "чёрный", 1
                , getUniqueLimit(500), getUniqueLimit(2), getUniqueLimit(10));

        cats[3].jump(1.2);
        cats[4].run(150);
        cats[5].swim(3);
        dogs[2].swim(10);
        dogs[3].run(400);
        dogs[2].jump(1);

        Animal[] animals = new Animal[cats.length + dogs.length];

        System.arraycopy(dogs, 0, animals, 0, dogs.length);
        System.arraycopy(cats, 0, animals, dogs.length, cats.length);

        printInfo();

        for (Animal animal : animals) {
            System.out.println(animal.toString());
            animal.run(250);
            animal.swim(5);
            animal.jump(1.5);
        }

        printInfo();
    }

    private static void printInfo() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("количество животных: %d, количество котов: %d, количество собак: %d%n"
                , Animal.getCounter(), Cat.getCounter(), Dog.getCounter());
        System.out.println("--------------------------------------------------------------------------");
    }

    private static double getUniqueLimit(double value) {
        return Math.floor(10 * value * random.nextDouble()) / 10;
    }
}
