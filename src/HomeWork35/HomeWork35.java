package HomeWork35;

import java.io.*;
import java.util.*;

class BankAccount {
    private double balance;
    private String owner;

    public BankAccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (balance - amount < 0) {
            System.out.println("Некорректная операция, баланс не может принимать значение меньше нуля");
            return balance;
        } else {
            return balance -= amount;
        }
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Order {
    private List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}

public class HomeWork35 {
    public static void main(String[] args) {
        //Задания для самостоятельной работы (Java, средний уровень)
        //Дополнительно
        //Все задания требуют обработки ошибок (например, если ввод некорректен) и должны быть решены
        //без использования break и continue, если это не критично.

        //1-2. Задания на if
        //Задание 1: Классификация углов
        //Напишите программу, которая запрашивает у пользователя угол в градусах (целое число от 0 до 360)
        // и классифицирует его следующим образом:
        //Острый угол (меньше 90 градусов)
        //Прямой угол (ровно 90 градусов)
        //Тупой угол (от 91 до 179 градусов)
        //Развернутый угол (ровно 180 градусов)
        //Невалидный угол (больше 180 градусов, но не более 360)
        //Выведите соответствующее сообщение.
        //Если введенное число выходит за пределы 0-360, программа должна выводить сообщение об ошибке.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 1. Вывод:");
        System.out.print("Введите градус от 0 до 360: ");
        int gradus = scanner.nextInt();
        scanner.nextLine();
//        int gradus = 50;
        if (gradus <= 0 || gradus > 360) {
            System.out.println("Некорректное значение");
        } else if (gradus < 90) {
            System.out.println("Острый угол");
        } else if (gradus == 90) {
            System.out.println("Прямой угол");
        } else if (gradus > 90 && gradus < 180) {
            System.out.println("Тупой угол");
        } else if (gradus == 180) {
            System.out.println("Развернутый угол");
        } else if (gradus > 180 && gradus <= 360) {
            System.out.println("Невалидный угол");
        }
        System.out.println();

        //Задание 2: Оценка кредита
        //Напишите программу, которая запрашивает у пользователя его возраст, ежемесячный доход и сумму кредита, который он хочет взять. Программа должна проверять следующие условия:
        //Возраст должен быть от 18 до 65 лет.
        //Доход должен быть не менее 50 000 рублей.
        //Сумма кредита не должна превышать 10-кратный размер ежемесячного дохода.
        //Если все условия выполняются, программа должна сообщить, что кредит одобрен.
        //В противном случае программа должна объяснить причину отказа.
        System.out.println("Задание 2. Оценка кредита. Вывод:");
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();
//        int age = 18;
        System.out.print("Введите доход: ");
        int dohod = scanner.nextInt();
        scanner.nextLine();
//        int dohod = 51000;
        System.out.print("Введите запрашиваемую сумму: ");
        int credit = scanner.nextInt();
        scanner.nextLine();
//        int credit = 300000;
        System.out.println("Возраст: " + age);
        System.out.println("Доход: " + dohod);
        System.out.println("Запрашиваемая сумма: " + credit);
        if (age >= 18 && age <= 65 && dohod >= 50000 && credit <= dohod * 10) {
            System.out.println("Кредит одобрен");
        } else {
            System.out.println("Кредит не одобрен");
        }
        System.out.println();

        //3. Задание на switch
        //Задание 3: Калькулятор простых операций
        //Напишите консольную программу, которая запрашивает у пользователя два числа (целые) и оператор (+, -, *, /).
        //Используйте switch для выполнения соответствующей арифметической операции.
        //Обработайте следующие случаи:
        //Деление на ноль (вывести сообщение об ошибке).
        //Ввод некорректного оператора (вывести сообщение об ошибке).
        //Корректный вывод результата.
        System.out.println("Задание 3. Вывод:");
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите операцию (+, -, *, /): ");
        char operation = scanner.next().charAt(0);
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();
        scanner.nextLine();
        switch (operation) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("На ноль делить нельзя");
                } else {
                    System.out.println(a + " / " + b + " = " + (a / b));
                }
                break;
            default:
                System.out.println("Неверная операция");
        }
        System.out.println();

        //4-5. Задания на while
        //Задание 4: Поиск числа Фибоначчи
        //Пользователь вводит целое положительное число n. Программа должна вывести n-й элемент последовательности Фибоначчи, используя цикл while.
        //(Последовательность: 0, 1, 1, 2, 3, 5, 8, 13, …)
        System.out.println("Задание 4. Вывод:");
        System.out.print("Введите число для вывода ряда Фибоначчи: ");
        int n = scanner.nextInt();
        scanner.nextLine();
//        int n = 8;
        int firstNum = 0; //первое число
        int secondNum = 1; //второе число
        int currentNum = 0; //текущее число
        int count = 1; //счетчик цикла
        while (count <= n) {
            if (count == 1) {
                currentNum = firstNum;
                System.out.print(currentNum + " ");
            } else if (count == 2) {
                currentNum = secondNum;
                System.out.print(currentNum + " ");
            } else {
                currentNum = firstNum + secondNum;
                firstNum = secondNum;
                secondNum = currentNum;
                System.out.print(currentNum + " ");
            }
            count++;
        }
        System.out.println();
        System.out.println();

        //Задание 5: Проверка на палиндром
        //Напишите программу, которая запрашивает у пользователя строку и проверяет, является ли она палиндромом (читается одинаково слева направо и справа налево). Используйте цикл while для проверки.
        //Пример работы:
        //Введите строку: level
        //Это палиндром!
        //Введите строку: hello
        //Это не палиндром.
        System.out.println("Задание 5. Вывод:");
        System.out.print("Введите слово: ");
        String inputString = scanner.nextLine().toLowerCase();
//        String inputString = "Level".toLowerCase();
        int startPoint = 0;
        int endPoint = inputString.length() - 1;
        boolean isPalindrome = true;

        while (startPoint < endPoint) {
            if (inputString.charAt(startPoint) != (inputString.charAt(endPoint))) {
                isPalindrome = false;
                break;
            } else {
                startPoint++;
                endPoint--;
            }
        }
        if (isPalindrome) {
            System.out.println("Слово \"" + inputString + "\" - палиндром");
        } else {
            System.out.println("Слово \"" + inputString + "\" - не палиндром");
        }
        System.out.println();

        //6-7. Задания на ООП
        //Задание 6: Банковский счет
        //Создайте класс BankAccount, который содержит:
        //Поля: balance (баланс), owner (владелец счета).
        //Метод deposit(double amount), который увеличивает баланс.
        //Метод withdraw(double amount), который уменьшает баланс, но не позволяет уйти в минус.
        //Конструктор, который принимает начальный баланс и имя владельца.
        //Напишите программу, которая создает объект BankAccount, выполняет несколько операций пополнения и снятия и выводит итоговый баланс.
        System.out.println("Задание 6. Вывод:");
        BankAccount bankAccount = new BankAccount(10000, "Дима");
        System.out.println("Исходный баланс: " + bankAccount.getBalance());
        bankAccount.deposit(10000);
        System.out.println("Измененный баланс: " + bankAccount.getBalance());
        bankAccount.withdraw(100);
        System.out.println("Измененный баланс: " + bankAccount.getBalance());
        bankAccount.withdraw(19900);
        System.out.println("Измененный баланс: " + bankAccount.getBalance());
        bankAccount.withdraw(1);
        System.out.println("Измененный баланс: " + bankAccount.getBalance());
        bankAccount.deposit(10000);
        System.out.println("Измененный баланс: " + bankAccount.getBalance());
        System.out.println();

        //Задание 7: Управление заказами
        //Создайте классы Product (товар) и Order (заказ).
        //Product должен содержать поля: name (название), price (цена).
        //Order должен содержать список товаров (List<Product>) и метод getTotalPrice(), который вычисляет общую стоимость заказа.
        //Создайте несколько товаров, добавьте их в заказ, посчитайте итоговую сумму и выведите результат.
        System.out.println("Задание 7. Вывод:");
        Product fish = new Product("Окунь", 450);
        Product milk = new Product("Молоко", 88.50);
        Product bread = new Product("Хлеб", 30.14);
        Order order = new Order();
        order.addProduct(fish);
        order.addProduct(milk);
        order.addProduct(bread);
        System.out.println("Стоимость заказа: " + order.getTotalPrice());
        System.out.println();

        //8-9. Задания на Stream API
        //Задание 8: Фильтрация чисел
        //Дан список чисел List<Integer>. Используйте Stream API, чтобы:
        //Оставить только четные числа.
        //Упорядочить их по убыванию.
        //Вывести их на экран.
        //Пример входных данных: [5, 12, 7, 3, 14, 18, 6]
        //Выход: [18, 14, 12, 6]
        System.out.println("Задание 8. Вывод:");
        List<Integer> integerList = List.of(5, 12, 7, 3, 14, 18, 6);
        System.out.println("Исходный лист: " + integerList);
        List<Integer> result8 = integerList.stream().filter(i -> i % 2 == 0).sorted((x, y) -> y.compareTo(x)).toList();
        System.out.println("Измененный лист: " + result8);
        System.out.println();

        //Задание 9: Поиск самого длинного слова
        //Дан список строк List<String>. Используйте Stream API, чтобы:
        //Найти самое длинное слово.
        //Если есть несколько слов одинаковой длины, выбрать первое.
        //Вывести его на экран.
        //Пример входных данных: ["кот", "слон", "крокодил", "тигр", "леопард"]
        //Выход: "крокодил"
        System.out.println("Задание 9. Вывод:");
        List<String> strings = List.of("кот", "слон", "крокодил", "тигр", "леопард");
        System.out.println("Исходный лист: " + strings);
        Optional<String> result9 = strings.stream().max(Comparator.comparingInt(String::length));
        System.out.println("Самое длинное слово: " + result9.get());
        System.out.println();

        //10. Задание на IO File
        //Задание 10: Чтение и обработка данных из файла
        //Напишите программу, которая:
        //Читает файл input.txt, содержащий числа (по одному числу в строке).
        //Суммирует все числа из файла.
        //Записывает результат в файл output.txt.
        //Пример input.txt:
        //10
        //20
        //30
        //40
        //Результат в output.txt:
        //Сумма чисел: 100
        System.out.println("Задание 10. Вывод:");
        File input = new File("input.txt");
        File output = new File("output.txt");
        try {
            //заполняю файл input.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter(input));
            writer.write("10");
            writer.newLine();
            writer.write("20");
            writer.newLine();
            writer.write("30");
            writer.newLine();
            writer.write("40");
            writer.newLine();
            writer.write("50");
            writer.close();

            //подсчитываю значения в файле input.txt и нахожу сумму
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            int result = 0;
            while ((line = reader.readLine()) != null) {
                int intermediateResult = line.lines().mapToInt(Integer::parseInt).sum();
                result += intermediateResult;
            }
            String resultToWrite = "Сумма чисел: " + result;
            System.out.println(resultToWrite);
            reader.close();

            //записываю результат в файл output.txt
            writer = new BufferedWriter(new FileWriter(output));
            writer.write(resultToWrite);
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
