package JavaBasic.HomeWork37;

import java.util.Random;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class HomeWork37 {
    public static void main(String[] args) {
        //Задание 1: Сравнение последовательного и параллельного выполнения
        //Создайте программу, которая демонстрирует разницу между последовательным и параллельным выполнением двух задач:
        //Первая задача: подсчет и вывод чисел от 0 до 10000
        //Вторая задача: вывод 5000 символов "*"
        //Измерьте и выведите время выполнения для обоих подходов (последовательного и с использованием потоков).
        System.out.println("Задание 1. Вывод:");
        System.out.println("Вариант с последовательным выполнением:");
        long sequentialTime = sequentialExecution();
        double duration1 = (double) sequentialTime / 1000;
        System.out.println("Время последовательного выполнения: " + duration1 + " секунд");
        System.out.println();

        System.out.println("Вариант с параллельным выполнением:");
        long parallelTime = parallelExecution();
        double duration2 = (double) parallelTime / 1000;
        System.out.println("Время выполнения параллельного выполнения: " + duration2 + " секунд");

        System.out.println();

        //Задание 2: Использование разных способов создания потоков
        //Напишите программу, которая выполняет одну и ту же задачу (например, вывод чисел от 1 до 100) тремя разными способами:
        //Используя наследование от класса Thread (как MyThread в примере)
        //Используя интерфейс Runnable (как MyRunnable в примере)
        //Используя лямбда-выражение
        //Для каждого способа выведите имя потока и его приоритет.
        System.out.println("Задание 2. Вывод:");
        //Создание через MyThread
        MyThread thread2_1 = new MyThread();
        System.out.println("Имя потока thread2_1: " + thread2_1.getName());
        System.out.println("Приоритет потока thread2_1: " + thread2_1.getPriority());
        System.out.println();

        //Создание через MyRunnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2_2 = new Thread(myRunnable);
        System.out.println("Имя потока thread2_2: " + thread2_2.getName());
        System.out.println("Приоритет потока thread2_2: " + thread2_2.getPriority());
        System.out.println();

        //Создание через Лямба-выражение
        Thread thread2_3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
        System.out.println("Имя потока thread2_3: " + thread2_3.getName());
        System.out.println("Приоритет потока thread2_3: " + thread2_3.getPriority());
        System.out.println();

        //Задание 3: Взаимодействие между потоками
        //Создайте два потока:
        //Первый поток генерирует и печатает случайные числа (от 1 до 100) каждую секунду
        //Второй поток ожидает, когда будет сгенерировано число больше 90, и останавливает оба потока
        //Используйте методы join(), sleep() и interrupt() для управления потоками, а также продемонстрируйте
        // различные состояния жизненного цикла потока (NEW, RUNNABLE, TERMINATED и т.д.).
        System.out.println("Задание 3. Вывод:");
        Random random = new Random();
        Thread thread3_1 = new Thread(() -> {
            System.out.println("Состояние потока \"" + Thread.currentThread().getName() + "\" " + Thread.currentThread().getState());
            try {
                while (true) {
                    int randomNum = random.nextInt(101);
                    System.out.println("Сгенерированное значение: " + randomNum);
                    if (randomNum > 90) {
                        System.out.println("Значение больше 90, останавливаем поток");
                        Thread.currentThread().interrupt();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException interruptedException) {
                System.out.println("Поток " + Thread.currentThread().getName() + " был прерван");
            } 
        });

        Thread thread3_2 = new Thread(() -> {
            System.out.println("Состояние потока \"" + Thread.currentThread().getName() + "\" " + Thread.currentThread().getState());
            try {
                thread3_1.join();
                System.out.println("Поток \"" + Thread.currentThread().getName() + "\" завершается");
            } catch (InterruptedException interruptedException) {
                System.out.println("Поток \"" + Thread.currentThread().getName() + "\" был прерван");
            }
        });
        System.out.println("Состояние потока \"" + thread3_1.getName() + "\" " + thread3_1.getState());
        System.out.println("Состояние потока \"" + thread3_2.getName() + "\" " + thread3_2.getState());
        thread3_1.start();
        thread3_2.start();


        try {
            thread3_1.join();
            thread3_2.join();
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
        }
        System.out.println("Состояние потока \"" + thread3_1.getName() + "\" " + thread3_1.getState());
        System.out.println("Состояние потока \"" + thread3_2.getName() + "\" " + thread3_2.getState());
    }

    private static long sequentialExecution() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 5000; i++) {
            System.out.print("*");
        }
        System.out.println();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long parallelExecution() {
        long startTime = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                System.out.print("*");
            }
            System.out.println();
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (RuntimeException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
