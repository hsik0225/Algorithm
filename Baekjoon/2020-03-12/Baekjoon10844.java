//https://www.acmipc.net/problem/10844

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        long[][] front = new long[101][11];

        for (int i = 1; i <= 9; i++) {
            front[1][i] = 1;
        }

        for (int i = 2; i <= length; i++) {
            front[i][0] = front[i - 1][1];
            for (int j = 1; j <= 9; j++) {
                front[i][j] = (front[i - 1][j - 1] + front[i - 1][j + 1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += front[length][i];
        }
        System.out.println(sum % 1000000000);
    }
}
