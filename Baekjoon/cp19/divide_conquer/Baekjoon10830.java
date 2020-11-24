package cp19.divide_conquer;

/*

https://www.acmicpc.net/problem/10830

*/

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon10830 {

    private static int n;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        long[][] arrayA = new long[n][n];

        long m = scanner.nextLong();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayA[i][j] = scanner.nextLong();
            }
        }

        long[][] result = power(arrayA, m);

        printArray(result);
    }

    private static long[][] power(long[][] array, long m) {
        if (m == 0) {
            long[][] temp = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = 1;
                }
            }
            return temp;
        } else if (m == 1) {
            return array;
        } else if (m%2 == 0) {
            long[][] temp = power(array, m / 2);
            return multiply(temp, temp);
        } else {
            long[][] temp = power(array, m - 1);
            return multiply(array, temp);
        }
    }

    private static long[][] multiply(long[][] arrayA, long[][] arrayB) {
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += (arrayA[i][k] * arrayB[k][j]) % 1000;
                }
            }
        }

        return result;
    }

    private static void printArray(long[][] result) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j] % 1000).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
