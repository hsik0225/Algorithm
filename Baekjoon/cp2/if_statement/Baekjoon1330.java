/*
https://www.acmicpc.net/problem/1330
첫째 줄에 다음 세 가지 중 하나를 출력한다.

- A가 B보다 큰 경우에는 '>'를 출력한다.
- A가 B보다 작은 경우에는 '<'를 출력한다.
- A와 B가 같은 경우에는 '=='를 출력한다.
 */

package cp2.if_statement;

import java.util.Scanner;

public class Baekjoon1330 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a > b)
            System.out.println(">");
        else if (a < b)
            System.out.println("<");
        else
            System.out.println("==");
    }
}
