// 백준 - 사탕 게임(3085)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BeakJoon_3085 {
    static int N;
    static String[][] candyBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        candyBoard = new String[N][N];

        for(int i = 0; i < N; i++) {
            String str = bf.readLine();
            candyBoard[i] = str.split("");
        }

        // 바로 앞에 놓인 사탕과 다른 색의 사탕이 나타날 때마다 갯수 탐색
        int max = 1;
        for(int i = 0; i < N; i++) {
            String rowColor = "A", columnColor = "A";
            for(int j = 0; j < N; j++) {
                // 가로(행) 탐색
                if(!candyBoard[i][j].equals(rowColor)) {
                    int temp = checkRow(i, j, candyBoard[i][j]);
                    rowColor = candyBoard[i][j];
                    if(temp > max) max = temp;
                }
                // 세로(열) 탐색
                if(!candyBoard[j][i].equals(columnColor)) {
                    int temp = checkColumn(j, i, candyBoard[j][i]);
                    columnColor = candyBoard[j][i];
                    if(temp > max) max = temp;
                }
            }
            if(max == N) break;
        }

        System.out.println(max);
    }
    // 가로(행) 체크
    static int checkRow(int r, int c, String color) {
        int cnt = 1;
        boolean check = false;
        for(int i = c+1; i < N; i++) {
            if(!candyBoard[r][i].equals(color)) {
                if(check) break;
                if(r+1 < N && candyBoard[r+1][i].equals(color)) check = true;
                else if(r > 0 && candyBoard[r-1][i].equals(color)) check = true;
                else if(i+1 < N && candyBoard[r][i+1].equals(color)){
                    cnt++;
                    break;
                }
                else break;
            }
            cnt++;
        }

        if(!check && c > 0) {
            if((r+1 < N && candyBoard[r+1][c-1].equals(color)) || (r > 0 && candyBoard[r-1][c-1].equals(color))) cnt++;
        }

        return cnt;
    }
    // 세로(열) 체크
    static int checkColumn(int r, int c, String color) {
        int cnt = 1;
        boolean check = false;
        for(int i = r+1; i < N; i++) {
            if(!candyBoard[i][c].equals(color)) {
                if(check) break;
                if(c+1 < N && candyBoard[i][c+1].equals(color)) check = true;
                else if(c > 0 && candyBoard[i][c-1].equals(color)) check = true;
                else if(i+1 < N && candyBoard[i+1][c].equals(color)){
                    cnt++;
                    break;
                }
                else break;
            }
            cnt++;
        }

        if(!check && r > 0) {
            if((c+1 < N && candyBoard[r-1][c+1].equals(color)) || (c > 0 && candyBoard[r-1][c-1].equals(color))) cnt++;
        }

        return cnt;
    }
}
