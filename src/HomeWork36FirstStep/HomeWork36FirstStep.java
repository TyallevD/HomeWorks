package HomeWork36FirstStep;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ProgrammPaths {
    public static final File PROJECT_DIR = new File(System.getProperty("user.dir"));
    public static final File USERS_DIR = new File(PROJECT_DIR, "users");
    public static final File USERS_FILE = new File(USERS_DIR, "users.txt");
    public static final File CONTACTS_DIR = new File(PROJECT_DIR, "contacts");
}

public class HomeWork36FirstStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginFileManager.createOrCheckExistingFolders();
        startMenu:
        while (true) {
            System.out.print("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |         добро пожаловать         |
                    ------------------------------------
                    |   1 - вход                       |
                    |   2 - регистрация                |
                    |   3 - выход из программы         |
                    ------------------------------------
                    """);
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    authorization();
                    if (Session.getCurrentLoginContacts() != null) {
                        mainMenu(Session.getCurrentLoginContacts());
                    }
                    break;
                case "2":
                    registration();
                    break;
                case "3":
                    System.out.println("""
                            ------------------------------------
                            |        Выход из программы        |
                            ------------------------------------""");
                    System.out.println();
                    break startMenu;
                default:
                    System.out.println("Ваш ввод неверный, попробуйте снова");
                    break;
            }
        }
    }

    private static void mainMenu(List<Contact> userContactList) {
        Scanner scanner = new Scanner(System.in);
        mainMenu:
        while (true) {
            System.out.print("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |           Главное меню           |
                    ------------------------------------
                    |   1 - изменение контактов        |
                    |   2 - просмотр контактов         |
                    |   3 - выход из аккаунта          |
                    ------------------------------------
                    """);
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    contactsChangeMenu(userContactList);
                    break;
                }
                case "2": {
                    contactsViewMenu(userContactList);
                    break;
                }
                case "3": {
                    System.out.println("""
                            ------------------------------------
                            |    Выход на экран авторизации    |
                            ------------------------------------""");
                    System.out.println();
                    userContactList = null;
                    break mainMenu;
                }
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    private static void contactsChangeMenu(List<Contact> userContactList) {
        Scanner scanner = new Scanner(System.in);
        contactsChangeMenu:
        while (true) {
            System.out.println("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |       Изменение контактов        |
                    ------------------------------------
                    |   1 - добавить контакт           |
                    |   2 - изменить контакт           |
                    |   3 - удалить контакт            |
                    |   4 - выход в главное меню       |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    ContactFileManager.addContact(userContactList, ContactFileManager.createContact(userContactList));
                    break;
                }
                case "2": {
                    //todo сделать изменение контакта
                    System.out.println("тут должно быть меню изменения контактов");
                    break;
                }
                case "3": {
                    deletionMenu(userContactList);
                    break;
                }
                case "4": {
                    ContactFileManager.saveToFile(userContactList);
                    System.out.println("""
                            ------------------------------------
                            |       Выход в главное меню       |
                            ------------------------------------""");
                    System.out.println();
                    break contactsChangeMenu;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте снова.");
                }
            }
        }
    }

    private static void contactsViewMenu(List<Contact> userContactList) {
        Scanner scanner = new Scanner(System.in);
        contactsViewMenu:
        while (true) {
            System.out.println("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |        Просмотр контактов        |
                    ------------------------------------
                    |   1 - просмотреть все контакты   |
                    |   2 - поиск контактов            |
                    |   3 - сортировка контактов       |
                    |   4 - выход в главное меню       |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    ContactFileManager.viewAllContacts(userContactList);
                    break;
                }
                case "2": {
                    //todo сделать поиск контактов (возможно ещё одно меню с разными вариантами)
                    System.out.println("Тут должен быть поиск контактов, ещё не реализовано");
                    break;
                }
                case "3": {
                    sortMenu(userContactList);
                    break;
                }
                case "4": {
                    System.out.println("""
                            ------------------------------------
                            |       Выход в главное меню       |
                            ------------------------------------""");
                    System.out.println();
                    break contactsViewMenu;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте снова.");
                }
            }
        }
    }

    private static void sortMenu(List<Contact> userContactList) {
        Scanner scanner = new Scanner(System.in);
        if (userContactList.isEmpty()) {
            System.out.println("""
                    ------------------------------------
                    |       Список контактов пуст      |
                    |        Заполните контакты и      |
                    |          попробуйте снова        |
                    ------------------------------------""");
            System.out.println();
            return;
        }
        sortMenu:
        while (true) {
            System.out.println("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |        Сортировка контактов      |
                    ------------------------------------
                    |   1 - сортировка по имени        |
                    |   2 - сортировка по фамилии      |
                    |   3 - сортировка по номеру       |
                    |   4 - сортировка по возрасту     |
                    |   5 - выход в меню просмотра     |
                    |       контактов                  |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |        Сортировка по имени       |
                            ------------------------------------
                            |   1 - сортировка по имени (A-Z)  |
                            |   2 - сортировка по имени (Z-A)  |
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String destinationInput = scanner.nextLine();
                    if (destinationInput.equals("1")) {
                        ContactFileManager.sortContact(userContactList, 1);
                    } else if (destinationInput.equals("2")) {
                        ContactFileManager.sortContact(userContactList, 2);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                    }
                    break;
                }
                case "2": {
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |       Сортировка по фамилии      |
                            ------------------------------------
                            |   1 - сортировка по фамилии (A-Z)|
                            |   2 - сортировка по фамилии (Z-A)|
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String destinationInput = scanner.nextLine();
                    if (destinationInput.equals("1")) {
                        ContactFileManager.sortContact(userContactList, 3);
                    } else if (destinationInput.equals("2")) {
                        ContactFileManager.sortContact(userContactList, 4);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                    }
                    break;
                }
                case "3": {
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |       Сортировка по номеру       |
                            ------------------------------------
                            |   1 - сортировка по номеру(0-9)  |
                            |   2 - сортировка по номеру(9-0)  |
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String destinationInput = scanner.nextLine();
                    if (destinationInput.equals("1")) {
                        ContactFileManager.sortContact(userContactList, 5);
                    } else if (destinationInput.equals("2")) {
                        ContactFileManager.sortContact(userContactList, 6);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                    }
                    break;
                }
                case "4": {
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |      Сортировка по возрасту      |
                            ------------------------------------
                            |   1 - сортировка по возрасту(0-9)|
                            |   2 - сортировка по возрасту(9-0)|
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String destinationInput = scanner.nextLine();
                    if (destinationInput.equals("1")) {
                        ContactFileManager.sortContact(userContactList, 7);
                    } else if (destinationInput.equals("2")) {
                        ContactFileManager.sortContact(userContactList, 8);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                    }
                    break;
                }
                case "5": {
                    System.out.println("""
                            ------------------------------------
                            |       Выход в меню просмотра     |
                            |              контактов           |
                            ------------------------------------""");
                    System.out.println();
                    break sortMenu;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте снова.");
                }
            }
        }
    }

    private static void deletionMenu(List<Contact> userContactList) {
        Scanner scanner = new Scanner(System.in);
        if (userContactList.isEmpty()) {
            System.out.println("""
                    ------------------------------------
                    |       Список контактов пуст      |
                    |        Заполните контакты и      |
                    |          попробуйте снова        |
                    ------------------------------------""");
            System.out.println();
            return;
        }
        deletionMenu:
        while (true) {
            System.out.println("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |        Удаление контактов        |
                    ------------------------------------
                    |   1 - удалить по id              |
                    |   2 - удалить по имени           |
                    |   3 - удалить по фамилии         |
                    |   4 - удалить по номеру          |
                    |   5 - выход в меню изменения     |
                    |       контактов                  |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.print("Введите id для удаления: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    ContactFileManager.deleteContactById(userContactList, id);
                    break;
                }
                case "2": {
                    System.out.print("Введите имя для удаления: ");
                    String name = scanner.nextLine().trim();
                    ContactFileManager.deleteContactByName(userContactList, name);
                    break;
                }
                case "3": {
                    System.out.print("Введите фамилию для удаления: ");
                    String surname = scanner.nextLine().trim();
                    ContactFileManager.deleteContactBySurname(userContactList, surname);
                    break;
                }
                case "4": {
                    System.out.print("Введите номер телефона для удаления");
                    String phone = scanner.nextLine().trim();
                    ContactFileManager.deleteContactByPhone(userContactList, phone);
                    break;
                }
                case "5": {
                    System.out.println("""
                            ------------------------------------
                            |       Выход в меню изменения     |
                            |              контактов           |
                            ------------------------------------""");
                    System.out.println();
                    break deletionMenu;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте снова.");
                }
            }
        }
    }

    private static void registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ------------------------------------
                |      << Телефонная книга >>      |
                |     Регистрация пользователя     |
                ------------------------------------""");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String passwd1 = scanner.nextLine();
        System.out.print("Повторите пароль: ");
        String passwd2 = scanner.nextLine();

        if (passwd1.equals(passwd2)) {
            Login login = new Login(name, surname, Login.generateLogin(name, surname), passwd1); //todo добавить проверок для пользователя
            try {
                LoginFileManager manager = new LoginFileManager();
                manager.createLoginContacts(login.getLogin());
                manager.addLogin(login);
                System.out.println("""
                        ------------------------------------
                        |       Вы зарегистрированы!       |
                        ------------------------------------""");
                System.out.println();
            } catch (IOException e) {
                System.out.println("Ошибка, не удалось зарегистрировать нового пользователя: " + e.getMessage());
            }

        } else {
            System.out.println("""
                    ------------------------------------
                    |       Пароли не совпадают.       |
                    |         Попробуйте снова         |
                    ------------------------------------""");
            System.out.println();
        }
    }

    private static void authorization() {
        Login user;
        Session currentSession;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        if (LoginFileManager.checkLogin(login, password)) {
            System.out.println("""
                    ------------------------------------
                    |          Вы авторизованы         |
                    ------------------------------------""");
            System.out.println();
            user = new Login(login, password);
            ContactFileManager.loadContactList(user);
            currentSession = new Session(user);
        } else {
            System.out.println("""
                    ------------------------------------
                    |     Неверный логин или пароль    |
                    |         Попробуйте снова         |
                    ------------------------------------""");
            System.out.println();
        }
    }
}


class Contact {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private int age;

    public Contact(int id, String name, String surname, String phone, int age) {
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

    public static Contact parse(String line) {
        String[] parts = line.split(" ");
        return new Contact(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                parts[3],
                Integer.parseInt(parts[4])
        );
    }

    public static int generateId(List<Contact> userContactsList) {
        int nextId;
        if (userContactsList.isEmpty()) {
            nextId = 0;
        } else {
            nextId = userContactsList.getLast().getId() + 1;
        }
        return nextId;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + phone + " " + age;
    }
}

class ContactFileManager {

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
            }
        }
    }

    public static void deleteContactById(List<Contact> userContactList, int id) {
        for (Contact contact : userContactList) {
            if (contact.getId() == id) {
                userContactList.remove(contact);
                System.out.println("Контакт с id \"" + id + "\" был удалён");
                return;
            }
        }
        System.out.println("Контакт с id \"" + id + "\" не найден");
    }

    public static void deleteContactByName(List<Contact> userContactList, String name) {
        for (Contact contact : userContactList) {
            if (contact.getName().equals(name)) {
                userContactList.remove(contact);
                System.out.println("Контакт с именем \"" + name + "\" был удалён");
                return;
            }
        }
        System.out.println("Контакт с именем \"" + name + "\" не найден");
    }

    public static void deleteContactBySurname(List<Contact> userContactList, String surname) {
        for (Contact contact : userContactList) {
            if (contact.getSurname().equals(surname)) {
                userContactList.remove(contact);
                System.out.println("Контакт с фамилией \"" + surname + "\" был удалён");
                return;
            }
        }
        System.out.println("Контакт с фамилией \"" + surname + "\" не найден");
    }

    public static void deleteContactByPhone(List<Contact> userContactList, String phone) {
        for (Contact contact : userContactList) {
            if (contact.getPhone().equals(phone)) {
                userContactList.remove(contact);
                System.out.println("Контакт с номером телефона \"" + phone + "\" был удалён");
            }
        }
        System.out.println("Контакт с номером телефона \"" + phone + "\" не найден");
    }
}

class Login {
    private String name;
    private String surname;
    private String login;
    private String password;
    private List<Contact> contactList;

    public Login(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.contactList = new ArrayList<>();
    }

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public static String getLoginContactsPath(String login) {
        return ProgrammPaths.CONTACTS_DIR + "/" + login.concat("Contacts.txt");
    }

    public static String generateLogin(String name, String surname) {
        return name.substring(0, 2).concat("-").concat(surname);
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + login + " " + password;
    }
}

class LoginFileManager {
// что должен уметь менеджер логинов:
    //1) добавлять новый уникальный логин //todo логин пока генерируется не совсем уникальный
    //2) считывать логин из файла и передавать в другие методы/классы

    public static void createOrCheckExistingFolders() {

        if (!ProgrammPaths.USERS_DIR.exists()) {
            System.out.println(ProgrammPaths.USERS_DIR.mkdir() ? "Папка пользователей создана" : "Папка юзеров не создана");
        }

        if (!ProgrammPaths.CONTACTS_DIR.exists()) {
            System.out.println(ProgrammPaths.CONTACTS_DIR.mkdir() ? "Папка контактов создана" : "Папка контактов не создана");

        }

        if (!ProgrammPaths.USERS_FILE.exists()) {
            try {
                ProgrammPaths.USERS_FILE.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка создания файла users.txt " + e.getMessage());
            }
        }
    }

    public void createLoginContacts(String login) throws IOException {
        Path contactsFilePath = Paths.get(ProgrammPaths.CONTACTS_DIR.getPath());
        File file = new File(contactsFilePath + "/" + login.concat("Contacts.txt"));
        file.createNewFile();
    }

    public void addLogin(Login login) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProgrammPaths.USERS_FILE.getPath(), true))) {
            writer.write(login.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось записать информацию в файл: " + e.getMessage());
        }
    }

    public static boolean checkLogin(String login, String password) {
        File usersFile = ProgrammPaths.USERS_FILE;
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4 && parts[2].equals(login) && parts[3].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла пользователей: " + e.getMessage());
        }
        return false;
    }
}

class Session {
    private static String currentLogin;
    private static List<Contact> currentLoginContacts;

    public Session(Login login) {
        Session.currentLogin = login.getLogin();
        Session.currentLoginContacts = login.getContactList();
    }

    public static String getCurrentLogin() {
        return currentLogin;
    }

    public static void setCurrentLogin(String currentLogin) {
        Session.currentLogin = currentLogin;
    }

    public static List<Contact> getCurrentLoginContacts() {
        return currentLoginContacts;
    }

    public static void setCurrentLoginContacts(List<Contact> currentLoginContacts) {
        Session.currentLoginContacts = currentLoginContacts;
    }
}


