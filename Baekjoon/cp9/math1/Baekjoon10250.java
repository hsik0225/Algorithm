package cp9.math1;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1011

각 층에 W 개의 방이 있는 H 층 건물이라고 가정하자 (1 ≤ H, W ≤ 99). 그리고 엘리베이터는 가장 왼쪽에 있다고 가정하자(

 N 번째로 도착한 손님에게 배정될 방 번호를 계산하는 프로그램이다.

 */
public class Baekjoon10250 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n-- > 0) {
            int h = scanner.nextInt();

            scanner.nextInt();

            int k = scanner.nextInt();

            // (k - 1) / h + 1
            // k = 10, h = 10이라고 할 때,
            // k - 1을 하지 않고 k / h  + 1 을 하면 손님은 1번방에 머무는게 아니라 2번 방에 머물게 된다
            // 그러므로 -1을 해줘야 한
            System.out.printf("%d%02d\n", k%h == 0 ? h : k%h, (k-1)/h + 1);
        }
    }
}
