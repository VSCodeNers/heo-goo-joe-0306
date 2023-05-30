// 백준 - 링크와 스타트(15661)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_15661 {
  static int[][] skillScore;
  static int min = 1000000; //능력치 차이 최소값
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    skillScore = new int[N][N];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      for(int j = 0; j < N; j++) {
        skillScore[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    // 스타트 팀의 인원수가 1명부터 N-1명인 경우까지
    for(int i = 1; i < N; i++) {
      int[] start = new int[i];
      startAndLink(N, start, 0, i);
    }
    System.out.print(min);
  }
  static void startAndLink(int N, int[] start, int cnt, int size) {
    if(cnt == size) {
      int scoreSub = calculateScore(N, start, size);
      if(scoreSub < min){
        min = scoreSub;
      }
      return;
    }

    int startI = 0;
    if(cnt != 0) startI = start[cnt-1]+1;
    for(int i = startI; i < N; i++) {
      start[cnt] = i;
      startAndLink(N, start, cnt+1, size);
    }
  }
  static int calculateScore(int N, int[] start, int size) {
    int[] link = new int[N-size];
    int cntS = 0, cntL = 0;
    for(int i = 0; i < N; i++) {
      if(cntS == size || start[cntS] != i) {
        link[cntL] = i;
        cntL++;
        if(cntL == (N-size)) break;
      }
      else cntS++;
    }

    //스타트 팀의 능력치 계산
    int startScore = 0;
    for(int i = 0; i < size; i++) {
      for(int j = i+1; j < size; j++) {
        startScore += skillScore[start[i]][start[j]];
        startScore += skillScore[start[j]][start[i]];
      }
    }

    //링크 팀의 능력치 계산
    int linkScore = 0;
    for(int i = 0; i < (N-size); i++) {
      for(int j = i+1; j < (N-size); j++) {
        linkScore += skillScore[link[i]][link[j]];
        linkScore += skillScore[link[j]][link[i]];
      }
    }
    
    return Math.abs(startScore - linkScore); //스타트 팀과 링크 팀의 능력치 차 반환
  }
}
