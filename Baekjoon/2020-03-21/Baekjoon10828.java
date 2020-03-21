import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Baekjoon10828 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    push(Integer.parseInt(input[1]));
                    break;

                case "pop":
                    pop();
                    break;

                case "size":
                    size();
                    break;

                case "empty":
                    empty();
                    break;

                case "top":
                    top();
                    break;
            }

        }

    }

    public static void push(int a) {
        stack.push(a);
    }

    public static void pop() {
        System.out.println(stack.isEmpty() ? -1 : stack.pop());
    }

    public static void size() {
        System.out.println(stack.size());
    }

    public static void empty() {
        System.out.println(stack.isEmpty() ? 1 : 0);
    }

    public static void top() {
        System.out.println(stack.isEmpty() ? -1 : stack.peek());
    }
}
