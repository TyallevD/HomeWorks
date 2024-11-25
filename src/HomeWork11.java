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
//    public static int factorial(int num) {
//        if (num > 0) {
//            num--;
//        factorial(num);
//        }
//        return 1;
//    }
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
    //Метод для задания 10
    //Метод для задания 11
    //Метод для задания 12
    //Метод для задания 13
    //Метод для задания 14
    //Метод для задания 15
    //Метод для задания 16
    //Метод для задания 17
    //Метод для задания 18
    //Метод для задания 19
    public static double circleLength(int num) {
        return Math.PI * num * 2;
    }

    //Метод для задания 20
    public static void main(String[] args) {
        //1) Написать метод, который возвращает факториал заданного числа.
//        System.out.println("Задание 1. Вывод:");
//        System.out.println(factorial(5));
//        System.out.println();
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
        System.out.println("Сумма элементов массива равна: ");
        System.out.println();
        //4) Написать метод, который возвращает произведение элементов массива.
        System.out.println("Задание 4. Вывод:");
        int[] arr4 = randomArray(10);
        printArray(arr4);
        System.out.println("Произведение элементов массива равно: ");
        System.out.println();
        //5) Написать метод, который возвращает наибольшее число из массива.
        System.out.println("Задание 5. Вывод:");
        int[] arr5 = randomArray(10);
        printArray(arr5);
        System.out.println("Максимальное значение в массиве равно: ");
        System.out.println();
        //6) Написать метод, который возвращает наименьшее число из массива.
        System.out.println("Задание 6. Вывод:");
        int[] arr6 = randomArray(10);
        printArray(arr6);
        System.out.println("Минимальное значение в массиве равно: ");
        System.out.println();
        //7) Написать метод, который возвращает разницу между максимальным и минимальным элементом массива.
        System.out.println("Задание 7. Вывод:");
        int[] arr7 = randomArray(10);
        printArray(arr7);
        //ТУТ ДУМАЮ МОЖНО ИСПОЛЬЗОВАТЬ МЕТОДЫ НАХОЖДЕНИЯ МИНИМАЛЬНОГО И МАКСИМАЛЬНОГО ЗНАЧЕНИЯ
        System.out.println("Разница между максимальным и минимальным значением в массиве равно: ");
        System.out.println();
        //8) Написать метод, который возвращает сумму квадратов элементов массива.
        System.out.println("Задание 8. Вывод:");
        int[] arr8 = randomArray(10);
        printArray(arr8);
        System.out.println("Сумма квадратов элементов массива равна: ");
        System.out.println();
        //9) Написать метод, который находит объем цилиндра по радиусу и высоте.
        System.out.println("Задание 9. Вывод:");
        System.out.println();
        //10) Написать метод, который вычисляет гипотенузу прямоугольного треугольника по двум катетам.
        System.out.println("Задание 10. Вывод:");
        System.out.println();
        //11) Написать метод, который возвращает сумму чисел от 1 до заданного числа без использования циклов и условий.
        System.out.println("Задание 11. Вывод:");
        System.out.println();
        //12) Написать метод, который проверяет, является ли число степенью двойки.
        System.out.println("Задание 12. Вывод:");
        System.out.println();
        //13) Написать метод, который вычисляет сумму чисел, кратных 3 или 5, в заданном диапазоне.
        System.out.println("Задание 13. Вывод:");
        System.out.println();
        //14) Написать метод, который возвращает сумму цифр числа.
        System.out.println("Задание 14. Вывод:");
        System.out.println();
        //15) Написать метод, который возвращает произведение цифр числа.
        System.out.println("Задание 15. Вывод:");
        System.out.println();
        //16) Написать метод, который возвращает количество цифр в числе.
        System.out.println("Задание 16. Вывод:");
        System.out.println();
        //17) Написать метод, который возвращает число, полученное в результате зеркального отображения (реверса) заданного числа.
        System.out.println("Задание 17. Вывод:");
        System.out.println();
        //18) Написать метод, который возвращает значение числа Фибоначчи с заданным номером.
        System.out.println("Задание 18. Вывод:");
        System.out.println();
        //19) Написать метод, который возвращает длину окружности по заданному радиусу.
        System.out.println("Задание 19. Вывод:");
        System.out.println("Длина окружности равна " + circleLength(5));
        System.out.println();
        //20) Написать метод, который проверяет, является ли треугольник прямоугольным по трём сторонам.
        System.out.println("Задание 20. Вывод:");
        //Если теорема Пифагора будет верна, и квадрат большей стороны треугольника равен сумме квадратов двух меньших сторон, то треугольник прямоугольный
        System.out.println();
    }
}
