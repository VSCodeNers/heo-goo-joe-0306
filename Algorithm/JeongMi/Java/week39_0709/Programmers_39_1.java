// 프로그래머스 - JadenCase 문자열 만들기(Lv.2)
class Solution {
  public String solution(String s) {
      String answer = "";
      boolean upper = true;
      
      // 모두 소문자로 변환
      answer = s.toLowerCase();
      
      for(int i = 0; i < answer.length(); i++) {
          // 영어 또는 숫자
          if(answer.charAt(i) != ' ') { 
              // 영어이고, 첫글자 => 대문자로 변환
              if(answer.charAt(i) > 9 && upper) {
                  String frontStr = answer.substring(0, i);
                  String upperStr = answer.substring(i, i+1).toUpperCase();
                  String backStr = answer.substring(i+1);
                  answer = frontStr + upperStr + backStr;
              }
              upper = false;
          }
          // 공백
          else {
              upper = true;
          }
      }
      
      return answer;
  }
}