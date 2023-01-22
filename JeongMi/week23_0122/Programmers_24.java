import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] fail = new int[N];            // 클리어한 사용자 수
        int[] challenge = new int[N];       // 도전한 사용자 수
        ArrayList<Double[]> failRate = new ArrayList<>(); // 실패율
        
        for(int i = 0; i < stages.length; i++) {
            for(int j = 0; j < N; j++) {
                if(stages[i] >= j+1) { // 도전한 사용자 수
                    challenge[j]++;
                }
                if(stages[i] == j+1) {  // 실패 사용자 수
                    fail[j]++;
                }
            }
        }
        
        // 실패율에 인덱스와 값 할당
        for (int i = 0; i < N; i++)
        {
            // 도전자, 실패자가 아무도 없을 경우 0을 나누게 되므로 NaN 처리 필요
            double rate
                = Double.isNaN((double) fail[i] / challenge[i]) ?
                0 : (double) fail[i] / challenge[i];
            
            failRate.add(new Double[] { (double) i + 1, rate });
        }
        
        // 정렬
        failRate.sort((o1, o2) -> Double.compare(o2[1], o1[1]));
        
        return failRate.stream().mapToInt(value -> value[0].intValue()).toArray();
    }
}