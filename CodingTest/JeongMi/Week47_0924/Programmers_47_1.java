// 프로그래머스 - [3차]N진수 게임(Lv.2)
class Solution {
  public String solution(int n, int t, int m, int p) {
    String answer = "";
    int num = 0;   // 현재 숫자 (10진수 기준))
    int order = 0; // 순서
    
    p--;
    
    // t개의 숫자를 구할 때까지
    while(answer.length() < t) {
      // 현재 숫자를 N진수로 변환
      String strNum = Integer.toString(num, n);
      
      for(int i = 0; i < strNum.length() && answer.length() < t; i++) {
        if(order == p) {
          answer += String.valueOf(strNum.charAt(i)).toUpperCase();
        }
        order = (order + 1) % m;
      }
      
      num++;
    }
      
      
    return answer;
  }
}