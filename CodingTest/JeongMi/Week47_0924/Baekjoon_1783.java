// 백준 - 병든 나이트(1738)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_1783 {
  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int count;

    // 세로 반경의 이동 가능 횟수가 0
    if(N == 1) {
      count = 1;
    }
    // 세로 반경의 이동 가능 횟수가 2번 이하
    // 가로 반경의 이동 가능 횟수가 2번 이하
    if(M < 4 || N < 3) {
      count = Math.min(N, M);
    }
    // 가로 반경의 이동 가능 횟수가 4번 미만
    else if(M < 10) {
      count = 4;
    }
    // 가로 반경의 이동 가능 횟수가 4번 이상
    else {
      count = M - 2;
    }

    System.out.print(count);
  }
}
