// 백준 - A와 B(12904)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon_12904 {
  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();

    while(S.length() < T.length()) {
      // T의 마지막 문자가 A면 -> 마지막 문자를 제거
      // T의 마지막 문자가 B면 -> 마지막 문자를 제거하고, 문자열 뒤집기

      // 마지막 문자
      char end = T.charAt(T.length() - 1);

      // 마지막 문자를 제거한다.
      T = T.substring(0, T.length() - 1);

      // 마지막 문자가 B이면 T를 뒤집는다
      if(end == 'B') {
        StringBuffer sb = new StringBuffer(T);
        T = sb.reverse().toString();
      }
    }

    int answer = 0;

    // S와 T가 같아진 경우
    if(S.equals(T)) answer = 1;

    System.out.println(answer);
  }
}
/* 
S -> T
1. 뒤에 A를 추가한다
2. 문자열을 뒤집고 뒤에 B를 추가한다

T -> S
1. 뒤에 있는 A를 제거한다
2. 뒤에 있는 B를 제거하고 문자열을 뒤집는다
*/