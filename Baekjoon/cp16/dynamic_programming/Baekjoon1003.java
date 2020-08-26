package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/1003

int n = 0 일 때, n = 1일 때를 count해서 출력하면 되지 않을까?
*/

import java.util.Scanner;

public class Baekjoon1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int zeroCount = 0;
            int oneCount = 0;
            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("1 0");
                continue;
            } else if (input == 1) {
                System.out.println("0 1");
                continue;
            }

            int a = 0;
            int b = 1;
            int c = 0;

            for (int i = 2; i <= input; i++) {
                c = a + b;
                a = b;
                b = c;
            }

            System.out.printf("%d %d\n", a, b);
        }
    }
}
