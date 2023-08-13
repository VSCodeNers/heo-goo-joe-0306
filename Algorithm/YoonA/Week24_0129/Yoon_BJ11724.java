import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ11724{
    static int N, M;            // 정점, 간선의 개수
    static boolean connect[][];    
    static boolean check[];     // 방문 여부 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        connect = new boolean[N+1][N+1];
        check = new boolean[N+1];
        int a, b, count = 0;
        
        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            connect[a][b] = true;
            connect[b][a] = true;
        }

        // 돌면서 방문 하지 않은 곳 있으면 탐색하고 연결 요소 수(count) 1 증가
        for (int i = 1; i < N+1; i++) {
            if (!check[i]) {
                DFS(i);
                count++;
            }
        }
        
        System.out.println(count);
    }

    public static void DFS(int start) {
        check[start] = true;            // 방문함

        // 배열 돌면서 연결되어 있고, 방문 하지않은 곳 있으면 방문함
        for (int i = 1; i < N+1; i++) {
            if (connect[start][i] && !check[i]) {
                DFS(i);
            }
        }
    }
}