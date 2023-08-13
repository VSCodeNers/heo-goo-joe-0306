public class Yoon_pro42 {
    public int solution(int N, int[][] road, int K) {
        int shortDis[][] = new int[N][N];    // 각 정점별 최단거리
        int count = 0;                       // 1번에 K이하만큼 연결된 도시 수
        
        for (int i = 0; i < shortDis.length; i++) {
            for (int j = 0; j < shortDis[0].length; j++) {
                if (i == j) {                       // 출발지/도착지가 같으면 걸리는 시간 0이니 
                    shortDis[i][j] = 0;
                    continue;
                }
                shortDis[i][j] = 500001;      // 나머지는 500001
            }
        }
 
        for (int i = 0; i < road.length; i++) {
            // 현재 거리가 원래 있던 거리보다 더 크면 무시하고 / 작으면 양쪽으로 연결해줌
            if(road[i][2] > shortDis[road[i][0] - 1][road[i][1] - 1])  
                continue;                                           
            shortDis[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            shortDis[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }
        
        // 플로이드 와샬 알고리즘 : 정점-정점 사이의 최소 거리를 구해준다(고 함)
        // j -> k 갈 때 i로 가는게 더 적은 시간이 든다면 그게 최단경로니까.. 경로를 변경함
        for (int i = 0; i < N; i++) {                                           
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(i == j) 
                        continue;
                    if (shortDis[j][k] > shortDis[j][i] + shortDis[i][k]) { 
                        shortDis[j][k] = shortDis[j][i] + shortDis[i][k];
                    }
                }
            }
        }
        // 시간 K 이하면 count + 1
        for (int i = 0; i < shortDis[0].length; i++) {
            if (shortDis[0][i] <= K) 
                count++;
        }
        
        return count;
    }
}
