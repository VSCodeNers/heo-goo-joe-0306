import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ16197 {
    static int N, M, ans = Integer.MAX_VALUE;
    static char map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        boolean flag = false;
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'o') {
                    if (flag) {
                        x2 = i;
                        y2 = j;
                    }
                    else {
                        x1 = i;
                        y1 = j;
                        flag = true;
                    }
                }
            }
        }
        BFS(x1, x2, y1, y2, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
    }

    public static void BFS(int x1, int x2, int y1, int y2, int count) {
        // ans보다 count가 더 크거나, count가 10 이상이면 종료
        if (count >= ans || count >= 10) return;

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int next_x1 = x1 + dx[i];
            int next_x2 = x2 + dx[i];
            int next_y1 = y1 + dy[i];
            int next_y2 = y2 + dy[i];
            int fall = 0;

            // 해당 코인이 떨어지는지를 판단
            if (!inRange(next_x1, next_y1)) fall++;
            if (!inRange(next_x2, next_y2)) fall++;

            // 코인이 둘 다 떨어지면 안됨
            if (fall == 2) continue;
            // 하나만 떨어졌다? 그러면 탐색 멈추고 최소값 구함
            else if (fall == 1) {
                ans = Math.min(ans, count + 1);
                return;
            }
            else {
                // 코인이 하나도 떨어지지 않았다면? 현재 자리에서 상하좌우 방향으로 동전 굴림
                if (map[next_x1][next_y1] == '#') {
                    next_x1 = x1;
                    next_y1 = y1;
                }
                if (map[next_x2][next_y2] == '#') {
                    next_x2 = x2;
                    next_y2 = y2;
                }
                // 코인 위치를 이동 시킴
                BFS(next_x1, next_x2, next_y1, next_y2, count + 1);
            }
        }
    }

    // 범위 안에 있으면 코인이 안 떨어지니까 true, 범위를 벗어나면 false
    static boolean inRange(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }
        return false;
    }
}
