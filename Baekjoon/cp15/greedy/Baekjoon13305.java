package cp15.greedy;

import java.util.Scanner;

public class Baekjoon13305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] distances = new long[n - 1];
        long[] prices = new long[n];


        for (int i = 0; i < n - 1; i++) {
            distances[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextLong();
        }

        long sum = 0;
        long minCost = prices[0];

        for (int i = 0; i < n - 1; i++) {
            minCost = Math.min(minCost, prices[i]);

            sum += (minCost * distances[i]);
        }

        System.out.println(sum);
    }
}
