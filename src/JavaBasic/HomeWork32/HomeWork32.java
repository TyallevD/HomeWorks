package JavaBasic.HomeWork32;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
        System.out.print("Укажите путь до файла: ");
        File file = new File(scanner.nextLine());

        while (true) {
            System.out.println("""
                    Введите команду:
                    - add
                    - remove
                    - update
                    - printall
                    - exit""");
            System.out.print("Введите команду: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы");
                break;
            }
            doCommand(input, file);
        }
    }

    private static void doCommand(String input, File file) {
        try {
            switch (input) {
                case "add": {
                    addCommand(file);
                    break;
                }
                case "remove": {
                    removeCommand(file);
                    break;
                }
                case "update": {
                    updateCommand(file);
                    break;
                }
                case "printall": {
                    printAllCommand(file);
                    break;
                }

                default: {
                    System.out.println("Введена неверная команда, попробуйте снова");
                }
            }
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static void addCommand(File file) {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            System.out.print("Укажите имя: ");
            String name = scanner.nextLine();
            System.out.print("Укажите фамилию: ");
            String surname = scanner.nextLine();
            System.out.print("Укажите возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Укажите номер телефона: ");
            String phone = scanner.nextLine();
            writer.write(new Person(name, surname, age, phone).toString());
            writer.newLine();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Запись добавлена");
    }

    private static void removeCommand(File file) {
        try {
            System.out.print("Какую запись хотите удалить?: ");
            String remove = new Scanner(System.in).nextLine().toLowerCase();
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
            if (!remove.isEmpty() && !lines.isEmpty()) {
                boolean isFound = false;
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).toLowerCase().contains(remove)) {
                        String removed = lines.remove(i);
                        System.out.println("Запись \"" + removed + "\" была удалена");
                        i--;
                        isFound = true;
                    }
                }
                if (isFound) {
                    Files.write(Paths.get(file.toURI()), lines);
                } else {
                    System.out.println("Запись не найдена. Попробуйте снова");
                }
            } else {
                System.out.println("Ошибка, пустая команда. Попробуйте снова");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void updateCommand(File file) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Какую запись хотите изменить?: ");
            String update = scanner.nextLine().toLowerCase();
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
            if (lines.isEmpty()) {
                System.out.println("Файл пуст.");
                return;
            }
            boolean isFound = false;
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i).split("\t ");
                if (update.equalsIgnoreCase(line[0]) || update.equalsIgnoreCase(line[1]) || update.equalsIgnoreCase(line[2]) || update.equalsIgnoreCase(line[3])) {
                    System.out.print("Введите новое имя: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новое фамилию: ");
                    String newSurname = scanner.nextLine();
                    System.out.print("Введите новый возраст: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите новый номер телефона: ");
                    String newPhone = scanner.nextLine();

                    Person updatedPerson = new Person(newName, newSurname, newAge, newPhone);
                    lines.set(i, updatedPerson.toString());
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                Files.write(Paths.get(file.toURI()), lines);
                System.out.println("Запись изменена");
            } else {
                System.out.println("Запись не изменена");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void printAllCommand(File file) {
        //вариант через Лист
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
//            for (String str : lines) {
//                System.out.println(str);
//            }

        //Вариант через BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
        return name + "\t " + surname + "\t " + age + "\t " + phone;
    }
}