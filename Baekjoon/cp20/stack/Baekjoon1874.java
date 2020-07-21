package cp20.stack;

/*

https://www.acmicpc.net/problem/1874

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.

이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.

임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.

이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.

둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.

물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.

push연산은 +로, pop 연산은 -로 표현하도록 한다.

불가능한 경우 NO를 출력한다.
 */

import java.io.*;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int top = 0;
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {

            // 입력 값
            int temp = Integer.parseInt(br.readLine());

            // 입력 값이 max보다 크다면 max가 될 때까지 push해준다
            if (temp > max) {
                for (int i = max+1; i <= temp; i++) {
                    stack[top++] = i;
                    sb.append("+\n");
                }
                max = temp;
            }

            // 만약 max값보다 작은 값이 입력으로 들어왔다면,
            // 이 숫자는 이미 스택안에 들어있는 숫자이다. 스택에서 pop을 해서 그 값이 입력받은 수와 같은지 다른지 비교를 한다.
            // 다르다면 이 수열은 스택수열이 아니다.
            // 만약 top - 1 의 값이 temp가 아니라면 temp를 pop으로 뽑을 때, 다른 값을 한 번 더 뽑아야 한다
            // 예를 들어, 내가 뽑으려는 값이 2이고 2,3,4가 저장되어 있을 때,
            // pop으로 2를 뽑으려고 하면 4,3이 딸려오게 된다
            // 그러므로 pop을 했을 때의 값이 무조건 temp이어야 한다
            else if (stack[top - 1] != temp) {
                System.out.println("NO");
                return;
            }

            top--;
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
