// 프로그래머스 - 숫자 짝꿍(Lv.1)
class Solution {
  public String solution(String X, String Y) {
      StringBuilder answer = new StringBuilder();
      int[] X_nums = new int[10]; // X의 0~9 갯수
      int[] Y_nums = new int[10]; // Y의 0~9 갯수
      int[] same_nums = new int[10]; // 공통으로 나타나는 0~9 갯수
      
      // X의 0~9 갯수 체크
      for(int i = 0; i < X.length(); i++) {
          X_nums[X.charAt(i) - '0']++;
      }
      
      // Y의 0~9 갯수 체크
      for(int i = 0; i < Y.length(); i++) {
          Y_nums[Y.charAt(i) - '0']++;
      }
      
      // 공통으로 나타나는 0~9 갯수 체크
      // 큰 수가 앞에 와야 최종 정답이 커지니까 9부터 시작
      for(int i = 9; i >= 0; i--) {
          // 나온 갯수만큼 뒤에 숫자 추가
          for(int j = 0; j < Math.min(X_nums[i], Y_nums[i]); j++) {
              answer.append(i); // 시간 단축
          }
      }
      
      String strAnswer = answer.toString();
      
      // 9~0까지 하나도 겹치는 게 없을 경우
      if(strAnswer.equals(""))
          strAnswer = "-1";
      // 9~1까지 하나도 겹치는 게 없고, 0은 겹칠 때
      else if(strAnswer.charAt(0) == '0')
          strAnswer = "0";

      return strAnswer;
  }
}