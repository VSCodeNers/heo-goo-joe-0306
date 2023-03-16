import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoon_BJ2178 {
    static int N, M;
    static int Maze[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Maze = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                Maze[i][j] = s.charAt(j) - '0';
            }
        }

         // 출발지
        check[0][0] = true;
        BFS(0, 0);
        System.out.println(Maze[N-1][M-1]);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int mapX[] = {0, -1, 1, 0};
        int mapY[] = {-1, 0, 0, 1};

        // 좌표 탐색 끝날 때까지 반복
        while(!q.isEmpty()) {
            // 큐에서 값을 꺼냄. 그거 기준에서 상하좌우 갈 수 있는 곳으로 간다.
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {
                int xx = nx + mapX[i];
                int yy = ny + mapY[i];
    
                // 범위 안일 경우
                if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
                    // 다음 갈 지점이 이동 가능한 칸이고, 아직 방문하지 않은 경우
                    if (Maze[xx][yy] == 1 && !check[xx][yy]) {
                        q.add(new int[] {xx, yy});
                        check[xx][yy] = true;
                        // 큐에서 꺼낸 now[] 값 기준으로 +1 헤준 값을 다음 갈 지점 배열에 저장?
                        Maze[xx][yy] = Maze[nx][ny] + 1;
                    }
                }
            }
        }
    }
}
