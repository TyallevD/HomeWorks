package JavaBasic.HomeWork25;

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
    public void removeByValue(T value) {
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (value.equals(arr[i])) {
                j++;
            }
            arr[i] = arr[j];
        }
        size--;
    }

    //метод для задания 2
    public void removeByIndex(int index) {
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (index == i) {
                j++;
            }
            arr[i] = arr[j];
        }
        size--;
    }

    //метод для задания 3
    public boolean isHasValue(T value) {
        for (T values : arr) {
            if (value.equals(values)) {
                return true;
            }
        }
        return false;
    }
}

public class HomeWork25 {
    public static void main(String[] args) {
        //1. public void removeByValue(int value)
        System.out.println("Задание 1. Вывод:");
        MyList myList1 = new MyList();
        myList1.add(1);
        myList1.add(2);
        myList1.add(3);
        myList1.add(1);
        System.out.print("Исходный массив: ");
        myList1.printInfo();

        myList1.removeByValue(1);
        System.out.print("Измененный массив: ");
        myList1.printInfo();
        System.out.println();

        //2. public void removeByIndex(int index)
        System.out.println("Задание 2. Вывод:");
        MyList myList2 = new MyList();
        myList2.add(1);
        myList2.add(2);
        myList2.add(3);
        myList2.add(4);
        System.out.print("Исходный массив: ");
        myList2.printInfo();

        myList2.removeByIndex(1);
        System.out.print("Измененный массив: ");
        myList2.printInfo();
        System.out.println();

        // public boolean isHasValue(int value)
        System.out.println("Задание 3. Вывод:");
        MyList myList3 = new MyList();
        myList3.add(1);
        myList3.add(2);
        myList3.add(3);
        myList3.add(4);
        System.out.print("Исходный массив: ");
        myList3.printInfo();

        System.out.println("Значение есть в массиве? Ответ: " + (myList3.isHasValue(3) ? "да" : "нет"));
        System.out.println("Значение есть в массиве? Ответ: " + (myList3.isHasValue(15) ? "да" : "нет"));
    }
}