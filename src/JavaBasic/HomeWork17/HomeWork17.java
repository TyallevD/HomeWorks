package JavaBasic.HomeWork17;

public class HomeWork17 {
    public static void main(String[] args) {
        //Задание 1
        //Создайте класс Circle, который имеет:
        //Поле radius (тип double).
        //Конструктор для установки радиуса.
        //Метод calculateArea(), который возвращает площадь круга.
        System.out.println("Задание 1. Вывод:");
        double radius = 10;

        Circle circle = new Circle(radius);

        System.out.println("Площадь круга с радиусом " + radius + " равна: " + circle.calculateArea());
        System.out.println();

        //Задание 2
        //Создайте класс Rectangle, который имеет:
        //Поля length и width (оба типа double).
        //Конструктор для установки длины и ширины.
        //Метод calculatePerimeter(), который возвращает периметр прямоугольника.
        System.out.println("Задание 2. Вывод:");
        double length = 10;
        double width = 10;

        Rectangle rectangle = new Rectangle(length, width);

        System.out.println("Периметр прямоугольника с длиной \"" + length + "\" и шириной \"" +
                width + "\" равна " + rectangle.calculatePerimeter());
        System.out.println();

        //Задание 3
        //Создайте класс Student, который имеет:
        //Поля name (тип String) и age (тип int).
        //Конструктор для установки имени и возраста.
        //Метод displayInfo(), который выводит имя и возраст студента в консоль.
        System.out.println("Задание 3. Вывод:");

        Student student = new Student("Дмитрий", 34);
        student.displayInfo();

        System.out.println();

        //Задание 4
        //Создайте класс Car, который имеет:
        //Поля brand (тип String) и speed (тип int).
        //Конструктор для установки бренда и начальной скорости.
        //Метод accelerate(int increment), который увеличивает скорость на указанное значение.
        System.out.println("Задание 4. Вывод:");

        Car car1 = new Car("Мерседес", 0);

        System.out.println("Автомобиль " + car1.brand + ". Скорость " + car1.speed + " км/ч");
        System.out.println("Разгоняем " + car1.brand + " до " + car1.accelerate(60) + " км/ч");
        System.out.println("Теперь " + car1.brand + " едет со скоростью " + car1.speed + " км/ч");
        System.out.println();

        //Задание 5
        //Создайте класс Book, который имеет:
        //Поля title (тип String) и author (тип String).
        //Конструктор для установки названия книги и автора.
        //Метод getBookInfo(), который возвращает строку с информацией о книге.
        System.out.println("Задание 5. Вывод:");

        Book book1 = new Book("Java. Полное руководство для начинающих", "Герберт Шилдт");
        System.out.println(book1.getBookInfo());
        Book book2 = new Book("Властелин колец", "Дж. Р. Р. Толкиен");
        System.out.println(book2.getBookInfo());

        System.out.println();

        //Задание 6
        //Создайте класс Point, который имеет:
        //Поля x и y (оба типа int).
        //Конструктор для установки координат точки.
        //Метод move(int dx, int dy), который изменяет координаты точки на заданное смещение.
        System.out.println("Задание 6. Вывод:");
        Point point = new Point(0, 0);
        System.out.println("Стартовая точка х = "+point.x + "; y =" + point.y);
        point.move(1, 2);
        System.out.println("Перемещаемся на координаты х = "+point.x + "; y = " + point.y);
        point.move(-1, 2);
        System.out.println("Перемещаемся на координаты х = "+point.x + "; y = " + point.y);
        System.out.println();

        //Задание 7
        //Создайте класс Person, который имеет:
        //Поля firstName и lastName (оба типа String).
        //Конструктор для установки имени и фамилии.
        //Метод getFullName(), который возвращает полное имя человека.
        System.out.println("Задание 7. Вывод:");

        Person person = new Person("Дмитрий", "Тяллев");
        System.out.println("Имя: " + person.firstName);
        System.out.println("Фамилия: " + person.lastName);
        System.out.println("Получаем полное имя: " + person.getFullName());

        System.out.println();

        //Задание 8
        //Создайте класс Temperature, который имеет:
        //Поле celsius (тип double).
        //Конструктор для установки температуры в градусах Цельсия.
        //Методы toFahrenheit() и toKelvin(), которые возвращают температуру в Фаренгейтах и Кельвинах соответственно.
        System.out.println("Задание 8. Вывод:");
        Temperature temperature = new Temperature(40);
        System.out.println("Текущая температура по Цельсию: " + temperature.celsius);
        System.out.println("Переводим температуру в Фаренгейты: " + temperature.toFahrenheit());
        System.out.println("Переводим температуру в Кельвины: " + temperature.toKelvin());
        System.out.println();

        //Задание 9
        //Создайте класс Counter, который имеет:
        //Поле count (тип int), изначально равное 0.
        //Метод increment(), который увеличивает значение поля на 1.
        //Метод decrement(), который уменьшает значение поля на 1.
        //Метод getCount(), который возвращает текущее значение счетчика.
        System.out.println("Задание 9. Вывод:");
        Counter counter = new Counter();
        System.out.println("Стартовое значение = " + counter.getCount());
        System.out.println();

        counter.decrement();
        System.out.println("Измененное значение = " + counter.getCount());
        System.out.println();

        counter.increment();
        System.out.println("Измененное значение = " + counter.getCount());
        System.out.println();

        counter.increment();
        System.out.println("Измененное значение = " + counter.getCount());
        System.out.println();

        //Задание 10
        //Создайте класс Time, который имеет:
        //Поля hours и minutes (оба типа int).
        //Конструктор для установки времени.
        //Метод addMinutes(int minutes), который добавляет заданное количество минут к времени и корректно обновляет часы.
        System.out.println("Задание 10. Вывод:");
        Time time = new Time(0, 0);
        System.out.println("Стартовое время");
        System.out.println(time.hours + ":" + time.minutes);
        time.addMinutes(3660);
        System.out.println(time.hours + ":" + time.minutes);
        System.out.println();
    }
}

//Класс для задания 1
class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

//Класс для задания 2
class Rectangle {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

//Класс для задания 3
class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(name + " " + age);
    }
}

//Класс для задания 4
class Car {
    String brand;
    int speed;

    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public int accelerate(int increment) {
        return speed += increment;
    }
}

//Класс для задания 5
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getBookInfo() {
        return "Книгу под названием \"" + title + "\" написал " + author;
    }
}

//Класс для задания 6
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

//Класс для задания 7
class Person {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName.concat(" " + lastName);
    }
}

//Класс для задания 8
class Temperature {
    double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double toFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    public double toKelvin() {
        return celsius + 273.15;
    }
}

//Класс для задания 9
class Counter {
    int count = 0;

    public int increment() {
        System.out.println("Увеличиваем счетчик");
        return count++;
    }

    public int decrement() {
        System.out.println("Уменьшаем счетчик");
        return count--;
    }

    public int getCount() {
        return count;
    }
}

//Класс для задания 10
class Time {
    int hours;
    int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public void addMinutes(int minutes) {
        System.out.println("Добавляем минуты: " + minutes);
        this.minutes += minutes;
        this.hours += this.minutes / 60;
        this.hours %= 24;
        this.minutes %= 60;

    }
}