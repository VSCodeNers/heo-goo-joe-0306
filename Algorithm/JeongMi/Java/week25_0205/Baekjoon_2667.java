// 백준 - 단지번호붙이기(2667)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_2667 {
  static int N;
  static int[][] town;
  static boolean[][] visited;
  static Queue<int[]> queue;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { 1, -1, 0, 0 };
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();
    ArrayList<Integer> apartmentCnts = new ArrayList<>();

    N = Integer.parseInt(bf.readLine());
    town = new int[N][N];

    // 각 줄마다 입력된 값을 바로 Integer.parseInt()를 이용해 정수로 변환하면,
    // Integer 범위를 벗어나서 런타임 에러가 발생함
    for(int i = 0; i < N; i++) {
      String input = bf.readLine();
      for(int j = 0; j < N; j++) {
        town[i][j] = input.charAt(j) - '0';
      }
    }

    int complexCnt = 0;
    visited = new boolean[N][N];
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        queue = new LinkedList<>();
        
        // 아직 방문하지 않은 집인 경우
        if(!visited[i][j] && town[i][j] == 1) {
          int apartmentCnt = checkApartmentComplex(i, j);
          apartmentCnts.add(apartmentCnt);
          complexCnt++;
        }
      }
    }

    printSet.append(complexCnt).append("\n");
    if(complexCnt != 0) {
      //Integer[] answer = apartmentCnts.toArray(new Integer[0]);
      Collections.sort(apartmentCnts);
      
      for(int num : apartmentCnts) {
        printSet.append(num).append("\n");
      }
    }

    System.out.print(printSet);
    
  }

  static int checkApartmentComplex(int startX, int startY) {
    int apartmentCnt = 1;

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

        // 이동할 위치가 구역을 벗어나지 않는지 확인
        if(moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
          // 이동할 위치가 집이고, 이전에 방문한 적 없는 경우
          if(town[moveX][moveY] == 1 && !visited[moveX][moveY]) {
            queue.add(new int[]{moveX, moveY});
            visited[moveX][moveY] = true;
            apartmentCnt++;
          }
        }
      }
    }

    return apartmentCnt;
  }
}
