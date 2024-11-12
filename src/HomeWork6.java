public class HomeWork6 {
    public static void main(String[] args) {
        //ЗАДАНИЕ 1. Нарисовать все фигуры, используя while и do while
        //Фигура #1. While
        System.out.println("Фигура 1. Построение с while");
        int height1 = 8;
        int width1 = 5;
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
        int y2 = 0;
        int x2 = 0;
        int count2 = 10;
        while (y2 < count2) {
            while (x2 < count2) {
                if (y2 == x2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x2++;
            }
            x2 = 0;
            System.out.println();
            y2++;
        }
        System.out.println();
        //Фигура #2. Do While
        System.out.println("Фигура 2. Построение с do while");
        y2 = 0;
        do {
            do {
                if (y2 == x2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x2++;
            } while (x2 < count2);
            x2 = 0;
            System.out.println();
            y2++;
        } while (y2 < count2);
        System.out.println();
        //Фигура #3. While
        System.out.println("Фигура 3. Построение с while");
        int x3 = 0;
        int count3 = 10;
        int y3 = count3 - 1;
        while (y3 >= 0) {
            while (x3 < count3) {
                if (y3 == x3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x3++;
            }
            x3 = 0;
            System.out.println();
            y3--;
        }
        System.out.println();
        //Фигура #3. Do While
        System.out.println("Фигура 3. Построение с do while");
        y3 = count3 - 1;
        do {
            do {
                if (y3 == x3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x3++;
            } while (x3 < count3);
            x3 = 0;
            System.out.println();
            y3--;
        } while (y3 >= 0);
        System.out.println();
        //Фигура #4. While
        System.out.println("Фигура 4. Построение с while");
        int x4 = 0;
        int count4 = 10;
        int y4 = count4 - 1;
        while (y4 >= 0) {
            while (x4 < count4) {
                if (y4 >= x4) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
                x4++;
            }
            x4 = 0;
            System.out.println();
            y4--;
        }
        System.out.println();
        //Фигура #4. Do While
        System.out.println("Фигура 4. Построение с do while");
        y4 = count4 - 1;
        do {
            do {
                if (y4 >= x4) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
                x4++;
            } while (x4 < count4);
            x4 = 0;
            System.out.println();
            y4--;
        } while (y4 >= 0);
        System.out.println();
        //Фигура #5. While
        System.out.println("Фигура 5. Построение с while");
        int x5 = 0;
        int y5 = 0;
        int count5 = 10;
        while (y5 < count5) {
            while (x5 < count5) {
                if (y5 >= x5) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
                x5++;
            }
            x5 = 0;
            System.out.println();
            y5++;
        }
        System.out.println();
        //Фигура #5. Do While
        System.out.println("Фигура 5. Построение с do while");
        y5 = 0;
        do {
            do {
                if (y5 >= x5) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
                x5++;
            } while (x5 < count5);
            x5 = 0;
            System.out.println();
            y5++;
        } while (y5 < count5);
        System.out.println();
        //Фигура #6. While
        System.out.println("Фигура 6. Построение с помощью while");
        int x6 = 0;
        int y6 = 0;
        int osnovanie6 = 15;
        int center6 = osnovanie6 / 2;
        while (y6 <= (osnovanie6 + 2) / 2) {
            while (x6 < osnovanie6) {
                if (x6 > (center6 - y6) && x6 < (center6 + y6)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x6++;
            }
            x6 = 0;
            System.out.println();
            y6++;
        }
        System.out.println();
        //Фигура #6. Do While
        System.out.println("Фигура 6. Построение с помощью do while");
        y6 = 0;
        do {
            do {
                if (x6 > (center6 - y6) && x6 < (center6 + y6)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x6++;
            } while (x6 < osnovanie6);
            x6 = 0;
            System.out.println();
            y6++;
        } while (y6 <= (osnovanie6 + 2) / 2);
        System.out.println();
        //Фигура #7. While
        System.out.println("Фигура 7. Построение с помощью while");
        int x7 = 0;
        int y7 = 0;
        int osnovanie7 = 17;
        int center7 = osnovanie7 / 2;
        int x8 = 0;
        int y8 = center7;
        while (y7 <= (osnovanie7 + 2) / 2) {
            while (x7 < osnovanie7) {
                if (x7 > (center7 - y7) && x7 < (center7 + y7)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x7++;
            }
            x7 = 0;
            System.out.println();
            y7++;
        }
        while (y8 > 0) {
            while (x8 < osnovanie7) {
                if (x8 > (center7 - y8) && x8 < (center7 + y8)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x8++;
            }
            x8 = 0;
            System.out.println();
            y8--;
        }
        System.out.println();
        //Фигура #7. Do While
        System.out.println("Фигура 7. Построение с помощью do while");
        y7 = 0;
        y8 = center7;
        do {
            do {
                if (x7 > (center7 - y7) && x7 < (center7 + y7)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x7++;
            }
            while (x7 < osnovanie7);
            x7 = 0;
            System.out.println();
            y7++;
        } while (y7 <= (osnovanie7 + 2) / 2);
        do {
            do {
                if (x8 > (center7 - y8) && x8 < (center7 + y8)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                x8++;
            } while (x8 < osnovanie7);
            x8 = 0;
            System.out.println();
            y8--;
        } while (y8 > 0);
        //ЗАДАНИЕ 2. Нарисовать все фигуры только с границами
        //Фигура 1.
        
    }
}
