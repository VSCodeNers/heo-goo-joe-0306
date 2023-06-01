// 프로그래머스 - 푸드 파이트 대회(Lv.1)
class Solution {
  public StringBuilder solution(int[] food) {
      StringBuilder answer = new StringBuilder();
      StringBuilder left = new StringBuilder();
      StringBuilder right = new StringBuilder();

      int len = food.length;
      for(int i = 1; i < len; i++) {
        for(int j = 0; j < food[i]/2; j++) {
          left.append(i);
        }
        for(int j = 0; j < food[len - i]/2; j++) {
          right.append(len - i);
        }
      }

      answer.append(left).append("0").append(right);

      return answer;
  }
}