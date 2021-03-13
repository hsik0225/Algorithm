package cp20.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10816. 숫자 카드2

https://www.acmicpc.net/problem/10816

이분 탐색으로 풀면 시간초과
메모이제이션으로 풀이
 */
public class Baekjoon10816 {
    
    private static final String BLANK = " ";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] hand = new int[20_000_001];
        for (int i = 0; i < n; i++) {
            hand[Integer.parseInt(st.nextToken()) + 10_000_000]++;
        }
        
        br.readLine();
        st = new StringTokenizer(br.readLine());
        
        while (st.hasMoreTokens()) {
            bw.write(hand[Integer.parseInt(st.nextToken()) + 10_000_000] + BLANK);
        }
        
        bw.flush();
    }
    
    public static void binarySearch(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] hand = new int[n];
        for (int i = 0; i < n; i++) {
            hand[i] = Integer.parseInt(st.nextToken());
        }
        
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        final int[] finds = new int[k];
        for (int i = 0; i < k; i++) {
            finds[i] = Integer.parseInt(st.nextToken());
        }
    
        Arrays.sort(hand);
    
        for (int find : finds) {
            bw.write(search(find, hand) + BLANK);
        }
        
        bw.flush();
    }
    
    private static int search(int find, int[] hand) {
        int high = hand.length - 1;
        int low = 0;
    
        while (low <= high) {
            int mid = (high + low) / 2;
            int handMidValue = hand[mid];
            
            if (find == handMidValue) {
                int count = 1;
                for (int i = mid - 1; (i >= 0) && (hand[i] == find); i--) {
                    count++;
                }
                
                for (int i = mid + 1; (i < hand.length) &&(hand[i] == find); i++) {
                    count++;
                }
                
                return count;
            } else if (find < handMidValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return 0;
    }
}
