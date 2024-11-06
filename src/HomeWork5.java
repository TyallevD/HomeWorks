public class HomeWork5 {
    public static void main(String[] args) {
        //Фигура #1
        System.out.println("Фигура 1");
        int height = 8;     //высота
        int width = 5;      //ширина
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
        //Фигура #2
        System.out.println("Фигура 2");
        int count = 10;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
        //Фигура #3
        System.out.println("Фигура 3");
        for (int i = 1; i <= count; i++) { // используем переменную count из "Фигуры #2"
            for (int j = count; j > 0; j--) {// используем переменную count из "Фигуры #2"
                if (i == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
        System.out.println();
        //Фигура #4
        System.out.println("Фигура 4");
        for (int i = 0; i < count; i++) { // используем переменную count из "Фигуры #2"
            for (int j = count; j > 0; j--) {// используем переменную count из "Фигуры #2"
                if (i >= j) {
                    System.out.print(" ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();

        }
        System.out.println();
        //Фигура #5
        System.out.println("Фигура 5");
        for (int i = 0; i < count; i++) {// используем переменную count из "Фигуры #2"
            for (int j = 0; j < count; j++) {// используем переменную count из "Фигуры #2"
                if (i >= j) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
        //Фигура #6
        System.out.println("Фигура 6");
        int size = 15;
        int center = size / 2;
        for (int i = 0; i <= (size + 2) / 2; i++) {
            for (int j = 0; j < size; j++) {
                if (j > (center - i) && j < (center + i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
        //Фигура #7

    }
}
