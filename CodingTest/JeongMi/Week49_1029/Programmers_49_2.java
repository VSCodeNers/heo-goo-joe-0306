// 프로그래머스 - 기능개발(Lv.2)
import java.util.ArrayList;

class Solution {
  public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
    ArrayList<Integer> answer = new ArrayList<Integer>();
    
    // 첫번째 작업이 완료되기까지 소요일
    int day = (int) Math.ceil((100 - progresses[0]) / (double) speeds[0]);
    int count = 1;
    for(int i = 1; i < progresses.length; i++) {
        
      // 앞선 작업과 같은 일수만큼 개발했을 때 완료되는 경우
      if(progresses[i] + (speeds[i] * day) >= 100) {
        count++;
      }
      // 앞선 작업보다 시간이 많이 소요되는 경우
      else {
        // 앞에 작업해둔 것들을 배포
        answer.add(count);
        // 현재 작업을 완료하기까지 소요일
        day = (int) Math.ceil((100.0 - progresses[i]) / (double) speeds[i]);
        count = 1;
      }
    }
    // 마지막 배포
    answer.add(count);
    
    return answer;
  }
}