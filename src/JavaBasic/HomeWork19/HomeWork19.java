package JavaBasic.HomeWork19;

public class HomeWork19 {
    //Задание: Работа с модификаторами доступа в Java
    //
    //Создайте класс Person с полями:
    //name (строка, доступ к полю только внутри класса),
    //age (целое число, доступ только из пакета),
    //email (строка, доступ из любого места),
    //phone (строка, доступ только наследникам класса).
    //
    //Реализуйте в классе Person:
    //Конструктор, который инициализирует все поля.
    //Методы для получения значений всех полей (геттеры) с соблюдением их модификаторов доступа.
    //Метод displayInfo(), который выводит имя, возраст и email (может вызываться из любого места).
    //
    //Создайте второй класс Employee, который наследуется от класса Person. В этом классе:
    //Реализуйте метод для вывода номера телефона (доступен только внутри пакета).
    //
    //Напишите основной класс Main19 с методом main, в котором:
    //Создайте объект класса Person.
    //Попробуйте обратиться к каждому из полей напрямую и через методы (проверьте соблюдение модификаторов доступа).
    //Создайте объект класса Employee и вызовите все доступные методы для проверки наследования и работы с полями.
}

class Main {
    public static void main(String[] args) {
        Person person = new Person("Дмитрий", 34, "Dodge2510@mail.ru", "+79605161073");
        person.displayInfo();
//        System.out.println(person.getName()); // т.к. геттер имеет модификатор private, то он недоступен в классе Main
        System.out.println(person.getAge());
        System.out.println(person.getPhone());
        System.out.println(person.getEmail());
        System.out.println();
        System.out.println(person.age);
        System.out.println(person.phone);
        System.out.println(person.email);
        System.out.println();

        Employee employee = new Employee("Константин", 35, "konstantin@mail.ru", "+79605161074");
        employee.displayInfo();
        employee.displayPhone();
//        System.out.println(employee.getName()); //т.к. геттер имеет модификатор доступа private, то он недоступен в классе Main
        System.out.println(employee.getAge());
        System.out.println(employee.getPhone());
        System.out.println(employee.getEmail());
        System.out.println();
        System.out.println(employee.age);
        System.out.println(employee.phone);
        System.out.println(employee.email);
    }
}

class Person {
    private String name;
    int age;
    public String email;
    protected String phone;

    public Person(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    private String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    protected String getPhone() {
        return phone;
    }

    public void displayInfo() {
        System.out.println(this.name + " " + this.age + " " + this.email);
    }
}

class Employee extends Person {
    public Employee(String name, int age, String email, String phone) {
        super(name, age, email, phone);
    }

    void displayPhone() {
        System.out.println(this.phone);
    }
}