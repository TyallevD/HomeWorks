public class HomeWork13 {
    //вспомогательные методы для печати массивов
    public static void myPrintArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void myPrintArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    //====================================================


    //Метод для задания 1
    public static char[] myLeftTrim(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                count++;
            } else {
                break;
            }
        }
        char[] arr2 = new char[arr.length - count];
        for (int i = count, j = 0; i < arr.length; i++, j++) {
            arr2[j] = arr[i];
        }
        return arr2;
    }

    //Метод для задания 2
    public static char[] myRightTrim(char[] arr) {
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                count++;
            } else {
                break;
            }
        }
        char[] arr2 = new char[arr.length - count];
        for (int i = 0, j = 0; i < arr2.length; i++, j++) {
            arr2[j] = arr[i];
        }
        return arr2;
    }

    //Метод для задания 3
    public static char[] myTrim(char[] arr) {
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                leftCount++;
            } else {
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                rightCount++;
            } else {
                break;
            }
        }
        char[] arr2 = new char[arr.length - leftCount - rightCount];
        for (int i = leftCount, j = 0; i < arr.length - rightCount; i++, j++) {
            arr2[j] = arr[i];
        }
        return arr2;
    }

    //Метод для задания 4
    public static boolean myEquals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    //Метод для задания 5
    public static boolean myStartsWith(char[] text, char[] arr) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    //Метод для задания 6 //TODO надо выполнить
//      Передаём строку, значение которое хотим поменять (или всю строку), значение на что хотим поменять (или полную строку). Просто (просто?)
//       Меняем на другое значение, возвращаем его
//    public static char[] myReplace (String fromString, String toSring){
//        char [] fromChar = fromString.toCharArray();
//        char [] toChar = toSring.toCharArray();
//        if (fromChar.length>=toChar.length){
//            for (int i = 0; i < toChar.length; i++) {
//                toChar[i]=fromChar[i];
//            }
//        } else {
//            for (int i = 0; i < fromChar.length; i++) {
//                toChar[i]=fromChar[i];
//            }
//        }
//
//
//        //char [] finalchar;
//        return toChar;
//    }
    //Метод для задания 7
    public static boolean myEqualsIgnoreCase(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            char first = (arr1[i] >= 'A' && arr1[i] <= 'Z') ? (char) (arr1[i] + 32) : arr1[i];
            char second = (arr2[i] >= 'A' && arr2[i] <= 'Z') ? (char) (arr2[i] + 32) : arr2[i];
            if (first != second) {
                return false;
            }
        }
        return true;
    }

    //Метод для задания 8
    public static char[] myConcat(char[] str1, char[] str2) {
        char[] concatedChar = new char[str1.length + str2.length];
        for (int i = 0; i < str1.length; i++) {
            concatedChar[i] = str1[i];
        }
        for (int i = str1.length, j = 0; i < concatedChar.length; i++, j++) {
            concatedChar[i] = str2[j];
        }
        return concatedChar;
    }

    //Метод для задания 9
    public static boolean myEndsWith(char[] text, char[] arr) {
        for (int i = arr.length - text.length, j = 0; i < arr.length; i++, j++) {
            if (text[j] == arr[i]) {
                return true;
            }
        }
        return false;
    }

    //Метод для задания 10
    public static char[] mySubstring(char[] text, int firstIndex, int lastIndex) {
        int size = lastIndex - firstIndex;
        char[] result = new char[size];
        for (int i = firstIndex, j = 0; i < lastIndex; i++, j++) {
            result[j] = text[i];
        }
        return result;
    }

    //Метод для задания 11
    public static char[] myToCharArray(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    //Метод для задания 12
    public static int myIndexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //Метод для задания 13
    public static int myIndexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //Метод для задания 14
    public static int myLastIndexOf(char[] arr, char ch) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //Метод для задания 15
    public static int myLastIndexOf(char[] arr, char ch, int fromIndex) {
        if (arr.length < fromIndex) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == ch) {
                    return i;
                }
            }
        } else {
            for (int i = fromIndex; i >= 0; i--) {
                if (arr[i] == ch) {
                    return i;
                }
            }
        }
        return -1;
    }

    //Метод для задания 16
    public static int myLastIndexOf(char[] arr, char[] text) {//todo не готово + нужно переделать на char[]

        if (arr.length > text.length) {
            for (int i = 0; i < arr.length; i++) {

            }
        }
        return -1;
    }
    //Метод для задания 17
    //Метод для задания 18
    //Метод для задания 19
    //Метод для задания 20
    //Метод для задания 21

    public static void main(String[] args) {
        //1) lTrim - метод удаляет пробелы слева
        System.out.println("Задание 1. Вывод:");
        String str1 = "    Sonic Syndicate     ";
        char[] charray1 = str1.toCharArray();
        char[] result1 = myLeftTrim(charray1);
        System.out.println("Изначальная строка: " + str1);
        System.out.print("Измененная строка: ");
        myPrintArray(result1);
        System.out.println();

        //2) RTrim - метод удаляет пробелы справа
        System.out.println("Задание 2. Вывод:");
        String str2 = "    Breaking Benjamin    ";
        char[] charray2 = str2.toCharArray();
        char[] result2 = myRightTrim(charray2);
        System.out.println("Изначальная строка: " + str2);
        System.out.print("Измененная строка: ");
        myPrintArray(result2);
        System.out.println();

        //3) Trim - метод удаляет пробелы слева и справа
        System.out.println("Задание 3. Вывод:");
        String str3 = "    Linkin Park    ";
        char[] charray3 = str3.toCharArray();
        char[] result3 = myTrim(charray3);
        System.out.print("Изначальная строка: ");
        myPrintArray(charray3);
        System.out.print("Измененная строка: ");
        myPrintArray(result3);
        System.out.println("Проверочный метод: " + str3.trim());

        System.out.println();

        //4) equals - метод сравнивает строки с учетом регистра
        System.out.println("Задание 4. Вывод:");
        String str4_1 = "A Perfect Circle";
        String str4_2 = "a perfect circle";
        char[] charray4_1 = str4_1.toCharArray();
        char[] charray4_2 = str4_2.toCharArray();
        boolean result4 = myEquals(charray4_1, charray4_2);
        System.out.println("Сравниваем строки с учетом регистра:\nПервая строка: \"" +
                str4_1.concat("\"\nВторая строка: \"" + str4_2 + "\""));
        System.out.println("Ответ: " + (result4 ? "Строки одинаковы" : "Строки не одинаковы"));
        System.out.print("Проверочный метод: ");
        System.out.println(str4_1.equals(str4_2) ? "Строки одинаковы" : "Строки не одинаковы");
        System.out.println();

        //5) startsWith - метод проверяет, начинается ли строка с указанной строки
        System.out.println("Задание 5. Вывод:");
        String str5 = "The animal in me";
        String taskText5 = "the";
        char[] charray5 = str5.toCharArray();
        char[] taskTextChar5 = taskText5.toCharArray();
        boolean result5 = myStartsWith(taskTextChar5, charray5);
        System.out.println(str5);
        System.out.println("Строка начинается с " + "\"" + taskText5 + "\"" + "? Ответ: " + (result5 ? "Да" : "Нет"));
        System.out.println("Проверочный метод:\nСтрока начинается с " + "\"" + taskText5 + "\"" + "? Ответ: " +
                (str5.startsWith(taskText5) ? "Да" : "Нет"));
        System.out.println();

        //6) replace - метод заменяет старую строку на новую //TODO не готово
        System.out.println("Задание 6. Вывод:");
        String str6_1 = "Aria";
        String str6_2 = "Kipelov";
        System.out.println("Было: " + str6_1);
        // char [] result6 = myReplace(str6_1,str6_2);
        //  System.out.println(result6);
        // System.out.println("Стало: " + str6.replace("Aria", "Kipelov"));
        System.out.println("Проверочный метод:");
        System.out.println("Было: " + str6_1);
        System.out.println("Стало: " + str6_1.replace("Aria", "Kipelov"));
        System.out.println();

        //7) equalsIgnoreCase - метод сравнивает строки без учета регистра
        System.out.println("Задание 7. Вывод:");
        String str7_1 = "Papa ROACH";
        String str7_2 = "papa roach";
        char[] charray7_1 = str7_1.toCharArray();
        char[] charray7_2 = str7_2.toCharArray();
        boolean result7 = myEqualsIgnoreCase(charray7_1, charray7_2);
        System.out.println("Сравниваем строки без учета регистра:\nПервая строка: \"" +
                str7_1.concat("\"\nВторая строка: \"" + str7_2 + "\""));
        System.out.println("Ответ: " + (result7 ? "Строки одинаковы" : "Строки не одинаковы"));
        System.out.println("Проверочный метод: " + (str7_1.equalsIgnoreCase(str7_2) ?
                "Строки одинаковы" : "Строки не одинаковы"));
        System.out.println();
        System.out.println();

        //8) concat - метод, который добавляет к текущей строке новую строку
        System.out.println("Задание 8. Вывод:");
        String str8_1 = "Nine Inch"; // Nails
        String str8_2 = " Nails";
        char[] charray8_1 = str8_1.toCharArray();
        char[] charray8_2 = str8_2.toCharArray();
        char[] result8 =  myConcat(charray8_1, charray8_2);
        System.out.println("Исходная первая строка: \"" + str8_1 + "\"\nИсходная вторая строка: \"" + str8_2 + "\"");
        System.out.print("Склеиваем и получаем: ");
        myPrintArray(result8);
        System.out.println("Проверочный метод: "+ str8_1.concat(str8_2));
        System.out.println();

        //9) endsWith - метод проверяет, заканчивается ли строка на указанную строку
        System.out.println("Задание 9. Вывод:");
        String str9 = "Justin Timberlake"; // lake
        String taskText9 = "lake";
        char[] charray9 = str9.toCharArray();
        char[] taskTextChar9 = taskText9.toCharArray();
        boolean result9 = myEndsWith(taskTextChar9, charray9);
        System.out.println(str9);
        System.out.println("Строка заканчивается на " + "\"" + taskText9 + "\"" + "? Ответ: " + (result9 ? "Да" : "Нет"));
        System.out.println("Проверочный метод: \nСтрока заканчивается на " + "\"" + taskText9 + "\"" + "? Ответ: " +
                (str9.endsWith(taskText9) ? "Да" : "Нет"));
        System.out.println();

        //10) substring - метод извлекается подстроку из текущей строки
        System.out.println("Задание 10. Вывод:");
        String str10 = "Fatboy Slim";
        int index10_1 = 3;
        int index10_2 = 6;
        char[] charray10 = str10.toCharArray();
        char[] result10 = mySubstring(charray10, index10_1, index10_2);
        System.out.println("Исходная строка: " + str10);
        System.out.print("Выводим строку между индексом " + index10_1 + " и индексом " + index10_2 + " : ");
        myPrintArray(result10);
        System.out.println("Проверочный метод: " + str10.substring(index10_1, index10_2));
        System.out.println();

        //11) toCharArray - метод, который конвертирует строку в массив char
        System.out.println("Задание 11. Вывод:");
        String str11 = "Bring Me The Horizon";
        char[] result11 = myToCharArray(str11);
        System.out.println("Преобразовываем строку \"" + str11 + "\" в массив: ");
        myPrintArray(result11);
        System.out.println("Проверочный метод:");
        char[] chars11 = str11.toCharArray();
        myPrintArray(chars11);
        System.out.println();

        //12) indexOf(char a) - метод возвращает индекс данного символа
        System.out.println("Задание 12. Вывод:");
        String str12 = "Green Day";
        char[] charray12 = str12.toCharArray();
        char taskChar12 = 'e';
        myPrintArray(charray12);
        int result12 = myIndexOf(charray12, taskChar12);
        System.out.println("Символ \"" + taskChar12 + "\" находится в индексе " + result12);
        System.out.println("Проверочный метод:");
        System.out.println("Символ \"" + taskChar12 + "\" находится в индексе " + str12.indexOf(taskChar12));
        System.out.println();

        //13) indexOf(char a , int fromIndex) - метод возвращает индекс данного СИМВОЛА?, если оно есть и начинается с указанного индекса, иначе = -1
        System.out.println("Задание 13. Вывод:");
        String str13 = "Red Hot Chili Peppers";
        char[] charray13 = str13.toCharArray();
        char taskChar13 = 'i';
        int fromIndex13 = 5;
        myPrintArray(charray13);
        int result13 = myIndexOf(charray13, taskChar13, fromIndex13);
        System.out.println("Символ \"" + taskChar13 + "\" находится в индексе " + result13);
        System.out.println("Проверочный метод:");
        System.out.println("Символ \"" + taskChar13 + "\" находится в индексе " + str13.indexOf(taskChar13, fromIndex13));
        System.out.println();

        //14) lastIndexOf(char a) - метод возвращает индекс данного символа с конца строки, иначе = -1
        System.out.println("Задание 14. Вывод:");
        String str14 = "Blue Foundation";
        char[] charray14 = str14.toCharArray();
        char taskChar14 = 'u';
        myPrintArray(charray14);
        int result14 = myLastIndexOf(charray14, taskChar14);
        System.out.println("Последний индекс символа \"" + taskChar14 + "\" равен: " + result14);
        System.out.println("Проверочный метод:");
        System.out.println("Последний индекс символа \"" + taskChar14 + "\" равен: " + str14.lastIndexOf(taskChar14));
        System.out.println();

        //15) lastIndexOf(char a , int fromIndex) - метод возвращает индекс данного СИМВОЛА? с конца строки, если оно есть начиная с индекса, иначе = -1
        System.out.println("Задание 15. Вывод:");
        String str15 = "Bullet for my Valentine";
        char[] charray15 = str15.toCharArray();
        char taskChar15 = 'e';
        int fromIndex15 = 100;
        myPrintArray(charray15);
        int result15 = myLastIndexOf(charray15, taskChar15, fromIndex15);
        System.out.println("Последний индекс символа \"" + taskChar15 + "\" равен: " + result15);
        System.out.println("Проверочный метод:");
        System.out.println("Последний индекс символа \"" + taskChar15 + "\" равен: " + str15.lastIndexOf(taskChar15, fromIndex15));
        System.out.println();

        //16) lastIndexOf(char[] a) - метод возвращает индекс данного слова с конца строки, если оно есть, иначе = -1 //TODO не готово
        System.out.println("Задание 16. Вывод:");
        String str16 = "Nickelback"; //back
        String taskText16 = "kel";
        char[] charray16 = str16.toCharArray();
        char[] taskTextChar16 = taskText16.toCharArray();
        myPrintArray(charray16);
        int result16 = myLastIndexOf(charray16, taskTextChar16);
        System.out.println("Последний индекс слова " + taskText16 + " равен: " + result16);
        System.out.print("Проверочный метод: ");
        System.out.println(str16.lastIndexOf(taskText16));
        System.out.println();

        //17) indexOf(char[] a) - метод возвращает индекс данного слова если оно есть, иначе = -1
        System.out.println("Задание 17. Вывод:");
        String str17 = "Alien Ant Farm";
        String taskText17 = "Ant";
        char[] charray17 = str17.toCharArray();
        char[] taskTextChar17 = taskText17.toCharArray();

        System.out.print("Проверочный метод: ");
        System.out.println(str17.indexOf(taskText17));
        System.out.println();

        //18) indexOf(char[] a , int fromIndex) - метод возвращает индекс данного слова, если оно есть и начинается с указанного индекса, иначе =-1
        System.out.println("Задание 18. Вывод:");
        String str18 = "God Is An Astronaut";

        System.out.print("Проверочный метод: ");
        System.out.println(str18.indexOf("Is", 3));
        System.out.println();

        //19) lastIndexOf(char[] a , int fromIndex) - метод возвращает индекс данного слова с конца строки, если оно есть и начинается с индекса, иначе =-1
        System.out.println("Задание 19. Вывод:");
        String str19 = "Creedence Clearwater Revival";

        System.out.print("Проверочный метод: ");
        System.out.println(str19.lastIndexOf("Clear", 30));
        System.out.println();

        //20) contains - метод проверяет, содержит ли строка указанную строку
        System.out.println("Задание 20. Вывод:");
        String str20 = "Thirty Seconds to Mars";

        System.out.print("Проверочный метод: ");
        System.out.println(str20.contains("Seconds"));
        System.out.println();

        //21) split - метод разделяет строку на подстроку
        System.out.println("Задание 21. Вывод:");
        String str21 = "Thomas Bergersen, Two Steps From Hell";

        System.out.println("Проверочный метод:");
        String[] result21 = str21.split(", ");
        myPrintArray(result21);
        System.out.println();


    }
}