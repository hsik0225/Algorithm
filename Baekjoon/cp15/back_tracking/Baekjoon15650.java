package cp15.back_tracking;

/*

https://www.acmicpc.net/problem/15650

문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

*/

import java.util.Scanner;

public class Baekjoon15650 {
    static int n;
    static int m;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        visited = new boolean[n + 1];

        dfs("", 0, 1);
    }

    private static void dfs(String answer, int depth, int start) {
        if (depth >= m) {
            System.out.println(answer);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(answer + i + " ", depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
