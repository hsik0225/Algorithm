package cp15.greedy;

/*

https://www.acmicpc.net/problem/1541

*/

import java.util.Scanner;

public class Baekjoon1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] splitSub =  expression.split("\\-");

        int sum = 0;
        if (expression.charAt(0) != '-') {
            for (String number : splitSub[0].split("\\+")) {
                sum += Integer.parseInt(number);
            }
        }

        for (int i = 1; i < splitSub.length; i++) {
            for (String number : splitSub[i].split("\\+")) {
                sum -= Integer.parseInt(number);
            }
        }
        System.out.println(sum);
    }
}
