package HomeWork39;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HomeWork39 {
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
                    |   3 - посмотреть логи            |
                    |   4 - завершение программы       |
                    ------------------------------------
                    """);
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1": {
                    Logger.addRecord("Начало авторизации");
                    Authorization.authorization();
                    if (Session.getCurrentLoginContacts() != null) {
                        mainMenu(Session.getCurrentLoginContacts());
                    }
                    break;
                }
                case "2": {
                    Logger.addRecord("Начало регистрации нового пользователя");
                    Authorization.registration();
                    Logger.addRecord("Конец регистрации нового пользователя");
                    break;
                }
                case "3": {
                    Logger.addRecord("Начало чтения файла логов");
                    Logger.readLogsFile();
                    Logger.addRecord("Конец чтения файла логов");
                    break;
                }
                case "4": {
                    System.out.println("""
                            ------------------------------------
                            |       Завершение программы       |
                            ------------------------------------""");
                    System.out.println();
                    Logger.addRecord("Завершение программы");
                    break startMenu;
                }
                default: {
                    System.out.println("Ваш ввод неверный, попробуйте снова");
                    System.out.println();
                    break;
                }
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
                    Logger.addRecord("Переход в меню изменения контактов");
                    contactsChangeMenu(userContactList);
                    break;
                }
                case "2": {
                    Logger.addRecord("Переход в меню просмотра контактов");
                    contactsViewMenu(userContactList);
                    break;
                }
                case "3": {
                    System.out.println("""
                            ------------------------------------
                            |    Выход на экран авторизации    |
                            ------------------------------------""");
                    System.out.println();
                    Logger.addRecord("Пользователь \"" + Session.getCurrentLogin() + "\" вышел из аккаунта");
                    Logger.addRecord("Список контактов очищен");
                    Session.setCurrentLogin(null);
                    userContactList = null;
                    break mainMenu;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте снова.");
                    System.out.println();
                }
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
                    Logger.addRecord("Начало добавления контакта");
                    try {
                        ContactFileManager.addContact(userContactList, ContactFileManager.createContact(userContactList));
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректное значение возраста. Попробуйте снова.");
                        System.out.println();
                    }
                    Logger.addRecord("Конец добавления контакта");
                    break;
                }
                case "2": {
                    Logger.addRecord("Переход в меню изменения контактов");
                    updateContactsMenu(userContactList);
                    break;
                }
                case "3": {
                    Logger.addRecord("Переход в меню удаления контактов");
                    deletionMenu(userContactList);
                    break;
                }
                case "4": {
                    Logger.addRecord("Сохранение контактов пользователя \"" + Session.getCurrentLogin() + "\" в файл " + Login.getLoginContactsPath(Session.getCurrentLogin()));
                    Logger.addRecord("Выход в главное меню");
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
                    Logger.addRecord("Начало просмотра всех контактов");
                    ContactFileManager.viewAllContacts(userContactList);
                    Logger.addRecord("Конец просмотра всех контактов");
                    break;
                }
                case "2": {
                    Logger.addRecord("Переход в меню поиска контактов");
                    searchContactMenu(userContactList);
                    break;
                }
                case "3": {
                    Logger.addRecord("Переход в меню сортировки контактов");
                    sortMenu(userContactList);
                    break;
                }
                case "4": {
                    Logger.addRecord("Выход в главное меню из меню просмотра контактов");
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
                    Logger.addRecord("Переход в меню сортировки по имени");
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
                        Logger.addRecord("Начало сортировки по имени A-Z");
                        SortContact.sortContact(userContactList, 1);
                        Logger.addRecord("Конец сортировки по имени A-Z");
                    } else if (destinationInput.equals("2")) {
                        Logger.addRecord("Начало сортировки по имени Z-A");
                        SortContact.sortContact(userContactList, 2);
                        Logger.addRecord("Конец сортировки по имени Z-A");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    break;
                }
                case "2": {
                    Logger.addRecord("Переход в меню сортировки по фамилии");
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
                        Logger.addRecord("Начало сортировки по фамилии A-Z");
                        SortContact.sortContact(userContactList, 3);
                        Logger.addRecord("Конец сортировки по фамилии A-Z");
                    } else if (destinationInput.equals("2")) {
                        Logger.addRecord("Начало сортировки по фамилии Z-A");
                        SortContact.sortContact(userContactList, 4);
                        Logger.addRecord("Конец сортировки по фамилии Z-A");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    break;
                }
                case "3": {
                    Logger.addRecord("Переход в меню сортировки по номеру телефона");
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
                        Logger.addRecord("Начало сортировки по номеру телефона 0-9");
                        SortContact.sortContact(userContactList, 5);
                        Logger.addRecord("Конец сортировки по номеру телефона 0-9");
                    } else if (destinationInput.equals("2")) {
                        Logger.addRecord("Начало сортировки по номеру телефона 9-0");
                        SortContact.sortContact(userContactList, 6);
                        Logger.addRecord("Конец сортировки по номеру телефона 9-0");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    break;
                }
                case "4": {
                    Logger.addRecord("Переход в меню сортировки по возрасту");
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
                        Logger.addRecord("Начало сортировки по возрасту 0-9");
                        SortContact.sortContact(userContactList, 7);
                        Logger.addRecord("Конец сортировки по возрасту 0-9");
                    } else if (destinationInput.equals("2")) {
                        Logger.addRecord("Начало сортировки по возрасту 9-0");
                        SortContact.sortContact(userContactList, 8);
                        Logger.addRecord("Конец сортировки по возрасту 9-0");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    break;
                }
                case "5": {
                    Logger.addRecord("Выход в меню просмотра контактов из меню сортировки");
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
                    Logger.addRecord("Начало удаления контакта по id");
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
                    Logger.addRecord("Конец удаления контакта по id");
                    break;
                }
                case "2": {
                    Logger.addRecord("Начало удаления контакта по имени");
                    System.out.print("Введите имя для удаления: ");
                    String name = scanner.nextLine().trim();
                    DeleteContact.deleteContactByName(userContactList, name);
                    Logger.addRecord("Конец удаления контакта по имени");
                    break;
                }
                case "3": {
                    Logger.addRecord("Начало удаления контакта по фамилии");
                    System.out.print("Введите фамилию для удаления: ");
                    String surname = scanner.nextLine().trim();
                    DeleteContact.deleteContactBySurname(userContactList, surname);
                    Logger.addRecord("Конец удаления контакта по фамилии");
                    break;
                }
                case "4": {
                    Logger.addRecord("Начало удаления контакта по номеру телефона");
                    System.out.print("Введите номер телефона для удаления: ");
                    String phone = scanner.nextLine().trim();
                    DeleteContact.deleteContactByPhone(userContactList, phone);
                    Logger.addRecord("Конец удаления контакта по номеру телефона");
                    break;
                }
                case "5": {
                    Logger.addRecord("Выход в меню изменения контактов из меню удаления контактов");
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
                    Logger.addRecord("Начало изменения контакта по имени");
                    System.out.print("Введите имя для изменения: ");
                    String name = scanner.nextLine().trim();
                    UpdateContact.updateContactByName(userContactList, name);
                    Logger.addRecord("Конец изменения контакта по имени");
                    break;
                }
                case "2": {
                    Logger.addRecord("Начало изменения контакта по фамилии");
                    System.out.print("Введите фамилию для изменения: ");
                    String surname = scanner.nextLine().trim();
                    UpdateContact.updateContactBySurname(userContactList, surname);
                    Logger.addRecord("Конец изменения контакта по фамилии");
                    break;
                }
                case "3": {
                    Logger.addRecord("Начало изменения контакта по номеру телефона");
                    System.out.print("Введите номер телефона для изменения: ");
                    String phone = scanner.nextLine().trim();
                    UpdateContact.updateContactByPhone(userContactList, phone);
                    Logger.addRecord("Конец изменения контакта по номеру телефона");
                    break;
                }
                case "4": {
                    Logger.addRecord("Начало изменения контакта по возрасту");
                    System.out.print("Введите возраст для изменения: ");
                    try {
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        UpdateContact.updateContactByAge(userContactList, age);
                    } catch (InputMismatchException e) {
                        System.out.println("Неверное значение возраста. Попробуйте снова");
                        System.out.println();
                    }
                    Logger.addRecord("Конец изменения контакта по возрасту");
                    break;
                }
                case "5": {
                    Logger.addRecord("Выход в меню изменения контактов из меню изменения существующих контактов");
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
                    Logger.addRecord("Начало поиска контактов по имени");
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |          Поиск по имени          |
                            ------------------------------------
                            |   1 - поиск по имени (полный)    |
                            |   2 - поиск по имени (частичный) |
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String searchOption = scanner.nextLine().trim();
                    if (searchOption.equals("1")) {
                        Logger.addRecord("Начало поиска контактов по имени (полный)");
                        System.out.print("Введите имя для поиска: ");
                        String name = scanner.nextLine().trim();
                        SearchContact.searchContactByName(userContactList, name);
                        Logger.addRecord("Конец поиска контактов по имени (полный)");
                    } else if (searchOption.equals("2")) {
                        Logger.addRecord("Начало поиска контактов по имени (частичный)");
                        System.out.print("Введите имя для поиска, используя символы \"_\" или \"%\": ");
                        String name = scanner.nextLine().trim();
                        PartialSearchContact.partialSearchByName(userContactList, name);
                        Logger.addRecord("Конец поиска контактов по имени (частичный)");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    Logger.addRecord("Конец поиска контактов по имени");
                    break;
                }
                case "2": {
                    Logger.addRecord("Начало поиска контактов по фамилии");
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |          Поиск по фамилии        |
                            ------------------------------------
                            | 1 - поиск по фамилии (полный)    |
                            | 2 - поиск по фамилии (частичный) |
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String searchOption = scanner.nextLine().trim();
                    if (searchOption.equals("1")) {
                        Logger.addRecord("Начало поиска контактов по фамилии (полный)");
                        System.out.print("Введите фамилию для поиска: ");
                        String surname = scanner.nextLine().trim();
                        SearchContact.searchContactBySurname(userContactList, surname);
                        Logger.addRecord("Конец поиска контактов по фамилии (полный)");
                    } else if (searchOption.equals("2")) {
                        Logger.addRecord("Начало поиска контактов по фамилии (частичный)");
                        System.out.print("Введите фамилию для поиска, используя символы \"_\" или \"%\": ");
                        String surname = scanner.nextLine().trim();
                        PartialSearchContact.partialSearchBySurname(userContactList, surname);
                        Logger.addRecord("Конец поиска контактов по фамилии (частичный)");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    Logger.addRecord("Конец поиска контактов по фамилии");
                    break;
                }
                case "3": {
                    Logger.addRecord("Начало поиска контактов по номеру телефона");
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |         Поиск по телефону        |
                            ------------------------------------
                            | 1 - поиск по телефону (полный)   |
                            | 2 - поиск по телефону (частичный)|
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String searchOption = scanner.nextLine().trim();
                    if (searchOption.equals("1")) {
                        Logger.addRecord("Начало поиска контактов по номеру телефона (полный)");
                        System.out.print("Введите номер для поиска: ");
                        String phone = scanner.nextLine().trim();
                        SearchContact.searchContactByPhone(userContactList, phone);
                        Logger.addRecord("Конец поиска контактов по номеру телефона (полный)");
                    } else if (searchOption.equals("2")) {
                        Logger.addRecord("Начало поиска контактов по номеру телефона (частичный)");
                        System.out.print("Введите номер для поиска, используя символы \"_\" или \"%\": ");
                        String phone = scanner.nextLine().trim();
                        PartialSearchContact.partialSearchByPhone(userContactList, phone);
                        Logger.addRecord("Конец поиска контактов по номеру телефона (частичный)");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    Logger.addRecord("Конец поиска контактов по номеру телефона");
                    break;
                }
                case "4": {
                    Logger.addRecord("Начало поиска контактов по возрасту");
                    System.out.println("""
                            ------------------------------------
                            |      << Телефонная книга >>      |
                            |         Поиск по возрасту        |
                            ------------------------------------
                            | 1 - поиск по возрасту (полный)   |
                            | 2 - поиск по возрасту (ниже/выше)|
                            ------------------------------------""");
                    System.out.print("Ввод команды: ");
                    String searchOption = scanner.nextLine().trim();
                    if (searchOption.equals("1")) {
                        Logger.addRecord("Начало поиска контактов по возрасту (полный)");
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
                        Logger.addRecord("Конец поиска контактов по возрасту (полный)");
                    } else if (searchOption.equals("2")) {
                        Logger.addRecord("Начало поиска контактов по возрасту (частичный)");
                        System.out.print("Введите возраст для поиска: ");
                        try {
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Введите значение 1 - выше, 2 - ниже: ");
                            String destination = scanner.nextLine().trim();
                            PartialSearchContact.partialSearchByAge(userContactList, age, destination);
                        } catch (InputMismatchException e) {
                            System.out.println("Неверный значение возраста. Попробуйте снова");
                            System.out.println();
                            scanner.nextLine();
                        }
                        Logger.addRecord("Конец поиска контактов по возрасту (частичный)");
                    } else {
                        System.out.println("Неверная команда. Попробуйте снова.");
                        System.out.println();
                    }
                    Logger.addRecord("Конец поиска контактов по возрасту");
                    break;
                }
                case "5": {
                    Logger.addRecord("Выход в меню просмотра контактов из меню поиска");
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

class Authorization {
    public static void registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ------------------------------------
                |      << Телефонная книга >>      |
                |     Регистрация пользователя     |
                ------------------------------------""");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine().trim();
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine().trim();
        System.out.print("Введите пароль: ");
        String passwd1 = scanner.nextLine().trim();
        System.out.print("Повторите пароль: ");
        String passwd2 = scanner.nextLine().trim();

        if (passwd1.equals(passwd2)) {
            Logger.addRecord("Начало генерации нового логина");
            String userLogin = Login.generateLogin(name, surname);
            Logger.addRecord("Конец генерации нового логина");
            if (!Login.isLoginExists(userLogin)) {
                Login login = new Login(name, surname, userLogin, passwd1);
                try {
                    LoginFileManager manager = new LoginFileManager();
                    manager.createLoginContacts(login.getLogin());
                    manager.addLogin(login);
                    Logger.addRecord("Регистрация нового пользователя \"" + login.getLogin() + "\" выполнена успешно");
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
                        |     Не удалось автоматически     |
                        | сгенерировать логин пользователя.|
                        |  Найден пользователь с таким же  |
                        |             логином.             |
                        |       Необходимо придумать       |
                        |      свой логин и ввести его     |
                        ------------------------------------""");
                System.out.println();
                Logger.addRecord("Не удалось автоматически сгенерировать логин пользователя. Переход на ручное создание логина.");
                userLogin = Login.manualCreateLogin();
                Login login = new Login(name, surname, userLogin, passwd1);
                try {
                    LoginFileManager manager = new LoginFileManager();
                    manager.createLoginContacts(login.getLogin());
                    manager.addLogin(login);
                    Logger.addRecord("Регистрация нового пользователя \"" + login.getLogin() + "\" выполнена успешно");
                    System.out.println("""
                            ------------------------------------
                            |       Вы зарегистрированы!       |
                            ------------------------------------""");
                    System.out.println();
                } catch (IOException e) {
                    System.out.println("Ошибка, не удалось зарегистрировать нового пользователя: " + e.getMessage());
                }
            }
        } else {
            Logger.addRecord("Ошибка регистрации");
            System.out.println("""
                    ------------------------------------
                    |       Пароли не совпадают.       |
                    |         Попробуйте снова         |
                    ------------------------------------""");
            System.out.println();
        }
    }

    public static void authorization() {
        Login user;
        Session currentSession;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine().trim();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();

        if (LoginFileManager.checkLogin(login, password)) {
            System.out.println("""
                    ------------------------------------
                    |          Вы авторизованы         |
                    ------------------------------------""");
            System.out.println();
            user = new Login(login, password);
            ContactFileManager.loadContactList(user);
            currentSession = new Session(user);
            Logger.addRecord("Пользователь " + Session.getCurrentLogin() + " авторизован");
            Logger.addRecord("Загружены данные файла контактов пользователя \"" + Session.getCurrentLogin() + "\" из файла: " + Login.getLoginContactsPath(login));
        } else {
            System.out.println("""
                    ------------------------------------
                    |       Неверный логин/пароль      |
                    |         или пользователь         |
                    |        не зарегистрирован        |
                    |          Попробуйте снова        |
                    ------------------------------------""");
            System.out.println();
            Logger.addRecord("Ошибка авторизации: неверный логин/пароль или пользователь не существует");
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
        return userContactsList.isEmpty() ? 0 : userContactsList.getLast().getId() + 1;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + phone + " " + age;
    }
}

class ContactFileManager {

    public static Contact createContact(List<Contact> userContactsList) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine().trim();
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine().trim();
        System.out.print("Введите номер телефона: ");
        String phone = scanner.nextLine().trim();
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
        Logger.addRecord("Добавлен контакт: " + contact);
    }

    public static void viewAllContacts(List<Contact> contactsList) {
        int count = 0;
        System.out.println("""
                ------------------------------------
                |          Ваши контакты           |
                ------------------------------------""");
        if (contactsList.isEmpty()) {
            Logger.addRecord("Список контактов пуст");
            System.out.println("""
                    ------------------------------------
                    |       Список контактов пуст      |
                    ------------------------------------""");
            System.out.println();
        }
        for (Contact contact : contactsList) {
            System.out.println(contact);
            count++;
        }
        Logger.addRecord("Всего контактов: " + count);
        System.out.println();
    }

    public static void loadContactList(Login login) {
        File contactFile = new File(Login.getLoginContactsPath(login.getLogin()));
        if (!contactFile.exists()) {
            System.out.println("Файл контактов не найден");
            System.out.println();
            Logger.addRecord("Ошибка. Файл контактов не найден");
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

class DeleteContact {
    public static void deleteContactById(List<Contact> userContactList, int id) {
        for (Contact contact : userContactList) {
            if (contact.getId() == id) {
                userContactList.remove(contact);
                System.out.println("Контакт с id \"" + id + "\" был удалён");
                System.out.println();
                Logger.addRecord("Контакт с id \"" + id + "\" был удалён");
                return;
            }
        }
        System.out.println("Контакт с id \"" + id + "\" не найден");
        System.out.println();
        Logger.addRecord("Контакт с id \"" + id + "\" не найден");
    }

    public static void deleteContactByName(List<Contact> userContactList, String name) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByName(userContactList, name);
        if (contactCount == 1) {
            for (Contact contact : userContactList) {
                if (contact.getName().equals(name)) {
                    userContactList.remove(contact);
                    System.out.println("Контакт с именем \"" + name + "\" был удалён");
                    System.out.println();
                    Logger.addRecord("Контакт с именем \"" + name + "\" был удалён");
                    return;
                }
            }
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с именем \"" + name + "\"");
            Logger.addRecord("Найдено несколько записей с именем \"" + name + "\"");
            try {
                System.out.print("Введите id для удаления: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                DeleteContact.deleteContactById(userContactList, contactId);
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
                Logger.addRecord("Некорректное значение id");
            }
        } else {
            System.out.println("Контакт с именем \"" + name + "\" не найден");
            System.out.println();
            Logger.addRecord("Контакт с именем \"" + name + "\" не найден");
        }
    }

    public static void deleteContactBySurname(List<Contact> userContactList, String surname) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactBySurname(userContactList, surname);
        if (contactCount == 1) {
            for (Contact contact : userContactList) {
                if (contact.getSurname().equals(surname)) {
                    userContactList.remove(contact);
                    System.out.println("Контакт с фамилией \"" + surname + "\" был удалён");
                    System.out.println();
                    Logger.addRecord("Контакт с фамилией \"" + surname + "\" был удалён");
                    return;
                }
            }
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с фамилией \"" + surname + "\"");
            Logger.addRecord("Найдено несколько записей с фамилией \"" + surname + "\"");
            try {
                System.out.print("Введите id для удаления: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                DeleteContact.deleteContactById(userContactList, contactId);
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
                Logger.addRecord("Некорректное значение id");
            }
        } else {
            System.out.println("Контакт с фамилией \"" + surname + "\" не найден");
            System.out.println();
            Logger.addRecord("Контакт с фамилией \"" + surname + "\" не найден");
        }
    }

    public static void deleteContactByPhone(List<Contact> userContactList, String phone) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByPhone(userContactList, phone);
        if (contactCount == 1) {
            for (Contact contact : userContactList) {
                if (contact.getPhone().equals(phone)) {
                    userContactList.remove(contact);
                    System.out.println("Контакт с номером телефона \"" + phone + "\" был удалён");
                    System.out.println();
                    Logger.addRecord("Контакт с номером телефона \"" + phone + "\" был удалён");
                    return;
                }
            }
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с номером телефона \"" + phone + "\"");
            Logger.addRecord("Найдено несколько записей с номером телефона \"" + phone + "\"");
            try {
                System.out.print("Введите id для удаления: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                DeleteContact.deleteContactById(userContactList, contactId);
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
                Logger.addRecord("Некорректное значение id");
            }
        } else {
            System.out.println("Контакт с номером телефона \"" + phone + "\" не найден");
            System.out.println();
            Logger.addRecord("Контакт с номером телефона \"" + phone + "\" не найден");
        }
    }
}

class Logger {
    public static void addRecord(String message) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String login;
        if (Session.getCurrentLogin() == null) {
            login = "unauthorized";
        } else {
            login = Session.getCurrentLogin();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProgrammPaths.LOGS_FILE, true))) {
            writer.write("[" + date.format(formatter) + "] " + "[" + login + "]" + " " + message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось выполнить запись в лог");
        }
    }

    public static void readLogsFile() {
        System.out.println("""
                ------------------------------------
                |          Логи программы          |
                ------------------------------------""");
        System.out.println();
        try (BufferedReader reader = new BufferedReader(new FileReader(ProgrammPaths.LOGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл логов");
        }
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

    public static boolean isLoginExists(String login) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ProgrammPaths.USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] readedLine = line.split("\\s+");
                if (readedLine[2].equals(login)) {
                    System.out.println("Такой логин уже зарегистрирован");
                    System.out.println();
                    Logger.addRecord("Такой логин уже зарегистрирован");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл пользователей");
        }
        return false;
    }

    public static String manualCreateLogin() {
        Scanner scanner = new Scanner(System.in);
        String manualLogin;
        do {
            System.out.print("Придумайте и введите свой логин: ");
            manualLogin = scanner.nextLine().trim();
            System.out.println();
        } while (isLoginExists(manualLogin));
        Logger.addRecord("Ручное создание логина выполнено успешно");
        return manualLogin;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + login + " " + password;
    }
}

class LoginFileManager {
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

class PartialSearchContact {
    public static void partialSearchByName(List<Contact> userContactList, String name) {
        int count = 0;
        if (name.contains("_")) {
            String regex = convertToPartialRegex(name);
            Pattern pattern = Pattern.compile(regex);
            Logger.addRecord("Поиск по имени: \"" + name + "\"");
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по шаблону имени \"" + name + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (pattern.matcher(contact.getName()).matches()) {
                    count++;
                    System.out.println(contact);
                }
            }
            System.out.println("Всего найдено: " + count);
            Logger.addRecord("Всего найдено контактов: " + count);
        } else if (name.contains("%")) {
            String regex = convertToFullRegex(name);
            Pattern pattern = Pattern.compile(regex);
            Logger.addRecord("Поиск по имени: \"" + name + "\"");
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по шаблону имени \"" + name + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (pattern.matcher(contact.getName()).matches()) {
                    count++;
                    System.out.println(contact);
                }
            }
            System.out.println("Всего найдено: " + count);
            Logger.addRecord("Всего найдено контактов: " + count);
        } else {
            System.out.println("По заданному шаблону ничего не найдено");
            Logger.addRecord("По заданному шаблону ничего не найдено");
        }
    }

    public static void partialSearchBySurname(List<Contact> userContactList, String surname) {
        int count = 0;
        if (surname.contains("_")) {
            String regex = convertToPartialRegex(surname);
            Pattern pattern = Pattern.compile(regex);
            Logger.addRecord("Поиск по фамилии: \"" + surname + "\"");
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по шаблону фамилии \"" + surname + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (pattern.matcher(contact.getSurname()).matches()) {
                    count++;
                    System.out.println(contact);
                }
            }
            System.out.println("Всего найдено: " + count);
            Logger.addRecord("Всего найдено контактов: " + count);
        } else if (surname.contains("%")) {
            String regex = convertToFullRegex(surname);
            Pattern pattern = Pattern.compile(regex);
            Logger.addRecord("Поиск по фамилии: \"" + surname + "\"");
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по шаблону фамилии \"" + surname + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (pattern.matcher(contact.getSurname()).matches()) {
                    count++;
                    System.out.println(contact);
                }
            }
            System.out.println("Всего найдено: " + count);
            Logger.addRecord("Всего найдено контактов: " + count);
        } else {
            System.out.println("По заданному шаблону ничего не найдено");
            Logger.addRecord("По заданному шаблону ничего не найдено");
        }
    }

    public static void partialSearchByPhone(List<Contact> userContactList, String phone) {
        int count = 0;
        if (phone.contains("_")) {
            String regex = convertToPartialRegex(phone);
            Pattern pattern = Pattern.compile(regex);
            Logger.addRecord("Поиск по номеру телефона: \"" + phone + "\"");
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по шаблону телефона \"" + phone + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (pattern.matcher(contact.getPhone()).matches()) {
                    count++;
                    System.out.println(contact);
                }
            }
            System.out.println("Всего найдено: " + count);
            Logger.addRecord("Всего найдено контактов: " + count);
        } else if (phone.contains("%")) {
            String regex = convertToFullRegex(phone);
            Pattern pattern = Pattern.compile(regex);
            Logger.addRecord("Поиск по номеру телефона: \"" + phone + "\"");
            System.out.println("------------------------------------");
            System.out.println(" Найденные контакты по шаблону телефона \"" + phone + "\"");
            System.out.println("------------------------------------");
            for (Contact contact : userContactList) {
                if (pattern.matcher(contact.getPhone()).matches()) {
                    count++;
                    System.out.println(contact);
                }
            }
            System.out.println("Всего найдено: " + count);
            Logger.addRecord("Всего найдено контактов: " + count);
        } else {
            System.out.println("По заданному шаблону ничего не найдено");
            Logger.addRecord("По заданному шаблону ничего не найдено");
        }
    }

    private static String convertToPartialRegex(String stringPattern) {
        String escapedString = stringPattern.replace("+", "\\+");
        String regex = escapedString.replace("_", ".");
        return "^" + regex + "$";
    }

    private static String convertToFullRegex(String stringPattern) {
        String escapedString = stringPattern.replace("+", "\\+");
        return escapedString.replace("%", ".*");
    }

    public static void partialSearchByAge(List<Contact> userContactList, int age, String direction) {
        boolean isFound = false;
        int count = 0;
        if (direction.equals("1")) {
            Logger.addRecord("Поиск по возрасту больше \"" + age + "\"");
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
                Logger.addRecord("Всего найдено контактов: " + count);
            } else {
                System.out.println("По заданным критериям ничего не найдено");
                System.out.println();
                Logger.addRecord("По заданным критериям ничего не найдено");
            }
        } else if (direction.equals("2")) {
            Logger.addRecord("Поиск по возрасту меньше \"" + age + "\"");
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
                Logger.addRecord("Всего найдено контактов: " + count);
            } else {
                System.out.println("По заданным критериям ничего не найдено");
                System.out.println();
                Logger.addRecord("По заданным критериям ничего не найдено");
            }
        } else {
            System.out.println("Неверное значение поиска");
            System.out.println();
            Logger.addRecord("Неверное значение поиска");
        }
    }
}

class ProgrammPaths {
    public static final File PROJECT_DIR = new File(System.getProperty("user.dir"));
    public static final File USERS_DIR = new File(PROJECT_DIR, "users");
    public static final File USERS_FILE = new File(USERS_DIR, "users.txt");
    public static final File CONTACTS_DIR = new File(PROJECT_DIR, "contacts");
    public static final File LOGS_DIR = new File(PROJECT_DIR, "logs");
    public static final File LOGS_FILE = new File(LOGS_DIR, "log.txt");

    public static void createOrCheckExistingFolders() {

        if (!ProgrammPaths.USERS_DIR.exists()) {
            System.out.println(ProgrammPaths.USERS_DIR.mkdir() ? "Папка пользователей создана" : "Папка пользователей не создана");
        }

        if (!ProgrammPaths.CONTACTS_DIR.exists()) {
            System.out.println(ProgrammPaths.CONTACTS_DIR.mkdir() ? "Папка контактов создана" : "Папка контактов не создана");
        }

        if (!ProgrammPaths.LOGS_DIR.exists()) {
            System.out.println(ProgrammPaths.LOGS_DIR.mkdir() ? "Папка логов создана" : "Папка логов не создана");

        }

        if (!ProgrammPaths.USERS_FILE.exists()) {
            try {
                ProgrammPaths.USERS_FILE.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка создания файла users.txt " + e.getMessage());
            }
        }

        if (!ProgrammPaths.LOGS_FILE.exists()) {
            try {
                ProgrammPaths.LOGS_FILE.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка создания файла log.txt " + e.getMessage());
            }
        }
    }
}

class SearchContact {
    public static int searchContactByName(List<Contact> userContactList, String name) {
        boolean isFound = false;
        int count = 0;
        Logger.addRecord("Поиск по имени: \"" + name + "\"");
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
        Logger.addRecord("Всего найдено контактов: " + count);
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
            Logger.addRecord("По заданным критериям ничего не найдено");
        }
        return count;
    }

    public static int searchContactBySurname(List<Contact> userContactList, String surname) {
        boolean isFound = false;
        int count = 0;
        Logger.addRecord("Поиск по фамилии: \"" + surname + "\"");
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
        Logger.addRecord("Всего найдено контактов: " + count);
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
            Logger.addRecord("По заданным критериям ничего не найдено");
        }
        return count;
    }

    public static int searchContactByPhone(List<Contact> userContactList, String phone) {
        boolean isFound = false;
        int count = 0;
        Logger.addRecord("Поиск по номеру телефона: \"" + phone + "\"");
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
        Logger.addRecord("Всего найдено контактов: " + count);
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
            Logger.addRecord("По заданным критериям ничего не найдено");
        }
        return count;
    }

    public static int searchContactByAge(List<Contact> userContactList, int age) {
        boolean isFound = false;
        int count = 0;
        Logger.addRecord("Поиск по возрасту: \"" + age + "\"");
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
        Logger.addRecord("Всего найдено контактов: " + count);
        if (!isFound) {
            System.out.println("По заданным критериям ничего не найдено");
            System.out.println();
            Logger.addRecord("По заданным критериям ничего не найдено");
        }
        return count;
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

class SortContact {
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
                Logger.addRecord("Сортировка по имени (A-Z) выполнена успешно");
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
                Logger.addRecord("Сортировка по имени (Z-A) выполнена успешно");
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
                Logger.addRecord("Сортировка по фамилии (A-Z) выполнена успешно");
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
                Logger.addRecord("Сортировка по фамилии (Z-A) выполнена успешно");
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
                Logger.addRecord("Сортировка по номеру (0-9) выполнена успешно");
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
                Logger.addRecord("Сортировка по номеру (9-0) выполнена успешно");
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
                Logger.addRecord("Сортировка по возрасту (0-9) выполнена успешно");
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
                Logger.addRecord("Сортировка по возрасту (9-0) выполнена успешно");
                break;
            }
            default: {
                System.out.println("Непредвиденная ошибка, попробуйте снова");
                System.out.println();
                Logger.addRecord("Непредвиденная ошибка, попробуйте снова");
            }
        }
    }
}

class UpdateContact {
    public static void updateContactByName(List<Contact> userContactList, String name) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByName(userContactList, name);
        if (contactCount == 1) {
            System.out.print("Введите новое имя: ");
            String newName = scanner.nextLine().trim();
            for (Contact contact : userContactList) {
                if (contact.getName().equals(name)) {
                    contact.setName(newName);
                }
            }
            System.out.println("Запись обновлена");
            Logger.addRecord("Запись успешно обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с именем \"" + name + "\"");
            Logger.addRecord("Найдено несколько записей с именем \"" + name + "\". Переход на удаление по id");
            try {
                System.out.print("Введите id для изменения имени: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новое имя: ");
                String newName = scanner.nextLine().trim();
                updateById(userContactList, contactId, 1, newName);
                System.out.println("Запись обновлена");
                Logger.addRecord("Запись успешно обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
                Logger.addRecord("Некорректное значение id");
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по имени \"" + name + "\"");
            Logger.addRecord("Не удалось изменить контакт: Контакт не найден по имени \"" + name + "\"");
        }

    }

    public static void updateContactBySurname(List<Contact> userContactList, String surname) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactBySurname(userContactList, surname);
        if (contactCount == 1) {
            System.out.print("Введите новую фамилию: ");
            String newSurname = scanner.nextLine().trim();
            for (Contact contact : userContactList) {
                if (contact.getSurname().equals(surname)) {
                    contact.setSurname(newSurname);
                }
            }
            System.out.println("Запись обновлена");
            Logger.addRecord("Запись успешно обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с фамилией \"" + surname + "\"");
            Logger.addRecord("Найдено несколько записей с фамилией \"" + surname + "\". Переход на удаление по id");
            try {
                System.out.print("Введите id для изменения фамилии: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новую фамилию: ");
                String newSurname = scanner.nextLine().trim();
                updateById(userContactList, contactId, 2, newSurname);
                System.out.println("Запись обновлена");
                Logger.addRecord("Запись успешно обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
                Logger.addRecord("Некорректное значение id");
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по фамилии");
            Logger.addRecord("Не удалось изменить контакт: Контакт не найден по фамилии");
        }
    }

    public static void updateContactByPhone(List<Contact> userContactList, String phone) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByPhone(userContactList, phone);
        if (contactCount == 1) {
            System.out.print("Введите новый номер телефона: ");
            String newPhone = scanner.nextLine().trim();
            for (Contact contact : userContactList) {
                if (contact.getPhone().equals(phone)) {
                    contact.setPhone(newPhone);
                }
            }
            System.out.println("Запись обновлена");
            Logger.addRecord("Запись успешно обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с номером \"" + phone + "\"");
            Logger.addRecord("Найдено несколько записей с номером \"" + phone + "\". Переход на удаление по id");
            try {
                System.out.print("Введите id для изменения номера телефона: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новый номер телефона: ");
                String newPhone = scanner.nextLine().trim();
                updateById(userContactList, contactId, 3, newPhone);
                System.out.println("Запись обновлена");
                Logger.addRecord("Запись успешно обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
                Logger.addRecord("Некорректное значение id");
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по номеру телефона");
            Logger.addRecord("Не удалось изменить контакт: Контакт не найден по номеру телефона");
        }
    }

    public static void updateContactByAge(List<Contact> userContactList, int age) {
        Scanner scanner = new Scanner(System.in);
        int contactCount = SearchContact.searchContactByAge(userContactList, age);
        if (contactCount == 1) {
            System.out.print("Введите новый возраст: ");
            int newAge = scanner.nextInt();
            for (Contact contact : userContactList) {
                if (contact.getAge() == age) {
                    contact.setAge(newAge);
                }
            }
            System.out.println("Запись обновлена");
            Logger.addRecord("Запись успешно обновлена");
        } else if (contactCount > 1) {
            System.out.println("Найдено несколько записей с возрастом \"" + age + "\"");
            Logger.addRecord("Найдено несколько записей с возрастом \"" + age + "\". Переход на удаление по id");
            try {
                System.out.print("Введите id для изменения возраста: ");
                int contactId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите новый возраст: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                updateById(userContactList, contactId, 4, String.valueOf(newAge));
                System.out.println("Запись обновлена");
                Logger.addRecord("Запись успешно обновлена");
            } catch (InputMismatchException e) {
                System.out.println("Некорректное значение id");
                System.out.println();
                scanner.nextLine();
                Logger.addRecord("Некорректное значение id");
            }
        } else {
            System.out.println("Не удалось изменить контакт: Контакт не найден по возрасту");
            Logger.addRecord("Не удалось изменить контакт: Контакт не найден по возрасту");
        }
    }

    public static void updateById(List<Contact> userContactList, int id, int updateFieldNumber, String newValue) {
        if (updateFieldNumber == 1) {
            for (Contact contact : userContactList) {
                if (contact.getId() == id) {
                    contact.setName(newValue);
                }
            }
            return;
        }
        if (updateFieldNumber == 2) {
            for (Contact contact : userContactList) {
                if (contact.getId() == id) {
                    contact.setSurname(newValue);
                }
            }
            return;
        }
        if (updateFieldNumber == 3) {
            for (Contact contact : userContactList) {
                if (contact.getId() == id) {
                    contact.setPhone(newValue);
                }
            }
            return;
        }
        if (updateFieldNumber == 4) {
            try {
                for (Contact contact : userContactList) {
                    if (contact.getId() == id) {
                        contact.setAge(Integer.parseInt(newValue));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Некорректное значение возраста");
                Logger.addRecord("Ошибка. Некорректное значение возраста");
            }
        }
    }
}