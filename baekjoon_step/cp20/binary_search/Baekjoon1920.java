package cp20.binary_search;

import java.util.Arrays;
import java.util.Scanner;

/*
재귀로 푸는게 while문으로 하는 것보다 더 빠름

이유는 모름

 */

public class Baekjoon1920 {
    private static int[] range;
    private static int find;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        range = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    
        scanner.nextLine();
        int[] finds = Arrays.stream(scanner.nextLine().split(" "))
                      .mapToInt(Integer::parseInt)
                      .toArray();
        
        Arrays.sort(range);
    
        for (int i : finds) {
            find = i;
            System.out.println(search(0, range.length - 1));
        }
    }
    
    private static int search(int x, int y) {
        int mid = (x + y) / 2;
        final int value = range[mid];
        
        if (value == find) {
            return 1;
        }
        
        if (x >= y) {
            return 0;
        }
        
        if (value > find) {
            return search(x, mid - 1);
        }
        
        return search(mid + 1, y);
    }
    
    private static int search(int find, int[] range) {
        int high = range.length - 1;
        int low = 0;
        int mid;
        
        while (low <= high) {
            mid = (high + low) / 2;
            
            if (range[mid] == find) {
                return 1;
            } else if (find < range[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return 0;
    }
}
