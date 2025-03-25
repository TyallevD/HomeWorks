package HomeWork36;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class LoginFileManager {
    private List<Login> logins;
    private final File file = new File("/users/users.txt");

// что должен уметь менеджер логинов:
    //1) добавлять новый уникальный логин
    //2) считывать логин из файла и передавать в другие методы/классы

//    public void saveLogin(Login user) throws Exception {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//            for (Login login : logins) {
//                writer.write(login.toString());
//                writer.newLine();
//            }
//        }
//    }
}
