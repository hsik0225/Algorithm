import java.util.Scanner;

public class Baekjoon2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int noJump = 0;
        int jump = 0;

        int[] score = new int[n + 1];
        int[] addedScore = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = scanner.nextInt();
        }

        addedScore[1] = score[1];

        if (n >= 2) {
            addedScore[2] = addedScore[1] + score[2];
        }

        //N번째 계단은 무조건 밟아야 하기 때문에 N번째 계단이 1번 연속인 경우!
        //N번째 계단이 2번연속인 경우! 이 2가지 경우를 나누어서 생각

        //N번째 계단에 한 번에 2계단 점프해서 도착한 경우
        //addedScore[N] = addedScore[N-2] + score[N]

        //N번째 계단에 1계단만 점프해서 도착한 경우
        //연속해서 3계단을 움직일 수 없으므로 N-3번째의 계단을 반드시 거쳤어야 한다
        //그러므로 N번째 계단의 점수 + N-1번째 계단의 점수 + N-3번 째의 계단까지 모은 점수 = N번쨰 계단의 총합
        //addedScore[N] = score[N] + score[N-1] + addedScore[N-3]

        for (int i = 3; i <= n; i++) {
            noJump = score[i] + score[i - 1] + addedScore[i - 3];
            jump = score[i] + addedScore[i - 2];
            addedScore[i] = Math.max(noJump, jump);
        }
        System.out.println(addedScore[n]);
    }
}
