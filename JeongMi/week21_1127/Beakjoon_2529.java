// 백준 - 부등호(2529)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Beakjoon_2529 {
  static int N;
  static String[] signs;
  static int[] num;
  static int[] arr;
  static boolean[] select;
  static Long min, max;
  static boolean startZero = false;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    StringTokenizer st = new StringTokenizer(bf.readLine());

    min = 9L;
    max = 0L;

    select = new boolean[10];
    arr = new int[N+1];
    signs = new String[N];
    num = new int[10];
    for(int i = 0; i < N; i++) {
      signs[i] = st.nextToken();
      min = min * 10 + 9;
    }
    for(int i = 0; i <= 9; i++) {
      num[i] = i;
    }

    makeSignList(0);

    StringBuilder printSet = new StringBuilder();
    printSet.append(max).append("\n");
    if(startZero) {
      printSet.append("0").append(min);
    }
    else {
      printSet.append(min);
    }
    System.out.print(printSet);
  }

  static void makeSignList(int cnt) {
    if(cnt == (N+1)) {
      Long correctNum = 0L;
      for(int i = 0; i < (N+1); i++) {
        correctNum = correctNum * 10 + arr[i];
      }

      if(correctNum < min) {
        min = correctNum;
        if(arr[0] == 0) startZero = true;
        else startZero = false;
      }
      if(correctNum > max) max = correctNum;

      return;
    }

    if(cnt == 0) {
      for(int i = 0; i <= 9; i++) {
        if(!select[i]) {
          arr[cnt] = num[i];
          select[i] = true;
          makeSignList(cnt + 1);
          select[i] = false;
        }
      }
    }
    else {
      for(int i = 0; i <= 9; i++) {
        if(!select[i] && check(i, cnt - 1)) {
          arr[cnt] = num[i];
          select[i] = true;
          makeSignList(cnt + 1);
          select[i] = false;
        }
      }
    }
  }

  static boolean check(int numIndex, int signIndex) {
    if(signs[signIndex].equals(">")) {
      if(arr[signIndex] > num[numIndex]) return true;
      else return false;
    }
    else {
      if(arr[signIndex] < num[numIndex]) return true;
      else return false;
    }
  }
}
