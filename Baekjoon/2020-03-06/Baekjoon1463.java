//https://www.acmicpc.net/problem/1463

import java.util.Scanner;

public class Baekjoon1463 {
    static int[] cases;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        cases = new int[n + 1];
        System.out.println(dynamicProgramming(n));
        scanner.close();
    }

    public static int dynamicProgramming(int current) {
        if (current == 1) {
            return 0;
        }
        if (cases[current] > 0) {
            return cases[current];
        }
        cases[current] = dynamicProgramming(current - 1) + 1;
        if (current % 2 == 0) {
            int temp = dynamicProgramming(current / 2) + 1;
            if (cases[current] > temp) {
                cases[current] = temp;
            }
        }
        if (current % 3 == 0) {
            int temp = dynamicProgramming(current / 3) + 1;
            if (cases[current] > temp) {
                cases[current] = temp;
            }
        }
        return cases[current];
    }
}
