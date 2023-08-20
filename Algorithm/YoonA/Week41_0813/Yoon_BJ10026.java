import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_BJ10026 {
    static int N;
    static char grid[][];
    static boolean check[][];
    static int mapX[] = {0, -1, 1, 0};
    static int mapY[] = {-1, 0, 0, 1};
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        // 색약이 아닌 경우
        int notColorWeakness = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    DFS(i, j);
                    notColorWeakness++;
                }
            }
        }
        
        // 색약인 경우
        // 색이 초록색인 애들은 다 빨간색으로 바꿔줌 (G -> R)
        int colorWeakness = 0;
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    DFS(i, j);
                    colorWeakness++;
                }
            }
        }

        System.out.println(notColorWeakness + " " + colorWeakness);
    }

    public static void DFS(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = x + mapX[i];
            int yy = y + mapY[i];

            // 범위를 벗어나지 않은 경우
            if(xx >= 0 && yy >= 0 && xx < N && yy < N) {
                if (grid[xx][yy] == grid[x][y] && !check[xx][yy]) {
                    check[xx][yy] = true;
                    DFS(xx, yy);
                }
            }
        }
    }
}