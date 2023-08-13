public class Yoon_pro28 {
    public int[] solution(int k, int[] score) {
        int answer[] = new int[score.length];
        List<Integer> top = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (top.size() < k) {
                top.add(score[i]);
                Collections.sort(top);
            }
            
            else if (top.size() == k) {
                // 명예의 전당 최하위 점수보다 score[i] 점수가 더 큰 경우
                if (top.get(0) < score[i]) {
                    top.set(0, score[i]);
                    Collections.sort(top);
                }
            }
            answer[i] = top.get(0);
        }
        
        return answer;
    }
}
