package cp9.math2;

/*

https://www.acmicpc.net/problem/4153

과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다.

주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다.

입력
6 8 10
25 52 60
5 12 13
0 0 0

 */

import java.util.Scanner;

public class Baekjoon4153 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;

        int aSquare;

        // a^2 + b^2 = c^2 이므로,
        // a^2 + b^2 + c^2 = 2 * (c^2) 이어야 한다
        // 문제에서 무조건 가장 마지막 숫자가 빗변이다
        while ((aSquare = (a = scanner.nextInt()) * a) > 0) {

            for (int i = 0; i++ < 2; a = Math.max(b, a)) {
                aSquare += (b = scanner.nextInt()) * b;
            }

            System.out.println(2*a*a==aSquare ? "right" : "wrong");
        }
    }
}
