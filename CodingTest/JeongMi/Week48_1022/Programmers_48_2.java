// 프로그래머스 - 다리를 지나는 트럭(Lv.2)
import java.util.Queue;
import java.util.LinkedList;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> queue = new LinkedList<>();
    int sumWeight = 0;
    int time = 0;
    
    for(int i = 0; i < truck_weights.length; i++) {
      // 건너야 하는 트럭의 무게
      int nextTruck = truck_weights[i];
      
      while(true) {
        // 다리 길이만큼 트럭이 다 찬 경우 = 새로운 트럭이 오를 수 없음
        // 가장 앞에 있는 트럭이 다리를 건너도록 함
        if(queue.size() == bridge_length) {
          sumWeight -= queue.poll();
        }
        
        // 새로운 트럭이 다리에 오를 수 있는 경우
        // = 새로운 트럭이 올랐을 때 다리의 트럭 무게가 weight를 넘지 않는 경우
        if(sumWeight + nextTruck <= weight) {
          queue.add(nextTruck);
          sumWeight += nextTruck;
          time++;
          break;
        }
        // 새로운 트럭이 다리에 오를 수 없음
        // 앞에 있는 트럭들이 전진하도록 보냄
        else {
          queue.add(0);
          time++;
        }
      }
    }
      
    // 마지막에 다리에 오른 트럭까지 다리 길이만큼 지나가야 하므로 + bridge_length
    return time + bridge_length;
  }
}