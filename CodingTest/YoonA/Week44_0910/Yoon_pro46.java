public class Yoon_pro46 {
    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] plate = new char[m][n];
            
            for(int i = 0; i < board.length; i++) {
                plate[i] = board[i].toCharArray();
            }
            
            while(true) {
                int count = checkBlock(plate, m, n);
                if (count == 0) break;              // 더 지울 블록이 없으면
                answer += count;
                
                dropBlock(plate, m, n);
            }
            
            return answer;
        }
        
        // 지울 블록 선택
        public int checkBlock(char[][] plate, int m, int n){
            int count = 0;
            boolean[][] isChecked = new boolean[m][n];
            
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    if(plate[i][j] == '.') continue; // 블록이 없는 경우
                    checkFour(plate, isChecked, i, j);
                }
            }
            
            
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(isChecked[i][j]) {
                        plate[i][j] = '.'; // 삭제할 블록 표시
                        count++;
                    }
                }
            }
            
            return count;
        }
        
        // 지울 블록 조건 확인
        public void checkFour(char[][] plate, boolean[][] isChecked, int r, int c){
            char block = plate[r][c];
            
            for(int i = r; i < r + 2; i++){
                for(int j = c; j < c + 2; j++){
                    if(plate[i][j] != block) return;
                }
            }
            
            for(int i = r; i < r + 2; i++){
                for(int j = c; j < c + 2; j++){
                    isChecked[i][j] = true;
                }
            }
        }
        
        // 블록 지움
        public void dropBlock(char[][] plate, int m, int n){
            for(int i = 0; i < n; i++) {
                for(int j = m - 1; j >= 0; j--) {
                    if(plate[j][i] == '.') {
                        for(int k = j - 1; k >= 0; k--) {
                            if(plate[k][i] != '.') {
                                plate[j][i] = plate[k][i];
                                plate[k][i] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
