// 백준 - 퇴사(14501)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_14501 {
    static int N;
    static int works[][];
    static boolean canWorks[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        works = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        canWorks = new boolean[N];
        checkCanWorkDay();

        dp = new int[N];
        
        int max = 0;
        for(int i = 0; i < N; i++) {
            if(dp[i] == 0 && canWorks[i]) {
                maxProfit(i);
            }
            if(dp[i] > max) max = dp[i];
        }

        System.out.print(max);
    }

    // 상담 가능한 날짜만 체크 = 퇴사 전에 상담할 수 있는
    static void checkCanWorkDay() {
        for(int i = 0; i < N; i++) {
            if((i + works[i][0]) <= N) {
                canWorks[i] = true;
            }
        }
    }

    // 최대 수익 구하기
    static void maxProfit(int start) {
        if(dp[start] != 0) { // 이미 탐색한 경우
            return;
        }
        // 아직 탐색을 안 한 경우
        // 해당 날짜의 상담을 한 경우, 다음 상담으로 가능한 경우의 수 계산
        dp[start] = works[start][1];
        int max = 0;
        for(int i = start + works[start][0]; i < N; i++) {
            if(dp[i] == 0 && canWorks[i]) {
                maxProfit(i);
            }
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        dp[start] += max;
    }
}
