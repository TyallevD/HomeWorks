import java.util.Random;

public class HomeWork7 {
    public static void main(String[] args) {
        //1) Создайте массив из 10 целых чисел и заполните его числами от 1 до 10. Выведите массив на экран.
        System.out.println("Задача 1. Вывод:");
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\n");
        //2) Найдите сумму элементов массива. Создайте массив из 5 элементов и вычислите сумму всех чисел в массиве.
        System.out.println("Задача 2. Вывод:");
        int summ2 = 0;
        int[] arr2 = new int[5];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
            summ2 += arr2[i];
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\nСумма элементов = " + summ2 + "\n");
        //3) Найдите максимальный элемент массива. Создайте массив из 10 целых чисел и найдите максимальное значение.
        System.out.println("Задача 3. Вывод:");
        int[] arr3 = new int[10];
        int index1 = 0;
        int max3 = 0;
        Random random = new Random();
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = random.nextInt(101); //ставим 101, потому что по документации к java.util.Random диапазон идёт от 0 включительно и до значения bound исключительно
            System.out.print(arr3[i] + " ");
        }
        for (int i = 0; i < arr3.length; i++) {
            if (max3 < arr3[i]) {
                max3 = arr3[i];
                index1 = i;
            }
        }
        System.out.println("\nМаксимальное значение = " + max3 + " в индексе " + index1 + "\n");
        //4) Найдите минимальный элемент массива. Создайте массив из 10 целых чисел и найдите минимальное значение.
        System.out.println("Задача 4. Вывод:");
        int[] arr4 = new int[10];
        int index2 = 0;
        int min4 = 100;
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = random.nextInt(101);
            System.out.print(arr4[i] + " ");
        }
        for (int i = 0; i < arr4.length; i++) {
            if (min4 > arr4[i]) {
                min4 = arr4[i];
                index2 = i;
            }
        }
        System.out.println("\nМинимальное значение = " + min4 + " в индексе " + index2 + "\n");
        //5) Посчитайте количество чётных чисел в массиве.
        System.out.println("Задача 5. Вывод:");
        int[] arr5 = new int[10];
        int count5 = 0;
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt(101);
            System.out.print(arr5[i] + " ");
        }
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] % 2 == 0) {
                count5++;
            }
        }
        System.out.println("\nКоличество четных чисел в массиве = " + count5 + "\n");
        //6) Посчитайте количество нечётных чисел в массиве.
        System.out.println("Задача 6. Вывод:");
        int[] arr6 = new int[10];
        int count6 = 0;
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = random.nextInt(101);//i + 1;
            System.out.print(arr6[i] + " ");
        }
        for (int i = 0; i < arr6.length; i++) {
            if (arr6[i] % 2 != 0) {
                count6++;
            }
        }
        System.out.println("\nКоличество нечетных чисел в массиве = " + count6 + "\n");
        //7) Посчитайте среднее арифметическое всех элементов массива.
        System.out.println("Задача 7. Вывод:");
        int summ7 = 0;
        int[] arr7 = new int[10];
        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = random.nextInt(101);
            summ7 += arr7[i];
            System.out.print(arr7[i] + " ");
        }
        System.out.println("\nСреднее арифметическое значений массива = " + summ7 / arr7.length + "\n");
        //8) Выведите все элементы массива в обратном порядке.
        System.out.println("Задача 8. Вывод:");
        int[] arr8 = new int[10];
        System.out.println("Вывод массива:");
        for (int i = 0; i < arr8.length; i++) {
            arr8[i] = random.nextInt(101);
            System.out.print(arr8[i] + " ");
        }
        System.out.println("\n\nВывод обратного массива:");
        for (int i = (arr8.length - 1); i >= 0; i--) {
            System.out.print(arr8[i] + " ");
        }
        System.out.println("\n");
        //9) Заполните массив случайными числами от 1 до 100 и выведите его на экран.
        System.out.println("Задача 9. Вывод:");
        int[] arr9 = new int[10];
        for (int i = 0; i < arr9.length; i++) {
            arr9[i] = random.nextInt(101);
            System.out.print(arr9[i] + " ");
        }
        System.out.println("\n");
        //10)Поменяйте местами первый и последний элементы массива.
        System.out.println("Задача 10. Вывод:");
        int[] arr10 = new int[10];
        int temp;
        System.out.println("Вывод массива:");
        for (int i = 0; i < arr10.length; i++) {
            arr10[i] = random.nextInt(101);
            System.out.print(arr10[i] + " ");
        }
        System.out.println();
        temp = arr10[0];
        arr10[0] = arr10[arr10.length - 1];
        arr10[arr10.length - 1] = temp;
        System.out.println("Вывод массива со сменой первого и последнего индекса:");
        for (int i = 0; i < arr10.length; i++) {
            System.out.print(arr10[i] + " ");
        }
        System.out.println("\n");
        //11)Найдите разницу между максимальным и минимальным элементами массива.
        System.out.println("Задача 11. Вывод:");
        int[] arr11 = new int[10];
        int max11 = 0;
        int min11 = 100;
        System.out.println("Вывод массива:");
        for (int i = 0; i < arr11.length; i++) {
            arr11[i] = random.nextInt(101);
            if (arr11[i] < min11) {
                min11 = arr11[i];
            }
            if (arr11[i] > max11) {
                max11 = arr11[i];
            }
            System.out.print(arr11[i] + " ");
        }
        System.out.println("\nРазница максимального значения " + max11 + " и минимального значения " + min11 + " в массиве равна: " + (max11 - min11) + "\n");
        //12)Посчитайте количество элементов, больше среднего арифметического.
        System.out.println("Задание 12. Вывод:");
        int summ12 = 0;
        int ariphmetic;
        int count12 = 0;
        int[] arr12 = new int[10];
        System.out.println("Вывод массива:");
        for (int i = 0; i < arr12.length; i++) {
            arr12[i] = random.nextInt(100);
            summ12 += arr12[i];
            System.out.print(arr12[i] + " ");
        }
        ariphmetic = summ12 / arr12.length;
        for (int i = 0; i < arr12.length; i++) {
            if (ariphmetic < arr12[i]) {
                count12++;
            }
        }
        System.out.println("\nКоличество элементов больше среднего арифметического (" + ariphmetic + ") равно: " + count12 + "\n");
        //13)Создайте массив и заполните его квадратами чисел от 1 до 10.
        System.out.println("Задание 13. Вывод:");
        int[] arr13 = new int[10];
        for (int i = 0; i < arr13.length; i++) {
            arr13[i] = (i + 1) * (i + 1);
            System.out.print(arr13[i] + " ");
        }
    }
}
