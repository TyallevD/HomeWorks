package JavaBasic.HomeWork12;

public class HomeWork12 {
    //вспомогательный метод для печати массивов
    public static void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    //Метод для задания 1
    public static int myLength(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
        }
        return count;
    }

    //Метод для задания 2
    public static char myCharAt(char[] arr, int index) {
        char result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                result = arr[i];
                break;
            }
        }
        return result;
    }

    //Метод для задания 3
    public static int myIndexOf(char[] arr, char symbol) {
        for (int i = 0; i < arr.length; i++) {
            if (symbol == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    //Метод для задания 4
    public static int myLastIndexOf(char[] arr, char symbol) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (symbol == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    //Метод для задания 5
    public static char[] myToUpperCase(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] -= 32;
            }
        }
        return arr;
    }

    //Метод для задания 6
    public static char[] myToLowerCase(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 32;
            }
        }
        return arr;
    }

    //Метод для задания 7
    public static char[] myTrim(char[] arr) {
        int countSpaceL = 0;
        int countSpaceR = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                countSpaceL++;
            } else {
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                countSpaceR++;
            } else {
                break;
            }
        }
        char[] arr2 = new char[arr.length - countSpaceL - countSpaceR];

        for (int i = countSpaceL, j = 0; i < arr.length - countSpaceR; i++, j++) {
            arr2[j] = arr[i];
        }
        return arr2;
    }

    public static void main(String[] args) {
        //1) public static int length(char[] arr));
        //Описание: Метод возвращает длину массива символов arr.
        //Считает количество символов в массиве arr и возвращает это значение.
        char[] str1 = {'J', 'o', 'h', 'n', ' ', 'W', 'i', 'l', 'l', 'i', 'a', 'm', 's'};
        System.out.println("Задание 1. Вывод:");
        printArray(str1);
        System.out.println("Количество символов: " + myLength(str1));
        System.out.println("Проверочный метод: " + str1.length);
        System.out.println();

        //2) public static char charAt(int index);
        //Описание:
        //Метод возвращает символ, находящийся по указанному индексу в массиве.
        //Берет массив символов и индекс index, проверяет, существует ли символ на этом месте. Если индекс корректен, возвращает символ.
        System.out.println("Задание 2. Вывод:");
        int index2 = 4;
        String str2 = "Ludovico Einaudi";
        char[] chars2 = str2.toCharArray();
        printArray(chars2);
        char result2 = myCharAt(chars2, index2);
        System.out.println("В индексе " + index2 + " находится символ: " + result2);
        System.out.println("Проверочный метод: в индексе " + index2 + " находится символ " + str2.charAt(index2));
        System.out.println();

        //3) public static int indexOf(char symbol);
        //Описание:
        //Метод возвращает индекс первого вхождения символа symbol в массиве. Если символ не найден, возвращает -1.
        //Проходит по массиву слева направо, ищет первый символ, совпадающий с symbol. Если символ найден, возвращает его индекс. Если нет, возвращает -1.
        System.out.println("Задание 3. Вывод:");
        String str3 = "Hans Zimmer";
        char symbol3 = 'i';
        char[] chars3 = str3.toCharArray();
        int result3 = myIndexOf(chars3, symbol3);
        printArray(chars3);
        System.out.println("Индекс символа " + symbol3 + " равен: " + result3);
        System.out.println("Проверочный метод: " + str3.indexOf(symbol3));
        System.out.println();

        //4) public static int lastIndexOf(char symbol);
        //Описание:
        //Метод возвращает индекс последнего вхождения символа symbol в массиве. Если символ не найден, возвращает -1.
        //Проходит по массиву справа налево, ищет последний символ, совпадающий с symbol. Если символ найден, возвращает его индекс. Если нет, возвращает -1.
        System.out.println("Задание 4. Вывод:");
        String str4 = "Howard Shore";
        char symbol4 = 'd';
        char[] chars4 = str4.toCharArray();
        int result4 = myLastIndexOf(chars4, symbol4);
        printArray(chars4);
        System.out.println("Последний индекс символа '" + symbol4 + "' равен: " + result4);
        System.out.println("Проверочный метод: " + str4.lastIndexOf(symbol4));
        System.out.println();

        //5) public static char[] toUpperCase(char[] arr) ;
        //Описание:
        //Метод возвращает новый массив символов, где все буквы преобразованы в верхний регистр.
        //Для каждой буквы в массиве проверяет, является ли она строчной (например, a-z). Если да, то заменяет её на соответствующую заглавную (например, A-Z).
        //Если символ не является буквой, он остается неизменным.
        System.out.println("Задание 5. Вывод:");
        String str5 = "Ramin Djawadi";
        char[] chars5 = str5.toCharArray();
        printArray(chars5);
        System.out.print("Изменяем: ");
        System.out.println(myToUpperCase(chars5));
        System.out.println("Проверочный метод: " + str5.toUpperCase());
        System.out.println();

        //6) public static char[] toLowerCase(char[] arr) ;
        //Описание:
        //Метод возвращает новый массив символов, где все буквы преобразованы в нижний регистр.
        //Для каждой буквы в массиве проверяет, является ли она заглавной (например, A-Z). Если да, то заменяет её на соответствующую строчную (например, a-z).
        //Если символ не является буквой, он остается неизменным.
        System.out.println("Задание 6. Вывод:");
        String str6 = "JoHN MuRPhy";
        char[] chars6 = str6.toCharArray();
        printArray(chars6);
        System.out.print("Изменяем: ");
        System.out.println(myToLowerCase(chars6));
        System.out.println("Проверочный метод: " + str6.toLowerCase());
        System.out.println();

        //7) public static char[] trim(char[] arr );
        //Метод возвращает новый массив символов, из которого удалены начальные и конечные пробелы.
        //Удаляет все пробелы (символы ' ') с начала и конца массива.
        //Пробелы внутри строки остаются неизменными.
        System.out.println("Задание 7. Вывод:");
        String str7 = "       Akira   Yamaoka          ";
        char[] chars7 = str7.toCharArray();
        printArray(chars7);
        System.out.print("Изменяем: ");
        System.out.println(myTrim(chars7));
        System.out.println("Проверочный метод: " + str7.trim());
        System.out.println();
    }
}
