package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/2579

마지막 계단을 무조건 밟아야 한다

마지막 계단을 n번째 계단이라고 할 때, n번째 계단을 밟는 경우의 수는
1. n - 1 번째의 계단과 n - 3번쨰의 계단을 밟았을 경우(연속된 3개의 계단을 밟을 수 없으므로 무조건 n-3번째의 계단을 밟아야 한다)
2. n - 2 번째의 계단을 밟았을 경우

로 나눠진다.

즉, stairs[n] = Math.max((stairs[n-1]+stairs[n-3], stairs[n-2])
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sum = new int[n + 1];
        int[] stairsScores = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairsScores[i] = Integer.parseInt(br.readLine());
        }

        sum[1] = stairsScores[1];

        if (n >= 2) {
            sum[2] = sum[1] + stairsScores[2];
        }

        for (int i = 3; i <= n; i++) {
            sum[i] = stairsScores[i] + Math.max((stairsScores[i-1] + sum[i-3]), sum[i-2]);
        }

        System.out.println(sum[n]);
    }
}
