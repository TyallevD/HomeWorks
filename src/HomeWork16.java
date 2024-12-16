import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HomeWork16 {
    //Метод для задания 1
    public static double myDivide(double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("Ошибка: делить на ноль нельзя");
        }
        return a / b;
    }

    //Метод для задания 3
    public static int[] arrayRandomFill(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(101);
        }
        return arr;
    }

    public static int showArrayItem(int[] arr, int index) {
        return arr[index];
    }

    //Метод для задания 4
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    //Метод для задания 5
    public static void verifyString(String str) throws Exception {
        if (str.length() <= 10) {
            System.out.println("Вы ввели: " + str);
        } else throw new Exception("Ошибка. Строка больше 10 символов");
    }

    //Метод для задания 6
    public static void findCharInString(String str, char ch) throws Exception {
        char[] charray = str.toCharArray();
        int count = 0;
        for (int i = 0; i < charray.length; i++) {
            if (charray[i] == ch) {
                count++;
                System.out.println("Символ \"" + ch + "\" встречается в " + i + " позиции строки");
            }
        }
        if (count == 0) {
            throw new Exception("Ошибка. Символ \"" + ch + "\" не найден в строке");
        }
    }

    //Метод для задания 7
    public static void checkRange(int a) throws Exception {
        if (a >= 1 && a <= 100) {
            System.out.println("Успех! Значение \"" + a + "\" находится в диапазоне от 1 до 100 включительно");
        } else throw new Exception("Ошибка. Значение \"" + a + "\" находится вне диапазона от 1 до 100 включительно");
    }

    //Метод для задания 8 //TODO
    //Метод для задания 9
    public static void divideCheck(int a, int b) throws Exception {
        if (a % b == 0) {
            System.out.println("Успех! Число \'" + a + "\' делится на число \'" + b + "\' без остатка");
        } else throw new Exception("Ошибка. Число \'" + a + "\' не делится на число \'" + b + "\' без остатка");
    }
    //Метод для задания 10

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Деление на ноль
        //Попросите пользователя ввести два числа (делимое и делитель). Если пользователь пытается выполнить
        // деление на ноль, обработайте эту ситуацию, выведя сообщение об ошибке.
//        System.out.println("Задание 1. Вывод:");
//        System.out.print("Введите первое число: ");
//        double a1 = scanner.nextDouble();
//        System.out.print("Введите второе число: ");
//        double b1 = scanner.nextDouble();
//        try {
//            System.out.println("Результат деления: " + myDivide(a1, b1));
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println();
//
//        //2. Неверный формат числа
//        //Запросите у пользователя ввод числа. Если пользователь ввёл строку, не являющуюся числом,
//        //выбросьте исключение и выведите сообщение об ошибке.
//        System.out.println("Задание 2. Вывод");
//        try {
//            System.out.print("Введите число: ");
//            int a2 = scanner.nextInt();
//            System.out.println("Вы ввели " + a2);
//        } catch (InputMismatchException ex) {
//            System.out.println("Ошибка. Введенное значение не является числом");
//        }
//        System.out.println();

//        //3. Обращение к элементу массива
//        //Создайте массив из 5 элементов. Запросите у пользователя индекс и выведите элемент массива по этому индексу.
//        // Обработайте ситуацию, когда индекс выходит за границы массива.
//        System.out.println("Задание 3. Вывод:");
//        int[] arr3 = new int[5];
//        arrayRandomFill(arr3);
//        System.out.println(Arrays.toString(arr3));
//        try {
//            System.out.print("Введите индекс массива: ");
//            int index3 = scanner.nextInt();
//            System.out.println(showArrayItem(arr3, index3));
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            System.out.println("Ошибка. Индекс выходит за пределы массива");
//        } catch (InputMismatchException ex) {
//            System.out.println("Ошибка. Введенное значение не является числом");
//        }
//        System.out.println();

//        //4. Нахождение минимального числа
//        //Запросите у пользователя несколько чисел (например, 5). Если одно из введённых значений
//        //не является числом, выбросьте исключение и выведите сообщение об ошибке.
//        System.out.println("Задание 4. Вывод:");
//        int[] arr4 = new int[5];
//        try {
//            for (int i = 0, j = 1; i < arr4.length; i++, j++) {
//                System.out.print("Введите " + j + "-е значение: ");
//                arr4[i] = scanner.nextInt();
//            }
//            System.out.println(Arrays.toString(arr4));
//            System.out.println("Минимальное значение: " + findMin(arr4));
//        } catch (InputMismatchException ex) {
//            System.out.println("Значение не является числом. Начните ввод заново");
//        }
//        System.out.println();

//        //5. Чтение строки с ограничением длины
//        //Запросите у пользователя ввод строки. Если длина строки превышает 10 символов,
//        //выбросьте исключение с сообщением, что строка слишком длинная.
//        System.out.println("Задание 5. Вывод:");
//        System.out.print("Введите строку до 10 символов включительно: ");
//        String str5 = scanner.nextLine();
//        try {
//            verifyString(str5);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println();

//        //6. Поиск подстроки //TODO - подстроки? не символа?
//        //Запросите у пользователя строку и символ. Если строка не содержит указанный символ,
//        //выбросьте исключение и выведите сообщение об ошибке.
//        System.out.println("Задание 6. Вывод:");
//        System.out.print("Введите строку: ");
//        String str6 = scanner.nextLine();
//        System.out.print("Введите символ: ");
//        char char6 = scanner.next().charAt(0);
//        try {
//            findCharInString(str6, char6);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println();

//        //7. Число в диапазоне
//        //Попросите пользователя ввести число. Если введённое число меньше 1 или больше 100, выбросьте исключение с сообщением о некорректном диапазоне.
//        System.out.println("Задание 7. Вывод:");
//        System.out.print("Введите число в диапазоне от 1 до 100 включительно: ");
//        try {
//            int a7 = scanner.nextInt();
//            checkRange(a7);
//        } catch (InputMismatchException ex) {
//            System.out.println("Ошибка. Неверный формат числа.");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println();

//        //8. Парсинг массива
//        //Создайте массив строк. Попробуйте преобразовать каждую строку в целое число.
//        // Если преобразование невозможно, выбросьте исключение и выведите сообщение о некорректном значении.
//        System.out.println("Задание 8. Вывод:");
//        //TODO надо уточнить детали
//        System.out.println();

//        //9. Проверка делимости
//        //Попросите пользователя ввести два числа. Если второе число не является делителем первого,
//        // выбросьте исключение с сообщением: "Число не делится без остатка".
//        System.out.println("Задание 9. Вывод:");
//        try {
//            System.out.print("Введите первое число: ");
//            int a9 = scanner.nextInt();
//            System.out.print("Введите второе число: ");
//            int b9 = scanner.nextInt();
//            divideCheck(a9, b9);
//        } catch (InputMismatchException ex) {
//            System.out.println("Неверный формат числа");
//        } catch (ArithmeticException ex) {
//            System.out.println("Делить на ноль нельзя!");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println();

//        //10. Индексы и значение //TODO вводим просто значения в массив?
//        //Создайте массив из 10 элементов. Попросите пользователя ввести индекс и значение для записи в массив.
//        // Обработайте ситуации, когда индекс выходит за пределы массива или значение некорректно.
//        System.out.println("Задание 10. Вывод:");
//        int []arr10 = new int[10];

    }
}
