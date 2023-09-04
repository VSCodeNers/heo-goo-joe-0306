// 백준 - 잃어버린 괄호(1541)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Baekjoon_1541 {
  static ArrayList<Integer> number = new ArrayList<>();
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String op = br.readLine();

    int num1 = 0, num2 = 0;
    for(int i = 0; i < op.length(); i++) {
      // 더하기일 경우 - 계산
      if(op.charAt(i) == '+') {
        num1 += num2;
        num2 = 0;
        continue;
      }

      // 빼기일 경우 - 계산 안 함
      else if(op.charAt(i) == '-') {
        if(num1 != 0) {
          num2 += num1;
          num1 = 0;
        }
        number.add(num2);
        num2 = 0;
        continue;
      }

      num2 = num2 * 10 + ((int)op.charAt(i) - '0');
    }

    // 마지막 연산자가 더하기였을 경우
    if(num1 !=0)
      num2 += num1;

    number.add(num2);

    // 빼기 계산
    int answer = number.get(0);
    for(int i = 1; i < number.size(); i++) {
      answer -= number.get(i);
    }

    System.out.print(answer);
  }
}
