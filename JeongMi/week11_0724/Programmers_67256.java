// 프로그래머스 - 키패드 누르기(Lv.1)
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 키패드 위치 표시 - C: 가운데 / L: 왼쪽 / R: 오른쪽
        String[] keyLocation = {"C", "L", "C", "R", "L", "C", "R", "L", "C", "R", "L", "C", "R"};
        int left = 10, right = 12; // 왼손 오른손 현재 위치 표시 - 10: * / 12: #
        
        for(int i = 0; i < numbers.length; i++) {
            if(!keyLocation[numbers[i]].equals("C")) { // 누를 번호가 가운데가 아닌 경우
                answer += keyLocation[numbers[i]];
                
                // 누른 후 손 위치 변경
                if(keyLocation[numbers[i]].equals("L")) left = numbers[i];
                if(keyLocation[numbers[i]].equals("R")) right = numbers[i];
            }
            else { // 가운데인 경우 거리 계산
                int leftDistance, rightDistance;
                if(numbers[i] == 0) numbers[i] = 11; // 거리 계산을 위해
                
                // 왼쪽 손 이동 거리 계산
                // 수직 이동 - 높이 차이만큼 이동
                leftDistance = Math.abs((left / 3) - (numbers[i] / 3));
                // 수평 이동 - 왼쪽 손이 왼쪽에 있는 경우 가운데로 이동해야 하므로 1 추가
                if(keyLocation[left].equals("L")) leftDistance++;
                
                // 오른쪽 손 이동 거리 계산
                // 수직 이동 - 높이 차이만큼 이동
                rightDistance = Math.abs((right / 3) - (numbers[i] / 3));
                // 수평 이동 - 오른쪽 손이 오른쪽에 있는 경우 가운데로 이동해야 하므로 1 추가
                // 오른쪽 수들은 3으로 나눴을 때 1 큰 수가 나오므로 수직 계산할 때 -1
                if(keyLocation[right].equals("R"))
                    rightDistance = Math.abs((right / 3) - 1 - (numbers[i] / 3)) + 1;
                
                // 거리 비교
                if(leftDistance < rightDistance) {
                    answer += "L";
                    left = numbers[i];
                }
                else if(leftDistance == rightDistance) {
                    if(hand.equals("left")) {
                        answer += "L";
                        left = numbers[i];
                    }
                    else {
                        answer += "R";
                        right = numbers[i];
                    }
                }
                else {
                    answer += "R";
                    right = numbers[i];
                }
            }
        }
        
        return answer;
    }
}