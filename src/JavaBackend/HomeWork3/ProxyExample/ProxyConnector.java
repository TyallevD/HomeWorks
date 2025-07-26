package JavaBackend.HomeWork3.ProxyExample;

public class ProxyConnector implements Connector {
    private SimpleConnector connector;

    @Override
    public void uploadFile(String fileName) {
        init();
        if (validate(fileName)) {
            connector.uploadFile(fileName);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void downloadFile(String fileName) {
        init();
        if (validate(fileName)) {
            connector.downloadFile(fileName);
        } else {
            System.out.println("Ошибка! Файл не выбран или не указано имя файла");
        }
    }

    private void init() {
        if (connector == null) {
            connector = new SimpleConnector(new Server());
        }
    }

    //проверка на заполнение имени файла
    private boolean validate(String fileName) {
        return !fileName.isEmpty();
    }
}
