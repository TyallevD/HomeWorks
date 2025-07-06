package JavaBasic.HomeWork31;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
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
            case "rename": {
                rename(params);
                break;
            }
            case "move": {
                myMove(params);
                break;
            }
            case "list": {
                myList(params);
                break;
            }
            case "size": {
                mySize(params);
                break;
            }
            case "sort": {
                mySort(params);
                break;
            }
            default: {
                System.out.println("Ошибка. Не поддерживаемая команда, попробуйте снова");
            }
        }
        System.out.println();
    }

    //1 - создание папки ================================
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
        System.out.println("Папка \"" + folder + "\" " + (folder.mkdirs() ? "создана" : "не создана"));
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

    //3 - удаление файла или папки ================================
    private static void myDelete(String[] params) {
        if (params.length < 1 || params.length > 2) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }
        boolean recurcive = false;
        String path;

        if (params.length == 2 && params[0].equalsIgnoreCase("-r")) {
            recurcive = true;
            path = params[1];
        } else {
            path = params[0];
        }

        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Папки или файла не существует. Попробуйте снова");
            return;
        }
        if (file.isFile() || (!recurcive && file.isDirectory())) {
            System.out.println("Папка или файл \"" + path + "\" " + (file.delete() ? "удален(а)" : "не удален(а)"));
        } else if (recurcive && file.isDirectory()) {

            System.out.println("Папка или файл \"" + path + "\" " + (deleteRecurcive(file) ? "удален(а)" : "не удален(а)"));
        }
    }

    //4 - рекурсивное удаление ================================
    private static boolean deleteRecurcive(File directory) {
        if (directory == null || !directory.exists() || !directory.isDirectory()) {
            return false;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (!deleteRecurcive(file)) {
                        return false;
                    }
                } else {
                    if (!file.delete()) {
                        return false;
                    }
                }
            }
        }
        return directory.delete();
    }

    //5 - переименование файл или папки ================================
    private static void rename(String[] params) {
        if (params.length != 2) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }
        File currentFile = new File(params[0]);
        if (!currentFile.exists()) {
            System.out.println("Файл или папка не найдены. Попробуйте снова");
            return;
        }
        System.out.println("Файл \"" + params[0] + "\" " +
                (currentFile.renameTo(new File(params[1])) ? " переименован в \"" + params[1] + "\"" : " не переименован"));
    }

    //6 - копирование файла или папки, используется библиотека java.nio.Files ================================
    private static void myMove(String[] params) {
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

    //7 - вывод всех папок и файлов ================================
    private static void myList(String[] params) {
        if (params.length != 1) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }
        File folder = new File(params[0]);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Указанный путь не является папкой");
            return;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Папка пуста");
        } else {
            System.out.println("Содержимое папки \"" + folder.getAbsolutePath() + "\":");
            System.out.println("Наименование\t Тип");
            for (File file : files) {
                String type = file.isDirectory() ? "файл" : "папка";
                System.out.printf("%-15s\t %-6s%n", file.getName(), type);
            }
        }
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

    //9 - сортировка директории ================================
    private static void mySort(String[] params) {
        if (params.length != 2) {
            System.out.println("Ошибка, неверный параметр, попробуйте снова");
            return;
        }
        String path = params[0];
        String sortDirection = params[1];
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Указанный путь не существует или не является папкой. Попробуйте снова");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Папка пуста");
            return;
        }

        try {

            if (sortDirection.equalsIgnoreCase("name")) {
                Arrays.sort(files, Comparator.comparing(File::getName));
                printSortedFiles(files);
            } else if (sortDirection.equalsIgnoreCase("size")) {
                Arrays.sort(files, Comparator.comparingLong(HomeWork31::getSize).reversed());
                printSortedFilesWithSize(files);
            } else {
                System.out.println("Не распознан параметр сортировки, попробуйте снова");
            }
        } catch (Exception ex) {
            System.out.println("Ошибка " + ex.getMessage());
        }
    }

    private static long getSize(File file) {
        if (file.isFile()) {
            return file.length();
        } else if (file.isDirectory()) {
            return getDirectorySize(file);
        }
        return 0;
    }

    private static void printSortedFiles(File[] files) {
        System.out.println("Содержимое папки \"" + files[0].getParentFile().getAbsolutePath() + "\" (отсортировано по имени):");
        System.out.println("Наименование\tТип");
        for (File file : files) {
            String type = file.isDirectory() ? "папка" : "файл";
            System.out.printf("%-15s\t%-6s%n", file.getName(), type);
        }
    }

    private static void printSortedFilesWithSize(File[] files) {
        System.out.println("Содержимое папки \"" + files[0].getParentFile().getAbsolutePath() + "\" (отсортировано по размеру):");
        System.out.printf("%-15s\t%-6s\t%8s%n", "Наименование", "Тип", "Размер");
        for (File file : files) {
            String type = file.isDirectory() ? "папка" : "файл";
            long size = getSize(file);
            System.out.printf("%-15s\t%-6s\t%8d байт%n", file.getName(), type, size);
        }
    }
}
