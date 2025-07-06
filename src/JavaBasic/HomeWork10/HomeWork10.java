package JavaBasic.HomeWork10;

public class HomeWork10 {
    //Метод для задания 1
    public static int add(int a, int b) {
        return a + b;
    }

    //Метод для задания 2
    public static void printMessage(String message) {
        System.out.println(message);
    }

    //Метод для задания 3
    public static int subtract(int a, int b) {
        return a - b;
    }

    //Метод для задания 4
    public static void greet() {
        System.out.println("Hello World");
    }

    //Метод для задания 5
    public static int square(int number) {
        return number * number;
    }

    //Метод для задания 6
    public static int kub(int number) {
        return square(number) * number;
    }

    //Метод для задания 7
    public static boolean isEven(int number) {
        return number % 2 == 0; //тут хотел сначала воспользоваться тернарным оператором, но IDE предложила ещё больше упростить.
    }

    //Метод для задания 8
    public static boolean isNegativ(int number) {
        return number < 0;
    }

    //Метод для задания 9
    public static void printNumber(int number) {
        System.out.println("Вывод числа: " + number);
    }

    //Метод для задания 10
    public static boolean areEqual(int a, int b) {
        return a == b;
    }

    //Метод для задания 11
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        //1)public static  int add(int a, int b)
        //Условие: Вернуть сумму двух чисел a и b.
        System.out.println("Задание 1. Вывод:");
        System.out.println("Сумма равна: " + add(5, 4));
        System.out.println();
        //2)public static  void printMessage(String message)
        //Условие: Вывести строку message в консоль.
        System.out.println("Задание 2. Вывод:");
        printMessage("Выводим строку на консоль");
        System.out.println();
        //3)public static int subtract(int a, int b)
        //Условие: Вернуть разность чисел a и b.
        System.out.println("Задание 3. Вывод:");
        System.out.println("Разность чисел равна: " + subtract(10, 4));
        System.out.println();
        //4)public static  void greet()
        //Условие: Напечатать в консоли стандартное приветствие, например, "Hello, world!".
        System.out.println("Задание 4. Вывод:");
        greet();
        System.out.println();
        //5)public static  int square(int number)
        //Условие: Вернуть квадрат числа number.
        System.out.println("Задание 5. Вывод:");
        System.out.println("Квадрат числа равен: " + square(3));
        System.out.println();
        //6)public static int kub(int number)
        //Условие: Вернуть kub числа number.
        System.out.println("Задание 6. Вывод:");
        System.out.println("Куб числа равен: " + kub(4));
        System.out.println();
        //7)public static  boolean isEven(int number)
        //Условие: Вернуть true, если число number чётное, иначе false.
        System.out.println("Задание 7. Вывод:");
        System.out.println("Число четное?: " + isEven(15));
        System.out.println();
        //8)public static boolean isNegativ(int number)
        //Условие: Вернуть true, если число number отрицательное иначе false.
        System.out.println("Задание 8. Вывод:");
        System.out.println("Число отрицательное?: " + isNegativ(-15));
        System.out.println();
        //9)public static void printNumber(int number)
        //Условие: Вывести число number в консоль.
        System.out.println("Задание 9. Вывод:");
        printNumber(354);
        System.out.println();
        //10)public static boolean areEqual(int a, int b)
        //Условие: Вернуть true, если числа a и b равны, иначе false.
        System.out.println("Задание 10. Вывод:");
        System.out.println("Числа равны?: " + areEqual(14, 15));
        System.out.println();
        //11)public static int multiply(int a, int b)
        //Условие: Вернуть произведение чисел a и b.
        System.out.println("Задание 11. Вывод:");
        System.out.println("Произведение чисел равно: " + multiply(3, 4));
        System.out.println();
    }
}
