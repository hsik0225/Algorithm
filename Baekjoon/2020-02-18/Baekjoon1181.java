import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Baekjoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        HashSet<String> words = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        ArrayList<String> wordsList = new ArrayList<>(words);

        Collections.sort(wordsList, (o1, o2) -> {
            int compareLength = Integer.compare(o1.length(), o2.length());
            if (compareLength == 0) {
                return o1.compareTo(o2);
            }
            return compareLength;
        });

        wordsList.forEach(System.out::println);
    }
}
