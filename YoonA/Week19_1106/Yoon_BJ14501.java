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

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            DP(i, T[i], P[i], 0);
        }
        System.out.println(max);
    }

    public static void DP(int day, int time, int price, int total) {
        if (day + time >= N + 1) {
            if (day + time == N + 1) {
                total += price;
            }
            max = Math.max(total, max);
            return;
        }
        for (int i = day + time; i <= N; i++) {
            DP(i, T[i], P[i], total + price);
        }
    }
}