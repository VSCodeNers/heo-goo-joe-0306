import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ10026 {
    static int N;
    static char grid[][];
    static boolean notCheck[][];
    static boolean check[][];
    static int mapX[] = {0, -1, 1, 0};
    static int mapY[] = {-1, 0, 0, 1};
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        check = new boolean[N][N];
        notCheck = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        // 색약이 아닌 경우
        int colorWeakness = 0;
        int notColorWeakness = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    DFS(i, j);
                    notColorWeakness++;
                    System.out.println(notColorWeakness);
                }
                if (!notCheck[i][j]) {
                    notDFS(i, j);
                    colorWeakness++;
                    System.out.println(colorWeakness);
                }
            }
        }
        System.out.println(notColorWeakness + " " + colorWeakness);
    }

    public static void notDFS(int x, int y) {
        notCheck[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = x + mapX[i];
            int yy = y + mapY[i];

            // 범위를 벗어나지 않은 경우
            if(xx >= 0 && yy >= 0 && xx < N && yy < N) {
                if (!notCheck[xx][yy]) {
                    if ((grid[x][y] == 'R' || grid[x][y] == 'G') && (grid[xx][yy] == 'R' || grid[xx][yy] == 'G')) {
                        notCheck[xx][yy] = true;
                        DFS(xx, yy);
                    }
                    if (grid[x][y] == 'B' && grid[xx][yy] == 'B') {
                        notCheck[xx][yy] = true;
                        DFS(xx, yy);
                    }
                }
            }
        }
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
