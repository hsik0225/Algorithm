package cp20.binary_search;

import java.io.*;
import java.util.Arrays;

/*
2805. 나무 자르기

https://www.acmicpc.net/problem/2805

cutTrees에서 sum을 한다. 이 때 sum결과값이 int 범위를 벗어날 수 있으므로 long으로 설정해야 한다.
 */
public class Baekjoon2805 {
    private static int k;
    private static long[] trees;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        
        trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    
        System.out.println(search());
    }
    
    private static long search() {
        long high = Arrays.stream(trees).max().getAsLong();
        long low = 1;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long remainTreeLengthSum = cutTrees(mid);
            
            if (remainTreeLengthSum >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
    private static long cutTrees(long mid) {
        return Arrays.stream(trees).filter(tree -> tree > mid).map(tree -> tree - mid).sum();
    }
}
