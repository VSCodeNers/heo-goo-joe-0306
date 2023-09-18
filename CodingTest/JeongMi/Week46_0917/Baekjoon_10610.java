// 백준 - 30(10610)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Baekjoon_10610 {
  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String N = br.readLine();

    // 각 자리수를 더한 합이 3의 배수인지 확인하기 위해 = 3의 배수가 가능한지
    int sum = 0;
    // 0이 있는지 확인 = 10의 배수가 가능한지
    boolean isTen = false;

    // 가능한 숫자
    int[] nums = new int[N.length()];

    for(int i = 0; i < N.length(); i++) {
      nums[i] = N.charAt(i) - '0';
      // 0이 존재 = 10의 배수 가능
      if(nums[i] == 0) isTen = true;

      // 각 자리수의 합을 구하기
      sum += nums[i];
    }

    if(sum % 3 == 0 && isTen) {
      // 숫자를 오름차순 정렬
      Arrays.sort(nums);

      // 큰 수부터 내림차순으로... 그럼 가장 큰 수가 됨
      StringBuilder printSet = new StringBuilder();
      for(int i = N.length() - 1; i >= 0; i--) {
        printSet.append(nums[i]);
      }

      System.out.print(printSet);
    }
    else {
      System.out.print(-1);
    }
  }
}

/*
30의 배수가 되려면
10, 3의 배수여야 함
10의 배수: 마지막 자리가 0 -> 0이 있는지 확인
3의 배수: 각 자리수를 더한 합이 3의 배수
*/