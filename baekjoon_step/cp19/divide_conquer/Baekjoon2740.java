package cp19.divide_conquer;

/*

https://www.acmicpc.net/problem/2740

*/

import java.util.Scanner;

public class Baekjoon2740 {

    private static int[][] arrayA = new int[100][100];
    private static int[][] arrayB = new int[100][100];
    private static int[][] arrayC = new int[100][100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrayA[i][j] = scanner.nextInt();
            }
        }

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arrayB[i][j] = scanner.nextInt();
            }
        }

        divideConquer(n, m, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(arrayC[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static void divideConquer(int n, int m, int y) {

        // arrayC의 가로
        for (int i = 0; i < n; i++) {

            // arrayC의 세로
            for (int j = 0; j < y; j++) {

                // arrayB의 세로
                for (int l = 0; l < m; l++) {
                    arrayC[i][j] += arrayA[i][l] * arrayB[l][j];
                }
            }
        }
    }
}
