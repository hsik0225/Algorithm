package cp16.math3;

/*

https://www.acmicpc.net/problem/11050

*/

import java.util.Scanner;

public class Baekjoon11050 {

    public static int[] factorial;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (k == 0 || n == k) {
            System.out.println(1);
            return;
        }

        factorial = new int[n + 1];
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
        }

        System.out.println(factorial[n] / (factorial[n - k] * factorial[k]));
    }
}
