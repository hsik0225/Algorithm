package cp14.dynamic_programming1;

/*

https://www.acmicpc.net/problem/11053

*/

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 수열을 저장
        int[] sequence = new int[n];

        // 수열의 길이를 저장
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // i의 이전인 j들 중 가장 큰 값에 + 1 한 값을 i에 dp[i]에 저장한다
                if (sequence[i] > sequence[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
