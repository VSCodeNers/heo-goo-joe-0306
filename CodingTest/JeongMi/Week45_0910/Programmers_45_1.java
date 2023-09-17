// 프로그래머스 - [1차]캐시(Lv.2)
import java.util.LinkedList;

class Solution {
  public int solution(int cacheSize, String[] cities) {
    // 캐시 사이즈가 0일 때는 캐시에 아무것도 저장할 수 없으므로 모두 cache miss
    if(cacheSize == 0)
      return cities.length * 5;
    
    int answer = 0;
    LinkedList<String> cache = new LinkedList<>();
    for(int i = 0; i < cities.length; i++) {
      String city = cities[i].toUpperCase();
      // 해당 값을 삭제했을 때 true: 이전에 같은 값이 있었다는 뜻
      // false: 이전에 같은 값이 없었다는 뜻
      if(cache.remove(city)) {
        // cache hit이므로 실행시간 1
        answer++;
      }
      else {
        // cache miss이므로 실행시간 5
        answer += 5;
        // 이미 캐시가 가득찬 경우, 저장한지 오래된 걸 삭제
        if(cache.size() >= cacheSize) {
          cache.remove(0);
        }
      }
      // 현재 처리 중인 값을 캐시에 저장
      cache.add(city);
    }
    
    return answer;
  }
}

/*
캐시 개념 참고
https://m.blog.naver.com/tlstjd436/221824813403
*/