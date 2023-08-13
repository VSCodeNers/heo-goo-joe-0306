// 백준 - 숨바꼭질(1697)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_1697 {
  static int N, K;
  static int[] visited = new int[1000001];
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.print(checkToBFS());
  }

  static int checkToBFS() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(N);
    visited[N] = 1;
    
    while(!queue.isEmpty()) {
      int prePosition = queue.remove();

      // 도착한 경우
      if(prePosition == K)
        return visited[prePosition] - 1;
      
      // n-1 이동 시, 범위를 벗어나지 않고 방문한 적이 없는 경우
      if(prePosition - 1 >= 0 && visited[prePosition - 1] == 0) {
        visited[prePosition - 1] = visited[prePosition] + 1;
        queue.add(prePosition - 1);
      }

      // n+1 이동 시, 범위를 벗어나지 않고 방문한 적이 없는 경우
      if(prePosition + 1 <= 1000000 && visited[prePosition + 1] == 0) {
        visited[prePosition + 1] = visited[prePosition] + 1;
        queue.add(prePosition + 1);
      }

      // 2*n 이동 시, 범위를 벗어나지 않고 방문한 적이 없는 경우
      if(prePosition * 2 <= 1000000 && visited[prePosition * 2] == 0) {
        visited[prePosition * 2] = visited[prePosition] + 1;
        queue.add(prePosition * 2);
      }
    }

    return -1;
  }
}
