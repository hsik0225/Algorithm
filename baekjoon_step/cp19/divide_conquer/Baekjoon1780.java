package cp19.divide_conquer;

/*

https://www.acmicpc.net/problem/1780

*/

import java.util.Scanner;

public class Baekjoon1780 {
    private static int[][] paper = new int[(int) Math.pow(3, 7) + 1][(int) Math.pow(3, 7) + 1];

    private static int minus = 0;
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }

        divideConquer(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void divideConquer(int x, int y, int length) {
        int forward = length / 3;

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (paper[x][y] != paper[i][j]) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            divideConquer(x + k * forward, y + l * forward, forward);
                        }
                    }

                    return;
                }
            }
        }

        if (paper[x][y] == -1) {
            minus++;
        } else if (paper[x][y] == 0) {
            zero++;
        } else {
            one++;
        }
    }
}
