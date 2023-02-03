// 백준 - 섬의 개수(4963) -> 처음 풀었던 방법
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_4963_2 {
  static int w, h;
  static int[][] world;
  static boolean[][] visited;
  static Queue<Integer> queueH;
  static Queue<Integer> queueW;
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

      // 아래로 땅이 연결된 경우
      if((startH < h-1 && world[startH + 1][startW] == 1) && !visited[startH + 1][startW]) {
        queueH.add(startH + 1);
        queueW.add(startW);
        visited[startH + 1][startW] = true;
      }

      // 위로 땅이 연결된 경우
      if((startH > 0 && world[startH - 1][startW] == 1) && !visited[startH - 1][startW]) {
        queueH.add(startH - 1);
        queueW.add(startW);
        visited[startH - 1][startW] = true;
      }

      // 왼쪽으로 땅이 연결된 경우
      if((startW > 0 && world[startH][startW - 1] == 1) && !visited[startH][startW - 1]) {
        queueH.add(startH);
        queueW.add(startW - 1);
        visited[startH][startW - 1] = true;
      }

      // 오른쪽으로 땅이 연결된 경우
      if((startW < w-1 && world[startH][startW + 1] == 1) && !visited[startH][startW + 1]) {
        queueH.add(startH);
        queueW.add(startW + 1);
        visited[startH][startW + 1] = true;
      }

      // 우측 하단 대각선 방향으로 땅이 연결된 경우
      if((startH < h-1 && startW < w-1) && (world[startH + 1][startW + 1] == 1 && !visited[startH + 1][startW + 1])) {
        queueH.add(startH + 1);
        queueW.add(startW + 1);
        visited[startH + 1][startW + 1] = true;
      }

      // 우측 상단 대각선 방향으로 땅이 연결된 경우
      if((startH > 0 && startW < w-1) && (world[startH - 1][startW + 1] == 1 && !visited[startH - 1][startW + 1])) {
        queueH.add(startH - 1);
        queueW.add(startW + 1);
        visited[startH - 1][startW + 1] = true;
      }

      // 좌측 하단 대각선 방향으로 땅이 연결된 경우
      if((startH < h-1 && startW > 0) && (world[startH + 1][startW - 1] == 1 && !visited[startH + 1][startW - 1])) {
        queueH.add(startH + 1);
        queueW.add(startW - 1);
        visited[startH + 1][startW - 1] = true;
      }

      // 좌측 상단 대각선 방향으로 땅이 연결된 경우
      if((startH > 0 && startW > 0) && (world[startH - 1][startW - 1] == 1 && !visited[startH - 1][startW - 1])) {
        queueH.add(startH - 1);
        queueW.add(startW - 1);
        visited[startH - 1][startW - 1] = true;
      }
      
    }
  }
}