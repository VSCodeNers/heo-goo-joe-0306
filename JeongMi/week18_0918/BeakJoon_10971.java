// 백준 - 외판원 순회 2 (10971)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_10971 {
    static int N;
    static int[][] cost;
    static boolean[] checked; // 방문한 도시 체크
    static long min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        cost = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checked = new boolean[N];
        for(int i = 0; i < N; i++) {
            checked[i] = true;
            minCost(0, 0, i, i);
            checked[i] = false;
        }

        System.out.print(min);
    }

    static void minCost(int cnt, long sum, int start, int pre) {
        if(cnt+1 == N) {
            if(cost[pre][start] != 0) { // 출발 지점으로 돌아갈 수 있는 경우
                sum += cost[pre][start];

                // 비용이 더 작거나, 첫번째 경우일 때
                if(sum < min || min == 0) min = sum;
            }

            return;
        }
        
        for(int i = 0; i < N; i++) {
            // 아직 방문하지 않았으며, 현재 도시에서 이동할 수 있는 도시인 경우
            if(!checked[i] && cost[pre][i] != 0) {
                checked[i] = true;
                minCost(cnt + 1, sum + cost[pre][i], start, i);
                checked[i] = false;
            }
        }
    }
}
