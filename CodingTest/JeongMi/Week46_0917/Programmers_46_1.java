// 프로그래머스 - [3차]압축(Lv.2)
import java.util.ArrayList;

class Solution {
  public ArrayList<Integer>solution(String msg) {
    ArrayList<String> dictionary = new ArrayList<String>();
    ArrayList<Integer> answer = new ArrayList<Integer>();
    
    // A-Z를 사전에 추가
    for(int i = 0; i < 26; i++) {
      dictionary.add(String.valueOf((char)('A' + i)));
    }
    
    // 메시지 첫 인덱스부터 돌면서 압축...
    for(int i = 0; i < msg.length(); i++) {
      // 사전의 마지막 인덱스부터 해당하는 단어가 있는지 확인
      // 마지막부터 찾는 이유: 뒤쪽으로 갈수록 사전의 단어 길이가 길 확률 높음
      for(int j = dictionary.size() - 1; j >= 0; j--) {
        // 메시지를 i번째부터 자른 값이 사전의 j번째 단어로 시작하는지 확인
        if(msg.substring(i).startsWith(dictionary.get(j))) {
          // 맞다면 사전에 있는 것이므로 해당 색인 번호를 출력
          i += dictionary.get(j).length() - 1;
          answer.add(j + 1);
          // 처리되지 않은 다음글자가 남아있는 경우
          if(i+1 < msg.length()) {
            // 다음 글자를 포함한 단어를 사전에 추가
            dictionary.add(dictionary.get(j) + msg.charAt(i+1));
          }
          // 해당 인덱스에서의 작업을 종료하고 메시지의 다음 인덱스에서 동일한 과정 반복하기
          break;
        }
      }
    }
    
    return answer;
  }
}