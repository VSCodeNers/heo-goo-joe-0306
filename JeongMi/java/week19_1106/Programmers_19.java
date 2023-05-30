// 프로그래머스: 내적(Lv.1)

class Solution {
  public int solution(int[] a, int[] b) {
      int answer = 0;
      
      for(int i = 0; i < a.length; i++) {
          answer += a[i]*b[i];
      }
      return answer;
  }
}