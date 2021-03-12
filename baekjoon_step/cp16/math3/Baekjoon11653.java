package cp16.math3;

/*

https://www.acmicpc.net/problem/11653

*/

import java.util.Scanner;

public class Baekjoon11653 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int divide = 2;

        while (n != 1) {
            if (n % divide == 0) {
                System.out.println(divide);
                n /= divide;
            } else {
                divide++;
            }
        }
    }
}
