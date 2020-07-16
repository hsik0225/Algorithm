package cp4.whileloop;

/*
https://www.acmicpc.net/problem/10952

두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력의 마지막에는 0 두 개가 들어온다.
 */

import java.util.Scanner;

public class Baekjoon10952 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a,b;

        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();

            if (a == 0 && b ==0)
                break;

            System.out.println(a+b);
        }
    }
}
