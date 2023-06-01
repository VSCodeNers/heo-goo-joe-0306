// 백준 - 종이조각(14391)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_14391 {
  static int N, M;
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    Long sum1 = 0L, sum2 = 0L;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[] input = new int[N];
    arr = new int[N][M];

    for(int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(bf.readLine());
      sum1 += input[i];
      for(int j = M - 1; j >= 0; j--) {
        arr[i][j] = input[i] % 10;
        input[i] /= 10;
      }
    }

    sum2 = Check();

    if(sum1 > sum2)
      System.out.print(sum1);
    else
      System.out.print(sum2);
    
  }

  static Long Check() { // 수직 계산
    Long sum = 0L;

    for(int j = 0; j < M; j++) {
      int temp = 0;
      for(int i = 0; i < N; i++) {
        temp *= 10;
        temp += arr[i][j];
      }
      sum += temp;
    }
    return sum;
  }
}
