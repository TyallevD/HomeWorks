package JavaBasic.HomeWork15;

import java.util.Arrays;

public class HomeWork15 {
    public static int[] myConcat(int[] one, int[] two) {
        int[] result = new int[one.length + two.length];
        int min1 = 0; //начальный индекс в массиве 1
        int min2 = 0; // начальный индекс в массиве 2

        for (int i = 0; i < result.length; i++) { //цикл для заполнения результирующего массива
            if (min1 >= one.length) { // если вышли за предел массива 1, то в результат записываем оставшиеся значения из массива 2
                result[i] = two[min2];
                min2++; //переходим на следующий индекс в массиве 2
            } else if (min2 >= two.length) { //иначе если вышли за предел массива 2, то в результат записываем оставшиеся значения из массива 1
                result[i] = one[min1];
                min1++; //переходим на следующий индекс в массиве 1
            } else if (one[min1] > two[min2]) { //иначе, если не вышли за пределы массивов - если значение в индексе массива 1 > значения в индексе массива 2, то записываем значение из массива 2
                result[i] = two[min2];
                min2++; //переходим на следующий индекс в массиве 2
            } else { // иначе, если не вышли за пределы массивов - если значение в индексе массива 1 меньше или равно значению в индексе массива 2, то записываем в результат значение из массива 1
                result[i] = one[min1];
                min1++; //переходим на следующий индекс в массиве 1
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //public static int[] concat(int[] one , int[] two){
        //
        //        return null;
        //    }
        //
        //Есть 2 массива
        //int[] arr1 = {-2,-1,0,4,7,10,12};
        //int[] arr2 = {-10,1,1,1,2,3,6,7,10,100,1000};
        //Написать метод который принимает 2 массива и возвращает
        //3тий массив в таком виде чтобы данный массив был выстроен от
        // меньшего до большего
        //int[] arr3 = concat(arr1,arr2);
        //for (int i = 0; i < arr3.length; i++) {
        //   System.out.print(arr3[i] + " ");
        //}
        //-10,-2,-1,1,1,1,0,2,3,4,6,7,7,10,10,12,100,1000
        //Нельзя использовать
        //Какие либо готовые методы
        //Сортировку

        int[] arr1 = {-2, -1, 0, 4, 7, 10, 12};
        int[] arr2 = {-10, 1, 1, 1, 2, 3, 6, 7, 10, 100, 1000};

        System.out.println("Массив 1: " + Arrays.toString(arr1));
        System.out.println("Массив 2: " + Arrays.toString(arr2));

        int[] arr3 = myConcat(arr1, arr2);

        System.out.print("Выводим соединенный массив: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
