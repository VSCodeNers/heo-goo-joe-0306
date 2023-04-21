// 백준 - 테트로미노(14500)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_14500 {
  static int N, M;
  static int[][] paper;
  static boolean[][] visited;
  static int max = 0; // 최대값 저장

  // 상하좌우 이동
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    paper = new int[N][M];
    visited = new boolean[N][M];

    // 입력
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for(int j = 0; j < M; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 모든 경우의 수 계산
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        visited[i][j]= true;
        maxTetromino(i, j, paper[i][j], 1);
        visited[i][j] = false;
      }
    }

    System.out.print(max);
  }

  // 상하좌우 움직임으로 4개 합 찾기
  static void maxTetromino(int x, int y, int sum, int cnt){
    // 테트로미노 모양 완성
    if(cnt == 4) {
      max = Math.max(sum, max);
      return;
    }

    // 상하좌우 탐색
    for(int i = 0; i < 4; i++) {
      int moveX = x + dx[i];
      int moveY = y + dy[i];

      // 범위 벗어나는지 확인 = 벗어나면 패스
      if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) {
        continue;
      }

      // 방문하지 않았는지 체크
      if(!visited[moveX][moveY]) {
        // ㅗ 모양 테트로미노는 중간에 양쪽으로 갈리기 때문에 한 번 더 체크
        if(cnt == 2) {
          visited[moveX][moveY] = true;
          maxTetromino(x, y, sum + paper[moveX][moveY], cnt + 1); // 이동 후 위치 말고 현 위치로 전달
          visited[moveX][moveY] = false;
        }

        visited[moveX][moveY] = true;
        maxTetromino(moveX, moveY, sum + paper[moveX][moveY], cnt + 1);
        visited[moveX][moveY] = false;
      }
    }
  }
}
/*
상하좌우 움직임으로 테트로미노가 아닌 모양이 나올 수 있는 경우?
=> 없음!

각 모양별로 회전, 대칭된 경우의 수를 다 계산하려다가
생각보다 제한해줘야 할 게 많아서 결국 솔루션 서칭...
*/