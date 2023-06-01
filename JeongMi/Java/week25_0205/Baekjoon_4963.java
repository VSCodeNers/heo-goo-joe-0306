// 백준 - 섬의 개수(4963)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_4963 {
  static int w, h;
  static int[][] world;
  static boolean[][] visited;
  static Queue<Integer> queueH;
  static Queue<Integer> queueW;
  static int[] dw = { 0, 0, -1, 1, 1, 1, -1, -1 };
  static int[] dh = { 1, -1, 0, 0, 1, -1, 1, -1 };
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    do {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      if(w == 0) break;

      world = new int[h][w];
      for(int i = 0; i < h; i++) {
        st = new StringTokenizer(bf.readLine());
        for(int j = 0; j < w; j++) {
          world[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int islandCnt = 0;
      visited = new boolean[h][w];
      for(int i = 0; i < h; i++) {
        for(int j = 0; j < w; j++) {
          queueH = new LinkedList<>();
          queueW = new LinkedList<>();
          
          // 아직 방문하지 않은 땅인 경우
          if(!visited[i][j] && world[i][j] == 1) {
            checkIsLandArea(i, j);
            islandCnt++;
          }
        }
      }

      printSet.append(islandCnt).append("\n");

    } while(w > 0 && h > 0);

    System.out.print(printSet);
    
  }

  static void checkIsLandArea(int startH, int startW) {
    queueH.add(startH);
    queueW.add(startW);
    visited[startH][startW] = true;

    while(!queueH.isEmpty()) {
      startH = queueH.poll();
      startW = queueW.poll();

      // 하단, 상단, 좌측, 우측, 우하단, 우상단, 좌하단, 좌상단 순으로 땅 연결 유무 확인
      for(int i = 0; i < 8; i++) {
        int moveH = startH + dh[i];
        int moveW = startW + dw[i];

        // 이동할 위치가 구역을 벗어나지 않는지 확인
        if(moveH >= 0 && moveH < h && moveW >= 0 && moveW < w) {
          // 이동할 위치가 땅이고, 이전에 방문한 적 없는 경우
          if(world[moveH][moveW] == 1 && !visited[moveH][moveW]) {
            queueH.add(moveH);
            queueW.add(moveW);
            visited[moveH][moveW] = true;
          }
        }

      }
      
    }
  }
}
