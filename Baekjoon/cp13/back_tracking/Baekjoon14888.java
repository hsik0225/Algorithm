package cp13.back_tracking;

/*

https://www.acmicpc.net/problem/14888

*/

import java.util.Scanner;

public class Baekjoon14888 {
    private static int n;
    private static int[] numbers;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int plus = scanner.nextInt();
        int minus = scanner.nextInt();
        int multiple = scanner.nextInt();
        int divide = scanner.nextInt();

        dfs(1, numbers[0], plus, minus, multiple, divide);

        System.out.println(max + "\n" + min);
    }

    private static void dfs(int depth, int value, int plus, int minus, int multiple, int divide) {
        if (depth == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        if (plus > 0)
            dfs(depth + 1, value + numbers[depth], plus-1, minus, multiple, divide);
        if (minus > 0)
            dfs(depth + 1, value - numbers[depth], plus, minus-1, multiple, divide);
        if (multiple > 0)
            dfs(depth + 1, value * numbers[depth], plus, minus, multiple-1, divide);
        if (divide > 0)
            dfs(depth + 1, value / numbers[depth], plus, minus, multiple, divide-1);
    }
}
