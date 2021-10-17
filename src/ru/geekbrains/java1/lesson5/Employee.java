package ru.geekbrains.java1.lesson5;

public class Employee {

    private String fullName;
    private String post;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String post, String email, String phoneNumber, int salary, int age) {

        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPost() { return post; }
    public void setPost(String post) { this.post = post; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public void printInformation() {
        System.out.printf("ФИО: %s, должность: %s, Email: %s, номер телефона: %s, зарплата: %s, возраст: %s\n"
                , fullName, post, email, phoneNumber, salary, age);
    }
}
