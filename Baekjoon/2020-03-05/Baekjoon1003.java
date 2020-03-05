//https://www.acmicpc.net/problem/1003

import java.util.Scanner;

public class Baekjoon1003 {
    static long[] fibo = new long[41];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 0; i < n; i++) {
            int testInt = scanner.nextInt();
            if (testInt == 0) {
                System.out.println("1 0");
                continue;
            }
            fibonacci(testInt);
            System.out.println(fibo[testInt - 1] + " " + fibo[testInt]);
        }
    }

    public static void fibonacci(int n) {
        for (int i = 2; i < n + 1; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }
}
