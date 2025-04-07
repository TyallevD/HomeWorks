package HomeWork36;

import java.util.List;

public class SearchContact {
    public static int searchContactByName(List<Contact> userContactList, String name) {
        boolean isFound = false;
        int count = 0;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по имени \"" + name + "\":");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (name.equals(contact.getName())) {
                isFound = true;
                count++;
                System.out.println(contact);
            }
        }
        System.out.println("Всего найдено: " + count);
        System.out.println();
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
        return count;
    }

    public static int searchContactBySurname(List<Contact> userContactList, String surname) {
        boolean isFound = false;
        int count = 0;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по фамилии \"" + surname + "\"");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (surname.equals(contact.getSurname())) {
                isFound = true;
                count++;
                System.out.println(contact);
            }
        }
        System.out.println("Всего найдено: " + count);
        System.out.println();
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
        return count;
    }

    public static int searchContactByPhone(List<Contact> userContactList, String phone) {
        boolean isFound = false;
        int count = 0;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по номеру \"" + phone + "\"");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (phone.equals(contact.getPhone())) {
                isFound = true;
                count++;
                System.out.println(contact);
            }
        }
        System.out.println("Всего найдено: " + count);
        System.out.println();
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
        return count;
    }

    public static int searchContactByAge(List<Contact> userContactList, int age) {
        boolean isFound = false;
        int count = 0;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по возрасту \"" + age + "\"");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (age == contact.getAge()) {
                isFound = true;
                count++;
                System.out.println(contact);
            }
        }
        System.out.println("Всего найдено: " + count);
        System.out.println();
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
        return count;
    }
}
