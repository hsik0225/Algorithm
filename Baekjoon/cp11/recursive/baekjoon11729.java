package cp11.recursive;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/11729

세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.

각 원판은 반경이 큰 순서대로 쌓여있다.

이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.

한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라.

단, 이동 횟수는 최소가 되어야 한다.

첫째 줄에 옮긴 횟수 K를 출력한다.

두 번째 줄부터 수행 과정을 출력한다.

두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,

이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.

 */
public class baekjoon11729 {
    private static int count = 0;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        hanoi(1, 2, 3, n);
        System.out.print(stringBuilder.insert(0, count + "\n").toString());
    }

    private static void hanoi(int left, int middle, int right, int n) {
        count++;

        // 원반이 1개일 때 left에서 right 옮기고 종료
        if (n == 1) {
            stringBuilder.append(left + " " + right + "\n");
        }

            // 원반이 n개 일 때
        else {
            // 1. 1번 기둥에 있는 n개 원반 중 n-1 개를 2번 기둥으로 옮긴다
            hanoi(left, right, middle, n-1);

            // 2. 1번 기둥에 있는 가장 큰 원반은 3번 기둥으로 옮긴다
            stringBuilder.append(left + " " + right + "\n");

            // 3. 2번 기둥에 있는 n-1개 원반을 3번 기둥으로 옮긴다
            hanoi(middle, left, right, n-1);
        }
    }
}
