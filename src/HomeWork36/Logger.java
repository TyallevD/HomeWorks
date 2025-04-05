package HomeWork36;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Logger {
    //логгер должен записывать все действия:
    //1) запуск программы, остановка программы
    //2) авторизация, регистрация
    //3) добавление, удаление, изменение контактов, сохранение контактов
    //4) просмотр контактов (отображение всех контактов, поиск контактов, сортировка контактов
    public static void addRecord(String message) {
        LocalDate date = LocalDate.now();
        String login;
        if (Session.getCurrentLogin() == null) {
            login = "unauthorized";
        } else {
            login = Session.getCurrentLogin();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProgrammPaths.LOGS_FILE, true))) {
            writer.write("[" + date + "] " + "[" + login + "]" + " " + message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось выполнить запись в лог");
        }
    }
}
