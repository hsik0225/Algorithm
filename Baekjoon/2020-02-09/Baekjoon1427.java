import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] array = br.readLine().toCharArray();
        Arrays.sort(array);
        for (int index = array.length-1; index >= 0; index--) {
            bw.write(array[index]);
        }
        bw.flush();
    }
}
