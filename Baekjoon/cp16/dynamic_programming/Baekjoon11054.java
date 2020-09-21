package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/11054

*/

import java.util.Scanner;

public class Baekjoon11054 {
    private static int n;
    private static int[] front;
    private static int[] back;
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        array = new int[n];
        front = new int[n];
        back = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            front[i] = back[i] = 1;
        }

        lis();
        reverselis();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, front[i] + back[i]);
        }

        System.out.println(max - 1);
    }

    private static void lis() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[i] > array[j]) {
                    front[i] = Math.max(front[i], front[j] + 1);
                }
            }
        }
    }

    private static void reverselis() {
        for (int i = n-1; i >= 1; i--) {
            for (int j = n-1; j >= i; j--) {
                if (array[i] > array[j]) {
                    back[i] = Math.max(back[i], back[j] + 1);
                }
            }
        }
    }
}
