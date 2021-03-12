package cp16.math3;

import java.util.Scanner;

public class Baekjoon1934 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }

            long gcd = gcd(a, b);

            System.out.println(a * b / gcd);
        }
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}

