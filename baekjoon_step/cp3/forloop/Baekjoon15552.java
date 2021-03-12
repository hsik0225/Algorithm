package cp3.forloop;

/*
https://www.acmicpc.net/problem/15552
 */

import java.io.*;

public class Baekjoon15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer stringBuffer = new StringBuffer();

        for (String line = bufferedReader.readLine(), tokens[]; !(line = bufferedReader.readLine()).equals(""); stringBuffer.append(Long.parseLong(tokens[0]) + Long.parseLong(tokens[1]) + "\n")) {
            tokens = line.split(" ");
        }

        System.out.println(stringBuffer);

    }
}
