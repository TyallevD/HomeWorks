package JavaBasic.HomeWork18;

import java.util.Random;
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
* */
        System.out.println("Начинаем игру");
        template();

        //выбрал вариант с одномерным массивом для реализации заданий
        char[] field = new char[9];
        gameTableStart(field);

        //Добавил возможность выбора варианта игры, с игроком (задание 1) или с компьютером (задание2)
        System.out.print("Выбор режима игры. Хотите играть с игроком (1) или компьютером (2)? :");
        int answer = new Scanner(System.in).nextInt();

        if (answer == 1) { //выбираем игру с игроком
            while (!isXWin(field) || !isOWin(field) || !isDraw(field)) {
                xTurn(field);
                gameTable(field);
                if (isXWin(field) || isDraw(field)) {
                    break;
                }

                oTurn(field);
                gameTable(field);
                if (isOWin(field) || isDraw(field)) {
                    break;
                }
            }
        }

        //2. Человек против компьютера
        //Реализуйте логику игрового поля так же, как в первом варианте.
        //Добавьте возможность игры против компьютера:
        //Игрок делает ход первым (за X).
        //После хода игрока компьютер выбирает случайную свободную клетку для своего хода (за O).
        //После каждого хода:
        //Проверяйте условия победы.
        //Если поле заполнено, игра заканчивается ничьей.
        //Убедитесь, что компьютер не делает ход в занятую клетку.

        else if (answer == 2) { //выбираем игру с компьютером
            while (!isXWin(field) || !isComputerWin(field) || !isDraw(field)) {
                xTurn(field);
                gameTable(field);
                if (isXWin(field) || isDraw(field)) {
                    break;
                }

                computerTurn(field);
                gameTable(field);
                if (isComputerWin(field) || isDraw(field)) {
                    break;
                }
            }
        }
        System.out.println("Игра завершена");
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
            if (index <= 0 || index > field.length) {
                System.out.println("Вы вышли за пределы поля");
            } else if (field[index - 1] != ' ') {
                System.out.println("Ячейка занята, попробуйте снова");
            } else {
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
            if (index <= 0 || index > field.length) {
                System.out.println("Вы вышли за пределы поля");
            } else if (field[index - 1] != ' ') {
                System.out.println("Ячейка занята, попробуйте снова");
            } else {
                field[index - 1] = 'o';
                break;
            }
        }
        return field;
    }

    public static boolean isXWin(char[] field) {
        //Строки
        for (int i = 0; i < 7; i += 3) {
            if (field[i] == field[i + 1] && field[i] == field[i + 2] && field[i] == 'x') {
                System.out.println("Игрок X побеждает!");
                return true;
            }
        }
        //Столбцы
        for (int i = 0; i < 3; i++) {
            if (field[i] == field[i + 3] && field[i] == field[i + 6] && field[i] == 'x') {
                System.out.println("Игрок X побеждает!");
                return true;
            }
        }

        //Диагонали
        if (field[0] == field[4] && field[0] == field[8] && field[0] == 'x') {
            System.out.println("Игрок X побеждает!");
            return true;
        }
        if (field[2] == field[4] && field[2] == field[6] && field[2] == 'x') {
            System.out.println("Игрок X побеждает!");
            return true;
        }
        return false;
    }

    public static boolean isOWin(char[] field) {
        //Строки
        for (int i = 0; i < 7; i += 3) {
            if (field[i] == field[i + 1] && field[i] == field[i + 2] && field[i] == 'o') {
                System.out.println("Игрок O побеждает!");
                return true;
            }
        }
        //Столбцы
        for (int i = 0; i < 3; i++) {
            if (field[i] == field[i + 3] && field[i] == field[i + 6] && field[i] == 'o') {
                System.out.println("Игрок O побеждает!");
                return true;
            }
        }

        //Диагонали
        if (field[0] == field[4] && field[0] == field[8] && field[0] == 'o') {
            System.out.println("Игрок O побеждает!");
            return true;
        }
        if (field[2] == field[4] && field[2] == field[6] && field[2] == 'o') {
            System.out.println("Игрок O побеждает!");
            return true;
        }
        return false;
    }

    public static boolean isDraw(char[] field) {
        for (int i = 0; i < 9; i++) {
            if (field[i] == ' ') {
                return false;
            }
        }
        System.out.println("Ничья!");
        return true;
    }

    public static void computerTurn(char[] field) {
        Random random = new Random();
        while (true) {
            int fieldPlace = random.nextInt(9);
            if (field[fieldPlace] == ' ') {
                field[fieldPlace] = 'o';
                return;
            }
        }
    }

    public static boolean isComputerWin(char[] field) {
        //Строки
        for (int i = 0; i < 7; i += 3) {
            if (field[i] == field[i + 1] && field[i] == field[i + 2] && field[i] == 'o') {
                System.out.println("Игрок O побеждает!");
                return true;
            }
        }
        //Столбцы
        for (int i = 0; i < 3; i++) {
            if (field[i] == field[i + 3] && field[i] == field[i + 6] && field[i] == 'o') {
                System.out.println("Игрок O побеждает!");
                return true;
            }
        }

        //Диагонали
        if (field[0] == field[4] && field[0] == field[8] && field[0] == 'o') {
            System.out.println("Игрок O побеждает!");
            return true;
        }
        if (field[2] == field[4] && field[2] == field[6] && field[2] == 'o') {
            System.out.println("Игрок O побеждает!");
            return true;
        }
        return false;
    }
}
