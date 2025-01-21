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

    //метод для задания 2 //todo надо обработать ошибку выхода из массива
    public void add(T value, int index) {
        T[] tmp = (T[]) new Object[arr.length + 1];
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (j != index) {
                tmp[i] = arr[j];
            }
        }
        tmp[index] = value;
        arr = tmp;
    }

    //метод для задания 3
    public int size() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
        }
        return count;
    }

    //метод для задания 4 //todo стоит добавить проверку на выход из массива?
    public void get(int index) {
        System.out.println("Значение в индексе \"" + index + "\" равно: " + arr[index]);
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
        myStringList.add("string2");
        myStringList.print();
        System.out.println();
        MyList myIntList = new MyList<>();
        myIntList.add(1);
        myIntList.add(2);
        myIntList.add(3);
        myIntList.print();
        MyList myCharList = new MyList<>();
        myCharList.add('A');
        myCharList.add('B');
        myCharList.add('C');
        myCharList.print();
        System.out.println();

        //2 add(int index , T value)
        //реализовать следующим образом:
        //нулевой индекс - создаётся tmp массив с +1 размером, все значения смещаются на +1 индекс, в нулевой вставляется значение
        //индекс не ноль и не последний - создаётся tmp массив с +1 размером, все значения начиная с указанного индекса смещаются вправо, в индекс вставляется значение
        //последний индекс - добавляем как в первом задании
        System.out.println("Задание 2. Вывод");
        MyList myList2 = new MyList<>();
        myList2.add(2, 0);
        myList2.add(1, 1);
        myList2.add(4, 2);
        myList2.add(5, 3);
//        myList2.add(5, 5); //todo если есть разрыв в индексах - то будет выход за пределы создаваемого массива, надо по идее заполнять нулями или null значениями добавляемые индексы?
        myList2.print();
        System.out.println();

        //3 size()
        System.out.println("Задание 3. Вывод:");
        myList2.size();
        myIntList.size();
        myCharList.size();
        myStringList.size();
        System.out.println();

        //4 get(int index) //todo
        System.out.println("Задание 4. Вывод:");
        myList2.get(1);
//        myList2.get(15); //надо обрабатывать выход за пределы массива

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
