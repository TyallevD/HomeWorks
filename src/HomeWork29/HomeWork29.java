package HomeWork29;

import java.util.ArrayList;
import java.util.Collection;

class MySet<E> {
    private ArrayList<E> elements;  // Динамический массив для хранения элементов

    // Конструктор
    public MySet() {
        elements = new ArrayList<>();
    }

    // 1. Добавляет элемент в множество, если его еще нет
    public boolean add(E e) {
        // TODO: Реализация
        if (elements.contains(e)) {
            return false;
        } else {
            elements.add(e);
            return true;
        }
    }

    // 2. Удаляет элемент из множества
    public boolean remove(Object o) {
        // TODO: Реализация
        if (elements.contains(o)) {
            elements.remove(o);
            return true;
        } else {
            return false;
        }
    }

    // 3. Проверяет, содержит ли множество указанный элемент
    public boolean contains(Object o) {
        // TODO: Реализация
        return elements.contains(o);
    }

    // 4. Возвращает количество элементов в множестве
    public int size() {
        // TODO: Реализация
        return elements.size();
    }

    // 5. Проверяет, пусто ли множество
    public boolean isEmpty() {
        // TODO: Реализация
        return elements.isEmpty();
    }

    // 6. Удаляет все элементы из множества
    public void clear() {
        // TODO: Реализация
        elements.clear();
        System.out.println("Множество очищено");
    }

    // 7. Добавляет все элементы из указанной коллекции в множество
    public boolean addAll(Collection<? extends E> c) {
        // TODO: Реализация
        return false;
    }

    // 8. Проверяет, содержит ли множество все элементы из указанной коллекции
    public boolean containsAll(Collection<?> c) {
        // TODO: Реализация
        return false;
    }

    // 9. Удаляет из множества все элементы, которые есть в указанной коллекции
    public boolean removeAll(Collection<?> c) {
        // TODO: Реализация
        return false;
    }

    // 10. Сохраняет только те элементы, которые есть в указанной коллекции
    public boolean retainAll(Collection<?> c) {
        // TODO: Реализация
        return false;
    }

    @Override
    public String toString() {
        return "" + elements;
    }
}

public class HomeWork29 {
    public static void main(String[] args) {
        // 1. Добавляет элемент в множество, если его еще нет
        System.out.println("Задание 1. Вывод:");
        MySet set1 = new MySet<>();
        set1.add(1);
        set1.add("Строка 2");
        set1.add(2);
        set1.add(3);
        set1.add(4);
        System.out.println(set1);
        System.out.println();

        // 2. Удаляет элемент из множества
        System.out.println("Задание 2. Вывод:");
        MySet set2 = new MySet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println(set2);

        System.out.println("Удаляемое значение есть в списке? " + (set2.remove(2) ? "Да" : "Нет"));
        System.out.println("Удаляемое значение есть в списке? " + (set2.remove(5) ? "Да" : "Нет"));
        System.out.println(set2);
        System.out.println();

        // 3. Проверяет, содержит ли множество указанный элемент
        System.out.println("Задание 3. Вывод:");
        //todo contains()
        MySet set3 = new MySet<>();
        set3.add(1);
        set3.add(2);
        set3.add(3);
        System.out.println(set3);

        System.out.println("Значение есть в списке? " + (set3.contains(2) ? "Да" : "Нет"));
        System.out.println("Значение есть в списке? " + (set3.contains(5) ? "Да" : "Нет"));
        System.out.println();

        // 4. Возвращает количество элементов в множестве
        System.out.println("Задание 4. Вывод:");
        //todo size()
        MySet set4 = new MySet<>();
        set4.add(1);
        set4.add(2);
        set4.add(3);
        set4.add(4);
        System.out.println(set4);

        System.out.println("Размер = " + set4.size());
        System.out.println();

        // 5. Проверяет, пусто ли множество
        System.out.println("Задание 5. Вывод:");
        //todo isEmpty()
        MySet set5_1 = new MySet<>();
        set5_1.add(1);
        set5_1.add(2);
        set5_1.add(3);
        set5_1.add(4);
        System.out.println(set5_1);
        MySet set5_2 = new MySet<>();
        System.out.println("Пустой? " + (set5_1.isEmpty() ? "Да" : "Нет"));
        System.out.println("Пустой? " + (set5_2.isEmpty() ? "Да" : "Нет"));
        System.out.println();

        // 6. Удаляет все элементы из множества
        System.out.println("Задание 6. Вывод:");
        //todo clear()
        MySet set6 = new MySet<>();
        set6.add(1);
        set6.add(2);
        set6.add(3);
        set6.add(4);
        set6.add(5);
        System.out.println(set6);

        set6.clear();
        System.out.println();

        // 7. Добавляет все элементы из указанной коллекции в множество
        System.out.println("Задание 7. Вывод:");
        //todo addAll()
        MySet set7_1 = new MySet<>();
        set7_1.add(1);
        set7_1.add(2);
        set7_1.add(3);
        set7_1.add(4);
        System.out.println(set7_1);
        MySet set7_2 = new MySet<>();
        set7_2.add(5);
        set7_2.add(6);
        set7_2.add(7);
        set7_2.add(8);
        System.out.println(set7_2);

//        set7_1.addAll((Collection) set7_2);
        System.out.println();

        // 8. Проверяет, содержит ли множество все элементы из указанной коллекции
        System.out.println("Задание 8. Вывод:");
        //todo containsAll()
        MySet set8_1 = new MySet<>();
        set8_1.add(1);
        set8_1.add(2);
        set8_1.add(3);
        set8_1.add(4);
        System.out.println(set8_1);
        MySet set8_2 = new MySet<>();
        set8_2.add(1);
        set8_2.add(2);
        set8_2.add(3);
        set8_2.add(4);
        System.out.println(set8_2);

//        set8_1.containsAll((Collection<?>) set8_2);
        System.out.println();

        // 9. Удаляет из множества все элементы, которые есть в указанной коллекции
        System.out.println("Задание 9. Вывод:");
        //todo removeAll()
        MySet set9_1 = new MySet<>();
        set9_1.add(1);
        set9_1.add(2);
        set9_1.add(3);
        set9_1.add(4);
        set9_1.add(5);
        System.out.println(set9_1);
        MySet set9_2 = new MySet<>();
        set9_2.add(2);
        set9_2.add(5);
        System.out.println(set9_2);

//        set9_1.removeAll((Collection<?>) set9_2);
        System.out.println();

        // 10. Сохраняет только те элементы, которые есть в указанной коллекции
        System.out.println("Задание 10. Вывод:");
        //todo retainAll()
        MySet set10 = new MySet<>();
        set10.add(1);
        set10.add(2);
        set10.add(3);
        set10.add(4);
        set10.add(5);
        System.out.println(set10);

    }
}
