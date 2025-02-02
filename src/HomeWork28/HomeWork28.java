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
        }
        if (index == size) {
            addLast(value);
        }

        Node tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(value);
        node.next = tmp.next;
        tmp.next = node;
    }

    public boolean contains() {
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

//    public T get(int index) {
//        return value;
//    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    //public T remove(int index){
//    return ;
//}
//public T remove(T value){
//    return ;
//}
//    public T removeFirst(){
//        return ;
//    }


    //метод для задания 1
    public void clear() {

    }

    //метод для задания 2
    public boolean isEmpty() {
        return false;
    }

    //метод для задания 3
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
    //метод для задания 6
    //метод для задания 7
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
}

public class HomeWork28 {
    public static void main(String[] args) {
//1  -  public void clear();                        ocisaet linked list
        System.out.println("Задание 1. Вывод:");
        System.out.println();
//2  -  public boolean isEmpty();                   vozvrasaet true esli linked list pustoy inace false
        System.out.println("Задание 2. Вывод:");
        System.out.println();
//3  -  public String removeFirst();                udalyayet perviy element i vozvrasaet eqo
        System.out.println("Задание 3. Вывод:");
        System.out.println();
//4  -  public String removeLast();                 udalyayet posledniy element i vozvrasaet eqo
        System.out.println("Задание 4. Вывод:");
        System.out.println();
//5  -  public String getFirst();                   vernut perviy element
        System.out.println("Задание 5. Вывод:");
        System.out.println();
//6  -  public String getLast();                    vernut posledniy element
        System.out.println("Задание 6. Вывод:");
        System.out.println();
//7  -  public String remove(int index);            udalyayet po indeksu i vozvrasaet udalyayemiy obyekt
        System.out.println("Задание 7. Вывод:");
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
        System.out.println();

        //****  ---------------------------------------------------------------------------
//10  -  public void sort();                         sortiruet elementi po (vozrastaniyu / ubbivaniyu)
//11  -  public void reverse();                      povoracivaet elementi naoborot
    }
}
