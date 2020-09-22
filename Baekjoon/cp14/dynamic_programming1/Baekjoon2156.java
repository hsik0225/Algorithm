package cp14.dynamic_programming1;

/*

https://www.acmicpc.net/problem/2156

*/

import java.util.Scanner;

public class Baekjoon2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[11];
        int[] sum = new int[11];

        for (int i = 1; i <= n; i++) {
            sum[i] = a[i] = scanner.nextInt();
        }

        sum[2] = a[1] + a[2];

        for (int i = 3, x, y, z; i <= n; i++) {
            // oox
            x = sum[i - 1];

            // oxo
            y = sum[i - 2] + a[i];

            // xoo
            z = sum[i - 3] + a[i - 1] + a[i];

            sum[i] = Math.max(x, Math.max(y, z));
        }

        System.out.println(sum[n]);
    }
}
