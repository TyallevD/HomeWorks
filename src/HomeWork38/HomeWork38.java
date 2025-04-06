package HomeWork38;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork38 {
    static int wordsCount = 0;
    static int numsCount = 0;
    static int sentenceCount = 0;
//    static int vowelCount = 0;
//    static int consonatCount = 0;
//    static int punctuationCount = 0;
    static String text = "";

    public static void main(String[] args) {
        //Читаем файл и анализируем символы через ASCII.
        //Нужно посчитать:
        //🔤 Количество слов
        //🔢 Количество чисел
        //📝 Количество предложений
        //🅰️ Количество гласных
        //🅱️ Количество согласных
        //➕ Количество знаков препинания (точка, запятая, !, ?, ;, :)
        //⏱ Время выполнения
        //Использовать потоки

        System.out.println("Выполнение задания:");
        String delimeter = "------------------------";
        long startTime = System.nanoTime();
        Thread readerThread = new Thread(() -> {
            long startReaderTime = System.nanoTime();
            try {
                text = new String(Files.readAllBytes(Paths.get("ThreadsRead.txt"))); //todo тут нужно указать файл
            } catch (IOException e) {
                System.out.println("Не удалось прочитать файл");
            }
            long endReaderTime = System.nanoTime();
            long durationReader = (endReaderTime - startReaderTime) / 1_000_000;
            System.out.println("Время чтения файла: " + durationReader + " мс");
            System.out.println(delimeter);
        });
        try {
            readerThread.start();
            readerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток считывания файла прерван");
        }

        //Подсчет количества слов
        Thread wordsThread = new Thread(() -> {
            long startWordsCountTime = System.nanoTime();
            wordsCount = text.split("\\s+").length;
            System.out.println("Количество слов: " + wordsCount);
            long endWordsCountTime = System.nanoTime();
            long durationWordsCountTime = (endWordsCountTime - startWordsCountTime) / 1_000_000;
            System.out.println("Длительность подсчета слов: " + durationWordsCountTime + " мс");
            System.out.println(delimeter);
        });
        try {
            wordsThread.start();
            wordsThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток подсчета слов прерван");
        }

        //Подсчет количества чисел
        Thread numsThread = new Thread(() -> {
            long startNumsCountTime = System.nanoTime();
            Pattern pattern = Pattern.compile("\\b\\d+\\b");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                numsCount++;
            }
            System.out.println("Количество чисел: " + numsCount);
            long endNumsCountTime = System.nanoTime();
            long durationNumsCountTime = (endNumsCountTime - startNumsCountTime) / 1_000_000;
            System.out.println("Длительность подсчета слов: " + durationNumsCountTime + " мс");
            System.out.println(delimeter);
        });
        try {
            numsThread.start();
            numsThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток подсчета чисел прерван");
        }

        //Подсчет количества предложений
        Thread sentencesThread = new Thread(() -> {
            long startSentenceCountTime = System.nanoTime();
            sentenceCount = text.split("[.?!]").length;
            System.out.println("Количество предложений : " + sentenceCount);
            long endSentenceCountTime = System.nanoTime();
            long durationSentenceCountTime = (endSentenceCountTime - startSentenceCountTime) / 1_000_000;
            System.out.println("Длительность подсчета предложений: " + durationSentenceCountTime + " мс");
            System.out.println(delimeter);
        });
        try {
            sentencesThread.start();
            sentencesThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток подсчета предложений прерван");
        }

        //Подсчет гласных
        Thread vowelThread = new Thread(() -> {
//            Pattern pattern = Pattern.compile("[АЕЁИОУЭЮЯаеёиоуэюяAEIOUYaeiouy]");
//            Matcher matcher = pattern.matcher(text);
//            while (matcher.find()) {
//                vowelCount++;
//            }
            long startVovelCountTime = System.nanoTime();
            String vovelRegex = "[АЕЁИОУЭЮЯаеёиоуэюяAEIOUYaeiouy]";
            int vowelCount = countMatches(text, vovelRegex);
            System.out.println("Количество гласных: " + vowelCount);
            long endVovelCountTime = System.nanoTime();
            long durationVovelCountTime = (endVovelCountTime - startVovelCountTime) / 1_000_000;
            System.out.println("Длительность подсчета гласных: " + durationVovelCountTime + " мс");
            System.out.println(delimeter);
        });
        try {
            vowelThread.start();
            vowelThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток подсчета гласных прерван");
        }

        //Подсчет согласных
        Thread consonatThread = new Thread(() -> {
//            Pattern pattern = Pattern.compile("[БВГДЖЗЙКЛМНПРСТФХЦЧШЩЪЬбвгджзйклмнпрстфхцчшщъьBCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz]");
//            Matcher matcher = pattern.matcher(text);
//            while (matcher.find()) {
//                consonatCount++;
//            }
            long startConsonatCountTime = System.nanoTime();
            String consonatRegex = "[БВГДЖЗЙКЛМНПРСТФХЦЧШЩЪЬбвгджзйклмнпрстфхцчшщъьBCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz]";
            int consonatCount = countMatches(text, consonatRegex);
            System.out.println("Количество согласных: " + consonatCount);
            long endConsonatCountTime = System.nanoTime();
            long durationConsonatCountTime = (endConsonatCountTime - startConsonatCountTime) / 1_000_000;
            System.out.println("Длительность подсчета согласных: " + durationConsonatCountTime + " мс");
            System.out.println(delimeter);
        });
        try {
            consonatThread.start();
            consonatThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток подсчета согласных прерван");
        }

        //Подсчет знаков препинания
        Thread punctuationThread = new Thread(() -> {
//            Pattern pattern = Pattern.compile("[.,!?:;]");
//            Matcher matcher = pattern.matcher(text);
//            while (matcher.find()) {
//                punctuationCount++;
//            }
            long startPunctuationCountTime = System.nanoTime();
            String punctiationRegex = "[.,!?:;]";
            int punctuationCount = countMatches(text, punctiationRegex);
            System.out.println("Количество знаков препинания: " + punctuationCount);
            long endPunctuationCountTime = System.nanoTime();
            long durationPunctuationCountTime = (endPunctuationCountTime - startPunctuationCountTime) / 1_000_000;
            System.out.println("Длительность подсчета знаков препинания: " + durationPunctuationCountTime + " мс");
            System.out.println(delimeter);
        });
        try {
            punctuationThread.start();
            punctuationThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток подсчета знаков препинания прерван");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Общее время выполнения: " + duration + " мс");
    }

    private static int countMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
