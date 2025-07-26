package JavaBackend.HomeWork3.ProxyExample;

public class ProxyExample {
    public static void main(String[] args) {
        //обращение напрямую к простому коннектору
        System.out.println("Пример прямого обращения:");
        System.out.println("Создание \"подключения\" вне зависимости, есть ли обращение к методам download и upload:");
        Connector connector1 = new SimpleConnector(new Server()); //при создании коннектора сразу идет подключение к "серверу"
        connector1.downloadFile("Первый файл");
        connector1.uploadFile("Второй файл");
        connector1.downloadFile("");//в SimpleConnector нет проверки на пустое наименование файла
        System.out.println();

        //обращение к ProxyConnector
        System.out.println("Пример обращения через ProxyConnector:");
        Connector connector2 = new ProxyConnector();
        System.out.println("Создание \"подключения\" к серверу только после обращения к методам download и upload:");
        connector2.downloadFile("Первый файл");
        connector2.uploadFile("Второй файл");
        connector2.downloadFile("");//есть проверка на пустое имя файла
        System.out.println();

        System.out.println("Пример обращения к ProxyConnector без вызова методов download и upload:");
        Connector connector3 = new ProxyConnector(); //при создании коннектора через прокси не происходит подключения к серверу
        System.out.println("Тут подключение не срабатывает");
    }
}
