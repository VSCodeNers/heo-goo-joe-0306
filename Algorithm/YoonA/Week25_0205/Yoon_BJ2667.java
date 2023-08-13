import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Yoon_BJ2667 {
    static int N, count;
    static int map[][];
    static int apart[];
    static boolean check[][];
    static ArrayList list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];            // 지도
        check = new boolean[N][N];      // 방문 여부 표시

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 집이 있고, 방문하지 않은 곳
                count = 0;
                if (map[i][j] == 1 && !check[i][j]) {
                    DFS(i, j);
                    count++;
                    list.add(count);
                }
            }
        }

        // ArrayList 오름차순 정렬
        Collections.sort(list);
        // 단지 수는 ArrayList 수만큼이므로
        System.out.println(list.size());

        // 단지 내의 집 수를 출력함
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static int DFS(int x, int y) {
        // 해당 땅을 방문한 것으로 표시
        check[x][y] = true;
        map[x][y] = count;      // 방문했음을 표시

        // 현재 위치 기준으로 상하좌우를 모두 살펴봐야 하므로 / 땅으로 된 곳이 있는지
        int mapX[] = {0, -1, 1, 0};
        int mapY[] = {-1, 0, 0, 1};

        for (int i = 0; i < 4; i++) {
            int xx = x + mapX[i];
            int yy = y + mapY[i];

            // 범위를 벗어나지 않은 경우
            if(xx >= 0 && yy >= 0 && xx < N && yy < N) {
                //집이 있고, 아직 방문하지 않은 경우
                if (map[xx][yy] == 1 && !check[xx][yy]) {
                    check[xx][yy] = true;
                    // 조건에 만족하는 경우, 연결된 다른 땅을 방문하고 단지 내의 집 수 증가
                    DFS(xx, yy);
                    count++;
                }
            }
        }
        return count;
    }
}