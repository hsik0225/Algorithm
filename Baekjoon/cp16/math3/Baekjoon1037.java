package cp16.math3;

/*

https://www.acmicpc.net/problem/1037

*/

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1037 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] divisors = new int[n];
        while(n-- > 0) {
            divisors[n] = scanner.nextInt();
        }

        Arrays.sort(divisors);

        System.out.println("divisors = " + Arrays.toString(divisors));

        System.out.println(divisors[0] * divisors[divisors.length -1]);
    }
}
