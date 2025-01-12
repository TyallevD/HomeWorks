package HomeWork22;

import java.util.Scanner;

//enum для задания 1
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public void todayIsADay(Day day) {
        System.out.println("Сегодня " + day);
    }
}

//enum для задания 2
enum Season {
    WINTER, SPRING, SUMMER, FALL;

    public boolean isSummer(Season season) {
        return season == Season.SUMMER;
    }
}

//enum для задания 3
enum Difficulty {
    EASY, MEDIUM, HARD;
}

//enum для задания 4
enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public String whereToGo(Direction direction) {
        return "Вы двигаетесь в сторону " + direction;
    }
}

//enum для задания 5 //todo какую строку из консоли принимать?
// Создайте enum Status с константами START, PROCESSING, FINISHED.
//Напишите программу, которая принимает строку из консоли и преобразует её в значение перечисления с помощью valueOf.
enum Status {
    START, PROCESSING, FINISHED;

    public static void printStatusNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите статус (START, PROCESSING, FINISHED): ");
            String line = scanner.nextLine();
            try {
                Status status = Status.valueOf(line.toUpperCase());
                System.out.println("Введен статус " + status);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Неверное значение. Попробуйте снова");
            }
        }
    }
}

//enum для задания 6
enum Priority {
    LOW, MEDIUM, HIGH;

    public static void printPosition() {
        for (Priority priority : Priority.values()) {
            System.out.printf("Приоритет %s   \t=> %d%n", priority, priority.ordinal());
        }
    }
}

//enum для задания 7
enum Months {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

    public static void printMonths() {
        System.out.println("Выводим месяцы:");
        for (Months values : Months.values()) {
            System.out.print(values + " ");
        }
        System.out.println();
    }
}

//enum для задания 8
enum Season8 {
    WINTER("Cold"), SPRING("Warm"), SUMMER("Warm"), FALL("Cold");
    final String description;

    Season8(String description) {
        this.description = description;
    }

    public String getDescription() {
        return "Season is " + description;
    }
}

//enum для задания 9
enum ProductCategory {
    ELECTRONICS(0.35), FOOD(0.10), CLOTHING(0.20);
    final double taxRate;

    ProductCategory(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculateTax(double price) {
        return price - (price / (1 + this.taxRate)); //если я правильно понял задание, то мы вычисляем именно НДС
    }
}

//enum для задания 10
enum Day10 {
    MONDAY(true), TUESDAY(true), WEDNESDAY(true), THURSDAY(true), FRIDAY(true), SATURDAY(false), SUNDAY(false);
    private final boolean isWorkingDay;

    Day10(boolean isWorkingDay) {
        this.isWorkingDay = isWorkingDay;
    }

    public boolean isWorkingDay() {
        return isWorkingDay;
    }
}

public class HomeWork22 {
    public static void main(String[] args) {
        //Простые задания:
        //1. Создание и использование enum для дней недели:
        //Создайте перечисление Day с константами для всех дней недели.
        //Напишите метод, который принимает Day в качестве аргумента и выводит сообщение: "Сегодня [день]".
        System.out.println("Задание 1. Вывод:");
        Day day = Day.FRIDAY;
        day.todayIsADay(day);
        day.todayIsADay(Day.WEDNESDAY);
        System.out.println();
        //2. Создание enum для времён года:
        //Создайте перечисление Season с константами WINTER, SPRING, SUMMER, FALL.
        //Напишите метод, который принимает сезон и возвращает логическое значение: true, если это лето.
        System.out.println("Задание 2. Вывод:");
        Season season = Season.WINTER;
        System.out.println("Является ли текущий сезон \"" + season + "\" Летом?: " + (season.isSummer(season) ? "Да" : "Нет"));
        System.out.println();

        //3. Перечисление для уровней сложности:
        //Создайте enum Difficulty с уровнями EASY, MEDIUM, HARD.
        //Используйте цикл для перебора всех значений перечисления и выведите их на экран.
        System.out.println("Задание 3. Вывод:");
        //через обычный цикл for
        System.out.println("Перечисление сложностей через обычный цикл for:");
        for (int i = 0; i < Difficulty.values().length; i++) {
            System.out.println(Difficulty.values()[i]);
        }
        System.out.println();
        System.out.println("Перечисление сложностей через цикл for each:");
        //через цикл for each
        for (Difficulty values : Difficulty.values()) {
            System.out.println(values);
        }
        System.out.println();

        //4. Перечисление для направлений:
        //Создайте enum Direction с константами NORTH, EAST, SOUTH, WEST.
        //Напишите метод, который принимает направление и возвращает сообщение: "Вы движетесь на [направление]".
        System.out.println("Задание 4. Вывод:");
        Direction direction = Direction.NORTH;
        System.out.println(direction.whereToGo(direction));
        System.out.println(direction.whereToGo(Direction.WEST));
        System.out.println();

        //5. Использование метода valueOf:
        // Создайте enum Status с константами START, PROCESSING, FINISHED.
        //Напишите программу, которая принимает строку из консоли и преобразует её в значение перечисления с помощью valueOf.
        System.out.println("Задание 5. Вывод:");
        Status.printStatusNumber();
        System.out.println();

        //6. Работа с ordinal:
        // Создайте enum Priority с уровнями LOW, MEDIUM, HIGH.
        //Напишите метод, который возвращает номер каждого уровня, используя метод ordinal().
        System.out.println("Задание 6. Вывод:");
        Priority.printPosition();
        System.out.println();

        //7. Перебор значений с values:
        // Создайте enum Months с названиями месяцев.
        //Используйте метод values() для вывода всех месяцев на экран.
        System.out.println("Задание 7. Вывод:");
        Months.printMonths();
        System.out.println();

        //8. Добавление описания к временам года:
        //Создайте enum Season с константами WINTER, SPRING, SUMMER, FALL.
        //Добавьте поле description (строка) для каждого сезона (например, "Cold", "Warm").
        //Напишите метод getDescription, который возвращает описание сезона.
        //example: System.out.println(Season.WINTER.getDescription());
        System.out.println("Задание 8. Вывод:");
        System.out.println(Season8.WINTER + " : " + Season8.WINTER.getDescription());
        System.out.println(Season8.SUMMER + " : " + Season8.SUMMER.getDescription());
        System.out.println(Season8.SPRING + " : " + Season8.SPRING.getDescription());
        System.out.println(Season8.FALL + " : " + Season8.FALL.getDescription());
        System.out.println();

        //9. Добавление полей и методов для категорий товаров:
        //Создайте enum ProductCategory с константами ELECTRONICS, FOOD, CLOTHING.
        //Для каждой категории добавьте поле taxRate (процент налога).
        //Напишите метод calculateTax, который принимает цену товара и возвращает налог на него.
        //example: double tax = ProductCategory.ELECTRONICS.calculateTax(1000);
        //         System.out.println("Tax: " + tax);
        System.out.println("Задание 9. Вывод:");
        double tax = ProductCategory.ELECTRONICS.calculateTax(50000);
        System.out.printf("Налог на товар категории \"%s\" составит: %-10.2f%n", ProductCategory.ELECTRONICS, tax);
        tax = ProductCategory.FOOD.calculateTax(100);
        System.out.printf("Налог на товар категории \"%s\" составит: %-10.2f%n", ProductCategory.FOOD, tax);
        tax = ProductCategory.CLOTHING.calculateTax(3000);
        System.out.printf("Налог на товар категории \"%s\" составит: %-10.2f%n", ProductCategory.CLOTHING, tax);
        System.out.println();

        //10. Определение рабочего времени по дням недели:
        //Создайте enum Day с константами для всех дней недели.
        //Добавьте поле isWorkingDay (логическое значение).
        //Реализуйте метод isWorkingDay, который возвращает true для будних дней и false для выходных.
        //example: System.out.println(Day.MONDAY.isWorkingDay()); // true
        //         System.out.println(Day.SUNDAY.isWorkingDay()); // false
        System.out.println("Задание 10. Вывод:");
        System.out.println("Day \"" + Day10.MONDAY + "\" is working day?: " + (Day10.MONDAY.isWorkingDay() ? "Yes" : "No"));
        System.out.println("Day \"" + Day10.SUNDAY + "\" is working day?: " + (Day10.SUNDAY.isWorkingDay() ? "Yes" : "No"));
    }
}
