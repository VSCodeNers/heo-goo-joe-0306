// 백준: 에너지 모으기(16198)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_16198 {
  static int N;
  static int[] w;
  static boolean[] deleted;
  static int max = 0;
  static public void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    
    w = new int[N];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    bf.close();
    for(int i = 0; i < N; i++) {
      w[i] = Integer.parseInt(st.nextToken());
    }

    deleted = new boolean[N];
    calculateScore(N, 0);

    System.out.print(max);
  }
  // remain: 현재 남은 수의 갯수
  // score: 현 점수
  static void calculateScore(int remain, int score) {
    // 지우고 남은 수가 2개면 계산 종료
    if(remain == 2) {
      // 최댓값
      max = Math.max(score, max);
      return;
    }

    int cnt = 0;
    for(int i = 0; i < N; i++) {
      // 지우지 않은 수
      if(!deleted[i]) {
        deleted[i] = true;
        int e = energy(i);
        // 에너지가 0이면 첫번째 또는 마지막 구슬을 지운 것임
        if(e != 0) calculateScore(remain - 1, score + e);
        deleted[i] = false;
      }
    }
  }

  static int energy(int index) {
    int x1 = 0, x2 = 0;
    // W(x-1)
    for(int i = index - 1; i >= 0; i--) {
      if(!deleted[i]) {
        x1 = w[i];
        break;
      }
    }

    // W(x+1)
    for(int i = index + 1; i < N; i++) {
      if(!deleted[i]) {
        x2 = w[i];
        break;
      }
    }

    return x1 * x2;
  }
} 
