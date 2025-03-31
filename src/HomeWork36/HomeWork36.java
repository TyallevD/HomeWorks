package HomeWork36;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HomeWork36 {
    public static void main(String[] args) {
        //Старт : 22.03.2025
        //Финиш : 11.04.2025 (20 дней)
        //
        //
        // -----------------------------------
        //|                                  |
        //|                                  |
        //|        1   -   Sign in           |
        //|                                  |
        //|        2   -   Sign up           |
        //|                                  |
        //|        3   -   Exit              |
        //|                                  |
        //|                                  |
        // -----------------------------------
        //
        //
        //
        //📄 Техническое задание
        //Название проекта: Консольное приложение "Телефонная книга"
        //Язык реализации: Java
        //Формат взаимодействия: Консоль
        //🎯 Цель проекта
        //Разработать консольное Java-приложение для управления телефонной книгой.
        //Пользователь должен иметь возможность создавать, редактировать, удалять и просматривать контакты,
        // а также сохранять и загружать данные из файла.
        //
        //
        //🧩 Функциональные требования
        //1. CRUD-операции для контактов:
        //C (Create) – Добавление нового контакта
        //R (Read) – Просмотр списка всех контактов
        //U (Update) – Редактирование существующего контакта
        //D (Delete) – Удаление контакта по ID или имени
        //
        //2. Структура контакта:
        //Каждый контакт должен содержать:
        //
        //Уникальный ID (генерируется автоматически)
        //Имя
        //Фамилия
        //Номер телефона
        //Возраст
        //
        //3. Хранение данных:
        //Контакты должны сохраняться в файл (contacts.txt)
        //Реализовать чтение данных из файла при запуске
        //Реализовать запись данных в файл после изменений
        //
        //
        //4. Поиск и фильтрация:
        //Поиск по имени, фамилии, номеру телефона
        //
        //
        //_ -> 1 символ
        //% -> 0 или N количество символов
        //
        //Иван -> Иван Иванов
        //Ива -> Ива
        //Ива_ -> Иван Иванов , Ивар Иванов ,  Иваг Иванов
        //__рид -> Фарид , Дарид , Гарид
        //Ива% -> Иванфывап Иванов , Ивар Иванов ,  Иваг Иванов , Ива
        //
        //Поддержка частичного совпадения
        //
        //ВА - Нармина Махмудова , Фарид вараев
        //
        //
        //
        //5. Сортировка:
        //Возможность отсортировать контакты:
        //
        //По имени (A-Z, Z-A)
        //По фамилии
        //По номеру телефона
        //
        //6. Удобный CLI-интерфейс:
        //Меню с выбором опций
        //
        //1 - Контакты  (1 - Добавить 2 - Удалить 3 - Редактировать 4 - Отобразить)   1) Фарид Абдуллаев 29 +994519999902
        //2 - Поиск     (0 - Регистр OFF 1 - По имени 2 - По фамилии , 3 - По номеру , 4 - По всем параметрам , 5 - Спец поиск (_ , %))
        //3 - Фильтрация (1 - только мужчины 2 только женщины , 3 возраст больше n, 4 возраст меньше n )
        //4 - Сортировка
        //5 - Logger
        //6 - Back
        //
        //(1 -По ид  2 - по номеру 3 - по нумбер)
        //Подтверждение удаления
        //
        //Обработка ошибок (например, некорректный номер телефона, несуществующий ID и т.д.)
        //
        //
        //📦 Нефункциональные требования
        //Читаемый и структурированный код (рекомендуется использовать классы: PhoneBook, Contact, FileManager)
        //
        //Соблюдение принципов ООП
        //
        //
        //💡 Дополнительные (опциональные) фичи:
        //Поддержка нескольких номеров у одного контакта
        //
        //Логирование действий (файл logger.txt)
        //22.03.2025 15:02 Farid сделал вход
        //22.03.2025 15:03 Farid удалил контакт Фарид Абдуллаев 29 +994519999902
        //22.03.2025 15:05 Farid добавил контакт Дима Абдуллаев 29 +994519999902
        //22.03.2025 15:05 Farid сделал сортировку контакт Дима Абдуллаев 29 +994519999902
        //
        //
        //
        //1 - Sign In
        //  Enter username : Fayev
        //  Enter passowrd : Baku29
        //
        //
        //2 - Sign Up
        //  Enter name           : Farid
        //  Enter surnema        : Abdullayev
        //  Enter username       : f-abdullayev  (UNIQUE)
        //  Enter passowrd       : Baku29
        //  Enter repead passowrd: Baku29
        //
        //  Check password and repead
        //
        //  username : Fayev
        //
        //3 - Print logger
        //
        //4 - Exit
        //
        //
        //contacts/FayevContacts.txt
        //contacts/f-abdullayevContacts.txt
        //
        //
        //class User
        //class Contact
        //
        //
        //1) users.txt ( список всех юзеров )
        //2) username.txt ( у каждого юзера свой файл контаков)
        //3) logger.txt ( 1 общий для всех юзеров)
        //
        //
        //// FileManager (fileManger , filemanger,FILEMANGER)
        //// email_address
        //// fullName
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
                    System.out.println("тут должно быть изменение");
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
                    System.out.println(2);
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
            Login login = new Login(name, surname, Login.generateLogin(name, surname), passwd1); //todo добавить проверок для логина/пароля ?
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
    //При авторизации подгружаем из файла контактов юзера все контакты в лист
    //Потом редактирование, просмотр, поиск и сортировку делаем через лист (так проще, чем каждый раз загружать файл)
}