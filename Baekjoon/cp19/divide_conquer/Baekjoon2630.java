package cp19.divide_conquer;

/*

https://www.acmicpc.net/problem/2630

*/

import java.util.Scanner;

public class Baekjoon2630 {
    private static final int[][] rectangle = new int[257][257];

    private static int white = 0;

    private static int blue = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                rectangle[i][j] = scanner.nextInt();
            }
        }

        divideConquer(1, 1, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divideConquer(int x, int y, int length) {

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (rectangle[i][j] != rectangle[x][y]) {
                    divideConquer(x, y, length / 2);
                    divideConquer(x + length / 2, y, length / 2);
                    divideConquer(x, y + length / 2, length / 2);
                    divideConquer(x + length / 2, y + length / 2, length / 2);
                    return;
                }
            }
        }

        if (rectangle[x][y] == 0) {
            white++;
        } else {
            blue++;
        }
    }
}
