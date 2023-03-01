import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.Position;

public class Yoon_BJ2178 {
    static int N, M;
    static int Maze[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(null));
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
        check[0][0] = true; // 현재 위치는 방문한걸로 표시
        BFS(0, 0);
        System.out.println(Maze[N-1][M-1]);
    }

    public static void BFS(int x, int y) {
        Queue queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        check[x][y] = true;

        int mapX[] = {0, -1, 1, 0};
        int mapY[] = {-1, 0, 0, 1};

        // 좌표 탐색 끝날 때까지 반복
        while(!queue.isEmpty()) {

            for (int i = 0; i < 4; i++) {
                int xx = x + mapX[i];
                int yy = y + mapY[i];
    
                if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
                    
                }
            }
        }
    }
}
