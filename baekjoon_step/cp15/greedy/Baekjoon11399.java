package cp15.greedy;

/*

https://www.acmicpc.net/problem/11399

*/

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] times = new int[n];
        int spendTime = 0;
        int sumTime = 0;
        while (n -- > 0) {
            times[n] = scanner.nextInt();
        }

        Arrays.sort(times);

        for (int i = 0; i < times.length; i++) {
            spendTime += times[i];
            sumTime += spendTime;
        }

        System.out.println(sumTime);
    }
}
