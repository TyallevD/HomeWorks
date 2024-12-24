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

    //Метод для задания 2
    public static int checkWrongFormat() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        System.out.print("Введите число: ");
        try {
            a = scanner.nextInt();

        } catch (Exception ex) {
            throw new Exception("Ошибка. Введенное значение не является числом");
        }

        return a;
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

    //Метод для задания 8
    public static char[][] stringToChar(String[] strings) {
        char[][] chars = new char[strings.length][];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = strings[i].toCharArray();
        }
        return chars;
    }

    public static int[][] charsToInt(char[][] chars) throws Exception {
        int[][] ints = new int[chars.length][];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new int[chars[i].length];
            for (int j = 0; j < ints[i].length; j++) {
                switch (chars[i][j]) {
                    case (48):
                        ints[i][j] = 0;
                        break;
                    case (49):
                        ints[i][j] = 1;
                        break;
                    case (50):
                        ints[i][j] = 2;
                        break;
                    case (51):
                        ints[i][j] = 3;
                        break;
                    case (52):
                        ints[i][j] = 4;
                        break;
                    case (53):
                        ints[i][j] = 5;
                        break;
                    case (54):
                        ints[i][j] = 6;
                        break;
                    case (55):
                        ints[i][j] = 7;
                        break;
                    case (56):
                        ints[i][j] = 8;
                        break;
                    case (57):
                        ints[i][j] = 9;
                        break;
                    default:
                        throw new Exception("Ошибка. Преобразование невозможно. Значение не является числом");
                }
            }
        }
        return ints;
    }

    public static void printIntsDoubleArray(int[][] ints) {
        System.out.println("Выводим значения int:");
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    //Метод для задания 9
    public static void divideCheck(int a, int b) throws Exception {
        if (a % b == 0) {
            System.out.println("Успех! Число \'" + a + "\' делится на число \'" + b + "\' без остатка");
        } else throw new Exception("Ошибка. Число \'" + a + "\' не делится на число \'" + b + "\' без остатка");
    }

    //Метод для задания 10
    public static int[] fillArray(int[] array) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Scanner charScan = new Scanner(System.in);
        char exit;
        do {
            System.out.print("Введите значение: ");
            int value = scanner.nextInt();
            System.out.print("Введите индекс: ");
            int index = scanner.nextInt();
            if (index < 0 || index >= array.length) {
                throw new IndexOutOfBoundsException("Вы вышли за границы массива");
            }
            System.out.println("Вносим значение " + value + " в индекс " + index);
            array[index] = value;
            System.out.println(Arrays.toString(array));
            System.out.print("Хотите продолжить? y / n: ");
            exit = charScan.nextLine().charAt(0);
        } while (exit != 'n');
        System.out.println("Завершаем заполнение");
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Деление на ноль
        //Попросите пользователя ввести два числа (делимое и делитель). Если пользователь пытается выполнить
        // деление на ноль, обработайте эту ситуацию, выведя сообщение об ошибке.
        System.out.println("Задание 1. Проверка на деление на ноль:");
        System.out.print("Введите первое число: ");
        double a1 = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double b1 = scanner.nextDouble();
        try {
            System.out.println("Результат деления: " + myDivide(a1, b1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //2. Неверный формат числа
        //Запросите у пользователя ввод числа. Если пользователь ввёл строку, не являющуюся числом,
        //выбросьте исключение и выведите сообщение об ошибке.
        System.out.println("Задание 2. Проверка на неверный формат числа:");
        System.out.println("Вариант без метода");
        try {
            System.out.print("Введите число: ");
            int a2 = scanner.nextInt();
            System.out.println("Вы ввели: \"" + a2 + "\"");
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка. Введенное значение не является числом");
        }
        System.out.println();

        System.out.println("Вариант с методом");
        try {
            System.out.println("Вы ввели: \"" + checkWrongFormat()+"\"");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //3. Обращение к элементу массива
        //Создайте массив из 5 элементов. Запросите у пользователя индекс и выведите элемент массива по этому индексу.
        // Обработайте ситуацию, когда индекс выходит за границы массива.
        System.out.println("Задание 3. Обращение к элементу массива");
        int[] arr3 = new int[5];
        arrayRandomFill(arr3);
        System.out.println(Arrays.toString(arr3));
        try {
            System.out.print("Введите индекс массива: ");
            int index3 = scanner.nextInt();
            System.out.println(showArrayItem(arr3, index3));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Ошибка. Индекс выходит за пределы массива");
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка. Введенное значение не является числом");
        }
        System.out.println();

        //4. Нахождение минимального числа
        //Запросите у пользователя несколько чисел (например, 5). Если одно из введённых значений
        //не является числом, выбросьте исключение и выведите сообщение об ошибке.
        System.out.println("Задание 4. Нахождение минимального числа");
        int[] arr4 = new int[5];
        try {
            for (int i = 0, j = 1; i < arr4.length; i++, j++) {
                System.out.print("Введите " + j + "-е значение: ");
                arr4[i] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr4));
            System.out.println("Минимальное значение: " + findMin(arr4));
        } catch (InputMismatchException ex) {
            System.out.println("Значение не является числом. Начните ввод заново");
        }
        System.out.println();

        //5. Чтение строки с ограничением длины
        //Запросите у пользователя ввод строки. Если длина строки превышает 10 символов,
        //выбросьте исключение с сообщением, что строка слишком длинная.
        System.out.println("Задание 5. Чтение строки с ограничением длины в 10 символов");
        System.out.print("Введите строку до 10 символов включительно: ");
        String str5 = scanner.nextLine();
        try {
            verifyString(str5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //6. Поиск подстроки
        //Запросите у пользователя строку и символ. Если строка не содержит указанный символ,
        //выбросьте исключение и выведите сообщение об ошибке.
        System.out.println("Задание 6. Поиск подстроки");
        System.out.print("Введите строку: ");
        String str6 = scanner.nextLine();
        System.out.print("Введите символ: ");
        char char6 = scanner.next().charAt(0);
        try {
            findCharInString(str6, char6);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //7. Число в диапазоне
        //Попросите пользователя ввести число. Если введённое число меньше 1 или больше 100, выбросьте исключение с сообщением о некорректном диапазоне.
        System.out.println("Задание 7. Число в диапазоне");
        System.out.print("Введите число в диапазоне от 1 до 100 включительно: ");
        try {
            int a7 = scanner.nextInt();
            checkRange(a7);
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка. Неверный формат числа.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //8. Парсинг массива
        //Создайте массив строк. Попробуйте преобразовать каждую строку в целое число.
        // Если преобразование невозможно, выбросьте исключение и выведите сообщение о некорректном значении.
        System.out.println("Задание 8. Парсинг массива");
        String[] strings = {"1", "423", "5"};
        System.out.println("Исходный массив строк: \n" + Arrays.toString(strings));
        try {
            char[][] chars = stringToChar(strings);
            int[][] ints = charsToInt(chars);
            printIntsDoubleArray(ints);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //9. Проверка делимости
        //Попросите пользователя ввести два числа. Если второе число не является делителем первого,
        // выбросьте исключение с сообщением: "Число не делится без остатка".
        System.out.println("Задание 9. Проверка делимости");
        try {
            System.out.print("Введите первое число: ");
            int a9 = scanner.nextInt();
            System.out.print("Введите второе число: ");
            int b9 = scanner.nextInt();
            divideCheck(a9, b9);
        } catch (InputMismatchException ex) {
            System.out.println("Неверный формат числа");
        } catch (ArithmeticException ex) {
            System.out.println("Делить на ноль нельзя!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        //10. Индексы и значение
        //Создайте массив из 10 элементов. Попросите пользователя ввести индекс и значение для записи в массив.
        // Обработайте ситуации, когда индекс выходит за пределы массива или значение некорректно.
        System.out.println("Задание 10. Ввод значений в массив");
        int[] arr10 = new int[10];
        try {
            fillArray(arr10);
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка. Введено неверное значение");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
        System.out.println("Выводим получившийся массив: ");
        System.out.println(Arrays.toString(arr10));
    }
}
