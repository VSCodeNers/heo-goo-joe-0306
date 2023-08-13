// 백준 - 연산자 끼워넣기 (2)(15658)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_15658 {
  static int N;
  static int[] nums;
  static int[] operators = new int[4];
  static int max = -1000000000, min = 1000000000;
  static public void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());

    // 숫자 입력
    nums = new int[N];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for(int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    // 연산자 갯수 입력
    st = new StringTokenizer(bf.readLine());
    for(int i = 0; i < 4; i++) {
      operators[i] = Integer.parseInt(st.nextToken());
    }

    // 계산
    calculate(nums[0], 1, 0, 0, 0, 0);

    StringBuilder printSet = new StringBuilder();
    printSet.append(max);
    printSet.append("\n");
    printSet.append(min);

    System.out.print(printSet);
  }

  static void calculate(int result, int index, int add, int sub, int mul, int div) {
    // 수식 완성
    if(index == N) {
      // 현재 최댓값인 경우
      if(result > max) max = result;
      // 현재 최솟값인 경우
      if(result < min) min = result;

      return;
    }

    // 더하기
    if(add < operators[0])
      calculate(result + nums[index], index + 1, add + 1, sub, mul, div);

    // 빼기
    if(sub < operators[1])
      calculate(result - nums[index], index + 1, add, sub + 1, mul, div);

    // 곱하기
    if(mul < operators[2])
      calculate(result * nums[index], index + 1, add, sub, mul + 1, div);

    // 나누기
    if(div < operators[3])
      calculate(result / nums[index], index + 1, add, sub, mul, div + 1);
  }
}
