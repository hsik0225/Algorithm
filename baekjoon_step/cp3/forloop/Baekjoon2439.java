package cp3.forloop;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2439

별 찍기

    *
   **
  ***
 ****
*****

 */
public class Baekjoon2439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String str;

        for(int i=1, j=n;i<=j;i++) {
            str = new String(new char[i]).replace("\0", "*");
            System.out.printf("%"+j+"s\n",str);
        }
    }
}
