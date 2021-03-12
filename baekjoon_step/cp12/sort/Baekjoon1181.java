package cp12.sort;

/*

https://www.acmicpc.net/problem/2750

알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로

첫째 줄에 단어의 개수 N이 주어진다.

(1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

1. 글자 길이 순서대로 정렬 ( 힙 정렬 )
힙 정렬에서 downHeap할 때 글자를 사전 순서대로 정렬한다

*/

import java.io.*;
import java.util.Arrays;

public class Baekjoon1181 {
    private static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()) + 1;
        words = new String[n];

        while (n-- > 1) {
            words[n] = br.readLine();
        }

        heapSort();

        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1]))
                bw.write(words[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void heapSort() {
        int heapSize = words.length - 1;

        // 힙 생성
        for (int i = heapSize / 2; i > 0; i--) {
            downHeap(i, heapSize);
        }

        // 힙 정렬
        while (heapSize > 1) {
            swap(1, heapSize--);
            downHeap(1, heapSize);
        }
    }

    private static void downHeap(int p, int heapSize) {
        while (2 * p <= heapSize) {
            int s = 2 * p;

            if (s < heapSize) {
                if (words[s].length() < words[s + 1].length())
                    s++;

                else if (words[s].length() == words[s + 1].length()) {
                    int index = 0;

                    // 단어의 철자가 다른 부분이 나올때까지 while - loop
                    while (words[s].charAt(index) == words[s + 1].charAt(index)) {
                        if (index >= words[s].length() - 1)
                            break;

                        index++;
                    }

                    if (words[s].charAt(index) < words[s + 1].charAt(index)) {
                        s++;
                    }
                }
            }

            if (words[p].length() > words[s].length())
                break;

            else if (words[p].length() == words[s].length()) {
                int index = 0;

                // 단어의 철자가 다른 부분이 나올때까지 while - loop
                while (words[p].charAt(index) == words[s].charAt(index)) {
                    if (index >= words[p].length() - 1)
                        break;

                    index++;
                }

                if (words[p].charAt(index) > words[s].charAt(index))
                    break;
            }

            swap(p, s);

            p = s;
        }
    }

    private static void swap(int p, int s) {
        String tempStr = words[p];
        words[p] = words[s];
        words[s] = tempStr;
    }
}
