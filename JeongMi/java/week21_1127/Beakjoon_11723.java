// 백준 - 집합(11723)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Beakjoon_11723 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    HashSet<Integer> S = new HashSet<Integer>();
    StringBuilder printSet = new StringBuilder();
    HashSet<Integer> all = new HashSet<Integer>();

    for(int i = 1; i <= 20; i++) {
      all.add(i);
    }

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      String operater = st.nextToken();

      // S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
      if(operater.equals("add")) {
        int num = Integer.parseInt(st.nextToken());
        S.add(num);
      }

      // S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
      else if(operater.equals("remove")) {
        int num = Integer.parseInt(st.nextToken());
        S.remove(num);
      }

      // S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
      else if(operater.equals("check")) {
        int num = Integer.parseInt(st.nextToken());
        if(S.contains(num)) printSet.append(1).append("\n");
        else printSet.append(0).append("\n");
      }

      // S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
      else if(operater.equals("toggle")) {
        int num = Integer.parseInt(st.nextToken());
        if(S.contains(num)) S.remove(num);
        else S.add(num);
      }

      // S를 {1, 2, ..., 20} 으로 바꾼다.
      else if(operater.equals("all")) {
        S.addAll(all);
      }

      // S를 공집합으로 바꾼다. 
      else if(operater.equals("empty")) {
        S.clear();
      }
    }

    System.out.print(printSet);
  }
}
