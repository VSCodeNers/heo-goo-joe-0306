// 프로그래머스 : 옹알이(2) (Lv.1)
class Solution {
  public int solution(String[] babbling) {
      String[] ableWords = { "aya", "ye", "woo", "ma" }; // 가능한 발음
      int answer = 0;
      
      for(int i = 0; i < babbling.length; i++) {
          // 연속으로 같은 발음이 나오는 경우 => 발음 불가능하므로 패스
          Boolean isRepeat = false;
          for(int j = 0; j < 4; j++) {
              Boolean check = babbling[i].contains(ableWords[j] + ableWords[j]);
              if(check) {
                  isRepeat = true;
                  break;
              }
          }
          if(isRepeat) continue;
          
          // 발음할 수 있는 문자를 제거
          for(int j = 0; j < 4; j++) {
              // ""으로 바꿔버리면 제거하고 남은 앞 뒤 문자가 합쳐져서 새롭게 가능한 문자가 될 수 있음
              // " "으로 바꾸고 마지막에 처리
              // ex. mayaa에서 aya를 제거하면 ma만 남고,
              // ma도 가능한 발음이기 때문에 mayaa가 가능하게 됨
              babbling[i] = babbling[i].replaceAll(ableWords[j], " ");
          }
          // 위에서 공백으로 바꿨던 것도 지우기
          babbling[i] = babbling[i].replaceAll(" ", "");
          
          // 남은 문자가 없을 경우 발음 가능
          if(babbling[i].length() == 0) answer++;
      }
      
      return answer;
  }
}