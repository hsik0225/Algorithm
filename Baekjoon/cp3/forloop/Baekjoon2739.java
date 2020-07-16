package cp3.forloop;

/*
https://www.acmicpc.net/problem/2739

구구단

N*1부터 N*9까지 출력한다.

2 * 1 = 2
2 * 2 = 4
2 * 3 = 6
2 * 4 = 8
2 * 5 = 10
2 * 6 = 12
2 * 7 = 14
2 * 8 = 16
2 * 9 = 18

 */

import java.util.Scanner;

public class Baekjoon2739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d\n", n, i, n*i);
        }
    }
}
