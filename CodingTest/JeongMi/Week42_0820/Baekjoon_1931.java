// 백준 - 회의실 배정(1931)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1931 {
  static int[][] meet;
  static int N;
  static int start = 2147483647, finish = 0;
  static int max = 0;
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    meet = new int[N][2];
    
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      meet[i][0] = Integer.parseInt(st.nextToken());
      meet[i][1] = Integer.parseInt(st.nextToken());
      
      if(meet[i][0] < start) start = meet[i][0];
      if(meet[i][0] > finish) finish = meet[i][0];
    }
    
    checkMax(start, 0);
    
    System.out.print(max);
  }
    
  static void checkMax(int time, int count) {
    if(time > finish) {
      if(count > max) max = count;
      System.out.println(max);
      return;
    }
    
    for(int i = 0; i < N; i++) {
      if(time >= meet[i][0]) {
        checkMax(meet[i][1], count + 1);
      }
    }
  } 
}
