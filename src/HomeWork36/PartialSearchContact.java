package HomeWork36;

import java.util.List;

public class PartialSearchContact {
    public static void partialSearchByName(List<Contact> userContactList, String name) {
        if (name.contains("_")) {
            System.out.println("поиск по количеству введенных символов и приставке/окончанию");
        } else if (name.contains("%")) {
            System.out.println("Поиск по любому количеству символов");
        }
    }

    public static void partialSearchBySurname(List<Contact> userContactList, String surname) {
        //todo сделать поиск по символам "_" или "%"
    }

    public static void partialSearchByPhone(List<Contact> userContactList, String phone) {
        //todo сделать поиск по символам "_" или "%"

    }

    public static void partialSearchByAge(List<Contact> userContactList, int age, String direction) {
        boolean isFound = false;
        int count = 0;
        if (direction.equals("1")) {
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по возрасту больше \"" + age + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (contact.getAge() > age) {
                    isFound = true;
                    count++;
                    System.out.println(contact);
                }
            }
            if (isFound) {
                System.out.println("Всего найдено: " + count);
                System.out.println();
            } else {
                System.out.println("По заданным критериям ничего не найдено");
                System.out.println();
            }
        } else if (direction.equals("2")) {
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по возрасту меньше \"" + age + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (contact.getAge() < age) {
                    isFound = true;
                    count++;
                    System.out.println(contact);
                }
            }
            if (isFound) {
                System.out.println("Всего найдено: " + count);
                System.out.println();
            } else {
                System.out.println("По заданным критериям ничего не найдено");
                System.out.println();
            }
        } else {
            System.out.println("Неверное значение поиска");
            System.out.println();
        }
    }
}
