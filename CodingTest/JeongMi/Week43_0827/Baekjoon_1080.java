// 백준 - 행렬(1080)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1080 {
  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    boolean[][] matrix = new boolean[N][M];
    boolean[][] target = new boolean[N][M];
    for(int i = 0; i < N; i++) {
      String input = br.readLine();
      for(int j = 0; j < M; j++) {
        if(input.charAt(j) == '1') matrix[i][j] = true;
      }
    }
    for(int i = 0; i < N; i++) {
      String input = br.readLine();
      for(int j = 0; j < M; j++) {
        if(input.charAt(j) == '1') target[i][j] = true;
      }
    }
    br.close();

    int cnt = 0;
    for(int i = 0; i < N-2; i++) {
      for(int j = 0; j < M-2; j++) {
        if(matrix[i][j] != target[i][j]) {
          cnt++;
          for(int k = i; k < i+3; k++) {
            for(int l = j; l < j+3; l++) {
              matrix[k][l] = !matrix[k][l];
            }
          }
        }
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(matrix[i][j] != target[i][j]) {
          System.out.print(-1);
          return;
        }
      }
    }

    System.out.print(cnt);
  }
  
}
