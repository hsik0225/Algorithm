package cp5.practice1;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/10996

 */
public class Baekjoon10996 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 0;

        int n = scanner.nextInt();

        StringBuilder star = new StringBuilder();

        for (int j = 1; j <= n; j++) {
            star.append(j % 2 != 0 ? "*" : " ");
        }

        star.append("\n").append(" " + star);

        star.deleteCharAt(star.length()-2);

        while (i++ < n) {
            System.out.print(star.toString());
        }
    }
}
