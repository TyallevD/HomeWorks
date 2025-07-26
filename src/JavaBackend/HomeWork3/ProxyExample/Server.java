package JavaBackend.HomeWork3.ProxyExample;

public class Server {
    public void putFile(String fileName){
        System.out.println("Файл \""+ fileName +"\" загружается...");
    }
    public void takeFile(String fileName){
        System.out.println("Файл \"" + fileName +"\" скачивается...");
    }
}
