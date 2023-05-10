// 프로그래머스 : 햄버거 만들기(Lv.1) - 시간 초과
import java.util.Arrays;

class Solution {
  public int solution(String[] babbling) {
    return 0;
  }

  // 첫 번째 방법 -- 시간 초과
  public int Solution1() {
    // 빵 - 야채 - 고기 - 빵: 1231
    int answer = 0;
    
    // 재료를 12313221 이런 식으로 숫자가 다 붙은 String으로 변경
    String ingredientStr = Arrays.toString(ingredient);
    ingredientStr = ingredientStr.replaceAll("[^0-9]", "");
    
    // 햄버거 조합이 있는 동안 반복
    while(ingredientStr.contains("1231")) {
        answer++;
        ingredientStr = ingredientStr.replaceFirst("1231", "");
    }
    
    return answer;
  }
  
  // 2번째 방법 - StringBuilder 사용 -- 시간 초과
  // Replace 사용을 없앰
  public int Solution2() {
    // 빵 - 야채 - 고기 - 빵: 1231
    int answer = 0;
    StringBuilder stringBuilder = new StringBuilder();
    
    // 재료를 12313221 이런 식으로 숫자가 다 붙은 String으로 변경
  
    for(int ingre : ingredient) { stringBuilder.append(ingre); }
    String ingredientStr = stringBuilder.toString();
    
    // 햄버거 조합이 있는 동안 반복
    while(ingredientStr.contains("1231")) {
        answer++;
        int index = ingredientStr.indexOf("1231");
        ingredientStr = ingredientStr.substring(0, index) + ingredientStr.substring(index + 4);
    }
    
    return answer;
  }
}