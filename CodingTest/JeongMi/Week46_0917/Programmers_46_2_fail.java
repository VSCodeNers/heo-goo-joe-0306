// 프로그래머스 - [3차]파일명 정렬(Lv.2) - 런타임 에러
import java.util.Arrays;

class Solution {
  public String[] solution(String[] files) {
    String[][] cutFiles = new String[files.length][3];
    
    // 파일명을 HEAD, NUMBER, TAIL로 자르기
    for(int i = 0; i < files.length; i++) {
        cutFiles[i][0] = files[i];
        // HEAD 범위 탐색
        int numStart = 0;
        for(int j = 0; j < files[i].length(); j++) {
          // 숫자 등장
          if(files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
            // 숫자 시작 index
            numStart = j;
            break;
          }
        }
        // HEAD 자르기 + 정렬을 위해 모두 대문자로
        cutFiles[i][1] = files[i].substring(0, numStart).toUpperCase();
        
        // NUMBER 범위 탐색
        int tailStart = numStart;
        for(int j = numStart; j < files[i].length(); j++) {
          // 숫자 종료
          if(files[i].charAt(j) < '0' || files[i].charAt(j) > '9') {
            // tail 시작 index
            tailStart = j;
            break;
          }
        }
        // NUMBER 자르기
        cutFiles[i][2] = files[i].substring(numStart, tailStart);
    }
    
    // 정렬
    Arrays.sort(cutFiles, (o1, o2) -> {
      // HEAD가 같지 않을 경우, HEAD 기준으로 사전순 = 오름차순 정렬
      if(!o1[1].equals(o2[1])) {
        return o1[1].toString().compareTo(o2[1].toString());
      }
      // HEAD가 같고, NUMBER가 다를 경우 -> 비교를 위해 int형으로 변환
      int num1 = Integer.parseInt(o1[2]);
      int num2 = Integer.parseInt(o2[2]);
      if(num1 != num2) {
        return num1 - num2;
      }
      // HEAD, NUMBER가 모두 같을 경우
      return 0;
    });
    
    String[] answer = new String[files.length];
    for(int i = 0; i < files.length; i++) {
      answer[i] = cutFiles[i][0];
    }
    
    return answer;
  }
}