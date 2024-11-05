public class HomeWork4 {
    public static void main(String[] args) {
        //Задача 1: Месяц и количество дней
        //Напишите программу, которая принимает номер месяца (от 1 до 12) и выводит количество дней в этом месяце.
        // Учитывайте, что февраль может иметь 28 или 29 дней (не обязательно учитывать високосные годы для
        // этой задачи). Если введённое число не в диапазоне от 1 до 12, программа должна вывести сообщение об ошибке.
        System.out.println("Задание 1. Вывод:");
        int month = 2;
        switch (month) {
            case 1 -> System.out.println("В январе 31 день");
            case 2 -> System.out.println("В феврале 28 или 29 дней");
            case 3 -> System.out.println("В марте 31 день");
            case 4 -> System.out.println("В апреле 30 дней");
            case 5 -> System.out.println("В мае 31 день");
            case 6 -> System.out.println("В июне 30 дней");
            case 7 -> System.out.println("В июле 31 день");
            case 8 -> System.out.println("В августе 31 день");
            case 9 -> System.out.println("В сентябре 30");
            case 10 -> System.out.println("В октябре 31 день");
            case 11 -> System.out.println("В ноябре 30 дней");
            case 12 -> System.out.println("В декабре 31 день");
            default -> System.out.println("Ошибка: такого месяца не существует");
        }
        System.out.println();
        //Задача 2: Перевод чисел в слова
        //Напишите программу, которая принимает число от 0 до 9 и выводит его текстовое представление
        // (например, 1 — "Один", 2 — "Два", и так далее до 9 — "Девять").
        // Если введено число вне диапазона от 0 до 9, программа должна вывести сообщение об ошибке.
        System.out.println("Задание 2. Вывод:");
        int number = 9;
        String converter = switch (number) {
            case 0 -> "Ноль";
            case 1 -> "Один";
            case 2 -> "Два";
            case 3 -> "Три";
            case 4 -> "Четыре";
            case 5 -> "Пять";
            case 6 -> "Шесть";
            case 7 -> "Семь";
            case 8 -> "Восемь";
            case 9 -> "Девять";
            default -> "Ошибка. Введите цифру от 0 до 9";
        };
        System.out.println(number + " => " + converter);
        System.out.println();
        //Задача 3: Калькулятор для целых чисел
        //Создайте программу, которая принимает два целых числа и оператор (+, -, *, /, %).
        //В зависимости от введённого оператора программа должна выполнять соответствующую операцию над двумя числами.
        //Если оператор неизвестен или деление на ноль, программа должна вывести сообщение об ошибке.
        System.out.println("Задание 3. Вывод:");
        int a = 5;
        int b = 2;
        char c = '/';
        int result;
        switch (c) {
            case '*':
                result = a * b;
                System.out.println(a + " * " + b + " = " + result);
                break;
            case '+':
                result = a + b;
                System.out.println(a + " + " + b + " = " + result);
                break;
            case '-':
                result = a - b;
                System.out.println(a + " - " + b + " = " + result);
                break;
            case '/':
                switch (b) {
                    case 0:
                        System.out.println("Делить на ноль нельзя!");
                        break;
                    default:
                        result = a / b;
                        System.out.println(a + " / " + b + " = " + result);
                }
                break;
            case '%':
                result = a % b;
                System.out.println(a + " % " + b + " = " + result);
                break;
            default:
                System.out.println("Ошибка: Неизвестная операция");
        }
        System.out.println();
        //Задача 4: Определение части суток
        //Напишите программу, которая принимает час в 24-часовом формате (от 0 до 23) и выводит часть суток, к которой относится это время:
        //
        //0-5: Ночь
        //6-11: Утро
        //12-17: День
        //18-23: Вечер
        //Если введённое число не в диапазоне от 0 до 23, программа должна вывести сообщение об ошибке.
        System.out.println("Задание 4. Вывод:");
        int dayTime = 4;
        switch (dayTime) {
            case 0, 1, 2, 3, 4, 5:
                System.out.println("Ночь");
                break;
            case 6, 7, 8, 9, 10, 11:
                System.out.println("Утро");
                break;
            case 12, 13, 14, 15, 16, 17:
                System.out.println("День");
                break;
            case 18, 19, 20, 21, 22, 23:
                System.out.println("Вечер");
                break;
            default:
                System.out.println("Ошибка: Неверно задано время");
        }
        System.out.println();
        //Задача 5: Определение типа фигуры
        //Напишите программу, которая принимает число от 3 до 6 и выводит название соответствующей геометрической фигуры:
        //
        //3 — Треугольник
        //4 — Четырёхугольник
        //5 — Пятиугольник
        //6 — Шестиугольник
        //Если введённое число не в диапазоне от 3 до 6, программа должна вывести сообщение об ошибке
        System.out.println("Задание 5. Вывод:");
        int figure = 3;
        String answer = switch (figure) {
            case 3 -> "Треугольник";
            case 4 -> "Четырёхугольник";
            case 5 -> "Пятиугольник";
            case 6 -> "Шестиугольник";
            default -> "Ошибка: Нельзя вывести такую фигуру";
        };
        System.out.println(answer);
    }
}
