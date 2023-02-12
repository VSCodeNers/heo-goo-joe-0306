import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_BJ2667 {
    static int N, count;
    static int map[][];
    static int apart[];
    static boolean check[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(br.readLine());
            }
        }

        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 집이 있고, 방문하지 않은 곳
                if (map[i][j] == 1 && !check[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }
        apart = new int[count];
    }

    public static void DFS(int x, int y) {
        // 해당 땅을 방문한 것으로 표시
        check[x][y] = true;
        map[x][y] = count;      // 방문했음을 표시

        // 현재 위치 기준으로 상하좌우를 모두 살펴봐야 하므로 / 땅으로 된 곳이 있는지
        int mapX[] = {0, -1, 1, 0};
        int mapY[] = {-1, 0, 0, 1};

        for (int i = 0; i < 4; i++) {
            int xx = x + mapX[i];
            int yy = y + mapY[i];

            // 범위를 벗어나지 않은 경우
            if(xx >= 0 && yy >= 0 && xx < h && yy < w) {
                //집이 있고, 아직 방문하지 않은 경우
                if (map[xx][yy] == 1 && !check[xx][yy]) {
                    check[xx][yy] = true;
                    // 연결된 땅을 모두 방문함
                    DFS(xx, yy);
                }
            }
        }
    }
}
