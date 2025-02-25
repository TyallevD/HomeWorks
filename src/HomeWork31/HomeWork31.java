package HomeWork31;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class HomeWork31 {
    public static void main(String[] args) {
        //Задание: Разработка файлового менеджера на Java
        //Цель:
        //Разработать консольное приложение – файловый менеджер, который позволяет выполнять основные операции с файлами и папками:
        //✅ Создание (файлов и папок)
        //✅ Удаление (файлов и папок, включая рекурсивное удаление)
        //✅ Переименование
        //✅ Перемещение
        //✅ Вывод информации (размер файла, содержимое папки, сортировка)
        //
        //Функциональные требования:
        //Файловый менеджер должен поддерживать следующие команды:
        //
        //create-folder <путь> – создать папку
        //create-file <путь> – создать пустой файл
        //delete <путь> – удалить файл или папку
        //delete r <путь> – удалить файл или папку (содержимое папки удаляется рекурсивно)
        //rename <старое_имя> <новое_имя> – переименовать файл или папку
        //move <откуда> <куда> – переместить файл или папку
        //list <путь> – вывести содержимое папки (файлы и папки)
        //size <путь> – вывести размер файла или папки (считая размер всех вложенных файлов)
        //sort <путь> [name|size] – вывести содержимое папки с сортировкой по имени или размеру
        //exit – выход из программы
        //Дополнительные требования:
        //Приложение работает в консоли (без GUI).
        //Должна быть проверка ввода (например, существование файла перед удалением).
        //Возможность работы с разными дисками (C:\, D:\, E:\ и т.д.).
        //Красивый вывод в консоль (например, с отступами, табуляцией).

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Доступные команды:
                    - create-folder <путь>
                    - create-file <путь>
                    - delete <путь>
                    - delete r <путь>
                    - rename <старое_имя> <новое_имя>
                    - move <откуда> <куда>
                    - list <путь>
                    - size <путь>
                    - sort <путь> [name|size]
                    - exit""");
            System.out.print("Введите команду: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Вы вышли из программы");
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length == 0) {
                System.out.println("Неверная команда, попробуйте снова.");
                continue;
            }

            String command = parts[0];
            String[] params = new String[parts.length - 1];
            for (int i = 1; i < parts.length; i++) {
                params[i - 1] = parts[i];
            }

            myCommand(command, params);
        }
    }

    private static void myCommand(String command, String[] params) {
        switch (command) {
            case "create-folder": {
                createMyFolder(params);
                break;
            }
            case "create-file": {
                createMyFile(params);
                break;
            }
            case "delete": {
                myDelete(params);
                break;
            }
            case "delete r": {
                deleteRecurcive();
                break;
            }
            case "rename": {
                rename(params);
                break;
            }
            case "move": {
                myMove(params);
                break;
            }
            case "list": {
                myList();
                break;
            }
            case "size": {
                mySize(params);
                break;
            }
            case "sort": {
                mySort();
                break;
            }
            default: {
                System.out.println("Ошибка. Не поддерживаемая команда, попробуйте снова");
            }
        }
        System.out.println();
    }

    //1 - создание папки ================================ //todo нужно сделать возможность создать папку в папке (mkdirs)
    private static void createMyFolder(String[] params) {
        if (params.length != 1) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }

        File folder = new File(params[0]);
        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Папка уже существует");
            return;
        }
        System.out.println("Папка \"" + folder + "\" " + (folder.mkdir() ? "создана" : "не создана"));
    }

    //2 - создание пустого файла ================================
    private static void createMyFile(String[] params) {
        if (params.length != 1) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }

        File file = new File(params[0]);
        if (file.exists() && file.isFile()) {
            System.out.println("Файл уже существует.");
            return;
        }
        try {
            System.out.println("Файл \"" + file + "\" " + (file.createNewFile() ? "создан" : "не создан"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //3 - удаление файла или папки ================================ //todo надо обработать, если файл или папка не пусты
    private static void myDelete(String[] params) {
        if (params.length != 1) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }

        String path = params[0];
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Папки или файла не существует. Попробуйте снова");
            return;
        }
        System.out.println("Папка или файл \"" + path + "\" " + (file.delete() ? "удален(а)" : "не удален(а)"));
    }

    //4 - рекурсивное удаление ================================ //todo реализовать
    private static void deleteRecurcive() {
        System.out.println("Папка удалена");
    }

    //5 - переименование файл или папки ================================
    private static void rename(String[] params) {
        if (params.length != 2) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }
        File currentFile = new File(params[0]);
        if (!currentFile.exists()){
            System.out.println("Файл или папка не найдены. Попробуйте снова");
            return;
        }
        System.out.println("Файл \"" + params[0] + "\" " +
                (currentFile.renameTo(new File(params[1])) ? " переименован в \"" + params[1] + "\"" : " не переименован"));
    }

    //6 - копирование файла или папки (?) ================================
    private static void myMove(String[] params) {//todo другая библиотека, можно ли так или надо иначе... проверить для файлов и папок, нет проверок на существование путей
        if (params.length != 2) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }
        Path sourcePath = Path.of(params[0]);
        Path destinationPath = Path.of(params[1]);
        try {
            Files.copy(sourcePath, destinationPath);
            System.out.println("копировано из \"" + sourcePath + "\" в \"" + destinationPath + "\"");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    //7 - вывод всех папок и файлов ================================ //todo реализовать
    private static void myList() {
        System.out.println("вот все папки и файлы");
    }

    //8 - вывод размера файла/папки ================================
    private static void mySize(String[] params) {
        if (params.length != 1) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }
        File file = new File(params[0]);
        if (file.isFile()) {
            System.out.println("Размер файла \"" + params[0] + "\" " + file.length() + " байт");
        } else if (file.isDirectory()) {
            long directorySize = getDirectorySize(file);
            System.out.println("Размер директории \"" + params[0] + "\" " + directorySize + " байт");
        } else {
            System.out.println("Указанный путь к папке/файлу не найден, попробуйте снова");
        }
    }

    private static long getDirectorySize(File file) {
        long directorySize = 0;

        for (File files : file.listFiles()) {
            if (files.isFile()) {
                directorySize += files.length();
            } else {
                directorySize += getDirectorySize(files);
            }
        }
        return directorySize;
    }

    //9 - сортировка директории ================================ //todo реализовать (то же что и list, только с сортировкой по указанному направлению
    private static void mySort() {
        System.out.println("Отсортировано");
    }
}
