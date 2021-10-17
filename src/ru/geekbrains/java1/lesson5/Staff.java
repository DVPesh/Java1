package ru.geekbrains.java1.lesson5;

import java.util.Random;

public class Staff {

    private static Employee[] staff;
    private static Random random = new Random();

    public static void main(String[] args) {

        staff = new Employee[5];
        staff[0] = new Employee("Николай Васильевич Калита", "менеджер по маркетингу"
                , "NVKalita@yandex.ru", "+73459913204", 200000, generateAge());
        staff[1] = new Employee("Василий Петрович Сидоренко", "дизайнер интерьера"
                , "VPSidorenro@mail.ru", "+79165672315", 120000, generateAge());
        staff[2] = new Employee("Геннадий Олегович Мурза", "продакт менеджер"
                , "GOMurza@gmail.com", "87841264521", 180000, generateAge());
        staff[3] = new Employee("Ольга Дмитриевна Шевченко", "главный бухгалтер"
                , "OLShevchenko@yandex.ru", "+79626742316", 250000, generateAge());
        staff[4] = new Employee("Тамара Федоровна Рукопенко", "стилист"
                , "TFRucop@gmail.com", "+74993397891", 100000, generateAge());

        System.out.println("****** список сотрудников старше 40 лет ******");
        for (Employee person : staff) if (person.getAge() > 40) person.printInformation();

        System.out.println("\n****** полный список сотрудников ******");
        for (Employee person : staff) person.printInformation();
    }

    private static int generateAge() {
        return 18 + random.nextInt(61 - 18);
    }
}
