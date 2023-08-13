// 프로그래머스 - 점프와 순간 이동(Lv.2)
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        // 뒤에서부터 거슬러서 판단
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}