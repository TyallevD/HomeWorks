package JavaBasic.HomeWork29;

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
        if (elements.contains(e)) {
            return false;
        } else {
            elements.add(e);
            return true;
        }
    }

    // 2. Удаляет элемент из множества
    public boolean remove(Object o) {
        if (elements.contains(o)) {
            elements.remove(o);
            return true;
        } else {
            return false;
        }
    }

    // 3. Проверяет, содержит ли множество указанный элемент
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    // 4. Возвращает количество элементов в множестве
    public int size() {
        return elements.size();
    }

    // 5. Проверяет, пусто ли множество
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // 6. Удаляет все элементы из множества
    public void clear() {
        elements.clear();
        System.out.println("Множество очищено");
    }

    // 7. Добавляет все элементы из указанной коллекции в множество
    public boolean addAll(Collection<? extends E> c) {
        boolean isAdded = false;
        for (E value : c) {
            if (add(value)) {
                isAdded = true;
            }
        }
        return isAdded;
    }

    // 8. Проверяет, содержит ли множество все элементы из указанной коллекции
    public boolean containsAll(Collection<?> c) {
        boolean isContains = false;
        for (Object value : c) {
            if (contains(value)) {
                isContains = true;
            }
        }
        return isContains;
    }

    // 9. Удаляет из множества все элементы, которые есть в указанной коллекции
    public boolean removeAll(Collection<?> c) {
        boolean isRemoved = false;
        for (Object value : c) {
            if (elements.contains(value)) {
                elements.remove(value);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    // 10. Сохраняет только те элементы, которые есть в указанной коллекции
    public boolean retainAll(Collection<?> c) {
        boolean isAdded = false;
        for (Object value : c) {
            if (!elements.contains(value)) {
                elements.add((E) value);
                isAdded = true;
            }
        }
        return isAdded;
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
        System.out.println("Полученное множество");
        System.out.println(set1);
        System.out.println();

        // 2. Удаляет элемент из множества
        System.out.println("Задание 2. Вывод:");
        MySet set2 = new MySet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println("Изначальное множество:");
        System.out.println(set2);

        System.out.println("Удаляемое значение есть в списке? " + (set2.remove(2) ? "Да" : "Нет"));
        System.out.println("Удаляемое значение есть в списке? " + (set2.remove(5) ? "Да" : "Нет"));
        System.out.println("Измененное множество:");
        System.out.println(set2);
        System.out.println();

        // 3. Проверяет, содержит ли множество указанный элемент
        System.out.println("Задание 3. Вывод:");
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
        MySet set4 = new MySet<>();
        set4.add(1);
        set4.add(2);
        set4.add(3);
        set4.add(4);
        System.out.println(set4);

        System.out.println("Размер множества = " + set4.size());
        System.out.println();

        // 5. Проверяет, пусто ли множество
        System.out.println("Задание 5. Вывод:");
        MySet set5_1 = new MySet<>();
        set5_1.add(1);
        set5_1.add(2);
        set5_1.add(3);
        set5_1.add(4);
        System.out.println(set5_1);

        MySet set5_2 = new MySet<>(); //пустое множество для проверки

        System.out.println("Множество пустое? Ответ: " + (set5_1.isEmpty() ? "Да" : "Нет"));
        System.out.println("Множество пустое? Ответ: " + (set5_2.isEmpty() ? "Да" : "Нет"));
        System.out.println();

        // 6. Удаляет все элементы из множества
        System.out.println("Задание 6. Вывод:");
        MySet set6 = new MySet<>();
        set6.add(1);
        set6.add(2);
        set6.add(3);
        set6.add(4);
        set6.add(5);
        System.out.println("Изначальное множество:");
        System.out.println(set6);

        set6.clear();
        System.out.println("Измененное множество:");
        System.out.println(set6);
        System.out.println();

        // 7. Добавляет все элементы из указанной коллекции в множество
        System.out.println("Задание 7. Вывод:");
        MySet set7 = new MySet<>();
        set7.add(1);
        set7.add(2);
        set7.add(3);
        set7.add(4);
        System.out.println("Изначальное множество:");
        System.out.println(set7);

        ArrayList list7 = new ArrayList<>();
        list7.add(5);
        list7.add(6);
        list7.add(7);
        list7.add(8);
        System.out.println("Коллекция, которую хотим добавить:");
        System.out.println(list7);

        set7.addAll(list7);
        System.out.println("Измененное множество:");
        System.out.println(set7);
        System.out.println();

        // 8. Проверяет, содержит ли множество все элементы из указанной коллекции
        System.out.println("Задание 8. Вывод:");
        MySet set8 = new MySet<>();
        set8.add(1);
        set8.add(2);
        set8.add(3);
        set8.add(4);
        System.out.println(set8);

        ArrayList list8_1 = new ArrayList<>();
        list8_1.add(1);
        list8_1.add(2);
        list8_1.add(3);
        list8_1.add(4);
        System.out.println("Коллекция из элементов int:");
        System.out.println(list8_1);

        ArrayList list8_2 = new ArrayList<>();
        list8_2.add("1");
        list8_2.add("2");
        list8_2.add("3");
        list8_2.add("4");
        System.out.println("Коллекция из элементов String:");
        System.out.println(list8_2);

        System.out.println("Множество содержит все значения из коллекции " + list8_1 + " ? Ответ: " + (set8.containsAll(list8_1) ? "Да" : "Нет"));
        System.out.println("Множество содержит все значения из коллекции " + list8_2 + " ? Ответ: " + (set8.containsAll(list8_2) ? "Да" : "Нет"));
        System.out.println();

        // 9. Удаляет из множества все элементы, которые есть в указанной коллекции
        System.out.println("Задание 9. Вывод:");
        MySet set9 = new MySet<>();
        set9.add(1);
        set9.add(2);
        set9.add(3);
        set9.add(4);
        set9.add(5);
        System.out.println("Изначальное множество");
        System.out.println(set9);

        ArrayList list9_1 = new ArrayList<>();
        list9_1.add(2);
        list9_1.add(5);
        System.out.println("Коллекция для удаления из int:");
        System.out.println(list9_1);

        ArrayList list9_2 = new ArrayList<>();
        list9_2.add("2");
        list9_2.add("5");
        System.out.println("Коллекция для удаления из String:");
        System.out.println(list9_2);

        System.out.println("Удаляются элементы из коллекции " + list9_1 + " ? Ответ: " + (set9.removeAll(list9_1) ? "Да" : "Нет"));
        System.out.println("Удаляются элементы из коллекции " + list9_2 + " ? Ответ: " + (set9.removeAll(list9_2) ? "Да" : "Нет"));
        System.out.println("Измененное множество:");
        System.out.println(set9);
        System.out.println();

        // 10. Сохраняет только те элементы, которые есть в указанной коллекции
        System.out.println("Задание 10. Вывод:");
        MySet set10 = new MySet<>();
        set10.add(1);
        set10.add(2);
        set10.add(3);
        set10.add(4);
        set10.add(5);
        System.out.println("Изначальное множество:");
        System.out.println(set10);

        ArrayList list10 = new ArrayList();
        list10.add(6);
        list10.add(7);
        System.out.println("Коллекция для добавления:");
        System.out.println(list10);

        System.out.println("Добавляем коллекцию " + list10 + " в множество? " + (set10.retainAll(list10) ? "Да" : "Нет"));
        System.out.println("Измененное множество");
        System.out.println(set10);
        System.out.println();

        System.out.println("Добавляем коллекцию " + list10 + " в множество? " + (set10.retainAll(list10) ? "Да" : "Нет"));
        System.out.println("Проверяем, что ничего не изменилось:");
        System.out.println(set10);


    }
}
