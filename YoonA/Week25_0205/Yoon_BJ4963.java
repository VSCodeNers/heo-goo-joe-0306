import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ4963 {
    static int w, h, island;
    static int map[][];
    static boolean check[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());   // 지도의 너비
            h = Integer.parseInt(st.nextToken());   // 지도의 높이

            // 0인 경우 종료
            if (w == 0 && h == 0)
                break;

            map = new int[h][w];                    // 지도
            check = new boolean[h][w];              // 방문 여부

            island = 0;                             // 섬의 개수

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 만약 방문하지 않은 섬이 있다면? 거기 방문하고, 섬 개수 + 1
                    // map[i][j] == 1이면 땅으로 이루어진 곳이고, check == false면 방문하지 않았다는 뜻이니
                    if (map[i][j] == 1 && !check[i][j]) {  
                        DFS(i, j);
                        island++; 
                    }
                }
            }   
            System.out.println(island);
        }
    }

    public static void DFS(int x, int y) {
        // 해당 땅을 방문한 것으로 표시
        check[x][y] = true;

        // 현재 위치 기준으로 상하좌우대각선을 모두 살펴봐야 하므로 / 땅으로 된 곳이 있는지
        int mapX[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        int mapY[] = {-1, -1, -1, 0, 0, 1, 1, 1};

        // int mapX[] = {0, 0, -1, 1, -1, 1, -1, 1};
        // int mapY[] = {-1, 1, 0, 0, -1, -1, 1, 1};

        for (int i = 0; i < 8; i++) {
            int xx = x + mapX[i];
            int yy = y + mapY[i];

            // 범위를 벗어나지 않은 경우
            if(xx < 0 && yy < 0 && xx < w && yy < h) {
                //땅이고, 아직 방문하지 않은 경우
                if (map[xx][yy] == 1 && !check[xx][yy])
                    check[xx][yy] = true;
                    // 연결된 땅을 모두 방문함
                    DFS(xx, yy);
            }
        }
    }
}

/*         x x x
 *        -1 0 1
 * 
 * y: -1   0 0 0    -1, -1 / 0, -1  /  1, -1 
 * y: 0    0 1 0    -1,  0 /        /  1,  0
 * y: 1    0 0 0    -1,  1 / 0,  1  /  1,  1
 */