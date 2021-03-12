package cp3.forloop;

/*
https://www.acmicpc.net/problem/10871

정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

 */

import java.io.*;

public class Baekjoon10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine().split(" ")[1]);

        String[] array = br.readLine().split(" ");

        StringBuffer stringBuffer = new StringBuffer();

        for (String str : array) {
            int number = Integer.parseInt(str);

            if (number < x)
                stringBuffer.append(number).append(" ");
        }

        stringBuffer.deleteCharAt(stringBuffer.length()-1);

        System.out.println(stringBuffer);

        br.close();
    }
}
