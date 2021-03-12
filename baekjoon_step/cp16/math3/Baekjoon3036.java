package cp16.math3;

/*

https://www.acmicpc.net/problem/3036

*/

import java.util.Scanner;

public class Baekjoon3036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int firstCircle = scanner.nextInt();
        while (n-- > 1) {
            int radix = scanner.nextInt();
            int gcd = gcd(firstCircle, radix);
            System.out.println((firstCircle / gcd) + "/" + (radix / gcd));
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
