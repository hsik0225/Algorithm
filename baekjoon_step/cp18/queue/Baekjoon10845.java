package cp18.queue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon10845 {
    private static final String BLANK = " ";
    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";
    private static final Queue queue = new Queue();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            invokeQueue(br.readLine());
        }
    }
    
    private static void invokeQueue(String input) {
        String[] commandAndNumber = input.split(BLANK);
        
        switch (commandAndNumber[0]) {
            case PUSH:
                queue.push(Integer.parseInt(commandAndNumber[1]));
                break;
            
            case POP:
                System.out.println(queue.pop());
                break;
                
            case SIZE:
                System.out.println(queue.size());
                break;
                
            case EMPTY:
                System.out.println(queue.empty());
                break;
    
            case FRONT:
                System.out.println(queue.front());
                break;
    
            case BACK:
                System.out.println(queue.back());
                break;
        }
    }
    
    private static class Queue {
        List<Integer> queue;
    
        public Queue() {
            this.queue = new ArrayList<>();
        }
        
        public void push(int number) {
            queue.add(number);
        }
        
        public int pop() {
            if (queue.isEmpty()) {
                return -1;
            }
            
            return queue.remove(0);
        }
        
        public int size() {
            return queue.size();
        }
        
        public int empty() {
            return queue.isEmpty() ? 1 : 0;
        }
        
        public int front() {
            if (queue.isEmpty()) {
                return -1;
            }
            
            return queue.get(0);
        }
        
        public int back() {
            if (queue.isEmpty()) {
                return -1;
            }
            
            return queue.get(queue.size() - 1);
        }
    }
}
