package HomeWork33;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//интерфейс для задания 1
interface Summable {
    int sum(int a, int b);
}

//интерфейс для задания 2
interface Empty {
    boolean isEmpty(String string);
}

//интерфейс для задания 3
interface Length {
    int stringLength(String string);
}

//интерфейс для задания 4
interface Maximum {
    int max(int a, int b);
}

//интерфейс для задания 5
interface IsEven {
    boolean isEven(int a);
}

//интерфейс для задания 6
interface Pow {
    int pow(int a);
}

//интерфейс для задания 7
interface ToConsole {
    void toConsole(String s);
}

//интерфейс для задания 8
interface ToUpperCase {
    void toUpperCase(String s);
}

//интерфейс для задания 9
interface ContainsString {
    boolean containsString(String s1, String s2);
}

//интерфейс для задания 10
interface StringToInt {
    int stringToInt(String s);
}

//интерфейс для задания 11
interface Multiply {
    int miltiply(int a, int b);
}

//интерфейс для задания 12
interface IsPositive {
    boolean isPositive(int a);
}

//интерфейс для задания 13
interface ListIsEven {
    boolean listIsEven(Integer a);
}

//интерфейс для задания 14
interface MaxListValue {
    Integer maxValue(List<Integer> nums);
}

//интерфейс для задания 15
interface SortedStringList {
    List<String> sortedStringList(List<String> names);
}

//интерфейс для задания 16
interface TrimString {
    String trimmedString(String string);
}

//интерфейс для задания 17
interface ListAppender {
    List<String> appendedList(List<String> list1, List<String> list2);
}

//интерфейс для задания 18
interface UpperCaseFirstChar {
    String upperCased(String string);
}

//интерфейс для задания 19
interface DateDiff {
    int dateDiff(LocalDate d1, LocalDate d2);
}

//интерфейс для задания 20
interface StringIsNum {
    boolean stringIsNum(String string);
}

public class HomeWork33 {
    public static void main(String[] args) {
        //1) Напишите лямбда-выражение, которое принимает два целых числа и возвращает их сумму.
        System.out.println("Задание 1. Вывод:");
        Summable sum = (x, y) -> x + y;
        int a1 = 10;
        int b1 = 20;
        System.out.println("Сумма: \"" + a1 + "\" и \"" + b1 + "\" равна: " + sum.sum(a1, b1));
        System.out.println();

        //2) Создайте лямбда-выражение, которое проверяет, является ли строка пустой.
        System.out.println("Задание 2. Вывод:");
        Empty string2 = s2 -> s2.isEmpty();
        System.out.println("Строка пуста? Ответ: " + (string2.isEmpty("") ? "Да" : "Нет"));
        System.out.println("Строка пуста? Ответ: " + (string2.isEmpty("Dima") ? "Да" : "Нет"));
        System.out.println();

        //3) Напишите лямбда-выражение, которое принимает строку и возвращает её длину.
        System.out.println("Задание 3. Вывод:");
        Length string3 = s3 -> s3.length();
        System.out.println("Длина строки равна: " + string3.stringLength("HomeWork33"));
        System.out.println("Проверяем: " + "HomeWork33".length());
        System.out.println();

        //4) Создайте лямбда-выражение, которое возвращает максимальное из двух чисел.
        System.out.println("Задание 4. Вывод:");
        Maximum max4 = (x, y) -> (x > y) ? x : y;
        int a4 = 14;
        int b4 = 32;
        System.out.println("Максимальное число: " + max4.max(a4, b4));
        System.out.println();

        //5) Напишите лямбда-выражение для проверки, является ли число четным.
        System.out.println("Задание 5. Вывод:");
        IsEven isEven = x -> x % 2 == 0;
        int a5 = 3;
        int b5 = 6;
        System.out.println("Число \"" + a5 + "\" четное? Ответ: " + (isEven.isEven(a5) ? "Да" : "Нет"));
        System.out.println("Число \"" + b5 + "\" четное? Ответ: " + (isEven.isEven(b5) ? "Да" : "Нет"));
        System.out.println();

        //6) Напишите лямбда-выражение, которое возводит число в квадрат.
        System.out.println("Задание 6. Вывод:");
        Pow num6 = x6 -> (int) Math.pow(x6, 2);
        int a6 = 4;
        System.out.println("Квадрат числа \"" + a6 + "\" равен " + num6.pow(a6));
        System.out.println();

        //7) Создайте лямбда-выражение, которое выводит на экран строку.
        System.out.println("Задание 7. Вывод:");
        ToConsole string7 = (s -> System.out.println(s));
        string7.toConsole("Эта строка выводится на консоль");
        System.out.println();

        //8) Напишите лямбда-выражение, которое принимает строку и возвращает её в верхнем регистре.
        System.out.println("Задание 8. Вывод:");
        ToUpperCase string8 = s -> System.out.println(s.toUpperCase());
        string8.toUpperCase("строка выводится в верхнем регистре");
        System.out.println();

        //9) Напишите лямбда-выражение, которое проверяет, содержит ли строка подстроку.
        System.out.println("Задание 9. Вывод:");
        ContainsString string9 = (string9_1, string9_2) -> string9_1.contains(string9_2);
        String s9_1 = "Адмирал";
        String s9_2 = "мир";
        String s9_3 = "пир";
        System.out.println("Строка \"" + s9_1 + "\" содержит подстроку \"" + s9_2 + "\"? Ответ: " + (string9.containsString(s9_1, s9_2) ? "Да" : "Нет"));
        System.out.println("Строка \"" + s9_1 + "\" содержит подстроку \"" + s9_3 + "\"? Ответ: " + (string9.containsString(s9_1, s9_3) ? "Да" : "Нет"));
        System.out.println();

        //10) Напишите лямбда-выражение, которое преобразует строку в число.
        System.out.println("Задание 10. Вывод:");
        StringToInt string10 = s -> Integer.parseInt(s);
        String string10_1 = "1234";
        String string10_2 = "4321";
        int a10 = string10.stringToInt(string10_1);
        int b10 = string10.stringToInt(string10_2);
        System.out.println("Для проверки сложим сконвертированные строки: " + (a10 + b10));
        System.out.println();

        //11) Создайте лямбда-выражение, которое умножает два числа и возвращает результат.
        System.out.println("Задание 11. Вывод:");
        Multiply multiply = (x, y) -> x * y;
        int a11 = 10;
        int b11 = 3;
        System.out.println("Произведение \"" + a11 + "\" и \"" + b11 + "\" равно: " + multiply.miltiply(a11, b11));
        System.out.println();

        //12) Напишите лямбда-выражение, которое проверяет, является ли число положительным.
        System.out.println("Задание 12. Вывод:");
        IsPositive num12 = a -> a > 0;
        int a12 = 15;
        int b12 = -14;
        System.out.println("Число \"" + a12 + "\" положительное? Ответ: " + (num12.isPositive(a12) ? "Да" : "Нет"));
        System.out.println("Число \"" + b12 + "\" положительное? Ответ: " + (num12.isPositive(b12) ? "Да" : "Нет"));
        System.out.println();

        //13) Напишите лямбда-выражение для фильтрации всех чётных чисел из списка.
        System.out.println("Задание 13. Вывод:");
        ListIsEven numIsEven = n -> n % 2 == 0;
        List<Integer> nums13 = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Исходный список: " + nums13);
        List<Integer> evenList = new ArrayList<>();

        for (Integer num : nums13) {
            if (numIsEven.listIsEven(num)) {
                evenList.add(num);
            }
        }
        System.out.println("Список четных чисел: " + evenList);
        System.out.println();

        //14) Напишите лямбда-выражение, которое находит наибольший элемент в списке чисел.
        System.out.println("Задание 14. Вывод:");
        MaxListValue findMax = nums -> {
            Integer max = nums.get(0);
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        };
        List<Integer> nums14 = List.of(3, 2, 1, 5, 7, 0, 2);
        System.out.println("Вывод списка: " + nums14);
        System.out.println("Максимальное значение в списке: " + findMax.maxValue(nums14));
        System.out.println();

        //15) Напишите лямбда-выражение, которое сортирует список строк по длине.
        System.out.println("Задание 15. Вывод:");
        List<String> strings15 = new ArrayList<>();
        strings15.add("Dmitry");
        strings15.add("Ksenya");
        strings15.add("Mikhail");
        strings15.add("Robert");
        strings15.add("Konstantin");
        System.out.println("Список имен: " + strings15);
        SortedStringList sortedStringList = strings -> {
            List<String> sortedList = new ArrayList<>(strings);
            sortedList.sort((s1, s2) -> s1.compareTo(s2));
            return sortedList;
        };
        List<String> sortedStrings = sortedStringList.sortedStringList(strings15);
        System.out.println("Отсортированный список имен: " + sortedStrings);
        System.out.println();

        //16) Создайте лямбда-выражение, которое возвращает строку без пробелов в начале и в конце.
        System.out.println("Задание 16. Вывод:");
        TrimString trimString = string -> string.trim();
        String string16 = "    строку нужно подрезать     ";
        System.out.println("Изначальная строка: " + string16);

        System.out.println("Измененная строка: " + trimString.trimmedString(string16));
        System.out.println();

        //17) Напишите лямбда-выражение, которое объединяет два списка в один.
        System.out.println("Задание 17. Вывод:");
        List<String> strings17_1 = List.of("Один", "Два", "Три");
        List<String> strings17_2 = List.of("Четыре", "Пять", "Шесть");
        System.out.println("Исходные строки:\n" + strings17_1 + "\n" + strings17_2);

        ListAppender listAppender = (s1, s2) -> {
            List<String> fullList = new ArrayList<>();
            fullList.addAll(s1);
            fullList.addAll(s2);
            return fullList;
        };

        System.out.println("Соединяем строки: " + listAppender.appendedList(strings17_1, strings17_2));
        System.out.println();

        //18) Напишите лямбда-выражение, которое возвращает строку с первой буквой в верхнем регистре.
        System.out.println("Задание 18. Вывод:");
        String string18 = "с нижнего регистра";
        System.out.println("Исходная строка: " + string18);
        UpperCaseFirstChar upperCaseFirstChar = string -> Character.toUpperCase(string.charAt(0)) + string.substring(1);

        System.out.println("Измененная строка: " + upperCaseFirstChar.upperCased(string18));
        System.out.println();

        //19) Напишите лямбда-выражение, которое находит разницу между двумя датами.
        System.out.println("Задание 19. Вывод:");
        LocalDate date19_1 = LocalDate.of(2025, 3, 11);
        LocalDate date19_2 = LocalDate.of(2025, 3, 8);
        System.out.println("Первая дата: " + date19_1);
        System.out.println("Вторая дата: " + date19_2);
        DateDiff dateDiff = (d1, d2) -> {
            Period period = Period.between(d2, d1);
            return period.getDays();
        };
        System.out.println("Разница между датами в днях \"" + date19_1 + "\" и \"" + date19_2 + " равна: " + dateDiff.dateDiff(date19_1, date19_2));
        System.out.println();

        //20) Напишите лямбда-выражение, которое проверяет, является ли строка числом.
        System.out.println("Задание 20. Вывод:");
        String string20_1 = "1234";
        String string20_2 = "Не число";
        StringIsNum stringIsNum = string -> {
            boolean isNums = false;
            for (Character ch : string.toCharArray()) {
                isNums = Character.isDigit(ch);
            }
            return isNums;
        };
        System.out.println("Строка \"" + string20_1 + "\" является числом? Ответ: " + (stringIsNum.stringIsNum(string20_1) ? "Да" : "Нет"));
        System.out.println("Строка \"" + string20_2 + "\" является числом? Ответ: " + (stringIsNum.stringIsNum(string20_2) ? "Да" : "Нет"));
    }
}
