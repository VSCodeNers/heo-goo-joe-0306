// 프로그래머스 - [3차]파일명 정렬(Lv.2)
import java.util.Arrays;

class Solution {
  public String[] solution(String[] files) {
    Arrays.sort(files, (f1, f2) -> {
      // HEAD가 같지 않을 경우, HEAD 기준으로 사전순 = 오름차순 정렬
      // HEAD는 숫자가 등장하는 지점 앞까지
      String head1 = f1.split("[0-9]")[0].toUpperCase();
      String head2 = f2.split("[0-9]")[0].toUpperCase();
      int compareHead = head1.compareTo(head2);

      // HEAD가 같고, NUMBER가 다를 경우, NUMBER 기준으로 오름차순 정렬
      int num1 = getNumber(f1.substring(head1.length()));
      int num2 = getNumber(f2.substring(head2.length()));

      return compareHead == 0 ? num1 - num2 : compareHead;
    });

    return files;
  }
  // NUMBER 구간 컷 - HEAD 뒷부분을 받아서 NUMBER 값 반환
  static int getNumber(String file) {
    // 숫자는 다섯글자 미만
    String num = "";
    for(char c : file.toCharArray()){
      if(Character.isDigit(c) && num.length() < 5){
        num += c;
      } else break;
    }
    return Integer.parseInt(num);
  }
}