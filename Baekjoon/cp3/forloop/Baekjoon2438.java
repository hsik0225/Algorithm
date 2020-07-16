package cp3.forloop;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2438

첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

출력
*
**
***
****
*****

 */
public class Baekjoon2438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String star = "";

        for (int i = 0; i < n; i++) {
            star += "*";
            System.out.println(star);
        }
    }
}
