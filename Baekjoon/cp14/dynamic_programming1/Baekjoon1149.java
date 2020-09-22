package cp14.dynamic_programming1;

/*

https://www.acmicpc.net/problem/1149

RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

prices[n][m] = prices[n-1][m-1, m-2] 중 작은 값
*/

import java.util.Scanner;

public class Baekjoon1149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] prices = new int[n + 1][4];

        prices[1][1] = scanner.nextInt();
        prices[1][2] = scanner.nextInt();
        prices[1][3] = scanner.nextInt();

        for (int i = 2; i <= n; i++) {
            for (int j = 1, addNumber; j <= 3; j++) {
                if (j == 1) {
                    addNumber = Math.min(prices[i-1][2], prices[i-1][3]);
                }

                else if (j == 2) {
                    addNumber = Math.min(prices[i-1][1], prices[i-1][3]);
                }

                else {
                    addNumber = Math.min(prices[i-1][1], prices[i-1][2]);
                }

                prices[i][j] = scanner.nextInt() + addNumber;
            }
        }

        System.out.println(Math.min(prices[n][1], Math.min(prices[n][2], prices[n][3])));
    }
}
