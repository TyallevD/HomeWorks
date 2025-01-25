package HomeWork25;

class MyList {//todo возможно сделать через дженерик
    private int[] arr;
    private int size;
    private int capacity;

    {
        capacity = 10;
        size = 0;
        arr = new int[capacity];
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
            int[] tmp = new int[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
    }

    public void add(int value) {
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
    public void removeByValue(int value) {

    }

    //метод для задания 2
    public void removeByIndex(int index) {

    }

    //метод для задания 3
    public boolean isHasValue(int value) {
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
        System.out.print("Исходный массив: ");
        myList1.printInfo();

        myList1.removeByValue(2); //todo реализовать удаление по значению
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

        myList2.removeByIndex(1); //todo реализовать удаление по индексу
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

        String answer = myList3.isHasValue(3) ? "да" : "нет"; //todo реализовать ответ на вопрос есть или нет значение в массиве
        System.out.println(answer);
    }
}