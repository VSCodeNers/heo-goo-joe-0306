// 프로그래머스 - N-Queen(Lv.2)
class Solution {
  static int[] queen;
  static int answer = 0;
  public int solution(int n) {
      queen = new int[n];
      
      tracking(n, 0);
      
      return answer;
  }
  // 탐색
  static void tracking(int n, int index) {
      if(n == index) {
          answer++;
          return;
      }
      
      for(int i = 0; i < n; i++) {
          queen[index] = i;
          if(check(index)) {
              tracking(n, index + 1);
          }
      }
      
  }
  
  // 이미 놓여진 퀸을 공격 가능한지 확인
  static boolean check(int index) {
      for(int i = 0; i < index; i++) {
          // 같은 가로선에 있는 경우
          if(queen[i] == queen[index])
              return false;
          
          // 같은 대각선상에 있는 경우
          if(Math.abs(index - i) == Math.abs(queen[index] - queen[i]))
              return false;
      }
      
      // 공격 불가능
      return true;
  }
}