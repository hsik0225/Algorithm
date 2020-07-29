package cp15.back_tracking;

/*

https://www.acmicpc.net/problem/9663

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

*/

import java.util.Scanner;

public class Baekjoon9663 {
    private static int n;
    private static int count = 0;

    // 퀸의 y좌표들
    // yQueen[0] 는 0번째 줄(가로 기준)의 퀸의 y좌표
    private static int[] yQueen = new int[16];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            // 0번째 줄의 퀸을 i로 설정
            yQueen[0] = i;

            // 0번째 줄의 퀸의 x좌표는 i이다
            nQueen(0, i);
        }
        System.out.println(count);
    }

    // x번째 줄의 퀸의 y좌표는 y이다
    // x-1은 현재까지 찾은 퀸의 개수가 된다
    private static void nQueen(int x, int y) {
        for (int i = 0; i < x; i++) {
            // x번째 줄 이전의 퀸들의 y좌표가 지금의 퀸의 y좌표와 같거나 대각선에 있따면
            if (yQueen[i] == y || Math.abs(yQueen[i] - y) == x - i)
                return;
        }

        // x는 0부터 시작하므로 n-1에서 끝난다
        if (x == n-1) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {

            // x번째 줄까지는 퀸을 찾았다
            // x+1 번째의 퀸을 찾기위해 x = x+1, y = 0 ~ n 까지로 반복문을 돈다
            yQueen[x+1] = i;

            nQueen(x+1, i);
        }
    }
}
