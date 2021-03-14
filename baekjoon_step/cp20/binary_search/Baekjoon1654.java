package cp20.binary_search;

import java.io.*;
import java.util.Arrays;

/*
1654. 랜선 자르기

https://www.acmicpc.net/problem/1654

입력 가능한 최대 길이는 정수의 최대 길이이고, mid = (high + low) / 2이다.
high가 정수의 최대 길이라면, low는 1이므로 정수의 최대 길이에서 벗어나게 된다.
그러므로 mid, high, low를 long으로 설정해야 한다.
 */
public class Baekjoon1654 {
    private static long[] lengths;
    private static int k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
    
        lengths = new long[n];
        for (int i = 0; i < n; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
        }
    
        System.out.println(search());
    }
    
    private static long search() {
        long high = Arrays.stream(lengths).max().getAsLong();
        long low = 1;
        
        while (low <= high) {
            long mid = (high + low) / 2L;
            long count = getCount(mid);
    
            if (count < k) {
                high = mid - 1L;
            } else {
                low = mid + 1L;
            }
        }
        return high;
    }
    
    private static long getCount(long mid) {
        long count = 0;
        for (long length : lengths) {
            count += (length / mid);
        }
        return count;
    }
}
