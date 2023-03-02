import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ7562 {
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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static DFS(int start, int count) {
        // 나이트가 이동하고자 하는 칸
        int mapX[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        int mapY[] = {-2, -1, 1, 2, 2, 1, -1, -2};

        for (int i = 0; i < 8; i++) {
            int xx = x + mapX[i];
            int yy = y + mapY[i];

            // 범위를 벗어나지 않은 경우
            if(xx >= 0 && yy >= 0 && xx < N && yy < M) {
                // 아직 방문하지 않은 경우
                if (!check[xx][yy]) {
                    check[xx][yy] = true;
                    // 연결된 땅을 모두 방문함
                    DFS(xx, yy);
                }
            }
            
        }
    }
}