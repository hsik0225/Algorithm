package cp14.dynamic_programming1;

/*

https://www.acmicpc.net/problem/1463

*/

import java.util.Scanner;

public class Baekjoon1463 {
    private static int[] cases;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        cases = new int[n + 1];
        System.out.println(dp(n));
    }

    public static int dp(int input) {
        if (input == 1) {
            return 0;
        }

        if (cases[input] > 0) {
            return cases[input];
        }

        cases[input] = dp(input - 1) + 1;

        int temp;
        if (input%2 == 0) {
            temp = dp(input/2) + 1;
            cases[input] = Math.min(cases[input], temp);
        }

        if (input%3 == 0) {
            temp = dp(input/3) + 1;
            cases[input] = Math.min(cases[input], temp);
        }

        return cases[input];
    }
}
