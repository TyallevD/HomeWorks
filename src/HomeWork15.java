public class HomeWork15 {
    public static int[] concat(int[] one, int[] two) {
        //{-2,-1,0,4,7,10,12};
        //{-10,1,1,1,2,3,6,7,10,100,1000};

//        {-1, 0, 2};
//        {-10, -2, 1, 4};
        int[] result = new int[one.length + two.length];
        int min1 = 0;
        int min2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (one[min1] > two[min2]) { //&& min2 <= two.length -1
                System.out.println("Значение в индексе min1 больше min2: " + one[min1] + " > " + two[min2]);
                System.out.println("Ставим в " + i + " результат = " + two[min2]);
                result[i] = two[min2];
                System.out.println("Прибавляем min2 " + min2);
                min2++;
                System.out.println("min2 = " + min2);
                System.out.println();

            } else  {// if (one[min1] <= two[min2]) //&& min1 <= one.length-1
                System.out.println("Значение в индексе min1 меньше min2: " + one[min1] + " < " + two[min2]);
                System.out.println("Ставим в " + i + " результат = " + one[min1]);
                result[i] = one[min1];
                System.out.println("Прибавляем min1 " + min1);
                min1++;
                System.out.println("min1 = " + min1);
                System.out.println();
            }
//            if (min1 == one.length) {
//                result[i] = two[min2];
//                min2++;
//            }
//            if (min2 == two.length) {
//                result[i] = one[min1];
//                min1++;
//            }
        }
        //TODO Заполнение происходит частично, далее упираюсь в размер первого массива. А что если первый массив больше второго? Или равны?

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

//        int[] arr1 = {-2, -1, 0, 4, 7, 10, 12};
//        int[] arr2 = {-10, 1, 1, 1, 2, 3, 6, 7, 10, 100, 1000};
        int[] arr1 = {-1, -0, 2};
        int[] arr2 = {-10, -2, 1, 4};

        int[] arr3 = concat(arr1, arr2);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
