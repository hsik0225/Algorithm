package cp5.practice1;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/10039

기말고사 점수가 40점 이상인 학생들은 그 점수 그대로 자신의 성적이 된다. 하지만, 40점 미만인 학생들은 보충학습을 듣는 조건을 수락하면 40점을 받게 된다.

보충학습은 거부할 수 없기 때문에, 40점 미만인 학생들은 항상 40점을 받게 된다.

학생 5명의 점수가 주어졌을 때, 평균 점수를 구하는 프로그램을 작성하시오.

입력
입력은 총 5줄로 이루어져 있고, 원섭이의 점수, 세희의 점수, 상근이의 점수, 숭이의 점수, 강수의 점수가 순서대로 주어진다.

점수는 모두 0점 이상, 100점 이하인 5의 배수이다. 따라서, 평균 점수는 항상 정수이다.

출력
첫째 줄에 학생 5명의 평균 점수를 출력한다.
 */
public class Baekjoon10039 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        for (int i = 0; i < 5; i++) {
            result += Math.max(scanner.nextInt(), 40);
        }

        System.out.println(result/5);
    }
}
