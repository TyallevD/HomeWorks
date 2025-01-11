package HomeWork21;

public class HomeWork21 {
    public static void main(String[] args) {
        //1. Базовое задание: Абстрактный класс
        //Создайте абстрактный класс Shape с методом calculateArea(). Реализуйте два наследника: Circle и Rectangle.
        // В классе Circle метод должен вычислять площадь круга,а в Rectangle — площадь прямоугольника.
        System.out.println("Задание 1. Вывод:");
        Circle circle1 = new Circle(4);
        circle1.CalculateArea();

        Circle circle2 = new Circle();
        circle2.setRadius(5);
        circle2.CalculateArea();

        Rectangle rectangle1 = new Rectangle(7, 5);
        rectangle1.CalculateArea();

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setDlina(10);
        rectangle2.setShirina(10);
        rectangle2.CalculateArea();
        System.out.println();

        //2. Интерфейс для животных
        //Создайте интерфейс Animal с методами:
        //
        //makeSound()
        //move()
        //Создайте классы Dog и Bird, которые реализуют этот интерфейс. Реализуйте методы так, чтобы собака лаяла, а птица пела.
        System.out.println("Задание 2. Вывод:");
        Dog dog = new Dog("Шарик");
        dog.makeSound();
        dog.move();

        Bird bird = new Bird();
        bird.setType("Воробей");
        bird.makeSound();
        bird.move();
        System.out.println();

        //3. Абстрактный класс + интерфейс
        //Создайте абстрактный класс Vehicle с методом startEngine(). Добавьте интерфейс Flyable с методом fly(). Реализуйте два класса:
        //
        //Car (наследует Vehicle)
        //Plane (наследует Vehicle и реализует Flyable).
        System.out.println("Задание 3. Вывод:");
        Car car = new Car("Мерседес");
        car.startEngine();

        Plane plane = new Plane("Боинг");
        plane.startEngine();
        plane.fly();
        System.out.println();

        //4. Список сотрудников
        //Создайте абстрактный класс Employee с методами getSalary() и getRole(). Реализуйте два класса:
        //
        //Manager
        //Developer
        //Каждый класс должен возвращать свою зарплату и роль.
        System.out.println("Задание 4. Вывод:");
        Manager manager = new Manager();
        manager.setName("Вадим");
        System.out.println(manager.getRole());
        manager.getSalary();

        Developer developer = new Developer("Роман");
        System.out.println(developer.getRole());
        developer.getSalary();
        System.out.println();

        //5. Управление устройствами
        //Создайте интерфейс Switchable с методами turnOn() и turnOff(). Реализуйте классы:
        //
        //LightBulb
        //Fan
        //Каждый класс должен менять свое состояние (включено/выключено).
        System.out.println("Задание 5. Вывод:");
        LightBulb lightBulb1 = new LightBulb();
        lightBulb1.setType("Диодная лампочка");
        lightBulb1.turnOn();
        lightBulb1.turnOff();

        LightBulb lightBulb2 = new LightBulb("Лампа накаливания");
        lightBulb2.turnOn();
        lightBulb2.turnOff();

        Fan fan1 = new Fan();
        fan1.setType("Напольный вентилятор");
        fan1.turnOn();
        fan1.turnOff();

        Fan fan2 = new Fan("Настольный вентилятор");
        fan2.turnOn();
        fan2.turnOff();
        System.out.println();

        //6. Геометрические фигуры
        //Создайте интерфейс Drawable с методом draw(). Реализуйте классы:
        //
        //Circle
        //Square
        //Метод draw() должен выводить текстовое описание фигуры (например, "Рисуем круг").
        System.out.println("Задание 6. Вывод:");
        Circle6 circle6 = new Circle6();
        circle6.draw();

        Square square = new Square();
        square.draw();
        System.out.println();

        //7. Работа с базой данных
        //Создайте интерфейс Database с методами:
        //
        //connect()
        //disconnect()
        //Реализуйте классы:
        //
        //MySQLDatabase
        //PostgreSQLDatabase
        //Каждый класс должен выводить сообщения о подключении и отключении.
        System.out.println("Задание 7. Вывод:");
        MySQLDatabase mySQLDatabase = new MySQLDatabase(8.4);
        mySQLDatabase.connect();
        mySQLDatabase.disconnect();

        PostgreSQLDatabase postgreSQLDatabase = new PostgreSQLDatabase();
        postgreSQLDatabase.setVersion(15.2);
        postgreSQLDatabase.connect();
        postgreSQLDatabase.disconnect();
        System.out.println();

        //8. Спортивные соревнования //TODO нужно создать каждому классу по одному методу? Или можно имплементировать оба метода, но реализовать только нужный?
        //Создайте интерфейс Athlete с методами:
        //
        //run()
        //jump()
        //Реализуйте классы:
        //
        //Runner
        //Jumper
        //Каждый класс должен реализовать соответствующие методы.
        System.out.println("Задание 8. Вывод:");
        Runner runner = new Runner("Усейн Болт");
        runner.run();
        runner.jump(); //убрать?

        Jumper jumper = new Jumper();
        jumper.setName("Хавьер Сотомайор");
        jumper.run();
        jumper.jump();
        System.out.println();

        //9. Магазин
        //Создайте абстрактный класс Product с методами:
        //
        //getPrice()
        //getName()
        //Создайте классы Electronics и Clothing, которые наследуют Product и реализуют методы.
        System.out.println("Задание 9. Вывод:");
        System.out.println();

        //10. Зоопарк
        //Создайте абстрактный класс Animal с методами:
        //
        //eat()
        //sleep()
        //Добавьте интерфейс SoundMaker с методом makeSound(). Реализуйте классы:
        //
        //Lion
        //Elephant
        //Каждое животное должно реализовать свои звуки, приемы пищи и сон.
        System.out.println("Задание 10. Вывод:");
        System.out.println();
    }
}

//Классы и интерфейсы для задания 1
abstract class Shape {
    abstract void CalculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    void CalculateArea() {
        System.out.println("Площадь круга с радиусом " + this.radius + " = " + Math.PI * Math.pow(radius, 2));
    }
}

class Rectangle extends Shape {
    private int dlina;
    private int shirina;

    public Rectangle() {
    }

    public Rectangle(int dlina, int shirina) {
        this.dlina = dlina;
        this.shirina = shirina;
    }

    public int getDlina() {
        return dlina;
    }

    public void setDlina(int dlina) {
        this.dlina = dlina;
    }

    public int getShirina() {
        return shirina;
    }

    public void setShirina(int shirina) {
        this.shirina = shirina;
    }

    @Override
    void CalculateArea() {
        System.out.println("Площадь прямоугольника со сторонами " + this.dlina + " и " + this.shirina + " = " + (this.dlina * this.shirina));
    }
}

//Классы и интерфейсы для задания 2
interface Animal {
    void makeSound();

    void move();
}

class Dog implements Animal {
    public String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " лает");
    }

    @Override
    public void move() {
        System.out.println(this.name + " бежит");
    }


}

class Bird implements Animal {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void makeSound() {
        System.out.println(this.type + " поёт");
    }

    @Override
    public void move() {
        System.out.println(this.type + " летит");
    }
}

//Классы и интерфейсы для задания 3
interface Flyable {
    void fly();
}

abstract class Vehicle {
    abstract void startEngine();
}

class Car extends Vehicle {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    void startEngine() {
        System.out.println(this.model + " : Двигатель запускается");
    }
}

class Plane extends Vehicle implements Flyable {
    private String model;

    public Plane(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void fly() {
        System.out.println(this.model + " : Взлетает");
    }

    @Override
    void startEngine() {
        System.out.println(this.model + " : Двигатель запускается");
    }
}

//Классы и интерфейсы для задания 4
abstract class Employee {
    abstract void getSalary();

    abstract String getRole();
}

class Manager extends Employee {
    private String name;

    public Manager() {
    }

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void getSalary() {
        System.out.println("Зарплата руководителя " + this.name + " : 300 000 тыс рублей");
    }

    @Override
    String getRole() {
        return this.name + ": Руководитель";
    }
}

class Developer extends Employee {
    private String name;

    public Developer() {
    }

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void getSalary() {
        System.out.println("Зарплата разработчика " + this.name + " : 180 000 тыс рублей");
    }

    @Override
    String getRole() {
        return this.name + " : Разработчик";
    }
}

//Классы и интерфейсы для задания 5
interface Switchable {
    void turnOn();

    void turnOff();
}

class LightBulb implements Switchable {
    private String type;

    public LightBulb() {
    }

    public LightBulb(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void turnOn() {
        System.out.println(this.type + " включена");
    }

    @Override
    public void turnOff() {
        System.out.println(this.type + " выключена");
    }
}

class Fan implements Switchable {
    private String type;

    public Fan() {
    }

    public Fan(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void turnOn() {
        System.out.println(this.type + " включен");
    }

    @Override
    public void turnOff() {
        System.out.println(this.type + " выключен");
    }
}

//Классы и интерфейсы для задания 6
interface Drawable {
    void draw();
}

class Circle6 implements Drawable {

    @Override
    public void draw() {
        System.out.println("Рисуем круг");
    }
}

class Square implements Drawable {

    @Override
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}

//Классы и интерфейсы для задания 7
interface Database {
    void connect();

    void disconnect();
}

class MySQLDatabase implements Database {
    private double version;

    public MySQLDatabase() {
    }

    public MySQLDatabase(double version) {
        this.version = version;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public void connect() {
        System.out.println("Подключение к MySQL v" + this.version + "...");
        System.out.println("Подключено");
    }

    @Override
    public void disconnect() {
        System.out.println("Отключение от MySQL v" + this.version + "...");
        System.out.println("Отключено");
    }
}

class PostgreSQLDatabase implements Database {
    private double version;

    public PostgreSQLDatabase() {
    }

    public PostgreSQLDatabase(double version) {
        this.version = version;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public void connect() {
        System.out.println("Подключение к PostgreSQL v" + this.version + "...");
        System.out.println("Подключено");
    }

    @Override
    public void disconnect() {
        System.out.println("Отключение от PostgreSQL v" + this.version + "...");
        System.out.println("Отключено");
    }
}

//Классы и интерфейсы для задания 8
//Создайте интерфейс Athlete с методами:
//
//run()
//jump()
//Реализуйте классы:
//
//Runner
//Jumper
//Каждый класс должен реализовать соответствующие методы.
interface Athlete {
    void run();

    void jump();
}

class Runner implements Athlete {
    private String name;

    public Runner() {
    }

    public Runner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Бегун " + this.name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Бегун " + this.name + " прыгает");
    }
}

class Jumper implements Athlete {
    private String name;

    public Jumper() {
    }

    public Jumper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Прыгун " + this.name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Прыгун " + this.name + " прыгает");
    }
}
//Классы и интерфейсы для задания 9
//Создайте абстрактный класс Product с методами:
//
//getPrice()
//getName()
//Создайте классы Electronics и Clothing, которые наследуют Product и реализуют методы.
abstract class Product{
    abstract void getPrice();
    abstract void getName();
}
class Electronics extends Product{

    @Override
    void getPrice() {

    }

    @Override
    void getName() {

    }
}
class Clothing extends Product{

    @Override
    void getPrice() {

    }

    @Override
    void getName() {

    }
}
//Классы и интерфейсы для задания 10
//Создайте абстрактный класс Animal с методами:
//
//eat()
//sleep()
//Добавьте интерфейс SoundMaker с методом makeSound(). Реализуйте классы:
//
//Lion
//Elephant
//Каждое животное должно реализовать свои звуки, приемы пищи и сон.
