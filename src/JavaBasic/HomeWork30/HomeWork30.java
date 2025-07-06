package JavaBasic.HomeWork30;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HomeWork30 {
    public static void main(String[] args) {
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

        Map<String, String> dictionary = new LinkedHashMap<>();
        dictionary.put("1", "1");
        dictionary.put("dog", "собака");
        dictionary.put("mother", "мама");
        dictionary.put("brother", "брат");
        dictionary.put("sister", "сестра");
        dictionary.put("father", "папа");
        dictionary.put("home", "дом");

        do {
            System.out.println();
            System.out.print("Введите слово для перевода или введите команду (cmd) : ");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            word = word.toLowerCase();

            if (word.equals("cmd")) {
                System.out.print("Введите команду (print, cls, size, letter, num, delete, update, exit): ");
                word = scanner.nextLine().toLowerCase();

                if (word.equals("print")) {
                    printDictionary(dictionary);
                }
                if (word.equals("exit")) {
                    System.out.println("Вы вышли из программы");
                    break;
                }

                //1) cls -> очищает весь словарь
                if (word.equals("cls")) {
                    dictionary.clear();
                    System.out.println("Словарь очищен");
                }

                //2) size -> печатает количество слов в словаре
                if (word.equals("size")) {
                    sizeCount(dictionary);
                }

                //3) letter -> печатает количество символов в словаре
                if (word.equals("letter")) {
                    countLetters(dictionary);
                }

                //4) num -> печатает сколько чисел в словаре
                if (word.equals("num")) {
                    countNums(dictionary);
                }

                //5) delete -> удаляет по ключу или по значению
                if (word.equals("delete")) {
                    deleteWord(scanner, dictionary);
                }

                //6) update -> изменит слово на что-то
                if (word.equals("update")) {
                    updateDictionary(scanner, dictionary);
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
                addWord(scanner, dictionary, word);
            }
        } while (true);
    }


    // Метод для задания 2
    private static void sizeCount(Map<String, String> dictionary) {
        int count = 0;
        for (String key : dictionary.keySet()) {
            count++;
        }
        //т.к. в словаре всегда есть ключ и значение, то если хотим проверить количество слов и в ключе и в значениях -
        // умножаем подсчет на 2
        System.out.println(count * 2);
    }

    // Метод для задания 3
    private static void countLetters(Map<String, String> dictionary) {
        int letterCount = 0;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            letterCount += entry.getKey().length() + entry.getValue().length();
        }
        System.out.println(letterCount);
    }

    // Метод для задания 4
    private static void countNums(Map<String, String> dictionary) {
        int digitCount = 0;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            for (char c : entry.getKey().toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }
            for (char c : entry.getValue().toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }
        }
        System.out.println(digitCount);
    }

    // Метод для задания 5
    private static void deleteWord(Scanner scanner, Map<String, String> dictionary) {
        System.out.print("Какое слово хотите удалить?: ");
        String delWord = scanner.nextLine().toLowerCase();

        if (dictionary.containsKey(delWord)) {
            dictionary.remove(delWord);
        } else if (dictionary.containsValue(delWord)) {
            for (String key : dictionary.keySet()) {
                if (dictionary.get(key).equals(delWord)) {
                    System.out.println("Слово " + dictionary.get(key) + " было удалено");
                    dictionary.remove(key);
                    break;
                }
            }
        } else {
            System.out.println("Такого слова нет в словаре.");
        }
    }

    // Метод для задания 6
    private static void updateDictionary(Scanner scanner, Map<String, String> dictionary) {
        System.out.print("Введите слово, которое хотите изменить: ");
        String updateWord = scanner.nextLine().toLowerCase();

        //6.2 если первое введенное слово совпадает с ключом -> обновит только значение
        if (dictionary.containsKey(updateWord)) {
            System.out.print("Введите слово, на которое хотите изменить (ru): ");
            String newWord = scanner.nextLine().toLowerCase();
            if (isPairExists(dictionary, updateWord, newWord)) {
                System.out.println("В словаре уж есть подобный перевод слова");
                return;
            }
            dictionary.replace(updateWord, newWord);
            System.out.println("Слово обновлено");
        }

        //6.3 если первое введенное слово совпадает со значением -> обновит ключ
        else if (dictionary.containsValue(updateWord)) {
            String oldKey = null;
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(updateWord)) {
                    oldKey = entry.getKey();
                    break;
                }
            }
            if (oldKey != null) {
                System.out.print("Введите слово, на которое хотите изменить (en): ");
                String newWord = scanner.nextLine().toLowerCase();
                if (isPairExists(dictionary, updateWord, newWord)) {
                    System.out.println("В словаре уж есть подобный перевод слова");
                    return;
                }
                if (dictionary.containsKey(newWord)) {
                    System.out.println("Такое слово уже есть в словаре");
                } else {
                    String oldWord = dictionary.get(oldKey);
                    dictionary.put(newWord, oldWord);
                    dictionary.remove(oldKey);
                    System.out.println("Слово обновлено");
                }
            }
        } else {
            System.out.println("Такого слова нет в словаре");
        }
    }

    //Метод для задания 6.1 (если пара с таким же key и value есть -> ошибка, что данная пара уже существует)
    private static boolean isPairExists(Map<String, String> dictionary, String key, String value) {
        return dictionary.containsKey(key) && dictionary.get(key).equals(value);
    }

    // Вынесенный метод для печати словаря
    private static void printDictionary(Map<String, String> dictionary) {
        System.out.println("\n-----------------------------------------\nПечать словаря\n");
        for (String key : dictionary.keySet()) {
            System.out.println(key + " (en) => " + dictionary.get(key) + " (ru)");
        }
    }

    //Вынесенный метод для добавления новых слов
    private static void addWord(Scanner scanner, Map<String, String> dictionary, String word) {
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
}
