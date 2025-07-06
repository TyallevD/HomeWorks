package JavaBasic.HomeWork8;

import java.util.Random;

public class HomeWork8 {
    public static void main(String[] args) {
        Random random = new Random();
        //1) Создайте массив из 10 целых чисел и заполните его числами от 1 до 10. Выведите массив на экран.
        System.out.println("Задание 1. Вывод:");
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\n");
        //2) Найдите сумму элементов массива. Создайте массив из 5 элементов и вычислите сумму всех чисел в массиве.
        System.out.println("Задание 2. Вывод:");
        int[] arr2 = {84, 55, 434, 6, 8};
        int summ2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
            summ2 += arr2[i];
        }
        System.out.println("\nСумма элементов массива равна: " + summ2);
        System.out.println();
        //3) Найдите максимальный элемент массива. Создайте массив из 10 целых чисел и найдите максимальное значение.
        System.out.println("Задание 3. Вывод:");
        int[] arr3 = new int[]{14, 11, -1, 6, 84, -52, 0, -85, 94, 1};
        int max3 = arr3[0];
        for (int i = 1; i < arr3.length; i++) {
            if (arr3[i] > max3) {
                max3 = arr3[i];
            }
            System.out.print(arr3[i] + " ");
        }
        System.out.println("\nМаксимальное значение элемента массива равно : " + max3);
        System.out.println();
        //4) Найдите минимальный элемент массива. Создайте массив из 10 целых чисел и найдите минимальное значение.
        System.out.println("Задание 4. Вывод:");
        int[] arr4 = new int[]{14, 11, -1, 6, 84, -52, 0, -85, 94, 1};
        int min4 = arr4[0];
        for (int i = 1; i < arr4.length; i++) {
            if (arr4[i] < min4) {
                min4 = arr4[i];
            }
            System.out.print(arr4[i] + " ");
        }
        System.out.println("\nМинимальное значение элемента массива равно : " + min4);
        System.out.println();
        //5) Посчитайте количество чётных чисел в массиве.
        System.out.println("Задание 5. Вывод:");
        int[] arr5 = new int[10];
        int count5 = 0;
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt(101);
            System.out.print(arr5[i] + " ");
            if (arr5[i] % 2 == 0) {
                count5++;
            }
        }
        System.out.println("\nЧетных значений элементов: " + count5);
        System.out.println();
        //6) Посчитайте количество нечётных чисел в массиве.
        System.out.println("Задание 6. Вывод:");
        int[] arr6 = new int[10];
        int count6 = 0;
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = random.nextInt(101);
            System.out.print(arr6[i] + " ");
            if (arr6[i] % 2 != 0) {
                count6++;
            }
        }
        System.out.println("\nНечетных значений элементов: " + count6);
        System.out.println();
        //7) Посчитайте среднее арифметическое всех элементов массива.
        System.out.println("Задание 7. Вывод:");
        int[] arr7 = new int[10];
        double summ7 = 0;
        double ariphmetic7;
        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = random.nextInt(101);
            System.out.print(arr7[i] + " ");
            summ7 += arr7[i];
        }
        ariphmetic7 = summ7 / arr7.length;
        System.out.println("\nСреднее арифметическое элементов массива равно: " + ariphmetic7);
        System.out.println();
        //8) Выведите все элементы массива в обратном порядке.
        System.out.println("Задание 8. Вывод:");
        System.out.println("Первоначальный массив:");
        int[] arr8 = new int[10];
        for (int i = 0; i < arr8.length; i++) {
            arr8[i] = random.nextInt(101);
            System.out.print(arr8[i] + " ");
        }
        System.out.println("\n\nОбратный массив:");
        for (int i = arr8.length - 1; i >= 0; i--) {
            System.out.print(arr8[i] + " ");
        }
        System.out.println("\n");
        //9) Заполните массив случайными числами от 1 до 100 и выведите его на экран.
        System.out.println("Задание 9. Вывод:");
        int[] arr9 = new int[10];
        for (int i = 0; i < arr9.length; i++) {
            arr9[i] = random.nextInt(101);
            System.out.print(arr9[i] + " ");
        }
        System.out.println("\n");
        //10)Поменяйте местами первый и последний элементы массива.
        System.out.println("Задание 10. Вывод:");
        int[] arr10 = new int[10];
        int temp10;
        System.out.println("Изначальный массив:");
        for (int i = 0; i < arr10.length; i++) {
            arr10[i] = random.nextInt(101);
            System.out.print(arr10[i] + " ");
        }
        temp10 = arr10[0];
        arr10[0] = arr10[arr10.length - 1];
        arr10[arr10.length - 1] = temp10;
        System.out.println("\n\nМассив после замены элементов:");
        for (int i = 0; i < arr10.length; i++) {
            System.out.print(arr10[i] + " ");
        }
        System.out.println("\n");
        //11)Найдите разницу между максимальным и минимальным элементами массива.
        System.out.println("Задание 11. Вывод:");
        int[] arr11 = new int[10];
        for (int i = 0; i < arr11.length; i++) {
            arr11[i] = random.nextInt(101);
            System.out.print(arr11[i] + " ");
        }
        int min11 = arr11[0];
        int max11 = arr11[0];
        for (int i = 1; i < arr11.length; i++) {
            if (arr11[i] < min11) {
                min11 = arr11[i];
            }
            if (arr11[i] > max11) {
                max11 = arr11[i];
            }
        }
        System.out.println("\nМинимальное значение элемента массива равно : " + min11);
        System.out.println("Максимальное значение элемента массива равно : " + max11);
        System.out.println("Разница максимального и минимального значения равна: " + (max11 - min11));
        System.out.println("\n");
        //12)Посчитайте количество элементов, больше среднего арифметического.
        System.out.println("Задание 12. Вывод:");
        int[] arr12 = new int[10];
        double ariphmetic12;
        double sum12 = 0;
        int count12 = 0;
        System.out.println("Массив:");
        for (int i = 0; i < arr12.length; i++) {
            arr12[i] = random.nextInt(101);
            System.out.print(arr12[i] + " ");
            sum12 += arr12[i];
        }
        ariphmetic12 = sum12 / arr12.length;
        System.out.println("\nСреднее арифметическое равно: " + ariphmetic12);
        for (int i = 0; i < arr12.length; i++) {
            if (ariphmetic12 < arr12[i]) {
                count12++;
            }
        }
        System.out.println("Количество элементов, значение которых выше среднего арифметического: " + count12);
        System.out.println();
        //13)Создайте массив и заполните его квадратами чисел от 1 до 10.
        System.out.println("Задание 13. Вывод:");
        int[] arr13 = new int[10];
        for (int i = 0; i < arr13.length; i++) {
            arr13[i] = (i + 1) * (i + 1);
            System.out.print(arr13[i] + " ");
        }
        System.out.println();
    }
}
