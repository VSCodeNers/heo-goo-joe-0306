// 백준 - 병든 나이트(1783)
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

    int count = 0;

    // 세로 반경의 이동 가능 횟수가 0
    if(N == 1) {
      count = 1;
    }
    // 세로 반경의 이동 가능 횟수가 2번 이하
    else if(N == 2) {
      // 세로만 따지만 3번 이동이 최대 = 4칸 방문
      // 가로 반경에서 더 작게 나올 수 있음 = (M+1) / 2)칸 방문
      count = Math.min(4, (M + 1) / 2);
    }
    // 세로 반경의 이동 가능 횟수가 4번 이상
    else if(N >= 3) {
      // 가로 반경의 이동 가능 횟수가 4번 미만
      if(M < 7) {
        count = Math.min(4, M);
      }
      // 가로 반경의 이동 가능 횟수가 4번 이상
      else {
        count = M - 2;
      }
    }

    System.out.print(count);
  }
}
