package cp18.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1158 {
    
    private static final String CLOSING_BRACKET = ">";
    private static final String OPEN_BRACKET = "<";
    
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> answerQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();
    
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int index = queue.poll();
                queue.add(index);
            }
            
            answerQueue.add(queue.poll());
        }
    
        String answer = answerQueue.toString();
        answer = answer.substring(1, answer.length() - 1);
        System.out.println(OPEN_BRACKET + answer + CLOSING_BRACKET);
    }
}
