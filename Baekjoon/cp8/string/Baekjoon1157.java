package cp8.string;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1157

문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

 */
public class Baekjoon1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next().toUpperCase();

        int[] counts = new int[26];
        char result = '?';

        for (int i = 0, max = 0; i < word.length(); i++) {
            int index = (int) word.charAt(i)-65;
            counts[index]++;

            if (counts[index] > max) {
                max = counts[index];
                result = word.charAt(i);
            }

            else if (counts[index] == max)
                result = '?';
        }

        System.out.println(result);
    }
}
