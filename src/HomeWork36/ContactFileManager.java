package HomeWork36;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContactFileManager {
//    private List<Contact> contacts;
//    private File file;
//    private int nextId;
//
//    public ContactFileManager(List<Contact> contacts, File file, int nextId) {
//        this.contacts = new ArrayList<>();
//        this.file = file;
//        loadFromFile();
//        this.nextId = contacts.isEmpty() ? 1 : contacts.stream().mapToInt(Contact::getId).max().orElse(0);
//    }

    public static Contact createContact(String contactFilePath) { //todo - надо сначала создать контакт, а потом добавить его в файл (сделать в одном методе или в двух...)
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

        int id = Contact.generateId(contactFilePath);
        Contact contact = new Contact(id, name, surname, phone, age);
        return contact;
    }

    public static void addContact(String contactsPath, Contact contact) {
        File contactPath = new File(contactsPath);
        if (!contactPath.exists()) {
            System.out.println("Файл контактов не найден");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactPath, true))) {
            writer.write(contact.toString());
            writer.newLine();
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

    //возможно чушь
//    public void loadFromFile() throws IOException {
//        if (!file.exists()) {
//            file.createNewFile();
//            return;
//        }
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                try {
//                    contacts.add(Contact.parse(line));
//                } catch (NumberFormatException e) {
//                    System.out.println("Ошибка в строке " + line);
//                }
//            }
//
//        }
//    }
}
