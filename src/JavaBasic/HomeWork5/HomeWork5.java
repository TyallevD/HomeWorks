package JavaBasic.HomeWork5;

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
        int osnovanie = 15;
        int center = osnovanie / 2;
        for (int i = 0; i <= center; i++) {
            for (int j = 0; j < osnovanie; j++) {
                if (j >= (center - i) && j <= (center + i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
        //Фигура #7
        System.out.println("Фигура #7");
        int osnovanie2 = 17;
        int center2 = osnovanie2 / 2;
        for (int y = 0; y <= center2; y++) {
            for (int x = 0; x < osnovanie2; x++) {
                if (x >= (center2 - y) && x <= (center2 + y)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int y = center2; y > 0; y--) {
            for (int x = 0; x < osnovanie2; x++) {
                if (x > (center2 - y) && x < (center2 + y)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
