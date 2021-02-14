package cp17.stack;

import java.util.Scanner;

public class Baekjoon10799 {
    
    private static final char OPEN_BRACKET = '(';
    private static final char CLOSED_BRACKET = ')';
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pipe = scanner.nextLine();
    
        int bracketCount = 0;
        int reuslt = 0;
        
        char[] pieces = pipe.toCharArray();
    
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] == OPEN_BRACKET) {
                if (pieces[i + 1] == OPEN_BRACKET) {
                    bracketCount += 1;
                } else {
                    reuslt += bracketCount;
                    i++;
                }
            } else {
                reuslt += 1;
                bracketCount -= 1;
            }
        }
        
        System.out.println(reuslt);
    }
}
