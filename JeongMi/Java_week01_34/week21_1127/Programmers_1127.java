import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public Integer[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        
        int len = numbers.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i+1; j < len; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // set을 Integer 배열로 변환
        Integer[] answer = set.toArray(new Integer[0]);
        
        // 오름차순 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}