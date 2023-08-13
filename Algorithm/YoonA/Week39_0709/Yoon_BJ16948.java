import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoon_BJ16948 {
    static int N;
    static int r1, c1, r2, c2;
    static int dx[] = {-2, -2, 0, 0, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -1, 1};
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        check = new boolean[N][N];
        st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        BFS();
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r1, c1, 0});
        check[r1][c1] = true;

        int min = Integer.MAX_VALUE;
        boolean possible = false;

        while (!queue.isEmpty()) {
            int chess[] = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextR = chess[0] + dx[i];
                int nextC = chess[1] + dy[i]; 
                int count = chess[2];   

                // 체스핀 범위 안 + 방문한 적 없으면
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !check[nextR][nextC]) {
                    // 목적지 도착한 경우
                    if (nextR == r2 && nextC == c2) {
                        // 최소값 구하고 possible 참으로 바꿈
                        min = Math.min(min, count + 1);
                        possible = true;
                        break;
                    }
                    // 다음 칸으로 이동 + 반문 여부 체크
                    queue.offer(new int[] {nextR, nextC, count + 1});
                    check[nextR][nextC] = true;
                }
            }
        }

        // 출발지에서 목적지까지 제대로 도착했다면 최소값 반환
        if (possible) {
            System.out.print(min);
        }
        // 이동 불가능하다면 -1 반환
        else {
            System.out.print(-1);
        }
    }
}
