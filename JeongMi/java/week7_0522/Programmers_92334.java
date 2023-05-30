// 프로그래머스 - 신고 결과 받기(Lv.1)

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int userNum = id_list.length; // 유저 인원수
        int reportNum = report.length; // 총 신고 횟수
        int[] answer = new int[userNum];
        int[][] checkReport = new int[userNum][userNum];
        int[] countReport = new int[userNum];
        
        
        for(int i = 0; i < reportNum; i++) {
            String[] reportCase = report[i].split("\\s"); // 공백 기준으로 자르기
            int userIndex = search(id_list, userNum, reportCase[0]);
            int reportIndex = search(id_list, userNum, reportCase[1]);
            
            checkReport[reportIndex][userIndex] = 1; // 신고한 거 표시
        }
        
        for(int i = 0; i < userNum; i++) {
            for(int j = 0; j < userNum; j++) {
                countReport[i] += checkReport[i][j]; // 신고 당한 횟수
            }
        }
        
        for(int i = 0; i < userNum; i++) {
            if(countReport[i] >= k) { // k번 이상 신고 당한 경우
                for(int j = 0; j < userNum; j++) {
                    answer[j] += checkReport[i][j]; // i번째 사람을 신고한 사람
                }
            }
        }
        
        return answer;
    }
    
    static int search(String[] id_list, int len, String findName) {
        for(int i = 0; i < len; i++) {
            if(findName.equals(id_list[i]))
                return i;
        }
        return 0;
    }
}
