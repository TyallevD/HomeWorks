public class HomeWork2 {
    public static void main(String[] args) {
        //Задание 1
        //Создайте переменную типа int с именем height и присвойте ей значение вашего роста в сантиметрах. Выведите переменную на экран.
        int height = 175;
        System.out.println("Задание 1. Вывод: \nМой рост " + height + " см.");
        System.out.println();
//        Задание 2
//        Объявите две переменные типа int: length и width. Присвойте им значения 15 и 25 соответственно. Выведите их значения на экран.
        int length = 15, width = 25;
        System.out.println("Задание 2. Вывод: \nLength = " + length + " Width = " + width);
        System.out.println();
        //Задание 3
        //Создайте переменную price типа double, присвойте ей значение 99.99. Затем измените значение переменной на 79.99
        // и выведите оба значения на экран.
        double price = 99.99;
        System.out.println("Задание 3. Вывод: ");
        System.out.println("price = " + price);
        price = 79.99;
        System.out.println("price = " + price);
        System.out.println();
        //Задание 4
        //Объявите переменную number, но не присваивайте ей значения. Попробуйте вывести её на экран. Что произойдет?
//        int number;
//        System.out.println(number);
        // ОТВЕТ: ошибка компиляции. Переменная должна быть проинициализирована.
        System.out.println("Задание 4. Вывод: ");
        System.out.println("ОТВЕТ: ошибка компиляции. Переменная должна быть проинициализирована.");
        System.out.println();

        //Задание 5
        //Объявите переменную типа String с именем city, присвойте ей название вашего родного города и выведите её на экран.
        String city = "Калуга";
        System.out.println("Задание 5. Вывод: ");
        System.out.println("Мой родной город: " + city);
        System.out.println();
        //Задание 6
        //Одной строкой объявите три переменные типа int: day, month, year, и инициализируйте их значениями 20, 10, 2024 соответственно.
        // Выведите их на экран.
        System.out.println("Задание 6. Вывод: ");
        int day = 20, month = 10, year = 2024;
        System.out.println("День " + day + " Месяц " + month + " Год " + year);
        System.out.println();
        //Задание 7
        //Создайте переменную radius типа double, присвойте ей значение 7.5. Рассчитайте площадь круга по формуле ? * r^2,
        // используя значение переменной radius, и выведите результат на экран.
        double radius = 7.5;
        System.out.println("Задание 7. Вывод: ");
        System.out.println("Площадь круга по формуле ? * r^2 = " + Math.PI * Math.pow(radius, 2));
        System.out.println();
        //Задание 8
        //Объявите переменную типа boolean с именем isJavaFun. Присвойте ей значение true. Выведите её значение на экран.
        boolean isJavaFun = true;
        System.out.println("Задание 8. Вывод: ");
        System.out.println("isJavaFun = " + isJavaFun);
        System.out.println();
        //Задание 9
        //Создайте переменную count типа int, присвойте ей значение 0. Увеличьте значение переменной на 10, а затем уменьшите его на 3.
        // Выведите результат.
        int count = 0;
        count += 10; //count = count + 10
        count -= 3; // count = count - 3
        System.out.println("Задание 9. Вывод: ");
        System.out.println("count = " + count);
        System.out.println();
        //Задание 10
        //Объявите переменную firstName типа String и присвойте ей ваше имя. Затем объявите переменную lastName и присвойте ей вашу фамилию.
        // Выведите на экран строку, содержащую полное имя.
        String firstName = "Дмитрий", lastName = "Тяллев";
        System.out.println("Задание 10. Вывод: ");
        System.out.println(firstName + " " + lastName);
        System.out.println();
    }
}
