// 프로그래머스: 3진법 뒤집기(Lv.1)
class Solution {
  public long solution(int n) {
      long answer = 0L;
      long inverseTrinaryDigit = 0L; //앞뒤 반전 3진법
      long three = 1L;
      
      while(three <= n) {
          three *= 3;
      }
      
      three /= 3;
      long ten = 1L;
      
      // 앞뒤 반전 3진법 계산
      while(three > 0) {
          if(three*2 <= n) {
              n -= three*2;
              inverseTrinaryDigit += ten*2;
          }
          
          else if(three <= n) {
              n -= three;
              inverseTrinaryDigit += ten*1;
          }
          
          three /= 3;
          ten *= 10;
      }
      
      three = 1L;
      
      // 10진법으로 계산
      while(inverseTrinaryDigit > 0) {
          answer += (inverseTrinaryDigit % 10) * three;
          three *= 3;
          inverseTrinaryDigit /= 10;
      }
      
      return answer;
  }
}