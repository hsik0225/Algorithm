package cp13.brute_force;

/*

https://www.acmicpc.net/problem/1436

*/

import java.util.Scanner;

public class Baekjoon1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int title = 0;

        for (int i = 666, series = 0; series != n; i++) {
            String str = Integer.toString(i);

            if (str.contains("666")) {
                series++;
                title = i;
            }
        }

        System.out.println(title);
    }
}
