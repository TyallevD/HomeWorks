package HomeWork36;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContactFileManager {

//    public static Contact createContact(String contactFilePath) { //todo - надо сначала создать контакт, а потом добавить его в файл (сделать в одном методе или в двух...)
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите имя: ");
//        String name = scanner.nextLine();
//        System.out.print("Введите фамилию: ");
//        String surname = scanner.nextLine();
//        System.out.print("Введите номер телефона: ");
//        String phone = scanner.nextLine();
//        System.out.print("Введите возраст: ");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//
//        int id = Contact.generateId(contactFilePath);
//        Contact contact = new Contact(id, name, surname, phone, age);
//        return contact;
//    }

    public static Contact createContact(List<Contact> userContactsList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phone = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

//        int id = Contact.generateId(contactFilePath);
        int id = Contact.generateId(userContactsList);
        Contact contact = new Contact(id, name, surname, phone, age);
        return contact;
    }
    //вариант с файлом
//    public static void addContact(String contactsPath, Contact contact) {
//        File contactPath = new File(contactsPath);
//        if (!contactPath.exists()) {
//            System.out.println("Файл контактов не найден");
//            return;
//        }
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactPath, true))) {
//            writer.write(contact.toString());
//            writer.newLine();
//            System.out.println("Контакт добавлен \"" + contact.toString() + "\"");
//        } catch (IOException e) {
//            System.out.println("Ошибка записи в файл " + e.getMessage());
//        }
//    }

    //вариант с файлом
//    public static void viewAllContacts(String contactsPath) {
//        File contactPath = new File(contactsPath);
//        if (!contactPath.exists()) {
//            System.out.println("Файл контактов не найден");
//            return;
//        }
//        try (BufferedReader reader = new BufferedReader(new FileReader(contactPath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения контактов " + e.getMessage());
//        }
//    }
    public static void saveToFile(List<Contact> userContactList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Login.getLoginContactsPath(Session.getCurrentLogin())))) {
            for (Contact contact : userContactList) {
                writer.write(contact.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void addContact(List<Contact> contacts, Contact contact) {
        contacts.add(contact);
    }

    public static void viewAllContacts(List<Contact> contactsList) {
        for (Contact contact : contactsList) {
            System.out.println(contact);
        }
    }

    public static void loadContactList(Login login) {
        File contactFile = new File(Login.getLoginContactsPath(login.getLogin()));
        if (!contactFile.exists()) {
            System.out.println("Файл контактов не найден");
            return;
        }
        List<Contact> contactList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(contactFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contactList.add(Contact.parse(line));
            }
            login.setContactList(contactList);
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + e.getMessage());
        }
    }
}
