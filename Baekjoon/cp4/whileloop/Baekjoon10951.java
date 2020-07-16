package cp4.whileloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/10951

두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

 */
public class Baekjoon10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a,b;

        String line;

        while ((line = br.readLine()) != null) {
            String[] numbers = line.split(" ");

            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);

            System.out.println(a+b);
        }
    }
}
