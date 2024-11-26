import java.util.Random;

public class HomeWork11 {
    //вспомогательный метод для создания случайных массивов
    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101);
        }
        return arr;
    }

    //вспомогательный метод для печати массивов
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //===========================================================//
    //Метод для задания 1
    public static int factorial(int num) {
//        if (num > 0) {
//            return num * factorial(num - 1);
//        } else {
//            return 1;
//        }
        return (num > 0) ? num * factorial((num - 1)) : 1;
    }

    //Метод для задания 2
    public static double arrAriphmetic(int[] arr) {
        int i = 0;
        double result = 0;
        while (i < arr.length) {
            result += arr[i];
            i++;
        }
        return result / arr.length;
    }

    //Метод для задания 3
    //Метод для задания 4
    //Метод для задания 5
    //Метод для задания 6
    //Метод для задания 7
    //Метод для задания 8
    //Метод для задания 9
    public static double cylinderVolume(int radius, int height) {
        return Math.PI * radius * 2 * height;
    }

    //Метод для задания 10
    public static double hypotenuse(int sideA, int sideB) {
        return Math.sqrt((Math.pow(sideA, 2) + Math.pow(sideB, 2)));
    }

    //Метод для задания 11 ??? тернарный оператор подойдёт? или есть ещё другое решение
    public static int numberSumm(int num) {
        return (num > 0) ? num + numberSumm(num - 1) : 0;
    }

    //Метод для задания 12
    //Метод для задания 13
    //Метод для задания 14
    public static int digitSumm(int number) {
        int result = 0;
        int temp = number;
        while (temp != 0) {
            int ostatok = temp % 10;
            result = result + ostatok;
            temp /= 10;
        }
        return result;
    }

    //Метод для задания 15
    public static int numberMultiply(int number) {
        int result = 1;
        int temp = number;
        while (temp != 0) {
            int ostatok = temp % 10;
            result = result * ostatok;
            temp /= 10;
        }
        return result;
    }

    //Метод для задания 16
    public static int numberCount(int number) {
        int count = 0;
        int temp = number;
        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    //Метод для задания 17
    public static int numberReverse(int number) {
        int result = 0;
        int temp = number;
        while (temp != 0) {
            int ostatok = temp % 10;
            result = result * 10 + ostatok;
            temp /= 10;
        }
        return result;
    }

    //Метод для задания 18
    //Метод для задания 19
    public static double circleLength(int num) {
        return Math.PI * num * 2;
    }

    //Метод для задания 20
    public static boolean isRectangular(int sideA, int sideB, int sideC) {
        return (Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2));
    }

    public static void main(String[] args) {
        //1) Написать метод, который возвращает факториал заданного числа.
        System.out.println("Задание 1. Вывод:");
        int num1 = 5;
        int result1 = factorial(num1);
        System.out.println("Факториал числа " + num1 + " равен: " + result1);
        System.out.println();
        //2) Написать метод, который возвращает среднее арифметическое массива чисел.
        System.out.println("Задание 2. Вывод:");
        int[] arr2 = randomArray(10);
        printArray(arr2);
        System.out.println("Среднее арифметическое массива равно: " + arrAriphmetic(arr2));
        System.out.println();
        //3) Написать метод, который возвращает сумму элементов массива.
        System.out.println("Задание 3. Вывод:");
        int[] arr3 = randomArray(10);
        printArray(arr3);

        //TODO стоит ли использовать for или while? попробовать рекурсию?

        System.out.println("Сумма элементов массива равна: ");
        System.out.println();
        //4) Написать метод, который возвращает произведение элементов массива.
        System.out.println("Задание 4. Вывод:");
        int[] arr4 = randomArray(10);
        printArray(arr4);

        //TODO стоит ли использовать for или while? попробовать рекурсию?

        System.out.println("Произведение элементов массива равно: ");
        System.out.println();
        //5) Написать метод, который возвращает наибольшее число из массива.
        System.out.println("Задание 5. Вывод:");
        int[] arr5 = randomArray(10);
        printArray(arr5);

        //TODO стоит ли использовать for или while? попробовать рекурсию?

        System.out.println("Максимальное значение в массиве равно: ");
        System.out.println();
        //6) Написать метод, который возвращает наименьшее число из массива.
        System.out.println("Задание 6. Вывод:");
        int[] arr6 = randomArray(10);
        printArray(arr6);

        //TODO стоит ли использовать for или while? попробовать рекурсию?

        System.out.println("Минимальное значение в массиве равно: ");
        System.out.println();
        //7) Написать метод, который возвращает разницу между максимальным и минимальным элементом массива.
        System.out.println("Задание 7. Вывод:");
        int[] arr7 = randomArray(10);
        printArray(arr7);

        //TODO стоит ли использовать for или while? попробовать рекурсию?
        //ТУТ ДУМАЮ МОЖНО ИСПОЛЬЗОВАТЬ МЕТОДЫ НАХОЖДЕНИЯ МИНИМАЛЬНОГО И МАКСИМАЛЬНОГО ЗНАЧЕНИЯ
        System.out.println("Разница между максимальным и минимальным значением в массиве равно: ");
        System.out.println();
        //8) Написать метод, который возвращает сумму квадратов элементов массива.
        System.out.println("Задание 8. Вывод:");
        int[] arr8 = randomArray(10);
        printArray(arr8);

        //TODO стоит ли использовать for или while? попробовать рекурсию?

        System.out.println("Сумма квадратов элементов массива равна: ");
        System.out.println();
        //9) Написать метод, который находит объем цилиндра по радиусу и высоте.
        System.out.println("Задание 9. Вывод:");
        //V=πr2h
        int radius9 = 5;
        int height9 = 9;
        double volume9 = cylinderVolume(radius9, height9);
        System.out.println("Объём цилиндра по радиусу " + radius9 + " и высоте " + height9
                + " равен: " + volume9);
        System.out.println();
        //10) Написать метод, который вычисляет гипотенузу прямоугольного треугольника по двум катетам.
        System.out.println("Задание 10. Вывод:");
        //теорема Пифагора, только нужен квадратный корень
        int sideA10 = 3;
        int sideB10 = 4;
        double result10 = hypotenuse(sideA10, sideB10);
        System.out.println("Гипотенуза треугольника со сторонами " + sideA10 + " и " + sideB10 + " равна: " + result10);
        System.out.println();
        //11) Написать метод, который возвращает сумму чисел от 1 до заданного числа без использования циклов и условий.
        System.out.println("Задание 11. Вывод:");
        int num11 = 10;
        int sum11 = numberSumm(num11);
        System.out.println("Сумма цифр от 1 до " + num11 + " равна: " + sum11);
        System.out.println();
        //12) Написать метод, который проверяет, является ли число степенью двойки.
        System.out.println("Задание 12. Вывод:");

        //TODO надо понять алгоритм

        System.out.println();
        //13) Написать метод, который вычисляет сумму чисел, кратных 3 или 5, в заданном диапазоне.
        System.out.println("Задание 13. Вывод:");

        //TODO из диапазона нужно условием выделить число, которое делится или на 3 или на 5 (if (num%3==0||num%5==0) то записываем в сумму)

        System.out.println();
        //14) Написать метод, который возвращает сумму цифр числа.
        System.out.println("Задание 14. Вывод:");
        int number14 = 123456789;
        int result14 = digitSumm(number14);
        System.out.println("Сумма цифр числа " + number14 + " равно: " + result14);
        System.out.println();
        //15) Написать метод, который возвращает произведение цифр числа.
        System.out.println("Задание 15. Вывод:");
        int number15 = 657;
        int result15 = numberMultiply(number15);
        System.out.println("Произведение цифр числа " + number15 + " равно:" + result15);
        System.out.println();
        //16) Написать метод, который возвращает количество цифр в числе.
        System.out.println("Задание 16. Вывод:");
        int number16 = 12345;
        int result16 = numberCount(number16);
        System.out.println("Количество цифр в числе " + number16 + ": " + result16);
        System.out.println();
        //17) Написать метод, который возвращает число, полученное в результате зеркального отображения (реверса) заданного числа.
        System.out.println("Задание 17. Вывод:");
        int number17 = 123450789;
        int result17 = numberReverse(number17);
        System.out.println("Зеркальное отображение числа " + number17 + ": " + result17);
        System.out.println();
        //18) Написать метод, который возвращает значение числа Фибоначчи с заданным номером.
        System.out.println("Задание 18. Вывод:");

        //TODO понять формулу?

        System.out.println();
        //19) Написать метод, который возвращает длину окружности по заданному радиусу.
        System.out.println("Задание 19. Вывод:");
        int radius19 = 5;
        double result19 = circleLength(radius19);
        System.out.println("Длина окружности c радиусом " + radius19 + " равна: " + result19);
        System.out.println();
        //20) Написать метод, который проверяет, является ли треугольник прямоугольным по трём сторонам.
        System.out.println("Задание 20. Вывод:");
        int sideA20 = 3;
        int sideB20 = 4;
        int sideC20 = 5;
        String result20;
        if (isRectangular(sideA20, sideB20, sideC20)) {
            result20 = "Треугольник прямоугольный";
        } else {
            result20 = "Треугольник не прямоугольный";
        }
        System.out.println("Является ли треугольник прямоугольным по сторонам А = "
                + sideA20 + "; B = " + sideB20 + "; C = " + sideC20 + ";\nОтвет: " + result20);
        System.out.println();
    }
}
