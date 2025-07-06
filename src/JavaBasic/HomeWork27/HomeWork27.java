package JavaBasic.HomeWork27;

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

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    //====================================================================

    //метод для задания 1
    public int size() {
        Node tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    //метод для задания 2
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

    //метод для задания 3
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

    //метод для задания 4
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

    //метод для задания 5
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
}

public class HomeWork27 {
    public static void main(String[] args) {
        //1  -  public int size(); VERNI RAZMER (SKOLKO NODE)
        System.out.println("Задание 1. Вывод:");
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addLast(1);
        myLinkedList1.addLast("два");
        myLinkedList1.addLast('3');
        myLinkedList1.addLast(4.5);
        myLinkedList1.print();

        System.out.println("Размер листа: " + myLinkedList1.size());
        System.out.println();

        //2  -  public boolean contains(String value); // ESLI EST VERNET TRUE ESLI NET FALSE
        System.out.println("Задание 2. Вывод:");
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast("Зима");
        myLinkedList2.addLast("Весна");
        myLinkedList2.addLast("Лето");
        myLinkedList2.addLast("Осень");
        myLinkedList2.print();

        System.out.println("Лист содержит значение? Ответ: " + (myLinkedList2.contains("Осень") ? "Да" : "Нет"));
        System.out.println();

        //3  -  public int indexOf(String value);  VOZVRAWAET INDEX DANNOQO ELEMENTA ELSI NETU -1
        System.out.println("Задание 3. Вывод:");
        MyLinkedList myLinkedList3 = new MyLinkedList();
        myLinkedList3.addLast("Дима");
        myLinkedList3.addLast(34);
        myLinkedList3.addLast('м');
        myLinkedList3.print();

        System.out.println("Индекс возраста: " + myLinkedList3.indexOf(34));
        System.out.println("Индекс возраста: " + myLinkedList3.indexOf(25));
        System.out.println();

        //4  -  public String get(int index); VOZVRAWAET SAM ELEMENT  ELSI NETU THROW NEW EXCEPTION(VI VISLI ZA RAZMER)
        System.out.println("Задание 4. Вывод:");
        MyLinkedList myLinkedList4 = new MyLinkedList();
        myLinkedList4.addLast(1);
        myLinkedList4.addLast(2);
        myLinkedList4.addLast(3);
        myLinkedList4.addLast(4);
        myLinkedList4.addLast(5);
        myLinkedList4.print();
        try {
            System.out.println("Индекс -1 -> Значение: " + myLinkedList4.get(-1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Индекс 0 -> Значение: " + myLinkedList4.get(0));
            System.out.println("Индекс 1 -> Значение: " + myLinkedList4.get(1));
            System.out.println("Индекс 2 -> Значение: " + myLinkedList4.get(2));
            System.out.println("Индекс 3 -> Значение: " + myLinkedList4.get(3));
            System.out.println("Индекс 4 -> Значение: " + myLinkedList4.get(4));
            System.out.println("Индекс 5 -> Значение: " + myLinkedList4.get(5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //5  -  public void add(int index , String value);// DOBAVIT NODE V UKAZANNIY INDEX
        System.out.println("Задание 5. Вывод:");
        MyLinkedList myLinkedList5 = new MyLinkedList();
        try {
            myLinkedList5.add(-1, -1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            myLinkedList5.add(0, "Один");
            myLinkedList5.add(1, 2);
            myLinkedList5.add(2, '3');
            myLinkedList5.add(3, 4f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        myLinkedList5.print();
    }
}
