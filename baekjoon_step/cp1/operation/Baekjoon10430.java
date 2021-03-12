package cp1.operation;/*
* https://www.acmicpc.net/problem/10430
* 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
* */
import java.util.Scanner;

public class Baekjoon10430 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println((a + b)%c);
        System.out.println(((a%c) + (b%c))%c);
        System.out.println((a * b)%c);
        System.out.println(((a%c) * (b%c))%c);
    }
}
