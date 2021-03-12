package cp1.operation;// https://www.acmicpc.net/problem/2588

import java.util.Scanner;

public class Baekjoon2588 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        String b = scanner.next();
        char[] bChars = b.toCharArray();

        int result = 0;

        int j = 1;

        for (int i = bChars.length-1; i >= 0 ; i--, j*=10) {
            int number = bChars[i] - '0';
            int multiple = a * number;
            System.out.println(multiple);

            result += (multiple * j);
        }

        System.out.println(result);
    }
}
