package cp9.math1;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1193

이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

 */
public class Baekjoon1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 분모는 자신을 포함한 자신의 왼쪽 대각선에 있는 분수들의 개수
        // 분자는 자신을 포함한 자신의 오른쪽 대각선에 있는 분수들의 개수

        // 1. 찾는 수를 n이라고 할 때, n이 몇 번째 대각선에 있는지 찾는다
        // 2. 찾은 대각선에서 가장 오른쪽 위에서 몇 칸 떨어져 있는지 찾는다
        // 3. 오른쪽 위를 기준으로 몇 칸, 왼쪽 대각선아래를 기준으로 몇 칸 떨어졍있는지 계산한다
        // 4. 출력

        // 분수들의 개수는 1, 2, 3, ... 식으로 늘어난다
        int index = 1;

        while (n > index)
            n -= index++;

        int up;
        int down;

        if (index%2!=0) {
            up = index - n + 1;
            down = n;
        } else {
            up = n;
            down = index - n + 1;
        }

        System.out.printf("%d/%d", up, down);
    }
}
