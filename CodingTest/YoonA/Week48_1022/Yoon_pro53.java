public class Yoon_pro53 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            // 이미 있는 옷이면 해당 옷 종류 개수 + 1
            // 없으면 옷 종류 개수 1로 줌
            if (hash.containsKey(type)) {
                hash.put(type, hash.get(type) + 1);
            } else {
                hash.put(type, 1);
            }
        }
        // 각 종류 별 개수 + 1을 다 곱해서 answer에 저장
        // 선택하지 않는 경우도 0이라 가정해서 개수 + 1을 해줘야 한다고 함
        for (String key : hash.keySet()) {
            answer *= (hash.get(key) + 1);
        }
        // 모든 category가 0인 경우 제외
        return answer - 1;
    }
}
