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
        int totalMovie = 99; //тестовая строка
        System.out.println(totalMovie);

        for (int i = 1; i <= totalMovie; i++) {
            list.add("Movie № " + i);
//            System.out.println("Movie № " + i);
        }
//        System.out.println();

        //Вводим количество фильмов на одной странице
        System.out.print("Введите количество фильмов на одной странице: ");
        //int pageSize = scanner.nextInt();
        int pageSize = 10; //тестовый вариант, 2 фильма на странице
        System.out.println(pageSize);
//        System.out.println();

        //Вводим страницу, на которой хотим получить список фильмов
        System.out.print("Введите номер страницы: ");
        //int pageNum = scanner.nextInt();
        int pageNum = 10; //тестовый вариант, 3-я страница, должно выводиться фильм 5 и 6
        System.out.println(pageNum);
//        System.out.println();

        //Реализация
        //нужно вернуть элементы, находящиеся на странице pageNum, в количестве pageSize

        List<String> result = list.stream().distinct().skip(pageSize * (pageNum - 1)).limit(pageSize)
                .toList();
        //todo надо обработать, если страница 0 или меньше - ошибка, если страница ничего не содержит - вывести "ничего не найдено"

        //Результат
        System.out.println("Найденные фильмы:");
        for (String movie : result) {
            System.out.println(movie);
        }
    }
}
