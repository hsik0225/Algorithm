package cp14.dynamic_programming1;

/*

https://www.acmicpc.net/problem/10844

dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
길이가 N 일 때, 마지막 수가 L일 경우의 계단 수

주의할 점은 위의 점화식은 L이 (1 ~ 8) 일 때 성립한다.
왜냐하면 0은 +1을 한 1만 허용되고 9는 -1을 한 8만 적용되기 때문이다.

각 점화식을 조건에 따라 분기처리를 하면된다.

if (j == 0) {
    dp[i][j] = dp[i-1][j+1];
} else if (j == 9) {
    dp[i][j] = dp[i-1][j-1];
} else {
    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];					
}

출처: https://mygumi.tistory.com/260 [마이구미의 HelloWorld]
*/

import java.util.Scanner;

public class Baekjoon10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[101][11];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= n; i++) {
            // 0으로 끝나는 숫자들은 1로 끝나는 숫자들이 -1 해야만들어지므로 둘의 개수는 같다
            dp[i][0] = dp[i-1][1];

            for (int j = 1; j <= 9; j++) {
                // 끝이 9로 끝나는 숫자는 끝이 8로 끝나는 숫자와 10으로 끝나는 숫자가 더해진다
                // 끝이 10으로 끝나는 숫자는 없으므로, 끝이 9로만 끝나는 숫자만 더해진다
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1_000_000_000L;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum%1_000_000_000L);
    }
}
