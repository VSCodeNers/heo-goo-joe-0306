// 프로그래머스 - 콜라 문제(LV.1)
class Solution {
  public int solution(int a, int b, int n) {
      // a개의 빈병을 주면, 콜라 b병을 줌
      // 빈 병 n개를 가져다주면 몇 병을 받을 수 있는가?
      int answer = countCola(a, b, n, 0);
      
      return answer;
  }
  static public int countCola(int a, int b, int n, int cnt) {
      // 보유 중인 빈 병이 a개 미만이면 계산 끝내기
      if(a > n) return cnt;
      
      // a개를 한 세트라고 했을 때 몇 세트 줄 수 있는지
      int share = n / a;
      cnt += share * b;
      // 교환하고 남은 빈 병
      n %= a;
      // 새롭게 받은 콜라를 다 마시고 얻은 빈 병을 더해주기
      n += share * b;
      
      // 남은 빈 병으로 다시 교환
      int total = countCola(a, b, n, cnt);
      
      return total;
  }
}