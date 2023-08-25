// 프로그래머스 - 영어 끝말잇기(Lv.2)
import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] solution(int n, String[] words) {
    int player = 0, fail = 0;
    
    List<String> pastWords = new ArrayList<String>();
    pastWords.add(words[0]);
    
    for(int i = 1; i < words.length; i++) {
      // 이전 단어에서 끝말잇기가 안 되는 경우
      if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length() - 1)) {
        player = i % n + 1;
        fail = i / n + 1;
        break;
      }
      
      // 단어가 겹치는 경우
      if(pastWords.contains(words[i])) {
        player = i % n + 1;
        fail = i / n + 1;
        break;
      }
      
      // 끝말잇기 성공
      pastWords.add(words[i]);
    }
    
    int[] answer = {player, fail};
    return answer;
  }
}