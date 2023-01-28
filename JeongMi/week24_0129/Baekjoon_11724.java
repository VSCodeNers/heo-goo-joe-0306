// 백준 - 연결 요소의 개수(11724)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_11724 {
  static int N, M;
  static boolean[][] edges;
  static boolean[] visited;
  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int cnt = 0;
    
    N = Integer.parseInt(st.nextToken()); // 정점의 개수
    M = Integer.parseInt(st.nextToken()); // 간선의 개수

    edges = new boolean[N+1][N+1];

    // 연결된 정점(간선이 존재하는 정점쌍 표시)
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(bf.readLine());
      int edge1 = Integer.parseInt(st.nextToken());
      int edge2 = Integer.parseInt(st.nextToken());

      edges[edge1][edge2] = true;
      edges[edge2][edge1] = true;
    }

    visited = new boolean[N+1];

    for(int i = 1; i <= N; i++) {
      if(!visited[i]) {
        checkBFS(i);
        cnt++;
      }
    }

    System.out.print(cnt);
  }

  static void checkBFS(int start) {
    q.add(start);
    visited[start] = true;

    while(!q.isEmpty()) {
      start = q.poll();

      for(int i = 1; i <= N; i++) {
        if(edges[start][i] && !visited[i]) {
          q.add(i);
          visited[i] = true;
        }
      }
    }
  }
}
