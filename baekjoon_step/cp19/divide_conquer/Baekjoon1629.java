package cp19.divide_conquer;

import java.util.Scanner;

/*
제곱의 성질을 이용하여 분할정복으로 제곱 연산을 O(logn)에 처리하는 알고리즘이다.

10^11 = 10^5 * 10^5 * 10
10^5 = 10^2 * 10^2 * 10
10^2 = 10^1 * 10^1

위와 같이 제곱수가
- 짝수일 때는 밑^제곱수/2 * 밑^제곱수/2 의 형태를
- 홀수일 때는 밑^제곱수/2 * 밑^제곱수/2 * 밑 의 형태를
띄게된다.

나머지의 성질을 이용

( ( a % m) * ( b % m) ) % m = ( a * b) % m

 */
public class Baekjoon1629 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
    
        System.out.println(power(a % c, b, c));
    }
    
    private static long power(long a, long b, long c) {
        if (b == 1) {
            return a;
        }
        
        long temp = power(a, b / 2, c) % c;
        
        if (b % 2 == 0) {
            return (temp * temp) % c;
        }
        
        return (((temp * temp) % c ) * a) % c;
    }
}
