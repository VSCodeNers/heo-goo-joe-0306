// 백준 - A와 B(12904)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Baekjoon_12919 {
  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();

    int answer = 0;

    Queue<String> queue = new LinkedList<>();
    queue.add(T);

    while(!queue.isEmpty()) {
      String str = queue.poll();
      if(str.length() <= S.length()) break;

      // 문자열의 뒤의 A 제거
      if(str.charAt(str.length() - 1) == 'A') {
        // 마지막 문자를 제거한다.
        String s1 = str.substring(0, str.length() - 1);
        // S와 T가 같아진 경우
        if(s1.equals(S)){
          answer = 1;
          break;
        }
        queue.add(s1);
      }

      // 맨앞의 B 제거하고 문자열 뒤집기
      if(str.charAt(0) == 'B') {
        // 마지막 문자를 제거한다.
        String s2 = str.substring(1, str.length());

        StringBuffer sb = new StringBuffer(s2);
        s2 = sb.reverse().toString();
        
        // S와 T가 같아진 경우
        if(s2.equals(S)){
          answer = 1;
          break;
        }
        queue.add(s2);
      }
    }

    System.out.println(answer);
  }
}
