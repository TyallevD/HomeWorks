package JavaBasic.HomeWork23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork23 {
    public static void main(String[] args) {
        //1. Создайте обобщённый метод для вывода элементов.
        //Напишите метод printElement, который принимает один параметр любого типа (T) и выводит его значение в консоль.
        printElement("Задание 1. Вывод:");
        printElement("String");
        printElement('A');
        printElement(1);
        printElement(0.5f);
        System.out.println();

        //2. Создайте обобщённый метод для работы с массивами.
        //Напишите метод getFirstElement, который принимает массив любого типа (T[]) и возвращает его первый элемент.
        System.out.println("Задание 2. Вывод:");
        Character[] charray = new Character[]{'a', 'b', 'c', 'd'};
        System.out.println("Первый элемент массива charray: " + getFirstElement(charray));

        Integer[] ints = new Integer[]{1, 2, 3, 4, 5};
        System.out.println("Первый элемент массива ints: " + getFirstElement(ints));
        System.out.println();

        //3. Напишите метод для проверки равенства.
        //Реализуйте метод isEqual, который принимает два параметра одного типа (T) и возвращает true, если они равны.
        System.out.println("Задание 3. Вывод:");
        System.out.println(isEqual(1, 2));
        System.out.println(isEqual(1, 1));
        System.out.println(isEqual(true, true));
        System.out.println(isEqual("one", "two"));
        System.out.println(isEqual('a', 'a'));
        System.out.println();

        //4. Создайте обобщённый класс для хранения пары.
        //Напишите класс Pair<T1, T2>, который хранит два значения (T1 и T2). Реализуйте методы getFirst() и getSecond().
        System.out.println("Задание 4. Вывод:");
        Pair pair = new Pair("one", 2);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println();

        //5. Обобщённый метод для реверса массива.
        //Напишите метод reverseArray, который принимает массив любого типа (T[]) и возвращает новый массив с элементами в обратном порядке.
        System.out.println("Задание 5. Вывод:");
        Integer[] array1 = new Integer[]{1, 2, 3, 4, 5};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(array1));
        System.out.print("Измененный массив: ");
        System.out.println(Arrays.toString(reverseArray(array1)));
        System.out.println();

        String[] strings = new String[]{"раз", "два", "три", "четыре", "пять"};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(strings));
        System.out.print("Измененный массив: ");
        System.out.println(Arrays.toString(reverseArray(strings)));
        System.out.println();

        //6. Сравнение элементов.
        //Реализуйте метод compareElements, который принимает два элемента одного типа (T) и возвращает строку:
        //"Элементы равны" — если они равны.
        //"Элементы не равны" — если они различны.
        System.out.println("Задание 6. Вывод:");
        Integer int1 = 1;
        Integer int2 = 2;
        Integer int3 = 1;
        System.out.println("Сравниваем числовые значения");
        compareElements(int1, int2);
        compareElements(int1, int3);
        System.out.println();

        System.out.println("Сравниваем символьные значения");
        Character ch1 = 'a';
        Character ch2 = 'b';
        Character ch3 = 'a';
        compareElements(ch1, ch2);
        compareElements(ch1, ch3);
        System.out.println();


        System.out.println("Сравниваем символьное и числовое значения");
        compareElements(ch1, int1);
        System.out.println();

        //7. Создайте обобщённый метод для поиска элемента.
        //Напишите метод findIndex, который принимает массив (T[]) и элемент (T) и возвращает индекс первого вхождения элемента в массив (или -1, если элемент не найден).
        System.out.println("Задание 7. Вывод:");
        Integer[] ints7 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer element7 = 8;
        System.out.println(Arrays.toString(ints7));
        System.out.println("Значение элемента " + element7 + " в индексе: " + findIndex(ints7, element7));
        System.out.println();

        Character[] chars7 = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Character character7 = 'x';
        System.out.println(Arrays.toString(chars7));
        System.out.println("Значение элемента \"" + character7 + "\" в индексе: " + findIndex(chars7, character7));
        System.out.println("Значение элемента \"" + element7 + "\" в индексе: " + findIndex(chars7, element7));
        System.out.println();

        //8. Обобщённый метод для создания списка.
        //Реализуйте метод toList, который принимает массив любого типа (T[]) и возвращает список (List<T>), содержащий те же элементы.
        System.out.println("Задание 8. Вывод:");
        Integer[] ints8 = new Integer[]{23, 52, 11, 63, 13};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(ints8));
        System.out.print("Лист: ");
        System.out.println(toList(ints8));
        System.out.println();

        String[] strings8 = new String[]{"Раз", "Два", "Три", "Четыре"};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(strings8));
        System.out.print("Лист: ");
        System.out.println(toList(strings8));
        System.out.println();

        //9. Метод для копирования массива.
        //Напишите метод copyArray, который принимает массив любого типа (T[]) и возвращает его копию.
        System.out.println("Задание 9. Вывод:");
        Character[] chars9 = new Character[]{'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(chars9));
        System.out.print("Копия массива: ");
        System.out.println(Arrays.toString(copyArray(chars9)));
        System.out.println();

        //10. Создайте класс для хранения трёх объектов.
        //Реализуйте класс Triple<T1, T2, T3>, который содержит три поля разных типов (T1, T2, T3). Добавьте методы для установки и получения значений.
        System.out.println("Задание 10. Вывод:");
        Triple triple = new Triple<>();
        triple.setFirst("Строка");
        triple.setSecond(1);
        triple.setThird('A');
        System.out.println("Первый элемент: \"" + triple.getFirst() +
                "\"\nВторой элемент: \"" + triple.getSecond() +
                "\"\nТретий элемент: \"" + triple.getThird() + "\"");

    }

    //метод для задания 1
    private static <T> void printElement(T element) {
        System.out.println(element);
    }

    //метод для задания 2
    private static <T> T getFirstElement(T[] elements) {
        return elements[0];
    }

    //метод для задания 3
    private static <T> boolean isEqual(T one, T two) {
        return one == two;
    }

    //метод для задания 5
    private static <T> T[] reverseArray(T[] array) {
        T[] reversedArray = (T[]) new Object[array.length];
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    //метод для задания 6
    private static <T> void compareElements(T one, T two) {
        if (one.equals(two)) {
            System.out.println("Элементы " + one + " и " + two + " равны");
        } else {
            System.out.println("Элементы " + one + " и " + two + " не равны");
        }
    }

    //метод для задания 7
    private static <T> int findIndex(T[] array, T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //метод для задания 8
    private static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            list.add(i, array[i]);
//        }
        for (T values : array) {
            list.add(values);
        }
        return list;
    }

    //метод для задания 9
    private static <T> T[] copyArray(T[] array) {
        T[] arrayCopy = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[i];
        }
        return arrayCopy;
    }
}

//класс для задания 4
class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }
}

// класс для задания 10
class Triple<T1, T2, T3> {
    private T1 first;
    private T2 second;
    private T3 third;

    public Triple() {
    }

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public T3 getThird() {
        return third;
    }

    public void setThird(T3 third) {
        this.third = third;
    }
}