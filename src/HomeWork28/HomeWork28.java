package HomeWork28;

class Node<T> {
    T value;
    Node next;

    public Node(T value) {
        this.value = value;
    }
}

class MyLinkedList<T> {
    Node head;


    public void addLast(T value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            Node next = new Node(value);
            tmp.next = next;
        }
    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void add(int index, T value) throws Exception {
        int size = size();
        if (index < 0 || index > size) {
            throw new Exception("Индекс вне пределов листа");
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(value);
        node.next = tmp.next;
        tmp.next = node;
    }

    public boolean contains(T value) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.value.equals(value)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public int indexOf(T value) {
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (tmp.value.equals(value)) {
                return index;
            }
            tmp = tmp.next;
            index++;
        }
        return -1;
    }

    public int size() {
        Node tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    public T get(int index) throws Exception {
        int size = size();
        if (index < 0 || index >= size) {
            throw new Exception("Индекс вне пределов листа");
        }
        if (index == 0) {
            return (T) head.value;
        } else {
            Node tmp = head;
            int tmpindex = 0;
            while (tmpindex != index && tmp != null) {
                tmp = tmp.next;
                tmpindex++;
            }
            return (T) tmp.value;
        }
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
//===========================================================================

    //метод для задания 1
    public void clear() {
        head = null;
        System.out.println("Лист очищен");
    }

    //метод для задания 2
    public boolean isEmpty() {
        return head == null;
    }

    //метод для задания 3
    public T removeFirst() {
        Node tmp = head;
        head = tmp.next;

        return (T) tmp.value;
    }

    //метод для задания 4
    public T removeLast() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            T removedValue = (T) head.value;
            head = null;
            return removedValue;
        }
        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        T removedValue = (T) tmp.next.value;
        tmp.next = null;
        return removedValue;
    }

    //метод для задания 5
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return (T) head.value;
    }

    //метод для задания 6
    public T getLast() {
        if (head == null) {
            return null;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return (T) tmp.value;
    }

    //метод для задания 7
    public T removeByIndex(Integer index) {
        if (head == null) {
            return null;
        }
        if (index < 0 || index > size() - 1) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size() - 1) {
            return removeLast();
        }
        int tmpindex = 1;
        Node tmp = head;
        while (tmp.next != null && tmpindex < index) {
            tmp = tmp.next;
            tmpindex++;
        }
        T deletedValue = (T) tmp.next.value;
        tmp.next = tmp.next.next;
        return deletedValue;
    }

    //метод для задания 8
    public T remove(T value) {
        if (head == null) {
            return null;
        }
        if (head.value.equals(value)) {
            head = head.next;
            return value;
        }
        Node tmp = head;
        while (tmp.next != null && !tmp.next.value.equals(value)) {
            tmp = tmp.next;
        }
        if (tmp.next == null) {
            return null;
        } else {
            tmp.next = tmp.next.next;
            return value;
        }
    }

    //метод для задания 9
    public void set(int index, T value) {
        if (head == null) {
            System.out.println("Лист пуст, нечего обновлять");
            return;
        }
        if (index < 0 || index > size() - 1) {
            System.out.println("Выход за пределы листа");
            return;
        }
        int tmpindex = 0;
        Node tmp = head;
        while (tmp != null && tmpindex != index) {
            tmp = tmp.next;
            tmpindex++;
        }
        tmp.value = value;
    }

    //метод для задания 10
    public void sortAsc() {
        int size = size();
        if (size <= 1) {
            System.out.println("Лист слишком мал (размер 1 или 0), сортировать нечего");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            Node tmp = head;
            while (tmp != null && tmp.next != null) {
                if (((Comparable<T>) tmp.value).compareTo((T) tmp.next.value) > 0) {//сравнение через compareTo, если первое больше второго, то вернёт значение больше 0
                    T swap = (T) tmp.value;
                    tmp.value = tmp.next.value;
                    tmp.next.value = swap;
                }
                tmp = tmp.next;
            }
        }
    }

    public void sortDesc() {
        int size = size();
        if (size <= 1) {
            System.out.println("Лист слишком мал (размер 1 или 0), сортировать нечего");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            Node tmp = head;
            while (tmp != null && tmp.next != null) {
                if (((Comparable<T>) tmp.value).compareTo((T) tmp.next.value) < 0) {//сравнение через compareTo, если первое меньше второго, то вернёт значение меньше 0
                    T swap = (T) tmp.value;
                    tmp.value = tmp.next.value;
                    tmp.next.value = swap;
                }
                tmp = tmp.next;
            }
        }
    }

    //метод для задания 11
    public void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;

            current = next;
        }
        head = previous;
    }
}

public class HomeWork28 {
    public static void main(String[] args) {
//1  -  public void clear();                        ocisaet linked list
        System.out.println("Задание 1. Вывод:");
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addLast(0);
        myLinkedList1.addLast(1);
        myLinkedList1.addLast(2);
        myLinkedList1.addLast(3);
        myLinkedList1.addLast(4);
        myLinkedList1.addLast(5);
        myLinkedList1.print();

        myLinkedList1.clear();
        myLinkedList1.print();
        System.out.println();

//2  -  public boolean isEmpty();                   vozvrasaet true esli linked list pustoy inace false
        System.out.println("Задание 2. Вывод:");
        System.out.println("Лист 1 пуст? Ответ: " + (myLinkedList1.isEmpty() ? "Да" : "Нет")); //проверим заодно действительно ли сработал clear()
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast(1);
        myLinkedList2.print();
        System.out.println("Лист 2 пуст? Ответ " + (myLinkedList2.isEmpty() ? "Да" : "Нет"));
        System.out.println();

//3  -  public String removeFirst();                udalyayet perviy element i vozvrasaet eqo
        System.out.println("Задание 3. Вывод:");
        MyLinkedList myLinkedList3 = new MyLinkedList();
        myLinkedList3.addFirst(213);
        myLinkedList3.addLast("Строка");
        myLinkedList3.addLast('!');
        myLinkedList3.print();

        System.out.println("Удаляем первое значение = " + myLinkedList3.removeFirst());
        myLinkedList3.print();
        System.out.println();

//4  -  public String removeLast();                 udalyayet posledniy element i vozvrasaet eqo
        System.out.println("Задание 4. Вывод:");
        MyLinkedList myLinkedList4 = new MyLinkedList();
        myLinkedList4.addLast(0);
        myLinkedList4.addLast(1);
        myLinkedList4.addLast(2);
        myLinkedList4.addLast(3);
        myLinkedList4.addLast(39);
        myLinkedList4.print();

        System.out.println("Удаляем последнее значение = " + myLinkedList4.removeLast());
        myLinkedList4.print();
        System.out.println();

//5  -  public String getFirst();                   vernut perviy element
        System.out.println("Задание 5. Вывод:");
        MyLinkedList myLinkedList5 = new MyLinkedList();
        myLinkedList5.addLast(1);
        myLinkedList5.addLast(2);
        myLinkedList5.addLast(3);
        myLinkedList5.addLast(4);
        myLinkedList5.addLast(5);
        myLinkedList5.print();

        System.out.println("Первый элемент листа -> " + myLinkedList5.getFirst());

        MyLinkedList myLinkedList5_1 = new MyLinkedList();
        System.out.println("Первый элемент пустого листа -> " + myLinkedList5_1.getFirst());
        System.out.println();

//6  -  public String getLast();                    vernut posledniy element
        System.out.println("Задание 6. Вывод:");
        MyLinkedList myLinkedList6 = new MyLinkedList();
        myLinkedList6.addLast('1');
        myLinkedList6.addLast('2');
        myLinkedList6.addLast('3');
        myLinkedList6.addLast('4');
        myLinkedList6.addLast('5');
        myLinkedList6.print();

        System.out.println("Последний элемент листа -> " + myLinkedList6.getLast());

        MyLinkedList myLinkedList6_1 = new MyLinkedList();
        System.out.println("Последний элемент пустого листа -> " + myLinkedList6_1.getLast());
        System.out.println();

//7  -  public String remove(int index);            udalyayet po indeksu i vozvrasaet udalyayemiy obyekt
        System.out.println("Задание 7. Вывод:");
        MyLinkedList myLinkedList7 = new MyLinkedList();
        myLinkedList7.addLast("Ноль");
        myLinkedList7.addLast("Один");
        myLinkedList7.addLast("Два");
        myLinkedList7.addLast("Три");
        myLinkedList7.addLast("Четыре");
        myLinkedList7.addLast("Пять");
        myLinkedList7.print();

        System.out.println("Удаляем значение \"" + myLinkedList7.removeByIndex(2) + "\" по индексу");
        myLinkedList7.print();
        System.out.println();

//8  -  public String remove(String value);         udalyayet po znaceniyu i vozvrasaet udalyayemiy obyekt
        System.out.println("Задание 8. Вывод:");
        MyLinkedList myLinkedList8 = new MyLinkedList();
        myLinkedList8.addLast(1);
        myLinkedList8.addLast(2);
        myLinkedList8.addLast(3);
        myLinkedList8.addLast(4);
        myLinkedList8.addLast(5);
        myLinkedList8.print();

        System.out.println("Удаляем значение " + myLinkedList8.remove(4));
        myLinkedList8.print();
        System.out.println();

//9  -  public void set(int index,String value);    zameni znacenie ukazannoqo index na value
        System.out.println("Задание 9. Вывод:");
        MyLinkedList myLinkedList9 = new MyLinkedList();
        myLinkedList9.addLast("Один");
        myLinkedList9.addLast("Два");
        myLinkedList9.addLast("Три");
        myLinkedList9.addLast("Четыре");
        myLinkedList9.addLast("Пять");
        System.out.println("Исходный лист:");
        myLinkedList9.print();

        myLinkedList9.set(-1, 0); //выходим за пределы листа
        myLinkedList9.set(0, 1);
        myLinkedList9.set(1, 2);
        myLinkedList9.set(2, 3);
        myLinkedList9.set(3, 4);
        myLinkedList9.set(4, 5);
        myLinkedList9.set(5, 6); //выходим за пределы листа
        myLinkedList9.set(150, '0'); //выходим за пределы листа

        System.out.println("Измененный лист:");
        myLinkedList9.print();

        MyLinkedList myLinkedList9_1 = new MyLinkedList();
        myLinkedList9_1.set(0, 1);
        System.out.println();

        //****  ---------------------------------------------------------------------------

//10  -  public void sort();                         sortiruet elementi po (vozrastaniyu / ubbivaniyu)
        System.out.println("Задание 10. Вывод:");
        MyLinkedList myLinkedList10_1 = new MyLinkedList();
        myLinkedList10_1.addLast(2);
        myLinkedList10_1.addLast(1);
        myLinkedList10_1.addLast(3);
        myLinkedList10_1.addLast(0);
        System.out.println("Исходный лист:");
        myLinkedList10_1.print();

        myLinkedList10_1.sortAsc();
        System.out.println("Измененный лист по возрастанию:");
        myLinkedList10_1.print();
        myLinkedList10_1.sortDesc();
        System.out.println("Измененный лист по убыванию:");
        myLinkedList10_1.print();
        System.out.println();

        MyLinkedList myLinkedList10_2 = new MyLinkedList();
        myLinkedList10_2.addLast("Дима");
        myLinkedList10_2.addLast("Аня");
        myLinkedList10_2.addLast("Миша");
        myLinkedList10_2.addLast("Маша");
        System.out.println("Исходный лист:");
        myLinkedList10_2.print();

        myLinkedList10_2.sortAsc();
        System.out.println("Измененный лист по возрастанию:");
        myLinkedList10_2.print();
        myLinkedList10_2.sortDesc();
        System.out.println("Измененный лист по убыванию:");
        myLinkedList10_2.print();
        System.out.println();

        MyLinkedList myLinkedList10_3 = new MyLinkedList();
        myLinkedList10_3.addLast(1);
        System.out.println("Исходный лист");
        myLinkedList10_3.print();
        myLinkedList10_3.sortAsc();
        System.out.println("Измененный лист по убыванию");
        myLinkedList10_3.print();
        myLinkedList10_3.sortDesc();
        System.out.println("Измененный лист по убыванию");
        myLinkedList10_3.print();

        MyLinkedList myLinkedList10_4 = new MyLinkedList();
        myLinkedList10_4.sortAsc();

        System.out.println();

//11  -  public void reverse();                      povoracivaet elementi naoborot
        System.out.println("Задание 11. Вывод:");
        MyLinkedList myLinkedList11 = new MyLinkedList();
        myLinkedList11.addLast(1);
        myLinkedList11.addLast(2);
        myLinkedList11.addLast(3);
        myLinkedList11.addLast(4);
        System.out.println("Исходный лист:");
        myLinkedList11.print();

        myLinkedList11.reverse();
        System.out.println("Измененный лист:");
        myLinkedList11.print();
    }
}
