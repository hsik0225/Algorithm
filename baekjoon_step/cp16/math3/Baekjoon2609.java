package cp16.math3;

/*

https://www.acmicpc.net/problem/2609

유클리드 호제법이란?
a를 b로 나눈 나머지를 r이라고 할 때, a와 b의 최대공약수는 b와 r의 최대공약수와 같다

〈유클리드 호제법 증명〉
G(a, b) = g라고 하자. 최대공약수의 성질에 의해 a = a′g, b = b′g이고 G(a′, b′) = 1이다.
a = bq + r로부터 r = a - bq = g(a′ - b′q) 이고, g는 r의 약수이다.
G(b, r) = g임을 보이기 위해서는 G(b′, a′ - b′q) = 1임을 보이면 된다.

귀류법을 적용하여 결론을 부정해보자.
어떤 정수 d가 존재하여 G(b′, a′ - b′q) =d(≠ 1)라고 하면, b′ = dm, a′ - b′q = dn라고 할 수 있고,
a′ = b′q + dn = dmq + dn = d(mq + n) 이므로 G(a′, b′) = 1라는 가정에 모순이다. 따라서 G(b′, a′ - b′q) = 1이므로 G(b, r) = g가 성립한다.

가정에 모순인 이유는 a′과 b′이 d를 약수를 가지고 있기 때문이다.
*/

import java.util.Scanner;

public class Baekjoon2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = gcd(Math.max(a,b), Math.min(a,b));

        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
