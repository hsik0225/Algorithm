package cp14.sort;

/*

https://www.acmicpc.net/problem/1181

시간복잡도가 O(N^2)인 정렬들
버블정렬, 삽입정렬(카드 정렬), 선택정렬

삽입정렬로 풀
*/

import java.util.Scanner;

public class Baekjoon2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int [n];
        for (int i = 0; i < n; i++)
            numbers[i] = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }

                else break;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.println(numbers[i]);
    }
}
