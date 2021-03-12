package cp2.if_statement;

/*
https://www.acmicpc.net/problem/14681
예를 들어, 좌표가 (12, 5)인 점 A는 x좌표와 y좌표가 모두 양수이므로 제1사분면에 속한다. 점 B는 x좌표가 음수이고 y좌표가 양수이므로 제2사분면에 속한다.

점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 알아내는 프로그램을 작성하시오. 단, x좌표와 y좌표는 모두 양수나 음수라고 가정한다.

점 (x, y)의 사분면 번호(1, 2, 3, 4 중 하나)를 출력한다.
 */

import java.util.Scanner;

public class Baekjoon14681 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x*y > 0)
            System.out.println(x > 0 ? 1 : 3);
        else
            System.out.println(x > 0 ? 4 : 2);
    }
}
