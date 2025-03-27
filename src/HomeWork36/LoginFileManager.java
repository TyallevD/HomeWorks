package HomeWork36;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LoginFileManager {
    private List<Login> logins;

// что должен уметь менеджер логинов:
    //1) добавлять новый уникальный логин
    //2) считывать логин из файла и передавать в другие методы/классы

    public static void createOrCheckExistingFolders() {

        if (!ProgrammPaths.USERS_DIR.exists()) {
            System.out.println(ProgrammPaths.USERS_DIR.mkdir() ? "Папка юзеров создана" : "Папка юзеров не создана");
        }

        if (!ProgrammPaths.CONTACTS_DIR.exists()) {
            System.out.println(ProgrammPaths.CONTACTS_DIR.mkdir() ? "Папка контактов создана" : "Папка контактов не создана");

        }

        if (!ProgrammPaths.USERS_FILE.exists()) {
            try {
                ProgrammPaths.USERS_FILE.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка создания файла users.txt " + e.getMessage());
            }
        }
    }

    public void createLoginContacts(String login) throws IOException {
        Path contactsFilePath = Paths.get(ProgrammPaths.CONTACTS_DIR.getPath());
        File file = new File(contactsFilePath + "/" + login.concat("Contacts.txt"));
        file.createNewFile();
    }

    public void addLogin(Login login) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProgrammPaths.USERS_FILE.getPath(), true))) {
            writer.write(login.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось записать информацию в файл: " + e.getMessage());
        }
    }
}
