package HomeWork30;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HomeWork30 {
    public static void main(String[] args) {
        Map<String, String> dictionary = new LinkedHashMap<>();
        dictionary.put("dog", "собака");
        dictionary.put("mother", "мама");
        dictionary.put("brother", "брат");
        dictionary.put("sister", "сестра");
        dictionary.put("father", "папа");
        dictionary.put("home", "дом");

        do {
            System.out.println();
            System.out.print("Введите слово для перевода или введите команду (command) : ");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            word = word.toLowerCase();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //1) cls -> очищает весь словарь
            //2) size -> печатает количество слов в словаре
            //3) letter -> печатает количество символов в словаре
            //4) num -> печатает сколько чисел в словаре
            //5) delete -> удаляет по ключу или по значению
            //6) update -> изменит слово на что-то
            //   6.1 = если пара с таким же key и value есть -> ошибка, что данная пара уже существует
            //   6.2 = если первое введенное слово совпадает с ключом -> обновит только значение
            //   6.3 = если первое введенное слово совпадает со значением -> обновит ключ
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            if (word.equals("command")) {
                System.out.print("Введите команду (print, cls, size, letter, num, delete, update, exit): ");
                word = scanner.nextLine();
                word = word.toLowerCase();

                if (word.equals("print")) {
                    System.out.println("\n-----------------------------------------\nПечать словаря\n");
                    for (String key : dictionary.keySet()) {
                        System.out.println(key + " (en) => " + dictionary.get(key) + " (ru)");
                    }
                }
                if (word.equals("exit")) {
                    System.out.println("Вы вышли из программы");
                    break;
                }

            } else if (dictionary.containsKey(word)) {
                System.out.println(word + "(en) => " + dictionary.get(word) + " (ru)");
            } else if (dictionary.containsValue(word)) {
                for (String key : dictionary.keySet()) {
                    if (dictionary.get(key).equals(word)) {
                        System.out.println(word + " (ru) => " + key + " (en)");
                        break;
                    }
                }
            } else {
                System.out.println("Данное слово отсутствует, не хотите ли его добавить?\n1 - Да\n2 - Нет");
                int select = scanner.nextInt();

                if (select == 1) {
                    System.out.print("Введите перевод данного слова : ");
                    scanner = new Scanner(System.in);

                    String translate = scanner.nextLine();
                    translate = translate.toLowerCase();
                    if (
                            dictionary.containsKey(word) || dictionary.containsValue(word) ||
                                    dictionary.containsKey(translate) || dictionary.containsValue(translate)
                    ) {
                        System.out.println("Данное слово имеет перевод");
                    } else {
                        System.out.println("Данное слово было переведено с \n1 - en -> ru\n2 - ru -> en");
                        select = scanner.nextInt();
                        if (select == 1) {
                            dictionary.put(word, translate);
                        } else if (select == 2) {
                            dictionary.put(translate, word);
                        } else {
                            System.out.println("Слово не было добавлено, вы выполнили неверный выбор");
                        }

                        System.out.println("Слово успешно добавлено");
                    }
                } else if (select == 2) {
                    System.out.println("Отмена.");
                } else {
                    System.out.println("Вы сделали неверный выбор, выберете 1 или 2");
                }

            }

        } while (true);
    }
}
