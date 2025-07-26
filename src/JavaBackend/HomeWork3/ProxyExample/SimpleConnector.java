package JavaBackend.HomeWork3.ProxyExample;

public class SimpleConnector implements Connector{
    private final Server server;

    public SimpleConnector(Server server) {
        System.out.println("Создается простой коннектор, идёт подключение...");
        this.server = server;
    }

    @Override
    public void uploadFile(String fileName) {
        server.putFile(fileName);
    }

    @Override
    public void downloadFile(String fileName) {
        server.takeFile(fileName);
    }
}
