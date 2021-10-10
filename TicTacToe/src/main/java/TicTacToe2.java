import java.util.Random;
import java.util.Scanner;

public class TicTacToe2 {
    public static char[][] map;
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static char DOT_EMPTY = '•';
    public static char DOT_PLAYER = 'X';
    public static char DOT_COMP = '0';
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        intMap();
        printMap();
        while (true) {
            int x;
            int y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = scan.nextInt() - 1;
                y = scan.nextInt() - 1;
            } while (!isCellValid(x, y));
            map[y][x] = DOT_PLAYER;
            printMap();
            if (checkWin(DOT_PLAYER)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            moveComp(x, y);
            printMap();
            if (checkWin(DOT_COMP)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }


    public static void intMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void moveComp(int x, int y) {
        int var;
        int xComp = 0;
        int yComp = 0;
        do {
            var = rand.nextInt(7);
            switch (var) {
                case 0: // справа
                    xComp = x + 1;
                    yComp = y + 0;
                    break;
                case 1:// вниз
                    xComp = x + 0;
                    yComp = y + 1;
                    break;
                case 2: // слева
                    xComp = x - 1;
                    yComp = y + 0;
                    break;
                case 3: // вверх
                    xComp = x + 0;
                    yComp = y - 1;
                    break;
                case 4: // диагональ снизу-влево
                    xComp = x - 1;
                    yComp = y + 1;
                    break;
                case 5: // диагональ снизу-вправо
                    xComp = x + 1;
                    yComp = y + 1;
                    break;
                case 6: // диагональ вверху-вправо
                    xComp = x + 1;
                    yComp = y - 1;
                    break;
                case 7: // диагональ вверху-слева
                    xComp = x - 1;
                    yComp = y - 1;
                    break;
            }
        } while (!isCellValid(xComp, yComp));
        map[yComp][xComp] = DOT_COMP;
        System.out.println("Компьютер походил в точку " + (xComp + 1) + " " + (yComp + 1));
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symb) {
        // по горизонтали
        for (int i = 0; i < SIZE; i++) {
            int result = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb)
                    result++;
            }
            if (result == DOTS_TO_WIN) return true;
        }
        // по горизонтали
        for (int i = 0; i < SIZE; i++) {
            int result = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb)
                    result++;
            }
            if (result == DOTS_TO_WIN) return true;
        }
        // по диагонали сверху-вниз
        int first = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == i && map[i][j] == symb)
                    first++;
            }
            if (first == DOTS_TO_WIN) return true;
        }
        // по диагонали снизу вверх
        int second = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][map.length - 1 - i] == symb)
                second++;
        }
        if (second == DOTS_TO_WIN) return true;
        return false;
    }

}


