import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ10971 {
    private static int N;
    private static long cost_min;
    private static int W[][];
    private static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost_min = Integer.MAX_VALUE;
        W = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            check[i] = true;
            DFS(i, i, 0, 0);
            check[i] = false;
        }
        System.out.println(cost_min);
    }

    public static void DFS(int start, int now, int depth, long cost) {
        if (depth == N - 1) {
            if (W[now][start] != 0) {
                cost_min = Math.min(cost_min, cost + W[now][start]);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i] && W[now][i] != 0) {
                check[i] = true;
                DFS(start, i, depth + 1, cost + W[now][i]);
                check[i] = false;
            }
        }
    }
}
