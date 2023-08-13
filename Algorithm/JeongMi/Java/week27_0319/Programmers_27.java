import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // 참가자 명단에 있는 인원을 +1
        for (String player : participant)
            // getOrDefault인 이유
            // 동명이인이 등장하면 get, 아니면 Default
            hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        
        // 완주자 명단에 있는 인원을 -1
        for (String player : completion) 
            hashMap.put(player, hashMap.get(player) - 1);
        
        Iterator<Map.Entry<String, Integer>> iter = hashMap.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            // 남은 수가 1, 또는 -1인 경우 => 완주하지 못한 선수
            // 1: 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명 (동명이인)
            // -1: 참여자 명단에는 있지만, 완주자 명단에는 없음.
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}