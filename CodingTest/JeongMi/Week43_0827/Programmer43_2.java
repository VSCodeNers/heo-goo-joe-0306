// 프로그래머스 - 예상 대진표(Lv.2)
class Solution
{
  public int solution(int n, int a, int b) {
    int answer = 0;
    
    for(int i = 2; i <= n; i *= 2) {
      answer++;
      int check = 0;
      for(int j = 0; j < n/i; j++) {
        int left = i * j;
        int right = left + i;
        if(left < a && a <= right && left < b && b <= right) {
          check = 1;
          break;
        }
      }
      
      if(check == 1) break;
    }

    return answer;
  }
}