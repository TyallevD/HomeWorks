import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbCreator {
    private static String sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String masterUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=master;TrustServerCertificate=true";
    private static String homeWorkUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=HomeWork9;TrustServerCertificate=true";
    private static String userName = ""; //ТУТ НЕОБХОДИМО ВПИСАТЬ ИМЯ ПОЛЬЗОВАТЕЛЯ ДЛЯ РАБОТЫ С БД
    private static String userPassword = "";//ТУТ НЕОБХОДИМО ВПИСАТЬ ПАРОЛЬ ПОЛЬЗОВАТЕЛЯ ДЛЯ РАБОТЫ С БД

    public static String getSqlDriver() {
        return sqlDriver;
    }

    public static String getHomeWorkUrl() {
        return homeWorkUrl;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static void createDb() {
        try {
            Class.forName(sqlDriver).getDeclaredConstructor().newInstance();

            String url = masterUrl;
            String username = userName;
            String password = userPassword;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String dbName = "HomeWork9";
                String sqlQuery = "CREATE DATABASE ";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sqlQuery + dbName);

                System.out.println("База данных \"" + dbName + "\" успешно создана");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createTables() {
        try {
            Class.forName(sqlDriver).getDeclaredConstructor().newInstance();

            String url = homeWorkUrl;
            String username = userName;
            String password = userPassword;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String dbName = "HomeWork9";
                String sqlQuery = "CREATE TABLE Students(" +
                        "id INT, " +
                        "firstname NVARCHAR(50), " +
                        "lastname NVARCHAR(50), " +
                        "age INT); " +
                        "CREATE TABLE Books(" +
                        "id INT PRIMARY KEY, " +
                        "book_name NVARCHAR(50), " +
                        "year INT); " +
                        "CREATE TABLE City(" +
                        "id INT PRIMARY KEY, " +
                        "city_name NVARCHAR(50)); " +
                        "CREATE TABLE Products(" +
                        "id INT PRIMARY KEY, " +
                        "product_name NVARCHAR(50), " +
                        "price MONEY); " +
                        "CREATE TABLE Employees(" +
                        "id INT PRIMARY KEY, " +
                        "firstname NVARCHAR(50), " +
                        "lastname NVARCHAR(50), " +
                        "salary MONEY); " +
                        "CREATE TABLE Category(" +
                        "id INT PRIMARY KEY IDENTITY, " +
                        "name NVARCHAR(50), " +
                        "description NVARCHAR(100)); " +
                        "CREATE TABLE Orders(" +
                        "id INT PRIMARY KEY, " +
                        "order_name NVARCHAR(50), " +
                        "date INT); " +
                        "CREATE TABLE Customers(" +
                        "id INT PRIMARY KEY, " +
                        "firstname NVARCHAR(50), " +
                        "lastname NVARCHAR(50));";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sqlQuery);

                System.out.println("База данных \"" + dbName + "\" успешно заполнена всеми таблицами");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fillDb() {
        try {
            Class.forName(sqlDriver).getDeclaredConstructor().newInstance();

            String url = homeWorkUrl;
            String username = userName;
            String password = userPassword;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                //Добавляем студентов в Students
                List<Student> students = new ArrayList<>();
                students.add(new Student(1, "Дима", "Тяллев", 34));
                students.add(new Student(2, "Алексей", "Никифоров", 35));
                students.add(new Student(3, "Константин", "Черемнов", 38));
                students.add(new Student(4, "Юрий", "Островский", 36));


                String sqlQueryStudents = "INSERT INTO Students(id,firstname, lastname,age) VALUES (?,?,?,?)";
                int insertedRows = 0;

                for (Student student : students) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryStudents)) {
                        preparedStatement.setInt(1, student.getId());
                        preparedStatement.setString(2, student.getName());
                        preparedStatement.setString(3, student.getSurname());
                        preparedStatement.setInt(4, student.getAge());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу Students: " + insertedRows);

                //Добавляем книги в Books
                List<Book> books = new ArrayList<>();
                books.add(new Book(1, "Братство кольца", 1954));
                books.add(new Book(2, "Две крепости", 1954));
                books.add(new Book(3, "Возвращение короля", 1955));
                books.add(new Book(4, "Страж", 2010));
                books.add(new Book(5, "Аутодафе", 2011));
                books.add(new Book(6, "Золотые костры", 2012));
                books.add(new Book(7, "Проклятый горн", 2014));

                String sqlQueryBooks = "INSERT INTO Books(id, book_name, year) VALUES(?,?,?)";
                insertedRows = 0;

                for (Book book : books) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryBooks)) {
                        preparedStatement.setInt(1, book.getId());
                        preparedStatement.setString(2, book.getBookName());
                        preparedStatement.setInt(3, book.getYear());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу Books: " + insertedRows);

                //Добавляем города в City
                List<City> cities = new ArrayList<>();
                cities.add(new City(1, "Москва"));
                cities.add(new City(2, "Калуга"));
                cities.add(new City(3, "Нижний Новгород"));
                cities.add(new City(4, "Санкт Петербург"));
                cities.add(new City(5, "Самара"));

                insertedRows = 0;
                String sqlQueryCities = "INSERT INTO City(id, city_name) VALUES (?,?)";

                for (City city : cities) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryCities)) {
                        preparedStatement.setInt(1, city.getId());
                        preparedStatement.setString(2, city.getCityName());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу City " + insertedRows);

                //Добавляем продукты в Products
                List<Product> products = new ArrayList<>();
                products.add(new Product(1, "Вода", 50.00));
                products.add(new Product(2, "Хлеб", 35.00));
                products.add(new Product(3, "Шоколад", 150.00));
                products.add(new Product(4, "Молоко", 95.00));
                products.add(new Product(5, "Яйца", 120.00));

                insertedRows = 0;
                String sqlQueryProducts = "INSERT INTO Products(id, product_name, price) VALUES (?,?,?)";
                for (Product product : products) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryProducts)) {
                        preparedStatement.setInt(1, product.getId());
                        preparedStatement.setString(2, product.getProductName());
                        preparedStatement.setDouble(3, product.getPrice());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу Products " + insertedRows);

                //Добавляем сотрудников в Employees
                List<Employee> employees = new ArrayList<>();
                employees.add(new Employee(1, "Михаил", "Петров", 50000.00));
                employees.add(new Employee(2, "Анна", "Иванова", 150000.00));
                employees.add(new Employee(3, "Константин", "Черемнов", 200000.00));
                employees.add(new Employee(4, "Петр", "Камышин", 100000.00));
                employees.add(new Employee(5, "Алексей", "Потапов", 70000.00));

                insertedRows = 0;
                String sqlQueryEmployees = "INSERT INTO Employees(id, firstname, lastname, salary) VALUES (?,?,?,?)";
                for (Employee employee : employees) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryEmployees)) {
                        preparedStatement.setInt(1, employee.getId());
                        preparedStatement.setString(2, employee.getName());
                        preparedStatement.setString(3, employee.getSurname());
                        preparedStatement.setDouble(4, employee.getSalary());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу Employees " + insertedRows);

                //Добавляем категории в Category
                List<Category> categories = new ArrayList<>();
                categories.add(new Category(1, "Книги", "Книги любого жанра"));
                categories.add(new Category(2, "Спорттовары", "Гантели, приспособления, спортивная одежда"));
                categories.add(new Category(3, "Хозтовары", "Веники, совки, тряпки, туалетная бумага, чистящие средства"));
                categories.add(new Category(4, "Еда", "Скоропортящиеся продукты, хлеб, шоколад, рыба, вода"));

                insertedRows = 0;
                String sqlQueryCategories = "INSERT INTO Category(name, description) VALUES (?,?)";
                for (Category category : categories) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryCategories)) {
//                        preparedStatement.setInt(1, category.getId());
                        preparedStatement.setString(1, category.getName());
                        preparedStatement.setString(2, category.getDescription());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу Category " + insertedRows);

                //Добавляем заказы в Orders
                List<Order> orders = new ArrayList<>();
                orders.add(new Order(1, "Покупка книг", 2015));
                orders.add(new Order(2, "Покупка пиццы", 2016));
                orders.add(new Order(3, "Покупка квартиры", 2017));
                orders.add(new Order(4, "Покупка машины", 2018));

                insertedRows = 0;
                String sqlQueryOrders = "INSERT INTO Orders(id, order_name, date) VALUES (?,?,?)";
                for (Order order : orders) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryOrders)) {
                        preparedStatement.setInt(1, order.getId());
                        preparedStatement.setString(2, order.getOrderName());
                        preparedStatement.setInt(3, order.getDate());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу Orders " + insertedRows);
                //Добавляем покупателей в Customers
                List<Customer> customers = new ArrayList<>();
                customers.add(new Customer(1, "Павел", "Петров"));
                customers.add(new Customer(2, "Алексей", "Иванов"));
                customers.add(new Customer(3, "Олег", "Сидоров"));

                insertedRows = 0;
                String sqlQueryCustomers = "INSERT INTO Customers(id, firstname, lastname) VALUES (?,?,?)";
                for (Customer customer : customers) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryCustomers)) {
                        preparedStatement.setInt(1, customer.getId());
                        preparedStatement.setString(2, customer.getName());
                        preparedStatement.setString(3, customer.getSurname());

                        preparedStatement.executeUpdate();
                        insertedRows++;
                    }
                }
                System.out.println("Добавлено строк в таблицу Customers " + insertedRows);

                System.out.println("Все таблицы успешно заполнены!");
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void dropDb() {
        try {
            Class.forName(sqlDriver).getDeclaredConstructor().newInstance();

            String url = masterUrl;
            String username = userName;
            String password = userPassword;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String dbName = "HomeWork9";
                String sqlQuery = "DROP DATABASE ";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sqlQuery + dbName);

                System.out.println("База данных \"" + dbName + "\" успешно удалена");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
