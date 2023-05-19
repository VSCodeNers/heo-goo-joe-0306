// 백준 - 단어 수학(1339)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Baekjoon_1339 {
  static int N;
  static String[] words;
  static int[] weights = new int[26];
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    words = new String[N];

    for(int i = 0; i < N; i++) {
      words[i] = bf.readLine();
    }

    // 각 알파벳에 가중치 주기
    // ABCD = 1000*A + 100*B + 10*C + 1*D
    // A = 1000, B = 100, C = 10, D = 1
    setWeight();

    // 오름차순 정렬
    Arrays.sort(weights);

    // 계산
    int answer = 0;
    int num = 9;
    for(int i = 25; weights[i] != 0; i--) {
      answer += weights[i] * num;
      num--;
    }
    
    System.out.print(answer);
  }
  // 각 알파벳에 가중치 주기
  static void setWeight() {
    for(int i = 0; i < N; i++) {
      int len = words[i].length();

      int weight = 1;
      for(int j = len - 1; j >= 0; j--) {
        weights[words[i].charAt(j) - 'A'] += weight;
        weight *= 10;
      }
    }
  }

}
