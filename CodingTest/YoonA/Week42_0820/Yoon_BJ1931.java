import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yoon_BJ1931 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MeetingTime[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            MeetingTime[i][0] = Integer.parseInt(st.nextToken());   // 시작
            MeetingTime[i][1] = Integer.parseInt(st.nextToken());   // 종료
        }
        
        Arrays.sort(MeetingTime, (time1, time2) -> {
            if (time1[1] == time2[1]) 
                return time1[0] - time2[0];     // 종료시간이 같으면 시작이 더 빠른 걸로
            else 
                return time1[1] - time2[1];
        });

        int prevTime = 0;   // 이전 회의 종료시간
        int max = 0;

        for (int i = 0; i < N; i++) {
            // 현재 회의 시작이 이전 회의 종료시간보다 늦게 시작하거나 같은 시간에 시작한다면
            if (MeetingTime[i][0] >= prevTime) {
                prevTime = MeetingTime[i][1];
                max++;
            }
        }

        System.out.println(max);
    }
}