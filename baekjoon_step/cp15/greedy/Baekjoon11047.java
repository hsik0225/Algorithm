package cp15.greedy;

/*

https://www.acmicpc.net/problem/11047

*/

import java.util.Scanner;

public class Baekjoon11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] numbers = new int[n];

        int count = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            if (numbers[i] >= k) {
                index = i - 1;
            }
        }

        if (n != 1 && index == 0) {
            index = n - 1;
        }

        while (k != 0) {
            count += k / numbers[index];
            k %= numbers[index--];
        }

        System.out.println(count);
    }
}
