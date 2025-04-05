package HomeWork36;

import java.io.IOException;
import java.util.Scanner;

public class Authorization {
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
            Login login = new Login(name, surname, Login.generateLogin(name, surname), passwd1); //todo добавить проверок для логина/пароля ?
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
                    |       Пароли не совпадают.       |
                    |         Попробуйте снова         |
                    ------------------------------------""");
            System.out.println();
        }
    }

    public static void authorization() {
        Login user;
        Session currentSession;
        //todo раскомментировать и удалить тестовые данные
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine().trim();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();
//        //тестовые данные
//        String login = "Ди-Тяллев";
//        String password = "123";
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
            Logger.addRecord("Неудачная авторизация, неверный логин/пароль или пользователь не существует");
        }
    }
}
