// 프로그래머스 - 과일 장수(Lv.1)
import java.util.Arrays;

class Solution {
  public int solution(int k, int m, int[] score) {
      int answer = 0;

      // 사과 점수 정렬 - 오름차순
      Arrays.sort(score);

      int start = score.length % m;
      for(int i = start; i < score.length; i += m) {
        answer += score[i] * m;
      }

      return answer;
  }
}
/*
12 2223 3334 4444
score.length = 14
score.length % m = 2
start = 2
2 6 10
*/