// 백준 - 종이 조각(14391)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_14391 {
  static int N, M;
  static int[][] paper;
  static boolean[][] marked; // 가로, 세로 조각 표시
  static int max = 0; // 최대 합
  public static void main(String args[]) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine()); 
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    paper = new int[N][M];
    marked = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      int line = Integer.parseInt(bf.readLine());
      int ten = 10;
      for(int j = M - 1; j >= 0; j--) {
        paper[i][j] = line % ten;
        line /= ten;
      }
    }

    checkPieceOfPaper(0, 0);

    System.out.print(max);
  }

  // 가로 세로 조각 나누기 - 모든 경우의 수
  // true: 가로 / false: 세로
  static void checkPieceOfPaper(int row, int col) {
    // N*M 종이를 모두 조각으로 나누면 종료하고 합 계산하기
    if(row >= N) {
      calculateSum();
      return;
    }

    // 다음 행으로 이동
    if(col >= M) {
      checkPieceOfPaper(row + 1, 0);
      return;
    }

    // 가로 조각
    marked[row][col] = true;
    checkPieceOfPaper(row, col + 1);

    // 세로 조각
    marked[row][col] = false;
    checkPieceOfPaper(row, col + 1);
  }

  // 종이 조각 합 계산
  static void calculateSum() {
    int sum = 0;   // 총합
    int piece = 0; // 조각의 합

    // 가로 조각
    for(int i = 0; i < N; i++) {
      piece = 0; // 조각 합 초기화
      for(int j = 0; j < M; j++) {
        // 가로 조각인 경우
        if(marked[i][j]) {
          // 앞에 이어지는 가로 조각의 자릿수를 높여주고 1의 자리에 더해주기
          piece *= 10;
          piece += paper[i][j];
        }
        // 가로 조각이 아닌 경우 = 앞에 가로 조각 계산해둔 거 더하기
        else {
          sum += piece;
          piece = 0; // 가로 조각 끊겼으니까 값 초기화
        }
      }
      // 한 줄이 통으로 조각인 경우가 있을 수 있으므로 더해주기
      sum += piece;
    }

    // 세로 조각
    for(int i = 0; i < M; i++) {
      piece = 0; // 조각 합 초기화
      for(int j = 0; j < N; j++) {
        // 세로 조각인 경우
        if(!marked[j][i]) {
          // 앞에 이어지는 세로 조각의 자릿수를 높여주고 1의 자리에 더해주기
          piece *= 10;
          piece += paper[j][i];
        }
        // 세로 조각이 아닌 경우 = 앞에 세로 조각 계산해둔 거 더하기
        else {
          sum += piece;
          piece = 0; // 세로 조각 끊겼으니까 값 초기화
        }
      }
      // 한 줄이 통으로 조각인 경우가 있을 수 있으므로 더해주기
      sum += piece;
    }

    // 계산한 값이 이전에 계산한 값보다 크면 저장
    max = Math.max(sum, max);
  }
}
