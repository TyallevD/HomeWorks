package HomeWork27;

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
        return -1;
    }

    //метод для задания 2
    public boolean contains() {
        return false;
    }

    //метод для задания 3
    public int indexOf(T value) {
        return -1;
    }

    //метод для задания 4
    //    public T get(int index) {
//        return value;
//    }

    //метод для задания 5
    public void add(int index, T value) {

    }
}

public class HomeWork27 {
    public static void main(String[] args) {
        //  -  public int size(); VERNI RAZMER (SKOLKO NODE)
        System.out.println("Задание 1. Вывод:");
        System.out.println();
        //  -  public boolean contains(String value); // ESLI EST VERNET TRUE ESLI NET FALSE
        System.out.println("Задание 2. Вывод:");
        System.out.println();
        //  -  public int indexOf(String value);  VOZVRAWAET INDEX DANNOQO ELEMENTA ELSI NETU -1
        System.out.println("Задание 3. Вывод:");
        System.out.println();
        //  -  public String get(int index); VOZVRAWAET SAM ELEMENT  ELSI NETU THROW NEW EXCEPTION(VI VISLI ZA RAZMER)
        System.out.println("Задание 4. Вывод:");
        System.out.println();
        //  -  public void add(int index , String value);// DOBAVIT NODE V UKAZANNIY INDEX
        System.out.println("Задание 5. Вывод:");

    }
}
