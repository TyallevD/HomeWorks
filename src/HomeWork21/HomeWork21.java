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
        System.out.println();

        //4. Список сотрудников
        //Создайте абстрактный класс Employee с методами getSalary() и getRole(). Реализуйте два класса:
        //
        //Manager
        //Developer
        //Каждый класс должен возвращать свою зарплату и роль.
        System.out.println("Задание 4. Вывод:");
        System.out.println();

        //5. Управление устройствами
        //Создайте интерфейс Switchable с методами turnOn() и turnOff(). Реализуйте классы:
        //
        //LightBulb
        //Fan
        //Каждый класс должен менять свое состояние (включено/выключено).
        System.out.println("Задание 5. Вывод:");
        System.out.println();

        //6. Геометрические фигуры
        //Создайте интерфейс Drawable с методом draw(). Реализуйте классы:
        //
        //Circle
        //Square
        //Метод draw() должен выводить текстовое описание фигуры (например, "Рисуем круг").
        System.out.println("Задание 6. Вывод:");
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
        System.out.println();

        //8. Спортивные соревнования
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
//3. Абстрактный класс + интерфейс
//Создайте абстрактный класс Vehicle с методом startEngine(). Добавьте интерфейс Flyable с методом fly(). Реализуйте два класса:
//
//Car (наследует Vehicle)
//Plane (наследует Vehicle и реализует Flyable).
interface Flyable {
    void fly();
}

abstract class Vehicle {
    abstract void startEngine();
}

class Car extends Vehicle {

    @Override
    void startEngine() {
        System.out.println("Двигатель запускается");
    }
}

class Plane extends Vehicle implements Flyable {

    @Override
    public void fly() {
        System.out.println("Взлетаем");
    }

    @Override
    void startEngine() {
        System.out.println("Двигатель запускается");
    }
}
//Классы и интерфейсы для задания 4
//Классы и интерфейсы для задания 5
//Классы и интерфейсы для задания 6
//Классы и интерфейсы для задания 7
//Классы и интерфейсы для задания 8
//Классы и интерфейсы для задания 9
//Классы и интерфейсы для задания 10
