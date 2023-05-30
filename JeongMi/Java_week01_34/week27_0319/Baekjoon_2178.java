// 백준 - 미로 탐색(2178)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_2178 {
  static int n, m;
  static int[][] map;
  static boolean[][] visited;
  static Queue<int[]> queue;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { 1, -1, 0, 0 };
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

    visited = new boolean[n][m];
		visited[0][0] = true;
    queue = new LinkedList<>();
    checkToBFS(0, 0);

    System.out.print(map[n-1][m-1]);
  }
  static void checkToBFS(int startX, int startY) {
    queue.add(new int[]{startX, startY});
    visited[startX][startY] = true;

    while(!queue.isEmpty()) {
      startX = queue.peek()[0];
      startY = queue.peek()[1];
      queue.poll();

      // 하단, 상단, 좌측, 우측 순으로 집 연결 유무 확인
      for(int i = 0; i < 4; i++) {
        int moveX = startX + dx[i];
        int moveY = startY + dy[i];

        // 이동할 위치가 구역을 벗어나는지 확인
        if(moveX < 0 || moveX >= n || moveY < 0 || moveY >= m)
          continue;

        // 이동할 위치가 길이 아니거나, 이전에 방문한 적 있는 경우
        if(map[moveX][moveY] == 0 || visited[moveX][moveY])
          continue;

        queue.add(new int[]{moveX, moveY});
        visited[moveX][moveY] = true;
        
        map[moveX][moveY] = map[startX][startY] + 1;
      }
    }
  }
}
