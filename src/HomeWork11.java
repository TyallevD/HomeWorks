import java.util.Random;

public class HomeWork11 {
    //вспомогательный метод для создания случайных массивов
    public static int[] randomArray(int size, int diapazon) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(diapazon);
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

    /*===========================================================*/
    //Метод для задания 1
    public static int factorial(int num) {
        return (num > 0) ? num * factorial((num - 1)) : 1;
    }

    //Метод для задания 2
    public static double arrayAriphmetic(int[] arr) {
        int i = 0;
        double result = 0;
        while (i < arr.length) {
            result += arr[i];
            i++;
        }
        return result / arr.length;
    }

    //Метод для задания 3
    public static int arraySumm(int[] arr) {
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i];
            i++;
        }
        return sum;
    }

    //Метод для задания 4
    public static int arrayMultiply(int[] arr) {
        int multiply = 1;
        int i = 0;
        while (i < arr.length) {
            multiply *= arr[i];
            i++;
        }
        return multiply;
    }

    //Метод для задания 5
    public static int arrayMax(int[] arr) {
        int max = arr[0];
        int i = 1;
        while (i < arr.length) {
            if (max < arr[i]) {
                max = arr[i];
            }
            i++;
        }
        return max;
    }

    //Метод для задания 6
    public static int arrayMin(int[] arr) {
        int min = arr[0];
        int i = 1;
        while (i < arr.length) {
            if (min > arr[i]) {
                min = arr[i];
            }
            i++;
        }
        return min;
    }

    //Метод для задания 7
    public static int arrayMaxMinSubstraction(int[] arr) {
        int max = arrayMax(arr);
        int min = arrayMin(arr);
        return max - min;
    }

    //Метод для задания 8
    public static int arrayPowSumm(int[] arr) {
        int sumPow = 0;
        int i = 0;
        while (i < arr.length) {
            sumPow += Math.pow(arr[i], 2);
            i++;
        }
        return sumPow;
    }

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
    public static int sumOfThreeFive(int begin, int last) {
        int sum = 0;
        int i = begin;
        while (i <= last) {
            if (i % 5 == 0 || i % 3 == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }

    //Метод для задания 14
    public static int digitSumm(int number) {
        int result = 0;
        while (number != 0) {
            result = result + (number%10);
            number /= 10;
        }
        return result;
    }

    //Метод для задания 15
    public static int numberMultiply(int number) {
        int result = 1;
        while (number != 0) {
            result = result * (number%10);
            number /= 10;
        }
        return result;
    }

    //Метод для задания 16
    public static int numberCount(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    //Метод для задания 17
    public static int numberReverse(int number) {
        int result = 0;
        while (number != 0) {
            result = result * 10 + (number%10);
            number /= 10;
        }
        return result;
    }

    //Метод для задания 18
    //Метод для задания 19
    public static double circleLength(int num) {
        return Math.PI * num * 2;
    }

    //Метод для задания 20
    public static String isRectangular(int sideA, int sideB, int sideC) {
        return (Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2)) ?
                "Треугольник прямоугольный" : "Треугольник не прямоугольный";
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
        int[] arr2 = randomArray(10, 101);
        printArray(arr2);
        System.out.println("Среднее арифметическое массива равно: " + arrayAriphmetic(arr2));
        System.out.println();

        //3) Написать метод, который возвращает сумму элементов массива.
        System.out.println("Задание 3. Вывод:");
        int[] arr3 = randomArray(10, 101);
        printArray(arr3);
        System.out.println("Сумма элементов массива равна: " + arraySumm(arr3)); //TODO попробовать проход рекурсией?
        System.out.println();

        //4) Написать метод, который возвращает произведение элементов массива.
        System.out.println("Задание 4. Вывод:");
        int[] arr4 = randomArray(10, 101);
        printArray(arr4);
        System.out.println("Произведение элементов массива равно: " + arrayMultiply(arr4)); //TODO попробовать рекурсию?
        System.out.println();

        //5) Написать метод, который возвращает наибольшее число из массива.
        System.out.println("Задание 5. Вывод:");
        int[] arr5 = randomArray(10, 101);
        printArray(arr5);
        System.out.println("Максимальное значение в массиве равно: " + arrayMax(arr5)); //TODO попробовать рекурсию?
        System.out.println();

        //6) Написать метод, который возвращает наименьшее число из массива.
        System.out.println("Задание 6. Вывод:");
        int[] arr6 = randomArray(10, 101);
        printArray(arr6);
        System.out.println("Минимальное значение в массиве равно: " + arrayMin(arr6)); //TODO попробовать рекурсию?
        System.out.println();

        //7) Написать метод, который возвращает разницу между максимальным и минимальным элементом массива.
        System.out.println("Задание 7. Вывод:");
        int[] arr7 = randomArray(10, 101);
        printArray(arr7);
        //ТУТ ДУМАЮ МОЖНО ИСПОЛЬЗОВАТЬ МЕТОДЫ НАХОЖДЕНИЯ МИНИМАЛЬНОГО И МАКСИМАЛЬНОГО ЗНАЧЕНИЯ
        int result7 = arrayMaxMinSubstraction(arr7);
        System.out.println("Разница между максимальным (" + arrayMax(arr7) + ") и минимальным значением (" +
                arrayMin(arr7) + ") в массиве равно: " + result7); //TODO попробовать рекурсию?
        System.out.println();

        //8) Написать метод, который возвращает сумму квадратов элементов массива.
        System.out.println("Задание 8. Вывод:");
        int[] arr8 = randomArray(10, 101);
        printArray(arr8);
        int result8 = arrayPowSumm(arr8);
        System.out.println("Сумма квадратов элементов массива равна: " + result8); //TODO попробовать рекурсию?
        System.out.println();

        //9) Написать метод, который находит объем цилиндра по радиусу и высоте.
        System.out.println("Задание 9. Вывод:");
        //V=πr2h
        int radius9 = 5;
        int height9 = 9;
        double volume9 = cylinderVolume(radius9, height9);
        System.out.println("Объём цилиндра по радиусу " +
                radius9 + " и высоте " + height9 + " равен: " + volume9);
        System.out.println();

        //10) Написать метод, который вычисляет гипотенузу прямоугольного треугольника по двум катетам.
        System.out.println("Задание 10. Вывод:");
        //теорема Пифагора, только нужен квадратный корень
        int sideA10 = 3;
        int sideB10 = 4;
        double result10 = hypotenuse(sideA10, sideB10);
        System.out.println("Гипотенуза треугольника со сторонами " +
                sideA10 + " и " + sideB10 + " равна: " + result10);
        System.out.println();

        //11) Написать метод, который возвращает сумму чисел от 1 до заданного числа без использования циклов и условий.
        System.out.println("Задание 11. Вывод:");
        int num11 = 10;
        int sum11 = numberSumm(num11);
        System.out.println("Сумма цифр от 1 до " + num11 + " равна: " + sum11);
        //TODO достаточно ли тернарного оператора в этом задании?
        System.out.println();

        //12) Написать метод, который проверяет, является ли число степенью двойки.
        System.out.println("Задание 12. Вывод:");

        //TODO надо понять алгоритм

        System.out.println();

        //13) Написать метод, который вычисляет сумму чисел, кратных 3 или 5, в заданном диапазоне.
        System.out.println("Задание 13. Вывод:");
        int first13 = 0;
        int last13 = 10;
        int result13 = sumOfThreeFive(first13, last13);
        System.out.println("Сумма чисел, кратных 3 или 5 из диапазона от " +
                first13 + " до " + last13 + " равна: " + result13); //TODO попробовать рекурсию?
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
        int number18 = 5;

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
        String result20 = isRectangular(sideA20, sideB20, sideC20);
        System.out.println("Является ли треугольник прямоугольным по сторонам А = " +
                sideA20 + "; B = " + sideB20 + "; C = " + sideC20 + ";\nОтвет: " + result20);
        System.out.println();
    }
}
