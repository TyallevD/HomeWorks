package HomeWork36;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class ContactFileManager {

    public static Contact createContact(List<Contact> userContactsList) throws InputMismatchException {
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

        int id = Contact.generateId(userContactsList);
        Contact contact = new Contact(id, name, surname, phone, age);
        return contact;
    }

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
        System.out.println("""
                ------------------------------------
                |          Ваши контакты           |
                ------------------------------------""");
        if (contactsList.isEmpty()) {
            System.out.println("""
                    ------------------------------------
                    |       Список контактов пуст      |
                    ------------------------------------""");
            System.out.println();
        }
        for (Contact contact : contactsList) {
            System.out.println(contact);
        }
        System.out.println();
    }

    public static void loadContactList(Login login) {
        File contactFile = new File(Login.getLoginContactsPath(login.getLogin()));
        if (!contactFile.exists()) {
            System.out.println("Файл контактов не найден");
            System.out.println();
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

    public static void sortContact(List<Contact> contacts, int destination) {
        switch (destination) {
            case 1: {
                System.out.println("""
                        ------------------------------------
                        |     Сортировка по имени (A-Z)    |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedByNameAZ = contacts.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
                for (Contact contact : sortedByNameAZ) {
                    System.out.println(contact);
                }
                break;
            }
            case 2: {
                System.out.println("""
                        ------------------------------------
                        |     Сортировка по имени (Z-A)    |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedByNameZA = contacts.stream().sorted((a, b) -> b.getName().compareTo(a.getName())).collect(Collectors.toList());
                for (Contact contact : sortedByNameZA) {
                    System.out.println(contact);
                }
                break;
            }
            case 3: {
                System.out.println("""
                        ------------------------------------
                        |    Сортировка по фамилии (A-Z)   |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedBySurnameAZ = contacts.stream().sorted((a, b) -> a.getSurname().compareTo(b.getSurname())).collect(Collectors.toList());
                for (Contact contact : sortedBySurnameAZ) {
                    System.out.println(contact);
                }
                break;
            }
            case 4: {
                System.out.println("""
                        ------------------------------------
                        |    Сортировка по фамилии (Z-A)   |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedBySurnameZA = contacts.stream().sorted((a, b) -> b.getSurname().compareTo(a.getSurname())).collect(Collectors.toList());
                for (Contact contact : sortedBySurnameZA) {
                    System.out.println(contact);
                }
                break;
            }
            case 5: {
                System.out.println("""
                        ------------------------------------
                        |    Сортировка по номеру (0-9)    |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedByPhoneForward = contacts.stream().sorted((a, b) -> a.getPhone().compareTo(b.getPhone())).collect(Collectors.toList());
                for (Contact contact : sortedByPhoneForward) {
                    System.out.println(contact);
                }
                break;
            }
            case 6: {
                System.out.println("""
                        ------------------------------------
                        |    Сортировка по номеру (9-0)    |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedByPhoneBackward = contacts.stream().sorted((a, b) -> b.getPhone().compareTo(a.getPhone())).collect(Collectors.toList());
                for (Contact contact : sortedByPhoneBackward) {
                    System.out.println(contact);
                }
                break;
            }
            case 7: {
                System.out.println("""
                        ------------------------------------
                        |    Сортировка по возрасту (0-9)  |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedByAgeForward = contacts.stream().sorted(Comparator.comparingInt(Contact::getAge)).collect(Collectors.toList());
                for (Contact contact : sortedByAgeForward) {
                    System.out.println(contact);
                }
                break;
            }
            case 8: {
                System.out.println("""
                        ------------------------------------
                        |    Сортировка по возрасту (9-0)  |
                        ------------------------------------""");
                System.out.println();
                List<Contact> sortedByAgeBackward = contacts.stream().sorted(Comparator.comparingInt(Contact::getAge).reversed()).collect(Collectors.toList());
                for (Contact contact : sortedByAgeBackward) {
                    System.out.println(contact);
                }
                break;
            }
            default: {
                System.out.println("Непредвиденная ошибка, попробуйте снова");
                System.out.println();
            }
        }
    }

    public static void deleteContactById(List<Contact> userContactList, int id) {
        for (Contact contact : userContactList) {
            if (contact.getId() == id) {
                userContactList.remove(contact);
                System.out.println("Контакт с id \"" + id + "\" был удалён");
                System.out.println();
                return;
            }
        }
        System.out.println("Контакт с id \"" + id + "\" не найден");
        System.out.println();
    }

    public static void deleteContactByName(List<Contact> userContactList, String name) {
        for (Contact contact : userContactList) {
            if (contact.getName().equals(name)) {
                userContactList.remove(contact);
                System.out.println("Контакт с именем \"" + name + "\" был удалён");
                System.out.println();
                return;
            }
        }
        System.out.println("Контакт с именем \"" + name + "\" не найден");
        System.out.println();
    }

    public static void deleteContactBySurname(List<Contact> userContactList, String surname) {
        for (Contact contact : userContactList) {
            if (contact.getSurname().equals(surname)) {
                userContactList.remove(contact);
                System.out.println("Контакт с фамилией \"" + surname + "\" был удалён");
                System.out.println();
                return;
            }
        }
        System.out.println("Контакт с фамилией \"" + surname + "\" не найден");
        System.out.println();
    }

    public static void deleteContactByPhone(List<Contact> userContactList, String phone) {
        for (Contact contact : userContactList) {
            if (contact.getPhone().equals(phone)) {
                userContactList.remove(contact);
                System.out.println("Контакт с номером телефона \"" + phone + "\" был удалён");
                System.out.println();
            }
        }
        System.out.println("Контакт с номером телефона \"" + phone + "\" не найден");
        System.out.println();
    }

    //Методы для поиска контактов
    public static void searchContactByName(List<Contact> userContactList, String name) {
        boolean isFound = false;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по имени \"" + name + "\":");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (name.equals(contact.getName())) {
                isFound = true;
                System.out.println(contact);
            }
        }
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
    }

    public static void searchContactBySurname(List<Contact> userContactList, String surname) {
        boolean isFound = false;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по фамилии \"" + surname + "\"");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (surname.equals(contact.getSurname())) {
                System.out.println(contact);
            }
        }
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
    }

    public static void searchContactByPhone(List<Contact> userContactList, String phone) {
        boolean isFound = false;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по номеру \"" + phone + "\"");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (phone.equals(contact.getPhone())) {
                System.out.println(contact);
            }
        }
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
    }

    public static void searchContactByAge(List<Contact> userContactList, int age) {
        boolean isFound = false;
        System.out.println("------------------------------------");
        System.out.println(" Найденные контакты по возрасту \"" + age + "\"");
        System.out.println("------------------------------------");
        for (Contact contact : userContactList) {
            if (age == contact.getAge()) {
                System.out.println(contact);
            }
        }
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
        }
    }

    //Методы для изменения контактов
    public static void updateContactByName(List<Contact> userContactList, String name) {

    }

    public static void updateContactBySurname(List<Contact> userContactList, String surname) {

    }

    public static void updateContactByPhone(List<Contact> userContactList, String phone) {

    }

    public static void updateContactByAge(List<Contact> userContactList, int age) {

    }
}
