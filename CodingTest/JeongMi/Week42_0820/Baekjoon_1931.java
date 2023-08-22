// 백준 - 회의실 배정(1931)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Baekjoon_1931 {
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    int[][] meet = new int[N][2];
    
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      meet[i][0] = Integer.parseInt(st.nextToken());
      meet[i][1] = Integer.parseInt(st.nextToken());
    }

    // 종료시간 기준으로 오름차순 정렬
		Arrays.sort(meet, (o1, o2) -> {
      // 종료 시간이 같으면 시작 시간 빠른순,
      // 종료 시간이 다르면 종료 시간 빠른순
			return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
		});

    int count = 0;   // 회의 수
    int endTime = 0; // 직전 회의 종료 시간
    for(int i = 0; i < N; i++) {
      // 직전 회의 종료시간 이후에 시작하는 회의인 경우
      if(endTime <= meet[i][0]) {
        endTime = meet[i][1];
        count++;
      }
    }

    System.out.print(count);
  }
}
