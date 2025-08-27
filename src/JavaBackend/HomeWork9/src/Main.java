
public class Main {
    //1. Insert с параметрами
    //Напиши метод insertStudent, который добавляет в таблицу Students запись с параметрами (id, firstname, lastname, age) через PreparedStatement.
    public static void insert(){
        System.out.println("тут добавление");
    }

    //2. Delete по условию
    //Сделай метод deleteOldBooks, который удаляет все книги из таблицы Books, где year < 2000.
    public static void deleteOldBooks(){
        System.out.println("тут удаление старых книг");
    }

    //3. Update имени
    //Создай метод updateCityName, который изменяет название города в таблице Cities с OldName на NewName.
    public static void updateCityName(){
        System.out.println("обновление наименований городов");
    }

    //4. Select с фильтром
    //Сделай метод getCheapProducts, который возвращает список продуктов из таблицы Products, где price < 100.
    public static void getCheapProducts(){
        System.out.println("тут выборка");
    }

    //5. Подсчёт строк
    //Напиши метод countEmployees, который выводит количество строк в таблице Employees.
    public static int countEmployees(){
        return 0;
    }

    //6. Insert без ID (auto_increment)
    //Создай метод addCategory, который добавляет категорию в таблицу Categories(name, description), где id генерируется автоматически.
    public static void addCategory(){
        System.out.println("вставка без id");
    }

    //7. Update зарплаты
    //Напиши метод increaseSalary, который увеличивает зарплату всем сотрудникам из таблицы Employees на 10%.
    public static void increaseSalary(){
        System.out.println("обновление зарплаты");
    }

    //8. Delete по ID
    //Сделай метод deleteOrder, который удаляет заказ из таблицы Orders по order_id.
    public static void deleteOrder(){
        System.out.println("удаление по id");
    }

    //9. Select сортировка
    //Создай метод getAllCustomersSorted, который возвращает список клиентов из таблицы Customers, отсортированных по фамилии.
    public static void getAllCustomersSorted(){
        System.out.println("выборка с сортировкой");
    }

    //10. Select с ограничением
    //Сделай метод getTop5ExpensiveProducts, который возвращает только 5 самых дорогих продуктов из таблицы Products.
    public static void getTop5ExpensiveProducts(){
        System.out.println("выборка с условием");
    }

    public static void main(String[] args) {
        /*todo сделать конфигурационный класс, туда добавить информацию о подключении, создать таблицы (через java или вручную? наверное через java.
        *  далее выполнить задание с использованием конфигурации*/

    }
}