package HomeWork20;

public class HomeWork20 {
    //TODO Нужны уточнения по поводу использования геттеров и сеттеров в классах, где не задано явно, что необходимо их использовать
    public static void main(String[] args) {
        //1. Простое наследование
        //Создайте базовый класс Animal с атрибутом name. Создайте дочерний класс Dog,
        // унаследуйте от Animal, и создайте объект класса Dog, передав ему имя.
        System.out.println("Задание 1. Вывод:");
        Dog20_1 dog1 = new Dog20_1("Шарик");
        System.out.println(dog1.getName());
        Dog20_1 dog2 = new Dog20_1();
        dog2.setName("Тузик");
        System.out.println(dog2.getName());
        System.out.println();

        //2. Добавление нового атрибута
        //Создайте класс Vehicle с атрибутом brand. Создайте класс Car, который наследует Vehicle,
        // и добавьте атрибут model. Создайте объект Car и установите оба атрибута.
        System.out.println("Задание 2. Вывод");
        Car20 car20 = new Car20("Мерседес", "S-класс");
        System.out.println(car20.getBrand() + " " + car20.getModel());
        System.out.println();

        //3. Наследование с использованием метода базового класса
        //Создайте класс Person с методом introduce(), который выводит строку "I am a person".
        //Создайте класс Student, который наследует Person, и создайте объект Student. Вызовите метод introduce().
        System.out.println("Задание 3. Вывод:");
        Student20 student20 = new Student20();
        student20.introduce();
        System.out.println();

        //4. Добавление метода в дочерний класс
        //Создайте класс Bird с атрибутом species. Создайте класс Penguin, который наследует Bird,
        // и добавьте метод swim(), который выводит "I can swim".
        System.out.println("Задание 4. Вывод:");
        Penguin penguin = new Penguin("Пингвин");
        System.out.println(penguin.species);
        penguin.swim();
        System.out.println();

        //5. Наследование с использованием конструктора
        //Создайте класс Shape с атрибутом color, который задается через конструктор. Создайте класс Rectangle,
        // который наследует Shape, и создайте объект Rectangle с указанием цвета.
        System.out.println("Задание 5. Вывод:");
        Rectangle20 rectangle20 = new Rectangle20("Красный");
        System.out.println(rectangle20.color);
        System.out.println();

        //6. Создание нескольких дочерних классов
        //Создайте класс Animal. Затем создайте два дочерних класса: Dog и Cat. В каждом из них добавьте
        // уникальный атрибут, например, breed для собак и color для кошек.
        System.out.println("Задание 6. Вывод:");
        Dog20_6 dog20_6 = new Dog20_6("Шарик", "Овчарка");
        System.out.println(dog20_6.name + " " + dog20_6.breed);
        System.out.println();
        Cat20_6 cat20_6 = new Cat20_6("Мурзик", "Рыжий");
        System.out.println(cat20_6.name + " " + cat20_6.color);
        System.out.println();

        //7. Наследование с передачей значений в конструктор
        //Создайте класс Appliance с атрибутом brand. Создайте класс WashingMachine, который наследует Appliance,
        // и установите значение для атрибута brand при создании объекта.
        System.out.println("Задание 7. Вывод:");
        WashingMachine washingMachine = new WashingMachine("Electrolux");
        System.out.println(washingMachine.brand);
        System.out.println();

        //8. Создание цепочки наследования
        //Создайте класс LivingBeing с атрибутом type (например, "Living"). Создайте класс Animal,
        // наследующий LivingBeing, и добавьте атрибут species. Создайте класс Mammal, который наследует Animal,
        // и добавьте атрибут name.
        System.out.println("Задание 8. Вывод:");
        Mammal mammal = new Mammal("Медведь", "Умка");
        System.out.println(mammal.species + " " + mammal.getName());
        System.out.println();

        //9. Проверка принадлежности к классу
        //Создайте класс Fruit и его дочерний класс Apple. Создайте объект Apple и
        // с помощью функции isinstance() проверьте, принадлежит ли он к классу Fruit.
        System.out.println("Задание 9. Вывод:");
        Apple apple = new Apple();
        System.out.println(apple instanceof Fruit ? "Объект принадлежит классу Fruit" :
                "Объект не принадлежит классу Fruit"); // об операторе instanceof прочитал отдельно в учебных материалах
        System.out.println();

        //10. Дочерний класс с дополнительным методом
        //Создайте класс Device с атрибутом name. Создайте класс Phone, который наследует Device,
        // и добавьте метод make_call(), который выводит "Calling...".
        System.out.println("Задание 10. Вывод:");
        Phone phone = new Phone("Google Pixel 7a");
        phone.make_call();
    }
}

//Классы для задания 1
class Animal20_1 {
    protected String name;

    public Animal20_1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog20_1 extends Animal20_1 {
    public Dog20_1() {
        super(null);
    }

    public Dog20_1(String name) {
        super(name);
    }
}

//Классы для задания 2
class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

class Car20 extends Vehicle {
    private String model;

    public Car20(String brand, String model) {
        super(brand);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

//Классы для задания 3
class Person20 {
    public void introduce() {
        System.out.println("I am a person");
    }
}

class Student20 extends Person20 {

}

//Классы для задания 4
class Bird {
    protected String species;
}

class Penguin extends Bird {
    public Penguin(String species) {
        this.species = species;
    }

    public void swim() {
        System.out.println("I can swim");
    }
}

//Классы для задания 5
class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }
}

class Rectangle20 extends Shape {

    public Rectangle20(String color) {
        super(color);
    }
}

//Классы для задания 6
class Animal20_6 {
    protected String name;

    public Animal20_6(String name) {
        this.name = name;
    }
}

class Dog20_6 extends Animal20_6 {
    public String breed;

    public Dog20_6(String name, String breed) {
        super(name);
        this.breed = breed;
    }
}

class Cat20_6 extends Animal20_6 {
    public String color;

    public Cat20_6(String name, String color) {
        super(name);
        this.color = color;
    }
}

//Классы для задания 7
class Appliance {
    protected String brand;

    public Appliance(String brand) {
        this.brand = brand;
    }
}

class WashingMachine extends Appliance {
    public WashingMachine(String brand) {
        super(brand);
    }
}

//Классы для задания 8
class LivingBeing {
    protected String type = "Living";
}

class Animal20_8 extends LivingBeing {
    protected String species;
}

class Mammal extends Animal20_8 {
    private String name;

    public Mammal(String species, String name) {
        this.species = species;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//Классы для задания 9
class Fruit {

}

class Apple extends Fruit {

}

//Классы для задания 10
class Device {
    protected String name;

    public Device(String name) {
        this.name = name;
    }
}

class Phone extends Device {
    public Phone(String name) {
        super(name);
    }

    public void make_call() {
        System.out.println("Calling...");
    }
}
