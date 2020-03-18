import java.util.Scanner;

public class Baekjoon11051 {
    static int dp[][] = new int[1001][1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(factorial(a, b));
    }

    public static int factorial(int a, int b) {
        if (a == b || b == 0) {
            return 1;
        }

        //값을 입력하지 않았을 땐 0으로 초기화되어있다
        //dp[a][b]가 0보다 크다는 것은 값이 입력되었었다는 뜻
        if (dp[a][b] > 0) {
            return dp[a][b];
        }

        dp[a][b] = factorial(a - 1, b - 1) + factorial(a - 1, b);

        return dp[a][b] % 10007;
    }
}
