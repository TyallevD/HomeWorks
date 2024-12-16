import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HomeWork16 {
    //Метод для задания 1
    public static double delenie(double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("Ошибка: делить на ноль нельзя");
        }
        return a / b;
    }

    //Метод для задания 3
    public static int[] arrayFill(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(101);
        }
        return arr;
    }

    public static int showArrayItem(int[] arr, int index) {
        return arr[index];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Деление на ноль
        //Попросите пользователя ввести два числа (делимое и делитель). Если пользователь пытается выполнить деление на ноль, обработайте эту ситуацию, выведя сообщение об ошибке.
//        System.out.println("Задание 1. Вывод:");
//        System.out.print("Введите первое число: ");
//        double a1 = scanner.nextDouble();
//        System.out.print("Введите второе число: ");
//        double b1 = scanner.nextDouble();
//        try {
//            System.out.println("Результат деления: " + delenie(a1, b1));
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println();
//
//        //2. Неверный формат числа //TODO - сделать отдельный метод?
//        //Запросите у пользователя ввод числа. Если пользователь ввёл строку, не являющуюся числом, выбросьте исключение и выведите сообщение об ошибке.
//        System.out.println("Задание 2. Вывод");
//        try {
//            System.out.print("Введите число: ");
//            int a2 = scanner.nextInt();
//            System.out.println("Вы ввели " + a2);
//        } catch (InputMismatchException ex) {
//            System.out.println("Ошибка. Введенное значение не является числом");
//        }
//        System.out.println();

        //3. Обращение к элементу массива
        //Создайте массив из 5 элементов. Запросите у пользователя индекс и выведите элемент массива по этому индексу. Обработайте ситуацию, когда индекс выходит за границы массива.
//        System.out.println("Задание 3. Вывод:");
//        int[] arr3 = new int[5];
//        arrayFill(arr3);
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
//        //Запросите у пользователя несколько чисел (например, 5). Если одно из введённых значений не является числом, выбросьте исключение и выведите сообщение об ошибке.
//        System.out.println("Задание 4. Вывод:");
//        try {
//            System.out.print("Введите первое число: ");
//            int a4 = scanner.nextInt();
//            System.out.print("Введите второе число: ");
//            int b4 = scanner.nextInt();
//            System.out.print("Введите третье число: ");
//            int c4 = scanner.nextInt();
//            System.out.print("Введите четвертое число: ");
//            int d4 = scanner.nextInt();
//            System.out.print("Введите пятое число: ");
//            int e4 = scanner.nextInt();
//        } catch (Exception ex){
//            System.out.println("Значение не является числом");
//        }
//        System.out.println();

//        //5. Чтение строки с ограничением длины
//        //Запросите у пользователя ввод строки. Если длина строки превышает 10 символов, выбросьте исключение с сообщением, что строка слишком длинная.
//        System.out.println("Задание 5. Вывод:");
//        System.out.print("Введите строку: ");
//        String str5 = scanner.nextLine();
//        //метод отправляющий строку на проверку
//        System.out.println();
//
//        //6. Поиск подстроки
//        //Запросите у пользователя строку и символ. Если строка не содержит указанный символ, выбросьте исключение и выведите сообщение об ошибке.
//        System.out.println("Задание 6. Вывод:");
//        System.out.print("Введите строку: ");
//        String str6 = scanner.nextLine();
//        System.out.print("Введите символ: ");
//        //char char6 = scanner.next();
//        System.out.println();
//
//        //7. Число в диапазоне
//        //Попросите пользователя ввести число. Если введённое число меньше 1 или больше 100, выбросьте исключение с сообщением о некорректном диапазоне.
//        System.out.println("Задание 7. Вывод:");
//        System.out.print("Введите число: ");
//        int a7 = scanner.nextInt();
        //метод, сравнивающий значение с введенным значением
//        System.out.println();
//
//        //8. Парсинг массива
//        //Создайте массив строк. Попробуйте преобразовать каждую строку в целое число. Если преобразование невозможно, выбросьте исключение и выведите сообщение о некорректном значении.
//        System.out.println("Задание 8. Вывод:");
//        System.out.println();
//
//        //9. Проверка делимости
//        //Попросите пользователя ввести два числа. Если второе число не является делителем первого, выбросьте исключение с сообщением: "Число не делится без остатка".
//        System.out.println("Задание 9. Вывод:");
//        System.out.print("Введите первое число: ");
//        int a9 = scanner.nextInt();
//        System.out.print("Введите второе число: ");
//        int b9 = scanner.nextInt();
//        System.out.println();
//
//        //10. Индексы и значение
//        //Создайте массив из 10 элементов. Попросите пользователя ввести индекс и значение для записи в массив. Обработайте ситуации, когда индекс выходит за пределы массива или значение некорректно.
//        System.out.println("Задание 10. Вывод:");
//        int []arr10 = new int[10];

    }
}
