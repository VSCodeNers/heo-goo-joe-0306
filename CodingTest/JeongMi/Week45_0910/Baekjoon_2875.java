// 백준 - 대회 or 인턴(2875
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2875 {
  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 여학생의 수
    int M = Integer.parseInt(st.nextToken()); // 남학생의 수
    int K = Integer.parseInt(st.nextToken()); // 인턴쉽에 참여해야하는 인원

    int teamN = N / 2;
    int teamM = M;

    // 최대로 만들 수 있는 팀의 수
    int maxTeam = Math.min(teamN, teamM);

    // 대회에 참가할 학생을 제외하고 남은 학생의 수
    int remain = (N + M) - (maxTeam * 3);

    // 남은 학생보다 인턴쉽에 참여해야할 인원이 많은 경우, 팀원 줄이기
    while(remain < K) {
      remain += 3;
      maxTeam--;
    }

    System.out.print(maxTeam);
  }
}
