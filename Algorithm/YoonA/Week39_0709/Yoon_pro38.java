public class Yoon_pro38 {
    int answer = 0;

    public int solution(int n) {
        int[] col = new int[n];
        DFS(0, col, n);
        return answer;
    }

    public void DFS(int row, int[] col, int n) {
        if (row == n) answer++;
        else {
            for (int i = 0; i < n; i++) {
                col[row] = i;
                // 배치 제대로 된 거 찾을 때까지 계속 탐색
                if (isPossible(row, col)) {
                    DFS(row + 1, col, n);
                }
            }
        }
    }

    public boolean isPossible(int row, int[] col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 위치한.. 퀸이 존재하는지 확인
            if (col[i] == col[row]) 
                return false;
            // 대각선 내에 퀸이 존재하는지 확인
            else if (Math.abs(col[i] - col[row]) == row - i) 
                return false;
        }
        return true;
    }    
}
