package HomeWork24;

class MyList<T> {
    private T[] arr;

    public MyList() {
        arr = (T[]) new Object[0];
    }

    public void add(T value) {
        T[] tmp = (T[]) new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        tmp[arr.length] = value;
        arr = tmp;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class HomeWork24 {
    public static void main(String[] args) {
        //Realizovat Dynamic Array
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
        //2 add(int index , T value)
        //реализовать следующим образом:
        //нулевой индекс - создаётся tmp массив с +1 размером, все значения смещаются на +1 индекс, в нулевой вставляется значение
        //индекс не ноль и не последний - создаётся tmp массив с +1 размером, все значения начиная с указанного индекса смещаются вправо, в индекс вставляется значение
        //последний индекс - добавляем как в первом задании

        // -  3 size()
        //реализовать следующим образом - берём массив и считаем количество элементов через count++ - по идее возвращаем значение

        // -  4 get(int index)
        //реализовать следующим образом - находим значение в индексе и возвращаем его на консоль (можно через void по идее)

        // -  5 clear()
        //реализовать следующим образом - надо обнулить массив

        // +  6 remove(T value)
        // создаётся новый массив, при нахождении первого вхождения значения - оно просто не записывается в новый

        // -  7 remove(int index)
        // создаётся новый массив, при нахождении индекса - он не записывается в новый массив

    }
}
