// 백준 - 테트로미노(14500)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_14500 {
  static int N, M;
  static int[][] paper;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    paper = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for(int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }
  static int maxTetromino(){
    int max = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {

      }
    }

    return max;
  }
  
  static int checkMaxSum(int x, int y) {
    // ㅁ
    int sum1 = paper[x][y];

    // ㅁㅁ
    int sum2hor = sum1 + paper[x][y+1];
    int sum2ver = 0;

    // ㅁㅁㅁ

    // ㅁㅁㅁㅁ
    int sum4hor = 0, sum4ver = 0;
    for(int i = 0; i < 4; i++) {
      sum4hor += paper[x + i][y];
      sum4ver += paper[x][y + i];
    }

    int max = 0;
    // 1*4 모양 - 회전 가로, 세로
    
    

    // 2*2 모양

    // 3 + 1 모양 - 4가지


    // 2개, 2개가 어긋나서 붙은 모양 - 회전 2가지 


    // 3개랑 중간에 하나 붙은 모양 - 회전 4가지


    return max;
  }
}
