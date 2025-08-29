import models.Customer;
import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String driver = DbCreator.getSqlDriver();
    static String url = DbCreator.getHomeWorkUrl();
    static String userName = DbCreator.getUserName();
    static String password = DbCreator.getUserPassword();

    //1. Insert с параметрами
    //Напиши метод insertStudent, который добавляет в таблицу Students запись с параметрами (id, firstname, lastname, age) через PreparedStatement.
    public static void insertStudent(int id, String firstname, String lastname, int age) {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                String sqlQueryAddNewStudent = "INSERT INTO Students(id,firstname,lastname,age) VALUES (?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryAddNewStudent)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, firstname);
                    preparedStatement.setString(3, lastname);
                    preparedStatement.setInt(4, age);

                    preparedStatement.executeUpdate();

                    System.out.println("Студент с id \"" + id +
                            "\" Именем: \"" + firstname +
                            "\" Фамилией \"" + lastname +
                            "\" и возрастом \"" + age +
                            "\" добавлен в таблицу Students");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //2. Delete по условию
    //Сделай метод deleteOldBooks, который удаляет все книги из таблицы Books, где year < 2000.
    public static void deleteOldBooks() {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();
                String deleteQuery = "DELETE FROM Books " +
                        "WHERE year < 2000";
                int deletedRows = statement.executeUpdate(deleteQuery);

                System.out.println("Удалено строк из Books " + deletedRows);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //3. Update имени
    //Создай метод updateCityName, который изменяет название города в таблице Cities с OldName на NewName.
    public static void updateCityName(String oldName, String newName) {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();
                String updateQuery = "UPDATE City " +
                        "SET city_name = '" + newName + "' " +
                        "WHERE city_name = '" + oldName + "'";

                int updatedRows = statement.executeUpdate(updateQuery);

                System.out.println("Изменено строк в таблице City: " + updatedRows);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //4. Select с фильтром
    //Сделай метод getCheapProducts, который возвращает список продуктов из таблицы Products, где price < 100.
    public static List<Product> getCheapProducts() {
        List<Product> cheapProducts = new ArrayList<>();
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();

                String cheapProductsQuery = "SELECT * FROM Products " +
                        "WHERE price<100";

                ResultSet resultSet = statement.executeQuery(cheapProductsQuery);

                while (resultSet.next()) {
                    cheapProducts.add(new Product(resultSet.getInt("id"),
                            resultSet.getString("product_name"),
                            resultSet.getDouble("price")));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cheapProducts;
    }

    //5. Подсчёт строк
    //Напиши метод countEmployees, который выводит количество строк в таблице Employees.
    public static void countEmployees() {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();

                String getEmployeesCountQuery = "SELECT COUNT(*) FROM Employees";
                ResultSet resultSet = statement.executeQuery(getEmployeesCountQuery);
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    System.out.println("Количество строк в Employees = " + count);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //6. Insert без ID (auto_increment)
    //Создай метод addCategory, который добавляет категорию в таблицу Categories(name, description), где id генерируется автоматически.
    public static void addCategory(String categoryName, String categoryDescription) {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();

            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                String addCategoryQuery = "INSERT INTO  Category(name, description) VALUES (?,?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(addCategoryQuery)) {
                    preparedStatement.setString(1, categoryName);
                    preparedStatement.setString(2, categoryDescription);

                    preparedStatement.executeUpdate();
                    System.out.println("Категория \"" + categoryName + "\" успешно добавлена");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //7. Update зарплаты
    //Напиши метод increaseSalary, который увеличивает зарплату всем сотрудникам из таблицы Employees на 10%.
    public static void increaseSalary() {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();

                String sqlUpdateSalaryQuery = "UPDATE Employees " +
                        "SET salary = salary + (salary * 0.1)";
                int updatedRows = statement.executeUpdate(sqlUpdateSalaryQuery);
                System.out.println("Обновлено строк: " + updatedRows);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //8. Delete по ID
    //Сделай метод deleteOrder, который удаляет заказ из таблицы Orders по order_id.
    public static void deleteOrder(int id) {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();
                String deleteOrderByIdQuery = "DELETE FROM  Orders " +
                        "WHERE id = " + id;
                int deletedRows = statement.executeUpdate(deleteOrderByIdQuery);
                System.out.println("Удалено строк из Order: " + deletedRows);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //9. Select сортировка
    //Создай метод getAllCustomersSorted, который возвращает список клиентов из таблицы Customers, отсортированных по фамилии.
    public static List<Customer> getAllCustomersSorted() {
        List<Customer> sortedCustomers = new ArrayList<>();
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();
                String sortedCustomersQuery = "SELECT * FROM Customers " +
                        "ORDER BY lastname ASC ";

                ResultSet resultSet = statement.executeQuery(sortedCustomersQuery);

                while (resultSet.next()) {
                    sortedCustomers.add(new Customer(resultSet.getInt("id"),
                            resultSet.getString("firstname"),
                            resultSet.getString("lastname")));
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sortedCustomers;
    }

    //10. Select с ограничением
    //Сделай метод getTop5ExpensiveProducts, который возвращает только 5 самых дорогих продуктов из таблицы Products.
    public static List<Product> getTop5ExpensiveProducts() {
        List<Product> expensiveProducts = new ArrayList<>();
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, userName, password)) {
                Statement statement = connection.createStatement();
                String sqlExpensiveProducts = "SELECT TOP 5 * FROM Products " +
                        "ORDER BY price DESC ";

                ResultSet resultSet = statement.executeQuery(sqlExpensiveProducts);

                while (resultSet.next()) {
                    expensiveProducts.add(new Product(resultSet.getInt("id"),
                            resultSet.getString("product_name"),
                            resultSet.getDouble("price")));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return expensiveProducts;
    }

    public static void main(String[] args) {
        //Создание и наполнение базы данных
        DbCreator.createDb();
        DbCreator.createTables();
        DbCreator.fillDb();

        //Удаление базы данных
//        DbCreator.dropDb();


        Scanner scanner = new Scanner(System.in);
        //Задание 1
        System.out.println("Задание 1. Добавление студента");
        System.out.print("Введите id: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите имя: ");
        String studentName = scanner.nextLine().trim();
        System.out.print("Введите фамилию: ");
        String studentSurname = scanner.nextLine().trim();
        System.out.print("Введите возраст: ");
        int studentAge = Integer.parseInt(scanner.nextLine());

        insertStudent(studentId, studentName, studentSurname, studentAge);
        System.out.println();

        //Задание 2
        System.out.println("Задание 2. Удаление старых книг из Books");
        deleteOldBooks();
        System.out.println();

        //Задание 3
        System.out.println("Задание 3. Обновление имени города в City");
        String oldName = "Санкт Петербург";
        String newName = "Ленинград";
        updateCityName(oldName, newName);
        System.out.println();

        //Задание 4
        System.out.println("Задание 4. Выборка дешевых продуктов из Products");
        for (Product product : getCheapProducts()) {
            System.out.println(product);
        }
        System.out.println();

        //Задание 5
        System.out.println("Задание 5. Подсчет количества сотрудников в таблице Employees");
        countEmployees();
        System.out.println();

        //Задание 6
        System.out.println("Задание 6. Добавление категории с автоинкрементом id");
        String categoryName = "Электротовары";
        String categoryDescription = "Настольные лампы, лампочки, тройники, сетевые фильтры";
        addCategory(categoryName, categoryDescription);
        System.out.println();

        //Задание 7
        System.out.println("Задание 7. Увеличение зарплаты на 10% в Employees");
        increaseSalary();
        System.out.println();

        //Задание 8
        System.out.println("Задание 8. Удаление заказа из Orders по id");
        deleteOrder(2);
        System.out.println();

        //Задание 9
        System.out.println("Задание 9. Выборка с сортировкой из таблицы покупателей (Customers)");
        for (Customer customer : getAllCustomersSorted()) {
            System.out.println(customer);
        }
        System.out.println();

        //Задание 10
        System.out.println("Задание 10. Выборка самых дорогих продуктов из Products");
        for (Product product : getTop5ExpensiveProducts()) {
            System.out.println(product);
        }
    }
}