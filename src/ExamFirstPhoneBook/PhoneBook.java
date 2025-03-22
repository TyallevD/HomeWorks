package ExamFirstPhoneBook;

import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        //1 вход в систему
        //меню входа,
        Scanner scanner = new Scanner(System.in);
        startMenu:
        while (true) {
            System.out.print("""
                    ------------------------------
                    |   << Телефонная книга >>   |
                    |      добро пожаловать      |
                    ------------------------------
                    |   1 - вход                 |
                    |   2 - регистрация          |
                    |   3 - выход                |
                    ------------------------------
                    """);
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Введите логин: ");
                    String login = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();
                    //проверяем, есть ли логин и совпадает ли пароль, если да - идём дальше, если нет - ввод заново, получается
                    System.out.println("Ваш логин \"" + login + "\" Ваш пароль \"" + password + "\"");
                    mainMenu();
                    break;
                case "2":
                    System.out.println("Регистрация крч");
                    break;
                case "3":
                    System.out.println("Выход из программы");
                    break startMenu;
                default:
                    System.out.println("Ваш ввод неверный, попробуйте снова");
                    break;
            }
        }
        //2 меню программы в другом классе, пожалуй
        //3 логирование
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        mainMenu:
        while (true) {
            System.out.print("""
                    ------------------------------
                    |   << Телефонная книга >>   |
                    |      главное меню:         |
                    ------------------------------
                    |   1 - добавить             |
                    |   2 - удалить              |
                    |   3 - распечатать          |
                    |   4 - изменить             |
                    |   5 - выход в главное меню |
                    ------------------------------
                    """);
            System.out.print("Ввод команды: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.println(1);
                    break;
                }
                case "2": {
                    System.out.println(2);
                    break;
                }
                case "3": {
                    System.out.println(3);
                    break;
                }
                case "4": {
                    System.out.println(4);
                    break;
                }
                case "5": {
                    System.out.println("Выход в главное меню");
                    break mainMenu;
                }
                default:
                    System.out.println("Вы ввели какую-то чушь");
            }
        }
    }
}
