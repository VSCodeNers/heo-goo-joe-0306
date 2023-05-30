// 프로그래머스 - 체육복(Lv.1)
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int clothNum[] = new int[n+1];
        
        // 학생 각각 가지고 있는 체육복의 개수를 체크
        Arrays.fill(clothNum, 1);
        for(int i: lost) { // 도난당한 학생의 체육복은 -1
            clothNum[i]--;
        }
        for(int i: reserve) { // 여분이 있는 학생의 체육복은 +1
            clothNum[i]++;
        }
        for(int i = 1; i <= n; i++) {
            // 체육복의 개수가 -1인 경우 = 체육복을 도난당한 경우
            if(clothNum[i] == 0) {
                if(i > 1 && clothNum[i-1] == 2) {
                    clothNum[i-1]--;
                    clothNum[i]++;
                } else if(i < n && clothNum[i+1] == 2) {
                    clothNum[i+1]--;
                    clothNum[i]++;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}

/*
틀린 답: 92.0 / 100.0
틀린 이유: 뒷 사람이 여분 옷이 있다고 무작정 빌리면 안 됨. 뒷사람도 도난 당했을 경우 빌려줄 수 없음.

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean checkLost[] = new boolean[n+1];
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++) {
            checkLost[lost[i]] = true;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            // 여분 체육복이 있는 학생 본인이 체육복을 도난당한 경우
            if(checkLost[reserve[i]]) {
                checkLost[reserve[i]] = false;
                answer++;
            }
            // 여분 체육복이 있는 학생의 앞번호 학생이 체육복을 도난당한 경우
            else if(reserve[i] > 1 && checkLost[reserve[i] - 1]) {
                checkLost[reserve[i] - 1] = false;
                answer++;
            }
            // 여분 체육복이 있는 학생의 뒷번호 학생이 체육복을 도난당한 경우
            else if(reserve[i] < n && checkLost[reserve[i] + 1]) {
                checkLost[reserve[i] + 1] = false;
                answer++;
            }
        }
        
        return answer;
    }
}
*/