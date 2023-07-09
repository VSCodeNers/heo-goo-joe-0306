// 백준 - 데스나이트(16948)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;

public class Baekjoon_16948 {
  static boolean[][] visited;
  static int count = 0;
  static int n;
  static int[] dx = {-2, -2, 0, 0, 2, 2};
  static int[] dy = {-1, 1, -2, 2, -1, 1};
  static int r1, r2, c1, c2;
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    r1 = Integer.parseInt(st.nextToken());
    c1 = Integer.parseInt(st.nextToken());
    r2 = Integer.parseInt(st.nextToken());
    c2 = Integer.parseInt(st.nextToken());

    visited = new boolean[n][n];
    System.out.print(bfs(r1,c1));
  }
  static int bfs(int r1, int c1) {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    q1.add(r1);
    q2.add(c1);

    visited[r1][c1] = true;

    while (!q1.isEmpty()) {
      int size = q1.size();

      for (int j = 0; j < size; j++) {
        int x = q1.remove();
        int y = q2.remove();

        if (x == r2 && y == c2) return count;

        for (int i = 0; i < 6; i++) {
          int mx = x + dx[i];
          int my = y + dy[i];

          if (mx < 0 || mx > n-1) continue;
          if (my < 0 || my > n-1) continue;
          if (!visited[mx][my]) {
            visited[mx][my] = true;
            q1.add(mx);
            q2.add(my);
          }
        }
      }
      count++;
    }
    return -1;
  }
}
