// 프로그래머스 - [1차] 다트 게임 (Lv.1)

class Solution {
  public int solution(String dartResult) {
      int answer = 0;
      String[] score_set = new String[3];
      int[] score = new int[3];
      
      // 기회 단위로 끊어주기 - 숫자로 시작되는 건 다음 숫자가 나오기까지 하나의 점수
      int start = 0;
      int cnt = 0;
      for(int i = 1; i < dartResult.length(); i++) {
          // 숫자가 나오는 부분
          // 10인 경우 1, 0이 따로 나오기 때문에 이를 체크하기 위해 i - start > 1 확인
          if(dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9' && i - start > 1) {
              score_set[cnt] = dartResult.substring(start, i);
              start = i;
              cnt++;
          }
          if(cnt == 2) {
              score_set[cnt] = dartResult.substring(start, dartResult.length());
              break;
          }
      }
      
      // 각 세트별로 계산
      for(int i = 0; i < 3; i++) {
          int second = 1, third = 2;
          score[i] = score_set[i].charAt(0) - '0'; // 점수
          // 10인 경우
          if(score_set[i].charAt(1) == '0') {
              score[i] = 10;
              second++;
              third++;
          }
          
          // 제곱수는 무엇인지 -> 1제곱은 무의미하기 때문에 계산 안 함
          if(score_set[i].charAt(second) == 'D') // 2제곱
              score[i] = score[i] * score[i];
          else if(score_set[i].charAt(second) == 'T') // 3제곱
              score[i] = score[i] * score[i] * score[i];
          
          // 곱하기
          if(score_set[i].length() == 2
              || (score_set[i].charAt(1) == '0' && score_set[i].length() == 3))
              continue; // 옵션이 없는 경우
          if(score_set[i].charAt(third) == '*') { // 2배
              if(i != 0) score[i - 1] *= 2; // 바로 전의 점수를 2배로
              score[i] *= 2; // 해당 점수를 2배로
          }
          else if(score_set[i].charAt(third) == '#') { // -1배
              score[i] *= -1; // 해당 점수를 -1배로
          }
      }
      
      answer = score[0] + score[1] + score[2];
      
      return answer;
  }
}
// 숫자는 무조건 점수
// 알파벳은 제곱: S = 1, D = 2, T = 3
// 특수 기호는 배수: * = 2배, # = -1배
// 계산 순서: 제곱 -> 곱하기 -> 더하기