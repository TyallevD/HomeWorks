package JavaBasic.HomeWork34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeWork34 {
    public static void main(String[] args) {
        //Задание: написать функционал пагинации страницы с фильмами используя stream-api
        Scanner scanner = new Scanner(System.in);
        //генерируется список фильмов
        List<String> list = new ArrayList<>();
        System.out.print("Введите количество всех фильмов в библиотеке: ");
        int totalMovie = scanner.nextInt();
//        int totalMovie = 9; // строка для тестирования
//        System.out.println(totalMovie);
//        System.out.println();

        for (int i = 1; i <= totalMovie; i++) {
            list.add("Movie № " + i);
        }

        //Вводим количество фильмов на одной странице
        System.out.print("Введите количество фильмов на одной странице: ");
        int pageSize = scanner.nextInt();
//        int pageSize = 2; // строка для тестирования
//        System.out.println(pageSize);
//        System.out.println();

        //Вводим страницу, на которой хотим получить список фильмов
        System.out.print("Введите номер страницы: ");
        int pageNum = scanner.nextInt();
//        int pageNum = 3; // строка для тестирования
//        System.out.println(pageNum);
//        System.out.println();

        //Реализация
        //проверки на корректность ввода
        if (pageNum <= 0) {
            System.out.println("Некорректная страница");
            return;
        }
        if (pageSize <= 0) {
            System.out.println("Некорректное число фильмов на странице");
            return;
        }
        List<String> result = list.stream().skip(pageSize * (pageNum - 1)).limit(pageSize)
                .toList();

        //Результат
        if (result.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Найденные фильмы:");
            for (String movie : result) {
                System.out.println(movie);
            }
        }
    }
}
