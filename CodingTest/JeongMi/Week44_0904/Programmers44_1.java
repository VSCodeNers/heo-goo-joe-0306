// 프로그래머스 - 뉴스 클러스터링(Lv.2)
import java.util.HashMap;

class Solution {
  public int solution(String str1, String str2) {
    str1 = str1.toUpperCase();
    str2 = str2.toUpperCase();
    
    // 합집합, 교집합
    double union = 0, inter = 0;
    
    // key: 2개씩 끊은 문자, value: 문자의 갯수
    HashMap<String, Integer> str1Map = new HashMap<>();
    HashMap<String, Integer> str2Map = new HashMap<>();
    
    // str1 문자 2개씩 끊기
    for(int i = 0; i < str1.length() - 1; i++) {
      // 문자 2개씩 자르고 알파벳이 아니면 지우기
      String s = str1.substring(i, i+2).replaceAll("[^A-Z]", "");
      
      // 특수문자 포함 = 문자의 길이가 2보다 작음
      // 특수문자가 없는 경우, 해당 문자를 map에 넣기. 이미 있을 경우 갯수 1 증가
      if(s.length() == 2)
        str1Map.put(s, str1Map.getOrDefault(s, 0) + 1);
    }
    
    // str2 문자 2개씩 끊기
    for(int i = 0; i < str2.length() - 1; i++) {
      // 문자 2개씩 자르고 알파벳이 아니면 지우기
      String s = str2.substring(i, i+2).replaceAll("[^A-Z]", "");
      
      // 특수문자 포함 = 문자의 길이가 2보다 작음
      // 특수문자가 없는 경우, 해당 문자를 map에 넣기. 이미 있을 경우 갯수 1 증가
      if(s.length() == 2)
        str2Map.put(s, str2Map.getOrDefault(s, 0) + 1);
    }
    
    // 만약 둘다 map이 비어있을 경우
    if(str1Map.size() == 0 && str2Map.size() == 0)
      return 65536;
    
    for(String key: str1Map.keySet()) {
      if(str2Map.containsKey(key)) {
        inter += Math.min(str1Map.get(key), str2Map.get(key));
        union += Math.max(str1Map.get(key), str2Map.get(key));
        str2Map.remove(key);
      }
      else {
        union += str1Map.get(key);
      }
    }
    for(String key: str2Map.keySet()) {
      union += str2Map.get(key);
    }
    
    return (int) Math.floor((inter / union) * 65536);
  }
}