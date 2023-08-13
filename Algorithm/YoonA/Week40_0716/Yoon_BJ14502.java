import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoon_BJ14502 {
    static int N, M, res = 0;
    static int map[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(res);
    }

    public static void DFS(int count) {
        // 벽 세개 세웠으면 바이러스 살포
        if (count == 3) {
            BFS();
            return;
        }

        // 벽 세개 못 세웠으면 세움
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 벽 없다면 
                if (map[i][j] == 0) {
                    // 벽 세우고
                    map[i][j] = 1;
                    DFS(count + 1);
                    // 다시 벽 없앰
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        int vm[][] = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                vm[i][j] = map[i][j];

                // 바이러스라면 큐에 추가
                if (vm[i][j] == 2) 
                    q.add(new int[] {i, j});
            }
        }

        while (!q.isEmpty()) {
            int v[] = q.poll();

            int row = v[0];
            int column = v[1];

            int dx[] = {-1, 1, 0, 0};
            int dy[] = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = column + dy[i];

                 // 범위 안에 들어있고 빈칸이라면
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && vm[nr][nc] == 0) {
                    // 바이러스 퍼트리고 큐에 넣어라
                    vm[nr][nc] = 2;
					q.add(new int[] { nr, nc });
				}
            }
        }
        safe(vm);
    }

    public static void safe(int[][] vm) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vm[i][j] == 0) 
                    count++;
            }
        }
        res = Math.max(count, res);
    }
}
