package cp14.sort;

/*

https://www.acmicpc.net/problem/2750

알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로

첫째 줄에 단어의 개수 N이 주어진다.

(1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

1. 글자 길이 순서대로 정렬 ( 힙 정렬 )
2. 글자를 사전 순서대로 정렬 ( 삽입 정렬 )
*/

import java.io.*;

public class baekjoon1181 {
    private static String[] words;
    private static int[] wordLengths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        words = new String[n];
        wordLengths = new int[n];

        while (n-- > 0) {
            words[n] = br.readLine();
            wordLengths[n] = words[n].length();
        }


    }
}
