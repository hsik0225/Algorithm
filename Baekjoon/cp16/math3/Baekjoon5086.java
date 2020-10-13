package cp16.math3;

/*

https://www.acmicpc.net/problem/5086

*/

import java.util.Scanner;

public class Baekjoon5086 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 && b == 0) {
                break;
            }

            if (b%a == 0) {
                System.out.println("factor");
            }

            else if (a%b == 0) {
                System.out.println("multiple");
            }

            else
                System.out.println("neither");
        }
    }
}
