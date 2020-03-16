//https://www.acmicpc.net/problem/1912

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        int[] dp = new int[n];
        String[] inputString = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(inputString[i]);
        }

        dp[0] = array[0];

        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
