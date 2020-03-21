import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Baekjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();

            String input = br.readLine();

            String answer = "YES";

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    stack.push(1);
                } else {
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    }

                    stack.pop();
                }
            }

            System.out.println(stack.isEmpty() ? answer : "NO");
        }
    }
}
