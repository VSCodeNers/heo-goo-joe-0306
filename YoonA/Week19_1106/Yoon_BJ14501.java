import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ14501 {
    public static int T[], P[], dp[];
    public static int N, max = 0;       // N일까지 얻을 수 있는 최대 수익
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];       

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            DP(i, T[i], P[i], 0);
        }

        System.out.println(max);
    }

    public static void DP(int day, int period, int profit, int total) {
        /* 현재 일(day)에 상담 걸리는 기간(period) 더해서 n+1일째가 되면 상담 불가이므로
           그대로 Math.max로 최대 수익(max) 구해서 출력
           근데 딱 퇴사날이라면 수익 합계에 그 상담 수익까지 합함
        */ 
        if (day + period >= N + 1) {
            if (day + period == N + 1) { 
                total += profit;           
            }       
            max = Math.max(total, max);    
            return;
        }
        /* 지난 기간부터 시작해서 퇴사날 될 때까지 계속 반복함 */
        for (int i = day + period; i <= N; i++) {
            DP(i, T[i], P[i], total + profit);
        }
    }
}