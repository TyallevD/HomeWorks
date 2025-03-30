package HomeWork36;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
                    //
                    String userContactFile = authorization();
                    if (userContactFile != null) {
                        mainMenu(userContactFile);
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

    public static void mainMenu(String userContactFile) {
        Scanner scanner = new Scanner(System.in);
        mainMenu:
        while (true) {
            System.out.print("""
                    ------------------------------------
                    |      << Телефонная книга >>      |
                    |           Главное меню           |
                    ------------------------------------
                    |   1 - изменить контакты          |
                    |   2 - просмотреть контакты       |
                    |   3 - выход из аккаунта          |
                    ------------------------------------
                    """);
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    contactsChangeMenu(userContactFile);
                    break;
                }
                case "2": {
                    contactsViewMenu(userContactFile);
                    break;
                }
                case "3": {
                    System.out.println("""
                            ------------------------------------
                            |    Выход на экран авторизации    |
                            ------------------------------------""");
                    System.out.println();
                    userContactFile = null;
                    break mainMenu;
                }
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    public static void contactsChangeMenu(String userContactFile) {
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
                    //todo доделать добавление контакта
                    ContactFileManager.addContact(userContactFile,ContactFileManager.createContact(userContactFile));
                    break;
                }
                case "2": {
                    //todo сделать изменение контакта
                    System.out.println("тут должно быть изменение");
                    break;
                }
                case "3": {
                    //todo сделать удаление контакта
                    System.out.println("тут должно быть удаление");
                    break;
                }
                case "4": {
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

    public static void contactsViewMenu(String userContactFile) {
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
                    |   3 - выход в главное меню       |
                    ------------------------------------""");
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    ContactFileManager.viewAllContacts(userContactFile);
                    break;
                }
                case "2": {
                    //todo сделать поиск контактов (возможно ещё одно меню с разными вариантами)
                    System.out.println(2);
                    break;
                }
                case "3": {
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

    public static void registration() {
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
//вариант с файлом
//    private static String authorization() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите логин: ");
//        String login = scanner.nextLine();
//        System.out.print("Введите пароль: ");
//        String password = scanner.nextLine();
//
//        File usersFile = ProgrammPaths.USERS_FILE;
//        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(" ");
//                if (parts.length == 4 && parts[2].equals(login) && parts[3].equals(password)) {
//                    System.out.println("Вы авторизованы");
//                    return ProgrammPaths.CONTACTS_DIR + "/" + login.concat("Contacts.txt");
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла пользователей: " + e.getMessage());
//        }
//        System.out.println("Неверный логин или пароль");
//        return null;
//    }

    //вариант с листом
    private static String authorization() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        File usersFile = ProgrammPaths.USERS_FILE;
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4 && parts[2].equals(login) && parts[3].equals(password)) {
                    System.out.println("Вы авторизованы");
                    return ProgrammPaths.CONTACTS_DIR + "/" + login.concat("Contacts.txt");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла пользователей: " + e.getMessage());
        }
        System.out.println("Неверный логин или пароль");
        return null;
    }
    //При авторизации подгружаем из файла контактов юзера все контакты в лист
    //Потом редактирование, просмотр, поиск и сортировку делаем через лист (так проще, чем каждый раз загружать файл)
}