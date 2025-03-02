package HomeWork32;

import java.util.Scanner;

public class HomeWork32 {
    public static void main(String[] args) {
        //Реализовать Объект Person с полями (name , surname, age, phone)
        //Реализовать CRUD operations
        //C - create
        //R - read
        //U - update
        //D - delete
        //
        //Чтобы все изменения фиксировались в файле
        //
        //1 - Add
        //2 - Remove
        //3 - Update
        //4 - Print All
        //5 - Exit


        //что делать?
        //1) нужно создать или выбрать текстовый файл, в котором будут происходить изменения
        //предложить выбрать файл, если существует, то берём его, если нет - создаём новый
        //2) передаём файл в работу, пробуем изменения, добавление/изменение/удаление/печать должны производиться только с учетом значений Person
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Введите команду:
                    - add
                    - remove
                    - update
                    - printall
                    - exit""");
            System.out.print("Введите команду: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход и программы");
                break;
            }
        }
    }
}

class Person {
    private String name;
    private String surname;
    private int age;
    private String phone;

    public Person(String name, String surname, int age, String phone) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + "\t" + surname + "\t" + age + "\t" + phone;
    }
}