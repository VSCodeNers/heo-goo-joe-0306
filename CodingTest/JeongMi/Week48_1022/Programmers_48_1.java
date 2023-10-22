// 프로그래머스 - 의상(Lv.2)
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int solution(String[][] clothes) {
    int answer = 1;
    
    // 옷 종류별로 개수 세기
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < clothes.length; i++) {
      Integer count = map.get(clothes[i][1]);
      if (count == null) {
        map.put(clothes[i][1], 1);
      } else {
        map.put(clothes[i][1], count + 1);
      }
    }
    
    // 경우의 수
    // 예: 상의 2개, 하의 1개
    // 상의 2개 중 하나를 입을 경우의 수: 2, 상의를 입지 않을 경우의 수: 1 => 총 3가지
    // 하의 1개 중 하나를 입을 경우의 수: 1, 하의를 입지 않을 경우의 수: 1 => 총 2가지
    // 3*2 = 6 (아무것도 입지 않을 경우의 수 1을 아래에서 마지막으로 빼줌)
    
    // 옷 종류마다 (개수 + 안 입을 경우 1)을 구해서 곱한다
    for(String key : map.keySet()) {
      answer *= map.get(key) + 1;
    }
    // 아무것도 안 입을 경우를 뺀다
    answer--;
    
    return answer;
  }
}
