package cp3.forloop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2742

자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

 */
public class Baekjoon2742 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (n-- > 0) {
            bw.write(Integer.toString(n+1) + "\n");
        }

        bw.flush();
    }
}
