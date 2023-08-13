// 프로그래머스 - 피보나치 수(Lv.2)

class Solution {
  public int solution(int n) {
      int[] fibonacci = new int[100001];
      
      fibonacci[1] = 1;
      fibonacci[2] = 1;
      
      for(int i = 3; i <= n; i++) {
          fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1234567;
      }
      
      return fibonacci[n];
  }
}