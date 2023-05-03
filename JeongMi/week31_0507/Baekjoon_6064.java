// 백준 - 카잉 달력(6064)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_6064 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());
    StringBuilder printSet = new StringBuilder();

    // 테스트 케이스 갯수만큼 반복
    while(T > 0) {
      // 입력 데이터: M, N, x, y
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      T--;

      // 세상의 종말이 오는 해 구하기
      // 마지막해 = M, N의 최소공배수
      // 최소공배수 = M*N / (M,N의 최대공약수)
      int lastYear = (M*N) / gdc(M, N);

      // x에 맞춰서 y 구하기
      // x 값은 고정하고, x에 맞춰서 y값 변화시키기 = 시간 절약!
      int year = x;
      int checkY = ((year-1) % N) + 1;
      while(checkY != y) {
        year += M;
        checkY = ((year-1) % N) + 1;

        // 세상의 종말이 지났으면 종료
        if(year > lastYear) {
          year = -1;
          break;
        }
      }

      printSet.append(year).append("\n");
    }
    
    System.out.print(printSet);
  }

  // 유클리드 호제법을 이용한 최대공약수 계산
  static int gdc(int a, int b) {
    // 유클리드 호제법은 a>b일 때만 성립하므로
    if(a < b) {
      int temp = a;
      a = b;
      b = temp;
    }
    while(b != 0) {
      int r = a%b;
      a = b;
      b = r;
    }

    return a;
  }
}
/*
M * ?? + x = N * ??? + y = 답
모르는 수가 많아서 안 되겠다.

x에 맞춰서 해당되는 y를 구해보기.
x는 고정하고, y만 변화

종말이 오는 연도를 알기 위해 N, M의 최소공배수 탐색 필요
*/