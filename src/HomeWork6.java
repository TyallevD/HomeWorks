public class HomeWork6 {
    public static void main(String[] args) {
        //Фигура #1. While
        System.out.println("Фигура 1. Построение с while");
        int height1 = 8;   //высота
        int width1 = 5;      //ширина
        int y1 = 0;
        int x1 = 0;

        while (y1 < width1 && x1 < height1) {
            System.out.print(" * ");
            y1++;
            if (y1 == width1) {
                System.out.println();
                x1++;
                y1 = 0;
            }
        }
        System.out.println();
        //Фигура #1. Do while
        System.out.println("Фигура 1. Построение с do while");
        x1 = 0;
        do {
            System.out.print(" * ");
            y1++;
            if (y1 == width1) {
                System.out.println();
                x1++;
                y1 = 0;
            }
        } while (y1 < width1 && x1 < height1);
        System.out.println();
        //Фигура #2. While
        System.out.println("Фигура 2. Построение с while");
        int x2 = 0;
        int y2 = 0;
        int count2 = 10;
        while (y2 < count2) {
            while (x2 < count2 && y2 == x2) {
                    System.out.print("0");
                x2++;
            }
         y2++;
        System.out.println();
    }
        System.out.println();
}
}
