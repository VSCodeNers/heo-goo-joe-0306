// 백준 - 나이트의 이동(7562)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Beakjoon_7562 {
  static int I;
  static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
  static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();
    int testCase = Integer.parseInt(bf.readLine());
    int cnt = 0;
    
    while(cnt < testCase) {
      cnt++;

      int[] start = new int[2];
      int[] finish = new int[2];

      I = Integer.parseInt(bf.readLine());

      StringTokenizer st = new StringTokenizer(bf.readLine());
      start[0] = Integer.parseInt(st.nextToken());
      start[1] = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(bf.readLine());
      finish[0] = Integer.parseInt(st.nextToken());
      finish[1] = Integer.parseInt(st.nextToken());

      printSet.append(checkToBFS(start[0], start[1], finish[0], finish[1])).append("\n");
    }

    System.out.print(printSet);
  }
  static int checkToBFS(int startX, int startY, int finishX, int finishY) {
    //System.out.println(startX + " " + startY + " " + finishX + " " + finishY);
    boolean[][] visited = new boolean[I][I];
    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[]{startX, startY, 0});
    visited[startX][startY] = true;

    while(!queue.isEmpty()) {
      startX = queue.peek()[0];
      startY = queue.peek()[1];
      int count = queue.peek()[2];
      queue.poll();

      // 도착
      if(startX == finishX && startY == finishY){
        return count;
      }

      // 하단, 상단, 좌측, 우측 순으로 집 연결 유무 확인
      for(int i = 0; i < 8; i++) {
        int moveX = startX + dx[i];
        int moveY = startY + dy[i];

        // 이동할 위치가 구역을 벗어나는지 확인
        if(moveX < 0 || moveX >= I || moveY < 0 || moveY >= I)
          continue;

        // 이동할 위치에 이전에 방문한 적 없는 경우
        if(!visited[moveX][moveY]) {
          queue.add(new int[]{moveX, moveY, count + 1});
          visited[moveX][moveY] = true;
        }
      }
    }

    return -1;
  }
}
