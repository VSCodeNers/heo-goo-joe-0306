// 백준 - 데스나이트(16948)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Baekjoon_16948 {
  static int startR, startC, finishR, finishC;
  static int N;
  static int min = -1;
  static int[][] moveKey = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1},};
  static public void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());

    StringTokenizer st = new StringTokenizer(bf.readLine());
    startR = Integer.parseInt(st.nextToken());
    startC = Integer.parseInt(st.nextToken());
    finishR = Integer.parseInt(st.nextToken());
    finishC = Integer.parseInt(st.nextToken());

    checkMin(0, startR, startC);

    System.out.print(min);
  }
  static void checkMin(int move, int preR, int preC) {
    if(min != -1 && min < move) return;
    if(preR == finishR && preC == finishC) {
      if(min == -1) min = move;
      else Math.min(min, move);

      return;
    }

    for(int i = 0; i < moveKey.length; i++) {
      if(preR + moveKey[i][0] >= 0 && preR + moveKey[i][0] < N
        && preC + moveKey[i][1] >= 0 && preC + moveKey[i][1] < N) {
          checkMin(move + 1, preR + moveKey[i][0], preC + moveKey[i][1]);
      }
    }
  }
}
