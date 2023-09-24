// 프로그래머스 - 전화번호 목록(Lv.2)
import java.util.Arrays;

class Solution {
  public boolean solution(String[] phone_book) {
    // 번호를 오름차순으로 정렬
    Arrays.sort(phone_book, (p1, p2) -> {
      return p1.compareTo(p2);
    });
    
    for(int i = 0; i < phone_book.length - 1; i++) {
      int len = phone_book[i].length();
      
      // 뒤에 오는 수가 길이가 더 짧은 경우 = 무조건 다름
      if(len > phone_book[i + 1].length())
        continue;
      
      String phone = phone_book[i + 1].substring(0, len);
      // 어떤 번호가 다른 번호의 접두어인 경우
      if(phone.equals(phone_book[i]))
        return false;
    }
    
    return true;
  }
}