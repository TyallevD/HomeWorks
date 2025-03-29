package HomeWork36;

import java.io.*;
import java.util.List;
import java.util.Scanner;

class ContactFileManager {
//    public static Contact createContact() { //todo - надо сначала создать контакт, а потом добавить его в файл (сделать в одном методе или в двух...)
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
//        Contact contact = new Contact()
//    }

    public static void addContact(String contactsPath, Contact contact) {
        File contactPath = new File(contactsPath);
        if (!contactPath.exists()) {
            System.out.println("Файл контактов не найден");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactPath, true))) {
            writer.write(contact.toString());
            System.out.println("Контакт добавлен \"" + contact.toString() + "\"");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + e.getMessage());
        }
    }

    public static void viewAllContacts(String contactsPath) {
        File contactPath = new File(contactsPath);
        if (!contactPath.exists()) {
            System.out.println("Файл контактов не найден");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(contactPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения контактов " + e.getMessage());
        }
    }
}
