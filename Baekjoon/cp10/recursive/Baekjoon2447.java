package cp10.recursive;

/*

https://www.acmicpc.net/problem/2447

N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

***
* *
***

N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.

입력
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3^k이며, 이때 1 ≤ k < 8이다.

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.

예제 입력 1
27
 */

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2447 {
    private static char[][] stars;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        stars = new char[n][n];
        fillSpace();
        fillStar(0, 0, n);
        printStar();
    }

    private static void fillStar(int x, int y, int length) {
        if (length == 1)
            stars[x][y] = '*';

        else {
            int div = length/3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j ==1) {
                    }

                    else {
                        fillStar(x + (i*div), y + (j * div), div);
                    }
                }
            }
        }
    }

    private static void printStar() {
        for (int i = 0; i < stars.length; i++) {
            System.out.println(stars[i]);
        }
    }

    private static void fillSpace() {
        for (int i = 0; i < stars.length; i++) {
            Arrays.fill(stars[i], ' ');
        }
    }
}
