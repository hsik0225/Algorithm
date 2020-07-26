package cp13.brute_force;

/*

https://www.acmicpc.net/problem/7568


*/

import java.util.Scanner;

public class Baekjoon7568 {
    static class body {
        public int weight;
        public int height;

        public body(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        body[] bodies = new body[n];

        for (int i = 0; i < n; i++) {
            bodies[i] = new body(scanner.nextInt(), scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int ranking = 1;

            for (int j = 0; j < n; j++) {
                if ((bodies[i].weight < bodies[j].weight) && (bodies[i].height < bodies[j].height))
                    ranking++;
            }

            System.out.print(ranking + " ");
        }
    }
}
