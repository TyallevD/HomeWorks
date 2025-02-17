package HomeWork31;

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
        String command;
        while (true){
            System.out.println("Доступные команды: \n" +
                    "- create-folder <путь>\n" +
                    "- create-file <путь>\n" +
                    "- delete <путь>\n" +
                    "- delete r <путь>\n" +
                    "- rename <старое_имя> <новое_имя>\n" +
                    "- move <откуда> <куда>\n" +
                    "- list <путь>\n" +
                    "- size <путь>\n" +
                    "- sort <путь> [name|size]\n" +
                    "- exit");
            System.out.print("Введите команду: ");
            command = scanner.nextLine().toLowerCase();

            if (command.equals("exit")){
                System.out.println("Вы вышли из программы");
                break;
            }
            myCommand(command);
        }
    }

    private static void myCommand(String command) {
        switch (command) {
            case "create-folder": {
                createFolder();
                break;
            }
            case "create-file": {
                createMyFile();
                break;
            }
            case "delete": {
                myDelete();
                break;
            }
            case "delete r": {
                deleteRecurcive();
                break;
            }
            case "rename": {
                rename();
                break;
            }
            case "move": {
                myMove();
                break;
            }
            case "list": {
                myList();
                break;
            }
            case "size": {
                mySize();
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

    private static void mySort() {
        System.out.println("Отсортировано");
    }

    private static void mySize() {
        System.out.println("Размер");
    }

    private static void myList() {
        System.out.println("вот все папки и файлы");

    }

    private static void myMove() {
        System.out.println("Перемещено");
    }

    private static void rename() {
        System.out.println("Папка или файл переименован");
    }

    private static void deleteRecurcive() {
        System.out.println("Папка удалена");
    }

    private static void myDelete() {
        System.out.println("Файл удалён");
    }

    private static void createMyFile() {
        System.out.println("Файл создан");
    }

    private static void createFolder() {
        System.out.println("папка создана");
    }
}
