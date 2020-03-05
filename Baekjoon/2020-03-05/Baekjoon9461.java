//https://www.acmicpc.net/problem/9461

import java.util.Scanner;

public class Baekjoon9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] fibo = new long[101];

        fibo[1] = 1;
        fibo[2] = 1;

        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            for (int j = 3; j <= input; j++) {
                fibo[j] = fibo[j-2] + fibo[j-3];
            }
            System.out.println(fibo[input]);
        }
    }
}
