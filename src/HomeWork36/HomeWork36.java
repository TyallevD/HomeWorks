package HomeWork36;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HomeWork36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgrammPaths.createOrCheckExistingFolders();
        Logger.addRecord("Запуск программы");
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
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Authorization.authorization();
                    if (Session.getCurrentLoginContacts() != null) {
                        mainMenu(Session.getCurrentLoginContacts());
                    }
                    break;
                case "2":
                    Authorization.registration();
                    break;
                case "3":
                    System.out.println("""
                            ------------------------------------
                            |        Выход из программы        |
                            ------------------------------------""");
                    System.out.println();
                    Logger.addRecord("Остановка программы");
                    break startMenu;
                default:
                    System.out.println("Ваш ввод неверный, попробуйте снова");
                    System.out.println();
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
            String input = scanner.nextLine().trim();
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
                    Logger.addRecord("пользователь вышел из аккаунта");
                    Logger.addRecord("список контактов очищен");
                    Session.setCurrentLogin(null);
                    userContactList = null;
                    break mainMenu;
                }
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
                    System.out.println();
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
                    |   2 - поменять контакт           |
                    |   3 - удалить контакт            |
                    |   4 - выход в главное меню       |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1": {
                    try {
                        ContactFileManager.addContact(userContactList, ContactFileManager.createContact(userContactList));
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректное значение возраста. Попробуйте снова.");
                        System.out.println();
                    }
                    break;
                }
                case "2": {
                    updateContactsMenu(userContactList);
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
                    System.out.println();
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
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1": {
                    ContactFileManager.viewAllContacts(userContactList);
                    break;
                }
                case "2": {
                    searchContactMenu(userContactList);
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
                    System.out.println();
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
            String input = scanner.nextLine().trim();
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
                    String destinationInput = scanner.nextLine().trim();
                    if (destinationInput.equals("1")) {
                        SortContact.sortContact(userContactList, 1);
                    } else if (destinationInput.equals("2")) {
                        SortContact.sortContact(userContactList, 2);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    break;
                }
                case "2": {
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |       Сортировка по фамилии      |
                            ------------------------------------
                            |  1 - сортировка по фамилии (A-Z) |
                            |  2 - сортировка по фамилии (Z-A) |
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String destinationInput = scanner.nextLine().trim();
                    if (destinationInput.equals("1")) {
                        SortContact.sortContact(userContactList, 3);
                    } else if (destinationInput.equals("2")) {
                        SortContact.sortContact(userContactList, 4);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
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
                    String destinationInput = scanner.nextLine().trim();
                    if (destinationInput.equals("1")) {
                        SortContact.sortContact(userContactList, 5);
                    } else if (destinationInput.equals("2")) {
                        SortContact.sortContact(userContactList, 6);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    break;
                }
                case "4": {
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |      Сортировка по возрасту      |
                            ------------------------------------
                            |  1 - сортировка по возрасту(0-9) |
                            |  2 - сортировка по возрасту(9-0) |
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String destinationInput = scanner.nextLine().trim();
                    if (destinationInput.equals("1")) {
                        SortContact.sortContact(userContactList, 7);
                    } else if (destinationInput.equals("2")) {
                        SortContact.sortContact(userContactList, 8);
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
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
                    System.out.println();
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
                    try {
                        System.out.print("Введите id для удаления: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        DeleteContact.deleteContactById(userContactList, id);
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректное значение id, попробуйте снова");
                        System.out.println();
                        scanner.nextLine();
                    }
                    break;
                }
                case "2": {
                    System.out.print("Введите имя для удаления: ");
                    String name = scanner.nextLine().trim();
                    DeleteContact.deleteContactByName(userContactList, name);
                    break;
                }
                case "3": {
                    System.out.print("Введите фамилию для удаления: ");
                    String surname = scanner.nextLine().trim();
                    DeleteContact.deleteContactBySurname(userContactList, surname);
                    break;
                }
                case "4": {
                    System.out.print("Введите номер телефона для удаления");
                    String phone = scanner.nextLine().trim();
                    DeleteContact.deleteContactByPhone(userContactList, phone);
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
                    System.out.println();
                }
            }
        }
    }

    private static void updateContactsMenu(List<Contact> userContactList) {
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
        updateContactsMenu:
        while (true) {
            System.out.println("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |      Изменение существующих      |
                    |            контактов             |
                    ------------------------------------
                    |   1 - изменить имя контакта      |
                    |   2 - изменить фамилию контакта  |
                    |   3 - изменить номер телефона    |
                    |       контакта                   |
                    |   4 - изменить возраст контакта  |
                    |   5 - выход в меню изменения     |
                    |       контактов                  |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.print("Введите имя для изменения: ");
                    String name = scanner.nextLine().trim();
                    UpdateContact.updateContactByName(userContactList, name);
                    break;
                }
                case "2": {
                    System.out.print("Введите фамилию для изменения: ");
                    String surname = scanner.nextLine().trim();
                    UpdateContact.updateContactBySurname(userContactList, surname);
                    break;
                }
                case "3": {
                    System.out.print("Введите номер телефона для изменения: ");
                    String phone = scanner.nextLine().trim();
                    UpdateContact.updateContactByPhone(userContactList, phone);
                    break;
                }
                case "4": {
                    System.out.print("Введите возраст для изменения: ");
                    try {
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        UpdateContact.updateContactByAge(userContactList, age);
                    } catch (InputMismatchException e) {
                        System.out.println("Неверное значение возраста. Попробуйте снова");
                        System.out.println();
                    }
                    break;
                }
                case "5": {
                    System.out.println("""
                            ------------------------------------
                            |       Выход в меню изменения     |
                            |              контактов           |
                            ------------------------------------""");
                    System.out.println();
                    break updateContactsMenu;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте снова.");
                    System.out.println();
                }
            }
        }
    }

    private static void searchContactMenu(List<Contact> userContactList) {
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
        searchContactMenu:
        while (true) {
            System.out.println("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |        Поиск существующих        |
                    |            контактов             |
                    ------------------------------------
                    |   1 - поиск по имени             |
                    |   2 - поиск по фамилии           |
                    |   3 - поиск по номеру телефона   |
                    |   4 - поиск по возрасту          |
                    |   5 - выход в меню просмотра     |
                    |       контактов                  |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    //todo Поиск по имени/частичный поиск
                    System.out.print("Введите имя для поиска: ");
                    String name = scanner.nextLine().trim();
                    SearchContact.searchContactByName(userContactList, name);
                    break;
                }
                case "2": {
                    //todo Поиск по фамилии/частичный поиск
                    System.out.print("Введите фамилию для поиска: ");
                    String surname = scanner.nextLine().trim();
                    SearchContact.searchContactBySurname(userContactList, surname);
                    break;
                }
                case "3": {
                    //todo Поиск по номеру телефона/частичный поиск
                    System.out.print("Введите номер для поиска: ");
                    String phone = scanner.nextLine().trim();
                    SearchContact.searchContactByPhone(userContactList, phone);
                    break;
                }
                case "4": {
                    //todo Поиск по возрасту/больше, меньше, равно
                    System.out.print("Введите возраст для поиска: ");
                    try {
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        SearchContact.searchContactByAge(userContactList, age);
                    } catch (InputMismatchException e) {
                        System.out.println("Неверный значение возраста. Попробуйте снова");
                        System.out.println();
                        scanner.nextLine();
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
                    break searchContactMenu;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте снова.");
                    System.out.println();
                }
            }
        }
    }
}