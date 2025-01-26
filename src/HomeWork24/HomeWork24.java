package HomeWork24;

class MyList<T> {
    private T[] arr;

    public MyList() {
        arr = (T[]) new Object[0];
    }

    //метод для задания 1
    public void add(T value) {
        T[] tmp = (T[]) new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        tmp[arr.length] = value;
        arr = tmp;
    }

    //метод для задания 2
    public void add(T value, int index) {
        if (index < 0) { //добавление в начало, скорее стоит вывести в отдельный метод, но я сделал всё в одном
            T[] tmp = (T[]) new Object[arr.length + 1];
            for (int i = arr.length - 1; i >= 0; i--) {
                tmp[i + 1] = arr[i];
            }
            tmp[0] = value;
            arr = tmp;
        } else if (index >= arr.length + 1) { //добавление в конец массива, если переданный индекс больше размера массива (временного)
            add(value);
        } else { //добавление по индексу
            T[] tmp = (T[]) new Object[arr.length + 1]; //создаём временный массив с увеличенным на 1 элемент размер
            for (int i = 0, j = 0; i < tmp.length; i++) { //проходим по временному массиву и добавляем туда значения из исходного, минуя указанный индекс
                if (i != index) {
                    tmp[i] = arr[j];
                    j++;
                }
            }
            tmp[index] = value; //вставляем в указанный индекс переданное значение
            arr = tmp;
        }
    }

    //метод для задания 3
    public int size() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
        }
        return count;
    }

    //метод для задания 4
    public T get(int index) {
        if (index < 0 || index >= arr.length) {
            return (T) ("Индекс \"" + index + "\" за пределами массива");
        } else {
            return (T) ("Значение в индексе \"" + index + "\" равно: " + arr[index]);
        }
    }

    //метод для задания 5
    public void clear() {
        T[] tmp = (T[]) new Object[0];
        arr = tmp;
        System.out.println("Лист очищен");
    }

    //метод для задания 6
    public boolean removeValue(T value) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            T[] tmp = (T[]) new Object[arr.length - 1];
            for (int i = 0, j = 0; i < tmp.length; j++) {
                if (j != index) {
                    tmp[i] = arr[j];
                    i++;
                }
            }
            arr = tmp;
            return true;
        }
        return false;
    }

    //метод для задания 7
    public boolean remove(int index) {
        if (index >= 0 && index < arr.length) {
            T[] tmp = (T[]) new Object[arr.length - 1];
            for (int i = 0, j = 0; i < tmp.length; j++) {
                if (j != index) {
                    tmp[i] = arr[j];
                    i++;
                }
            }
            arr = tmp;
            return true;
        }
        return false;
    }

    //вспомогательный метод для печати массива
    public void print() {
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}

public class HomeWork24 {
    public static void main(String[] args) {
        //Реализовать динамический массив
        //1 add(T value)
        System.out.println("Задание 1. Вывод:");
        MyList myStringList = new MyList<>();
        myStringList.add("string");
        myStringList.print();
        System.out.println();

        myStringList.add("string2");
        myStringList.print();
        System.out.println();

        MyList myIntList = new MyList<>();
        myIntList.add(1);
        myIntList.add(2);
        myIntList.add(3);
        myIntList.print();
        System.out.println();

        MyList myCharList = new MyList<>();
        myCharList.add('A');
        myCharList.add('B');
        myCharList.add('C');
        myCharList.print();
        System.out.println();

        //2 add(int index , T value)
        System.out.println("Задание 2. Вывод");
        MyList myList2 = new MyList<>();
        myList2.add(2, 0);
        myList2.add(-1,-1); //отрицательный индекс добавит значение в 0-й индекс
        myList2.add(1, 1);
        myList2.add(4, 2);
        myList2.add(5, 3);
        myList2.add(7, 5); //индекс, находящийся за пределом массива, значение добавится в последний индекс
        myList2.print();
        System.out.println();

        //3 size()
        System.out.println("Задание 3. Вывод:");
        System.out.println(myList2.size());
        System.out.println(myIntList.size());
        System.out.println(myCharList.size());
        System.out.println(myStringList.size());
        System.out.println();

        //4 get(int index)
        System.out.println("Задание 4. Вывод:");
        System.out.println(myList2.get(1));
        System.out.println(myList2.get(15));
        System.out.println(myCharList.get(0));
        System.out.println();

        //5 clear()
        System.out.println("Задание 5. Вывод:");
        myCharList.print();
        myCharList.clear();
        myCharList.print();
        myCharList.add('1');
        myCharList.print();
        System.out.println();

        //6 remove(T value)
        System.out.println("Задание 6. Вывод:");
        MyList myList6 = new MyList<>();
        myList6.add(1);
        myList6.add(2);
        myList6.add(3);
        myList6.add(4);
        myList6.add(1);
        System.out.println("Изначальный массив:");
        myList6.print();
        myList6.removeValue(1);
        System.out.println("Изменённый массив:");
        myList6.print();
        System.out.println();

        //7 remove(int index)
        System.out.println("Задание 7. Вывод:");
        MyList myList7 = new MyList<>();
        myList7.add('A');
        myList7.add('B');
        myList7.add('C');
        myList7.add('D');
        myList7.add('E');
        myList7.add('F');
        System.out.println("Изначальный массив:");
        myList7.print();

        myList7.remove(1);
        myList7.remove(18);
        System.out.println("Изменённый массив:");
        myList7.print();
    }
}
