// 기사단원의 무기(Lv.1)
class Solution {
  public int solution(int number, int limit, int power) {
      int answer = 0;

      for(int i = 1; i <= number; i++){
        int p = 0;
        for(int j = 1; j * j <= i; j++) {
          if(j * j == i) p++;
          else if(i % j == 0) p += 2;
        }

        if(p > limit) p = power;
        answer += p;
      }

      return answer;
  }
}