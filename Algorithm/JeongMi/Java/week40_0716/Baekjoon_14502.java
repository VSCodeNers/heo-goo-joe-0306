// 백준 - 연구소(14502)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_14502 {
  static int N, M;
  static int[][] map;
  static int maxSafe = 0;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfsWall(0);

    System.out.print(maxSafe);
  }

  // 벽 세우기
  static void dfsWall(int wall) {
    // 벽을 3개 세운 경우 -> 안전 구역 확인
    if(wall == 3) {
      bfsVirus();
      return;
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        // 바이러스가 없고, 벽이 없는 곳
        if(map[i][j] == 0) {
          map[i][j] = 1;
          dfsWall(wall + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  // 벽 세우고 바이러스 얼마나 퍼졌는지 확인
  static void bfsVirus() {
    Queue<int[]> q = new LinkedList<>();
    int[][] virusMap = new int[N][M];

    // 바이러스 퍼진 거 표시할 map이랑 벽 위치 queue
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        virusMap[i][j] = map[i][j];
        // 벽 위치 표시
        if (virusMap[i][j] == 2) {
          q.add(new int[]{i, j});
        }
      }
    }

    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0];
      int y = tmp[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && virusMap[moveX][moveY] == 0) {
          virusMap[moveX][moveY] = 2;
          q.add(new int[]{moveX, moveY});
        }
      }
    }

    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (virusMap[i][j] == 0) {
          count++;
        }
      }
    }

    maxSafe = Math.max(maxSafe, count);
  }
}