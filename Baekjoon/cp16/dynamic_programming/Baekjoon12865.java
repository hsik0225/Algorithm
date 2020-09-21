package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/12865

무게의 합 = 이전 무게까지들의 합 + 현재 무게
WSUM[N] = WSUM[N-1] + W[N]

가치들의 합 = 이전 가치까지들의 합 + 현재 가치
VSUM[N] = VSUM[N-1] + V[N]

must WSUM[N] <= K

*/

import java.util.Scanner;

public class Baekjoon12865 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
