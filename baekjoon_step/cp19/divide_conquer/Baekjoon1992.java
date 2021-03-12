package cp19.divide_conquer;

/*

https://www.acmicpc.net/problem/1992

*/

import java.util.Scanner;

public class Baekjoon1992 {

    private static int[][] video = new int[65][65];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            for (int j = 0; j < n; j++) {
                video[i][j] = input.charAt(j)-'0';
            }
        }

        divideConquer(0, 0, n);
    }

    private static void divideConquer(int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (video[x][y] != video[i][j]) {
                    System.out.print("(");
                    divideConquer(x, y, length / 2);
                    divideConquer(x, y + length / 2, length / 2);
                    divideConquer(x + length / 2, y, length / 2);
                    divideConquer(x + length / 2, y + length / 2, length / 2);
                    System.out.print(")");
                    return;
                }
            }
        }

        System.out.print(video[x][y]);
    }
}
