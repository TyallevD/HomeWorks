package HomeWork34;

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
//        int totalMovie = scanner.nextInt();
        int totalMovie = 9; //тестовая строка

        for (int i = 1; i <= totalMovie; i++) {
            list.add("Movie № " + i);
            System.out.println("Movie № " + i);
        }
//        System.out.println();
        //Вводим количество фильмов на одной странице
        System.out.print("Введите количество фильмов на одной странице: ");
        //int pageSize = scanner.nextInt();
        int pageSize = 2; //тестовый вариант, 2 фильма на странице
        System.out.println();

        //Вводим страницу, на которой хотим получить список фильмов
        System.out.print("Введите номер страницы: ");
        //int pageNum = scanner.nextInt();
        int pageNum = 3; //тестовый вариант, 3-я страница, должно выводиться фильм 5 и 6
        System.out.println();
        //Реализация
        //todo
        List<String> result = list;

        //Результат
        for (String movie : result) {
            System.out.println(movie);
        }
    }
}
