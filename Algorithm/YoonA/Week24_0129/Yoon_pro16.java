import java.util.Arrays;

class Solution {
    /* lost: 체육복을 도난당한 학생들 
       reserve: 체육복을 가져온 학생들 */
    public int solution(int n, int[] lost, int[] reserve) {
        // 체육복 갖고 온 학생 수 (전체 학생 - 체육복 잃어버린 학생)
        int possible = 0;
        possible = n - lost.length; 
        
        boolean rc[] = new boolean[n+1];
        boolean lc[] = new boolean[n+1];
        
        Arrays.sort(lost);
        
        // reserve[] 보고 여분 체육복이 있으면 rc[]에 true
        for (int i = 0; i < reserve.length; i++) {
            rc[reserve[i]] = true;
        }
        
        for (int i = 0; i < lost.length; i++) {
            /* rc[]가 true면 여분이 있다는 의미니까
            i번째 학생한테 체육복 빌려주고 reserve true => false로.
            수업 가능한 학생이 증가하므로 +1 */
            if (rc[lost[i]]) {
                rc[lost[i]] = false;
                possible++;
            }
            // rc[] = false면 빌려줄 체육복이 없다는 말이니 lc[] = true로 (잃어버렸다는 뜻)
            else 
                lc[lost[i]] = true;
        }
        
        for(int i = 0; i < lost.length; i++) {
            // i번째는 체육복이 없지만 앞 번호(i-1) 학생이 체육복이 있는경우
        	if(lc[lost[i]] && lost[i] - 1 >= 1 && rc[lost[i] - 1]) {
        		rc[lost[i] - 1] = false;
        		possible++;
        	}
            // i번째는 체육복이 없지만 뒷 번호(i+1) 학생이 체육복이 있는 경우
            else if(lc[lost[i]] && lost[i] + 1 <= n && rc[lost[i] + 1]) {
        		rc[lost[i] + 1] = false;
        		possible++;
        	}
        }
        
        return possible;
    }
}
