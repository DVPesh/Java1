package ru.geekbrains.java1.lesson6;
/* *****************************************************************
 вариант, когда у всех животных одного класса одинаковые ограничения
 ******************************************************************/
import ru.geekbrains.java1.lesson6.animal.Animal;
import ru.geekbrains.java1.lesson6.animals.limit1.Cat;
import ru.geekbrains.java1.lesson6.animals.limit1.Dog;

public class FixedLimits {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Василий", "чёрный", 2);
        Cat cat2 = new Cat("Мурзик", "серый", 1);
        Cat cat3 = new Cat("Рекардо", "рыжий", 4);
        Dog dog1 = new Dog("Шарик", "коричневый", 5);
        Dog dog2 = new Dog("Мухтар", "чёрный", 3);
        cat1.jump(1.2);
        cat2.run(150);
        cat3.swim(3);
        dog1.swim(10);
        dog2.run(400);
        dog1.jump(1);
        printInfo();
        Animal[] animals = new Animal[]{cat1, cat2, cat3, dog1, dog2};
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
        System.out.println("ограничения котов: " + Cat.getLimits());
        System.out.println("ограничения собак: " + Dog.getLimits());
        System.out.println("--------------------------------------------------------------------------");
    }
}
