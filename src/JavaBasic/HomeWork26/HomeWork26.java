package JavaBasic.HomeWork26;

class MyList<T> {
    private T[] arr;
    private int size;
    private int capacity;

    {
        capacity = 10;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void increaseArray() {
        if (size >= capacity) {
            System.out.print("Массив был пересоздан, ёмкость до: " + capacity);
            capacity = capacity * 2 + 2;
            System.out.println(", после: " + capacity);
            T[] tmp = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
    }

    public void add(T value) {
        increaseArray();
        arr[size] = value;
        size++;
    }

    public void printInfo() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //метод для задания 1
    public void clear() {
        arr = (T[]) new Object[capacity];
        size = 0;
        System.out.println("Лист очищен");
    }

    //метод для задания 2
    public boolean isHasValue(T value) {
        for (T values : arr) {
            if (value.equals(values)) {
                return true;
            }
        }
        return false;
    }

    //метод для задания 3
    public int indexOf(T value) {
        for (int i = 0; i < arr.length; i++) {
            if (value.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    //метод для задания 4
    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Индекс вне диапазона");
            return;
        }
        if (size <= 0) {
            System.out.println("Лист очищен полностью");
            return;
        }
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (index == i) {
                j++;
            }
            arr[i] = arr[j];
        }
        size--;
        decreaseArr();
    }

    //метод для задания 5
    public void removeByValue(T value) {
        if (size <= 0) {
            System.out.println("Лист очищен полностью");
            return;
        }
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (value.equals(arr[i])) {
                j++;
            }
            arr[i] = arr[j];
        }
        size--;
        decreaseArr();
    }

    //метод для задания 6
    public void addAll(MyList list) {
        for (int i = 0; i < list.size; i++) {
            add((T) list.arr[i]);
        }
    }

    //метод для задания 7
    public void removeAllDuplicate() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; ) {
                if (arr[i].equals(arr[j])) {
                    removeByIndex(j);
                } else {
                    j++;
                }
            }
        }
    }

    //метод для задания 8
    public void decreaseArr() {
        if (size < (capacity - 2) / 2) {
            System.out.print("Массив был пересоздан, ёмкость до: " + capacity);
            capacity = (capacity - 2) / 2;
            System.out.println(", после: " + capacity);
            T[] tmp = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
    }

    //вспомогательный метод для задания 8
    public void removeLast() {
        if (size <= 0) {
            System.out.println("Лист очищен полностью");
            return;
        }
        for (int i = 0, j = 0; j < size - 1; i++, j++) {
            arr[i] = arr[j];
        }
        size--;
        decreaseArr();
    }
}

public class HomeWork26 {
    public static void main(String[] args) {
//   1   public void clear()
        System.out.println("Задание 1. Вывод:");
        MyList myList1 = new MyList();
        myList1.add(1);
        myList1.add(2);
        myList1.add(3);
        myList1.add(4);
        myList1.add(5);
        System.out.println("Исходный список:");
        myList1.printInfo();

        myList1.clear();
        myList1.add(6);
        System.out.println("Измененный список:");
        myList1.printInfo();
        System.out.println();

//   2   public boolean isHasValue(int value)
        System.out.println("Задание 2. Вывод:");
        MyList myList2 = new MyList();
        myList2.add("One");
        myList2.add("Two");
        myList2.add("Three");
        myList2.add("Four");
        myList2.add("Five");
        myList2.printInfo();

        System.out.println("Значение есть в списке? Ответ: " + (myList2.isHasValue("Five") ? "Да" : "Нет"));
        System.out.println("Значение есть в списке? Ответ: " + (myList2.isHasValue("Пять") ? "Да" : "Нет"));
        System.out.println();

//   3   public int indexOf(int value)
        System.out.println("Задание 3. Вывод:");
        MyList myList3 = new MyList();
        myList3.add('1');
        myList3.add('2');
        myList3.add('3');
        myList3.add('4');
        myList3.add('5');
        myList3.printInfo();

        System.out.println("Индекс  = " + myList3.indexOf('5'));
        System.out.println();

//   4   public void removeByIndex(int index)
        System.out.println("Задание 4. Вывод:");
        MyList myList4 = new MyList();
        myList4.add('A');
        myList4.add('B');
        myList4.add('C');
        myList4.add('D');
        myList4.add('E');
        System.out.println("Исходный список:");
        myList4.printInfo();

        myList4.removeByIndex(3);
        myList4.removeByIndex(-5); //вернёт сообщение, что индекс вне диапазона
        myList4.removeByIndex(15); //аналогично вернёт сообщение, что индекс вне диапазона
        System.out.println("Измененный список:");
        myList4.printInfo();
        System.out.println();

//   5   public void removeByValue(int value)
        System.out.println("Задание 5. Вывод:");
        MyList myList5 = new MyList();
        myList5.add(0.5);
        myList5.add(1.0);
        myList5.add(1.5);
        myList5.add(2.0);
        myList5.add(2.5);
        System.out.println("Исходный список:");
        myList5.printInfo();

        myList5.removeByValue(0.5);
        System.out.println("Измененный список:");
        myList5.printInfo();
        System.out.println();

//   6   public void addAll(Integer[] arr)
        System.out.println("Задание 6. Вывод:");
        MyList myList6 = new MyList();
        myList6.add("Six");
        myList6.add("Seven");
        myList6.add("Eight");
        myList6.add("Nine");
        myList6.add("Ten");
        System.out.println("Исходный список:");
        myList6.printInfo();

        myList2.addAll(myList6);
        System.out.println("Измененный список:");
        myList2.printInfo();
        System.out.println();

//   7   public void removeAllDuplicate()
        System.out.println("Задание 7. Вывод:");
        MyList myList7 = new MyList();
        myList7.add("one");
        myList7.add("two");
        myList7.add("three");
        myList7.add("one");
        myList7.add("four");
        myList7.add("one");
        myList7.add("five");
        System.out.println("Исходный список:");
        myList7.printInfo();

        myList7.removeAllDuplicate();
        System.out.println("Измененный список:");
        myList7.printInfo();
        System.out.println();

//   8   public void decreaseArr()
        System.out.println("Задание 8. Вывод:");
        MyList myList8 = new MyList();
        System.out.println("Сначала заполняем и смотрим что получилось:");
        for (int i = 1; i <= 50; i++) {
            myList8.add(i);
        }
        myList8.printInfo();
        System.out.println();

        System.out.println("Затем удаляем и смотрим, что получается");
        for (int i = 0; i < 51; i++) {
            myList8.removeLast(); //вспомогательный метод, который удаляет последнее значение в списке
        }
        myList8.printInfo();
    }
}
