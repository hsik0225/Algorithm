package cp16.math3;

import java.util.Scanner;

public class Baekjoon1010 {
    private static final long[][] DP = new long[30][30];

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int t = SCANNER.nextInt();

        for (int i = 0; i < t; i++) {
            int r = SCANNER.nextInt();
            int n = SCANNER.nextInt();

            // n개 중에서 r개를 뽑는 경우이므로 nCr
            System.out.println(combination(n, r));
        }
    }

    private static long combination(int n, int r) {
        if (DP[n][r] != 0L) {
            return DP[n][r];
        }

        if (r == 0 || n == r) {
            return DP[n][r] = 1;
        }

        return DP[n][r] = combination(n -1, r - 1) + combination(n -1, r);
    }
}
