package cp19.divide_conquer;

import java.util.Scanner;

/*
확장 유클리드 알고리즘으로 풀이

https://onsil-thegreenhouse.github.io/programming/problem/2018/04/02/problem_combination/

답보고 해도 뭔지 하나도 모르겠다. 나중에 다시 공부해보는 걸로.. 할지는 모르겠다.
 */
public class Baekjoon11401 {
    private static long x, y, gcd, temp;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long p = 1000000007;
        
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % p;
        }
        
        long denominator = (factorial[k] * factorial[n - k]) % p;
        
        euclidean(p, denominator);
        
        long result = ((factorial[n] % p) * (y % p)) % p;
        
        if (result < 0) {
            result += p;
        }
    
        System.out.println(result);
    }
    
    private static void euclidean(long denominator, long p) {
        if (denominator % p > 0) {
            euclidean(p, denominator % p);
            temp = y;
            y = x - (denominator / p) * y;
            x = temp;
        } else {
            x = 0;
            y = 1;
            gcd = p;
        }
    }
}
