package cp10.math2;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1085

문제
한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 오른쪽 위 꼭짓점은 (w, h)에 있다.

직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 x y w h가 주어진다.

w와 h는 1,000보다 작거나 같은 자연수이고, x는 1보다 크거나 같고, w-1보다 작거나 같은 자연수이고, y는 1보다 크거나 같고, h-1보다 작거나 같은 자연수이다.

 */
public class Baekjoon1085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        // x가 w/2보다 작으면 왼쪽으로, 크면 오른쪽으로
        // y가 h/2보다 작으면 아래로, 크면 위로
        int a = Math.min(x, w-x);
        int b = Math.min(y, h-y);

        System.out.println(Math.min(a,b));
    }
}
