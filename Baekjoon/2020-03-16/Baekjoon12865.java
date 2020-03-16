import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int power = Integer.parseInt(input[1]);

        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int[][] dp = new int[n + 1][power + 1];

        for (int i = 1; i <= n; i++) {
            String[] temp = br.readLine().split(" ");
            weight[i] = Integer.parseInt(temp[0]);
            value[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= power; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][power]);
    }
}
