import java.util.*;

public class Yoon_pro52 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int weightSum = 0;
        int timeSum = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                // 1. 큐가 비어있는 경우 => 다리 위에 차가 없다는 의미
                // 첫 번째 트럭부터 다리(큐)에 올라가고, 현재 다리가 버티고 있는 무게(weightSum) + 경과 시간(timeSum) 추가함
                if (queue.isEmpty()) {
                    queue.add(truck);
                    weightSum += truck;
                    timeSum++;
                    break;
                }
                // 2. 큐 크기와 bridge_length가 동일한 경우 => 다리에 올라갈 수 있는 트럭 수 딱 맞음..?
                // 이제 다리 꽉 차서 트럭 못 올라간다 ~~
                // 다리 맨 앞에 있는 트럭을 뺌
                if (queue.size() == bridge_length) {
                    weightSum -= queue.remove();
                }
                // 3. 현재 올라간 트럭 + 기존에 다리 위에 있는 트럭 무게 합보다 다리가 더 버틸 수 있는 경우
                // 다리 위에 트럭 한 대 더 올려줌
                if (weight >= truck + weightSum) {
                    queue.add(truck);
                    weightSum += truck;
                    timeSum++;
                    break;
                }
                // 4. 다 해당 안되면.. 다리가 견딜 수 있는 무게를 초과한다.. 이런거니까..
                // 0을 넣어서 그.. 앞에 있는 트럭이 움직이게 해줌
                else {
                    queue.add(0);
                    timeSum++;
                }
            }
        }
        // 다리에 올라간 트럭이 다리 건너는 시간은 계산이 안된거니까.. 다리 길이 더해줘야 된다고 함.
        timeSum += bridge_length;
        
        return timeSum;
    }
}
