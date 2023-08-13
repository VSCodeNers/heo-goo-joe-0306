// 프로그래머스 - 배달(Lv.2)
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];
        int[] minPath = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i != j) {
                    // 50(N의 최대) * 10000(도로를 건너는 시간 최대) + 1 
                    map[i][j] = 500001;
                }
            }
        }
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];

            if (map[a][b] > w) {
                map[a][b] = w;
                map[b][a] = w;
            }
        }
        
        for(int i = 2; i <= N; i++) {
            minPath[i] = 500001;
            if(minPath[i] > map[1][i]) {
                minPath[i] = map[1][i];
            }
        }

        visited[1] = true;
        for (int i = 1; i <= (N - 1); i++) {
            // 현재 연결된 길 중에 제일 가까운 길(시간이 짧게 걸리는)
            int minIndex = 1;
            int minValue = 500001;
            for (int j = 2; j <= N; j++) {
                if (!visited[j] && minPath[j] < minValue) {
                    minValue = minPath[j];
                    minIndex = j;
                }
            }
            
            // 방문
            visited[minIndex] = true;
            
            // 바로 가는 것보다 다른 길을 지나가는 게 더 빠른지 확인
            for (int j = 2; j <= N; j++) {
                if (minPath[j] > minPath[minIndex] + map[minIndex][j]) {
                    minPath[j] = minPath[minIndex] + map[minIndex][j];
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            // 방문 가능하고, 제한 시간 내에 가능한 곳
            if(visited[i] && minPath[i] <= K) answer++;
        }
        
        return answer;
    }
}