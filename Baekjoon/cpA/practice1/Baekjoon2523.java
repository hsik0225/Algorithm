package cpA.practice1;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/2523

첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.

*
**
***
**
*

 */
public class Baekjoon2523 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String top = "";
        String down = top;

        for (int n = scanner.nextInt(), i = 0; ++i < n; down = top + "\n" + down) {
            System.out.println(top+="*");
        }

        System.out.println(top + "*\n" + down);
    }
}
