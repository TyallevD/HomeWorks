package Scratch;

import java.util.ArrayList;
import java.util.List;


class Person {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private int age;

    public Person(int id, String name, String surname, String phone, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + phone + " " + age;
    }
}


public class Scratch {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Дима", "Тяллев", "+79605161073", 34);
        Person person2 = new Person(2, "Гоша", "Куценко", "+79605161074", 50);
        Person person3 = new Person(3, "Миша", "Панков", "+79605161075", 35);
        Person person4 = new Person(4, "Дима", "Терещенко", "+79605161076", 33);
        Person person5 = new Person(123, "Марк", "Граховский", "+79605161077", 12);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        System.out.println(personList);

    }

    private static void partialPhoneSearch(List<Person> personList, String phone) {
        if (phone.contains("_")) {
            int count = 0;
            if (phone.startsWith("_")) {

            } else if (phone.endsWith("_")) {

            }
        }
    }
}

