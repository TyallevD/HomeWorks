import java.util.Arrays;
import java.util.Random;

public class HomeWork9 {
    public static void main(String[] args) {
        //1) Найдите и выведите количество положительных и отрицательных чисел в массиве.
        System.out.println("Задание 1. Вывод:");
        int[] arr1 = {0, 45, -1, -35, 60, -5, 22, 61, 46, -52, 32};
        int countPlus1 = 0;
        int countMinus1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] >= 0) {
                countPlus1++;
            } else {
                countMinus1++;
            }
        }
        System.out.println("Положительных чисел: " + countPlus1 + "\nОтрицательных чисел: " + countMinus1);
        System.out.println();
        //2) Подсчет нулей: Создайте массив из 20 чисел, заполните его случайными числами, и подсчитайте, сколько в нем нулей.
        System.out.println("Задание 2. Вывод:");
        int[] arr2 = new int[20];
        int zero2 = 0;
        Random random = new Random();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(3);//ставим маленькое значение для того, чтобы было больше нулей
            if (arr2[i] == 0) {
                zero2++;
            }
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\nНулевых значений: " + zero2);
        System.out.println();
        //3) Поиск элементов, равных индексу: Найдите все элементы массива, значения которых равны их индексам.
        System.out.println("Задание 3. Вывод:");
        int[] arr3 = new int[]{0, 2, 2, 4, 9, 5, 7, 8, 8, 9};
        int countIndex3 = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] == i) {
                countIndex3++;
                System.out.println("Индекс " + i + " Значение " + arr3[i]);
            }
        }
        System.out.println("Значений совпадающих с индексом: " + countIndex3);
        System.out.println();
        //4) Удаление элементов: Создайте массив из 15 чисел, замените все отрицательные числа на нули.
        System.out.println("Задание 4. Вывод:");
        int[] arr4 = {0, -2, 3, 4, -5, 6, -7, -8, 9, 10, -11, 12, 13, -14, 1};
        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] < 0) {
                arr4[i] = 0;
            }
            System.out.print(arr4[i] + " ");
        }
        System.out.println("\n");
        //5) Дублирование массива: Создайте массив из 15 чисел, а потом каждый элемент удвойте.
        System.out.println("Задание 5. Вывод:");
        int[] arr5 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = arr5[i] * 2;
            System.out.print(arr5[i] + " ");
        }
        System.out.println("\n");
        //6) Подсчет элементов, больших предыдущих: Определите количество элементов массива, которые больше предыдущего элемента.
        System.out.println("Задание 6. Вывод:");
        int[] arr6 = new int[10];
        int count6 = 0;
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = random.nextInt(101);
            System.out.print(arr6[i] + " ");
        }
        for (int i = 0; i < arr6.length - 1; i++) {
            if (arr6[i] < arr6[i + 1]) {
                count6++;
            }
        }
        System.out.println("\nКоличество элементов массива, значения которых больше предыдущего: " + count6);
        System.out.println();
        //7) Произведение элементов: Найдите произведение всех элементов массива, кроме нулевых.
        System.out.println("Задание 7. Вывод:");
        int[] arr7 = {1, 45, 2, 0, 4, 0, 8, 6};
        long multyplyElements7 = 1;
        for (int i = 0; i < arr7.length; i++) {
            System.out.print(arr7[i] + " ");
            if (arr7[i] != 0) {
                multyplyElements7 *= arr7[i];
            }
        }
        System.out.println("\nПроизведение элементов равно: " + multyplyElements7);
        System.out.println();
        //8) Сравнение крайних элементов: Определите, больше ли сумма первых пяти элементов массива, чем сумма последних пяти.
        System.out.println("Задача 8. Вывод:");
        int[] arr8 = new int[10];
        int firstSumm8 = 0;
        int secondSumm8 = 0;
        for (int i = 0; i < arr8.length; i++) {
            arr8[i] = random.nextInt(101);
            System.out.print(arr8[i] + " ");
            if (i < 5) {
                firstSumm8 += arr8[i];
            } else {
                secondSumm8 += arr8[i];
            }
        }
        System.out.println("\nСумма первых 5 элементов (" + firstSumm8 + ") больше суммы последних 5 элементов (" + secondSumm8 + ")?: "
                + (firstSumm8 > secondSumm8 ? "Да" : "Нет"));
        System.out.println("\n");
        //9) Поиск двух наименьших элементов: Найдите два наименьших элемента в массиве из 10 чисел.
        System.out.println("Задача 9. Вывод:");
        System.out.println("\n");
        //10) Проверка на упорядоченность: Определите, отсортирован ли массив по возрастанию. ???
        System.out.println("Задача 10. Вывод:");
        System.out.println("\n");
        //11) Проверка на упорядоченность: Определите, отсортирован ли массив по убыванию. ???
        System.out.println("Задача 11. Вывод:");
        System.out.println("\n");
        //12) Частота элементов: Подсчитайте, сколько раз каждое число встречается в массиве.
        System.out.println("Задача 12. Вывод:");
        System.out.println("\n");
        //13) Инвертирование знаков: Замените все положительные числа в массиве на отрицательные, и наоборот.
        System.out.println("Задача 13. Вывод:");
        int[] arr13 = {15, -25, 74, 32, -7, 74, -2, 73, -547, 14, -787, -3524, -124, 52};
        for (int i = 0; i < arr13.length; i++) {
            arr13[i] = arr13[i] * (-1);
            System.out.print(arr13[i] + " ");
        }
        System.out.println("\n");
        //14) Замена элементов на чётные индексы: Замените все элементы на чётных индексах на их квадрат.
        System.out.println("Задача 14. Вывод:");
        int[] arr14 = new int[10];
        for (int i = 0; i < arr14.length; i++) {
            arr14[i] = random.nextInt(101);
            System.out.print(arr14[i] + " ");
            if (i % 2 == 0) {
                arr14[i] = arr14[i] * arr14[i];
            }
        }
        System.out.println();
        for (int i = 0; i < arr14.length; i++) {
            System.out.print(arr14[i] + " ");
        }
        System.out.println("\n");
        //15) Сумма элементов на чётных индексах: Найдите сумму элементов, расположенных на чётных индексах массива.
        System.out.println("Задача 15. Вывод:");
        int[] arr15 = new int[10];
        int summ15 = 0;
        for (int i = 0; i < arr15.length; i++) {
            arr15[i] = random.nextInt(101);
            System.out.print(arr15[i] + " ");
            if (i % 2 == 0) {
                summ15 += arr15[i];
            }
        }
        System.out.println("\nCумма элементов, расположенных на четных индексах равна: " + summ15);
        System.out.println("\n");
        //16) Замена минимального элемента на 100: Замените минимальный элемент из массива.
        System.out.println("Задача 16. Вывод:");
        System.out.println("\n");
        //17) Обратный порядок массива: Распечатайте массив наоборот
        System.out.println("Задача 17. Вывод:");
        System.out.println("\n");
        //18) Замена элементов на индекс: Замените все элементы массива на их индекс.
        System.out.println("Задача 18. Вывод:");
        System.out.println("\n");
        //19) Сумма положительных элементов: Найдите сумму всех положительных элементов массива.
        System.out.println("Задача 19. Вывод:");
        System.out.println("\n");
        //20) Поиск последнего отрицательного элемента: Найдите последний отрицательный элемент в массиве и замените его на 0.
        System.out.println("Задача 20. Вывод:");
        System.out.println("\n");
        //21) Удвоение элементов на нечётных индексах: Умножьте все элементы на нечётных индексах на 2.
        System.out.println("Задача 21. Вывод:");
        System.out.println("\n");
        //22) Замена максимального элемента на минимальный: Найдите максимальный элемент массива и замените его на минимальный.
        System.out.println("Задача 22. Вывод:");
        System.out.println("\n");
        //23) Замена элементов, делящихся на 2 и 3: Замените в массиве все элементы, которые делятся на 2 и на 3 на число 100.
        System.out.println("Задача 23. Вывод:");
        int[] arr23 = new int[10];
        for (int i = 0; i < arr23.length; i++) {
            arr23[i] = random.nextInt(101);
            System.out.print(arr23[i] + " ");
            if (arr23[i] % 3 == 0 || arr23[i] % 2 == 0) {
                arr23[i] = 100;
            }
        }
        System.out.println();
        for (int i = 0; i < arr23.length; i++) {
            System.out.print(arr23[i] + " ");
        }
        System.out.println("\n");
        //24) Количество элементов, больших среднего арифметического: Подсчитайте количество элементов, которые больше среднего арифметического массива.
        System.out.println("Задача 24. Вывод:");
        System.out.println("\n");
        //25) Нахождение индекса максимального элемента: Найдите индекс максимального элемента в массиве.
        System.out.println("Задача 25. Вывод:");
        System.out.println();
    }
}
