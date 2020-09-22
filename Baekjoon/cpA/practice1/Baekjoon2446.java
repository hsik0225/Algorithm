package cpA.practice1;

import java.util.Scanner;/*

https://www.acmicpc.net/problem/2446

첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.

입력
5

출력
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********

 */

public class Baekjoon2446 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;

        String star = "";
        String enterLine;
        String result = star;

        while (i < n) {
            enterLine = String.format("%" + (n == 1 ? "" : n-1) + "s%s\n", star, star+="*");
            result = i++ > 0 ? enterLine + result + enterLine : enterLine;
        }

        System.out.println(result);
    }
}
