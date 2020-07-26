package cp13.brute_force;

/*

https://www.acmicpc.net/problem/2798

*/

import java.util.Scanner;

public class Baekjoon2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int max = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];
                    if (sum > max && sum <= m) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
