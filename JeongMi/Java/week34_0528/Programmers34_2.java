// 명예의 전당 (1) (Lv.1)
import java.util.Arrays;

class Solution {
  public int[] solution(int k, int[] score) {
      int[] answer = new int[score.length];
      int[] rank = new int[k];

      for(int i = 0; i < score.length; i++) {
        // 명예의 전당 최하위값과 비교 -> 더 크면 명예의 전당에 포함
        if(score[i] > rank[0]) {
          rank[0] = score[i];
          Arrays.sort(rank); // 명예의 전당을 오름차순 정렬
        }

        // 명예의 전당 인원이 k명보다 작은 경우
        // 앞쪽의 0을 제외하고 가장 작은 점수
        if((i+1) < k) {
          answer[i] = rank[k - i - 1];
        }
        // 명예의 전당 인원이 k명 이상인 경우
        // rank 맨 앞에 있는 점수가 최하점
        else {
          answer[i] = rank[0];
        }
      }

      return answer;
  }
}