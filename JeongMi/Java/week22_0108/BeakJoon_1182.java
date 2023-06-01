// 백준 - 부분수열의 합(1182)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_1182 {
  static int N, S;
  static int[] num;
  static boolean[] select; // 초기값 false
  static int resultCnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    num = new int[N];
    select = new boolean[N];

    st = new StringTokenizer(bf.readLine());
    for(int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    numArrSum(0, 0, 0);

    System.out.print(resultCnt);
  }

  static void numArrSum(int point, int cnt, int sum) {
    if(point == N) {
      if(sum == S && cnt > 0) {
        resultCnt++;
      }
      return;
    }

    numArrSum(point + 1, cnt + 1, sum + num[point]);
    numArrSum(point + 1, cnt, sum);
  }
}
