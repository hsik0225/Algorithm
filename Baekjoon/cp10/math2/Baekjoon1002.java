package cp10.math2;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1002

이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.

조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,

조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,

류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.

입력
3
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5

 */
public class Baekjoon1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n-- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();

            // type을 double로 해야한다. int로 하면 틀렷다고 뜬다
            double distance = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
            int result = 0;

            // 두 개의 원이 완전히 겹칠 때 -> distacne == 0 무한대
            if (distance == 0 && r1 == r2)
                result = -1;

            // 두 개의 원이 한 군데에서 만날 때
            // 1. r1 + r2 == distance
            // 2. |r1 -r2| == distance
            else if (r1 + r2 == distance || Math.abs(r1 - r2) == distance)
                result = 1;

            // 두 원의 중점이 같은데 반지름이 달라 만나지 않는다 -> distance == 0 && r1 != r2
            // 두 개의 원이 안 만날 때 -> r1 + r2 < distance
            else if (distance < Math.abs(r1 - r2) || r1 + r2 < distance || distance == 0)
                result = 0;

            // 두 개의 원이 두 군데에서 만날 때 -> r1 + r2 > distance
            else if (r1 + r2 > distance)
                result = 2;


            System.out.println(result);
        }
    }
}
