package cpA.practice1;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/10817

문제
세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.
 */
public class Baekjoon10817 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a >= b && a >= c)
            System.out.println(Math.max(b,c));

        else if (a < b && a < c)
            System.out.println(Math.min(b,c));

        else
            System.out.println(a);
    }
}
