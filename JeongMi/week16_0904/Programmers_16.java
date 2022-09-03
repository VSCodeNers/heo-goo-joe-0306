import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer, save;
        int cnt = 0;
        
        save = new int[arr.length];
        save[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(save[cnt] != arr[i]) {
                cnt++;
                save[cnt] = arr[i];
            }
        }
        
        answer = new int[cnt+1];
        for(int i = 0; i <= cnt; i++) {
            answer[i] = save[i];
        }

        return answer;
    }
}