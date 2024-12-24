import java.util.Scanner;

public class HomeWork18 {
    public static void main(String[] args) {
/* Задание: Реализация игры "Крестики-нолики"

Цель: Создать программу на языке программирования Java для игры в "Крестики-нолики" с использованием статического массива, циклов и условных операторов (if), методов и т.д.
 Игра должна быть оформлена в консоли с красивым выводом игрового поля.

Требования и условия:

1. Человек против человека
Создайте игровое поле в виде статического двумерного массива размером 3x3, либо использовать одномерный массив на 9 элементов.
Каждый ход игрока:
Выводите текущее состояние игрового поля.
Запрашивайте у пользователя координаты для хода (номер строки и столбца) (в одномерном массиве номер квадратика).
Проверьте корректность хода:
Если ячейка занята, запросите ввод заново.
Если координаты вне игрового поля, запросите ввод заново.
Определите условия победы:
Проверка наличия трех одинаковых символов (X или O) по строкам, столбцам или диагоналям.
Если никто не победил, а поле заполнено, игра заканчивается ничьей.
Оформите вывод в консоли так, чтобы игровое поле отображалось красиво.

Общие требования:
Для хранения игрового поля используйте статический массив размером 3x3.
Логику ходов реализуйте с помощью циклов и условных операторов (if).
Красиво оформите консольный вывод:
Игровое поле должно быть наглядным и обновляться после каждого хода.
Например:
markdown


Отображение в случаи двумерного массива
    0   1   2

 0  1 | X | O
    ---------
 1  O | X |
    ---------
 2    |   | X
Программа должна проверять ввод пользователя на корректность (например, не позволять ставить символ в занятую клетку или вводить некорректные координаты).


 Отображение в случаи одномерного массива
1 | 2 | 3
---------
4 | 5 | 6
---------
7 | 8 | 9
Программа должна проверять ввод пользователя на корректность (например, не позволять ставить символ в занятую клетку или вводить некорректные координаты).

        Распишем реализацию:
        1) нужно создать поле для отображения справки (отдельный метод)
        2) создать поле для отображения результата действий игроков (отдельный метод)
        3) создать запрос хода с вводом данных (проверка на корректность символов и вместимости массива)
        4) создать проверку на ввод в уже заполненное поле (нужно запросить заново ввод)
        5) создать проверку на победу первого или второго игрока
        * */
        System.out.println("Начинаем игру");
        template();
        char[] field = new char[9];
        gameTableStart(field);

        //ход первого игрока
        //отображение результата действий игрока
        while (!isXWin(field) || !isOWin(field)) {
            xTurn(field);
            gameTable(field);
            if (isXWin(field)) {
                break;
            }

            oTurn(field);
            gameTable(field);
            if (isOWin(field)) {
                break;
            }
        }
        //проверка на победу
        //ход второго игрока
        //отображение результата действий игрока
        //проверка на победу
    }

    public static void template() {
        System.out.println("Справочная информация:");
        for (int i = 1; i <= 9; i += 3) {
            System.out.print(" " + i + " | " + (i + 1) + " | " + (i + 2));
            System.out.println();
            if (i <= 5) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    public static void gameTableStart(char[] field) {
        System.out.println("Стартовое состояние игрового поля:");
        for (int i = 0; i < field.length; i++) {
            field[i] = ' ';
        }
        for (int i = 0; i < field.length; i += 3) {
            System.out.println(" " + field[i] + " | " + field[i + 1] + " | " + field[i + 2]);
            if (i <= 5) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    public static void gameTable(char[] field) {
        System.out.println("Текущее состояние игрового поля:");
        for (int i = 0; i < field.length; i += 3) {
            System.out.println(" " + field[i] + " | " + field[i + 1] + " | " + field[i + 2]);
            if (i <= 5) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    public static char[] xTurn(char[] field) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ходит игрок Х. Введите номер ячейки: ");
            int index = scanner.nextInt();
            if (index <= 0 || index > field.length || field[index - 1] != ' ') { //todo доделать корректно проверку на заполнение поля. Разделить проверку на выход из поля и на заполнение
                System.out.println("Вы вышли за пределы поля");
            }
//            if (field[index - 1] != '-') {
//                System.out.println("Ячейка занята, попробуйте снова");
//            }
            else {
                field[index - 1] = 'x';
                break;
            }
        }
        return field;
    }

    public static char[] oTurn(char[] field) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ходит игрок O. Введите номер ячейки: ");
            int index = scanner.nextInt();
            if (index <= 0 || index > field.length || field[index - 1] != ' ') {
                System.out.println("Вы вышли за пределы поля");
            }
//            if (field[index - 1] != '-') {
//                System.out.println("Ячейка занята, попробуйте снова");
//            }
            else {
                field[index - 1] = 'o';
                break;
            }
        }
        return field;
    }
    //TODO додумать проверку на победу и написать проверку на ничью
    public static boolean isXWin(char[] field) {
        for (int i = 0; i < 7; i += 3) {
            if (field[i] == field[i + 1] && field[i] == field[i + 2] && field[i] == 'x') {
                System.out.println("Игрок Х побеждает!");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i] == field[i + 4] && field[i] == field[i + 6] && field[i] == 'x') {
                System.out.println("Игрок Х побеждает!");
                return true;
            }
        }
//        for (int i = 0; i <= 3; i += 3) {
//            if (field[i] == field[4] && field[i] == field[field.length - i] && field[i] == 'x') {
//                System.out.println("Игрок Х побеждает!");
//                return true;
//            }
//        }
        return false;
    }

    public static boolean isOWin(char[] field) {

        return false;
    }
}
