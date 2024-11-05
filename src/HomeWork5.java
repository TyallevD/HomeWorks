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
        //Фигура #6
        System.out.println("Фигура 6");
//        int osnovanie = 7;
//        for (int i = 0; i < 8; i++) {// используем переменную count из "Фигуры #2"
//            for (int j = osnovanie; j > 0; j--) {
//                if (i < j) {
//                    System.out.print(" ");
//                } else {
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();

        System.out.println();
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print("*");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.println();
        System.out.print(" ");
        System.out.print(" ");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print(" ");
        System.out.print(" ");
        System.out.println();
        System.out.print(" ");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print(" ");
        System.out.println();
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.println();
        System.out.println();
//        System.out.println("       *       ");
//        System.out.println("      ***      ");
//        System.out.println("     *****     ");
//        System.out.println("    *******    ");
//        System.out.println("   *********   ");
//        System.out.println("  ***********  ");
//        System.out.println(" ************* ");
//        System.out.println("***************");
        int size = 15;
        //int lines = 8; //количество строк
        //int osn = 15; // основание
        for (int y = size; y > 0; y--) {
            for (int x = 0; x < size; x++) {
                if (x == size / 2) {
                    System.out.print("*");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}
