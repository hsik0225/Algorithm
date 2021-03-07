package cp8.math1;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon10757 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);

        System.out.println(a.add(b).toString());
    }}
