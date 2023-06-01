// 프로그래머스: K번째수(Lv.1)
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            // 배열 자르기
            int[] copyArray
                = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            
            // 배열 정렬
            Arrays.sort(copyArray);
            
            answer[i] = copyArray[commands[i][2] - 1];
        }
        
        return answer;
    }
}