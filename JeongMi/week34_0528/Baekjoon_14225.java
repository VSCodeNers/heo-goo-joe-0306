// 백준 - 부분수열의 합(14225)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_14225 {
  static int[] S;
  static int N;
  static boolean[] checked = new boolean[20*100000 + 10];
  static public void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());

    S = new int[N];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for(int i = 0; i < N; i++) {
      S[i] = Integer.parseInt(st.nextToken());
    }

    // 부분 수열의 합 체크
    checkSum(0, 0);

    // flase 값이 들어있는 경우 = 부분 수열의 합으로 나올 수 없는 값
    int answer = 1;
    while(checked[answer]) {
      answer++;
    }

    System.out.print(answer);
  }
  // 부분 수열의 합 체크
  static void checkSum(int cnt, int sum) {
    if(cnt == N) {
      // 부분 수열의 합으로 sum은 나올 수 있기 때문에 true
      checked[sum] = true;
      return;
    }
    checkSum(cnt + 1, sum); // cnt번째 원소를 안 더하는 경우
    checkSum(cnt + 1, sum + S[cnt]); // cnt번째 원소를 더하는 경우
  }
}
