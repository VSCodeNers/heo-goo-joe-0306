import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoon_BJ7562 {
	static int N;
	static int startX, startY, endX, endY;
	static int[][] chess;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int Number = Integer.parseInt(br.readLine());
		
		while(Number-- > 0) {
			// 체스판의 크기
			N = Integer.parseInt(br.readLine());
			
			chess = new int[N][N];
			check = new boolean[N][N];
			
			// 시작점
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			// 도착점
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			System.out.println(BFS(startX, startY));
		}
	}
	
	public static int BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		check[x][y] = true;

        int[] mapX = {-1, -2, -2, -1, 1, 2,  2,  1};
	    int[] mapY = {-2, -1,  1,  2, 2, 1, -1, -2};
		
		while(!q.isEmpty()) {
            // 큐에서 값을 꺼냄. 그거 기준에서 상하좌우 갈 수 있는 곳으로 간다.
			Node now = q.poll();
			// 현재 큐의 좌표
			int nx = now.x;
			int ny = now.y;
			
			// 현재 좌표가 도착지점이라면 이동횟수 출력
			if(nx == endX && ny == endY) {
				return now.cnt;
			}
			
			for(int i = 0; i < 8; i++) {
				// 다음으로 이동해야 할 좌표
				int xx = nx + mapX[i];
				int yy = ny + mapY[i];

                // 이동경로가 체스판의 범위를 벗어나지 않았고, 방문하지 않은 경우
				if(xx >= 0 && yy >= 0 && xx < N && yy < N) {
                    if (!check[xx][yy]) {
                        check[xx][yy] = true;
				        // 현재좌표에 이동횟수 1을 추가하여 큐에 담음
				        q.offer(new Node(xx, yy, now.cnt + 1));
                    }
				}
			}
		}
		return 0;
	}

    // 맵의 좌표와 이동 횟수
	static class Node {
		int x, y, cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}