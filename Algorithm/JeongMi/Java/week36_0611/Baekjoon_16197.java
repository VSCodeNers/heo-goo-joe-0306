// 백준 - 두 동전(16197)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Baekjoon_16197 {
  static int N, M;
  static boolean[][] map;
  static int minMove = 11;
  static public void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new boolean[N + 2][M + 2];
    int coinCount = 0;
    int[][] coins = new int[2][2]; // 두 동전의 현좌표
    for(int i = 1; i <= N; i++) {
      String line = bf.readLine();
      for(int j = 1; j <= M; j++) {
        // 벽 = true
        if(line.charAt(j-1) == '#')
          map[i][j] = true;
        // 동전이 놓인 곳
        else if(line.charAt(j-1) == 'o') {
          // 동전 좌표
          coins[coinCount][0] = i;
          coins[coinCount][1] = j;
          coinCount++;
        }
      }
    }
    bf.close();

    // 동전 이동
    moveCoin(coins[0][0], coins[0][1], coins[1][0], coins[1][1], 0);

    // 동전을 떨어뜨릴 수 없거나, 버튼을 10번보다 많이 눌러야 하는 경우
    if(minMove > 10) {
      minMove = -1;
    }

    System.out.print(minMove);
  }
  // 동전 이동
  static void moveCoin(int coin1x, int coin1y, int coin2x, int coin2y, int count) {
    int check = checkCoin(coin1x, coin1y, coin2x, coin2y);
    // 동전 하나만 떨어진 경우 계산을 멈추고 최솟값인지 확인
    if(check == 1) {
      minMove = Math.min(count, minMove);
      return;
    }
    // 이미 구해진 최소 횟수보다 많이 이동했거나
    // 동전 2개가 모두 떨어진 경우 게속 계산할 필요 없음
    else if(minMove < count || check == 2) return;

    int coin1 = 0, coin2 = 0;
    // 위로 이동 = 벽이 아닌 경우 움직임
    if(!map[coin1x - 1][coin1y]) coin1 = -1;
    if(!map[coin2x - 1][coin2y]) coin2 = -1;
    moveCoin(coin1x + coin1, coin1y, coin2x + coin2, coin2y, count + 1);

    coin1 = 0; coin2 = 0;
    // 아래로 이동 = 벽이 아닌 경우 움직임
    if(!map[coin1x + 1][coin1y]) coin1 = 1;
    if(!map[coin2x + 1][coin2y]) coin2 = 1;
    moveCoin(coin1x + coin1, coin1y, coin2x + coin2, coin2y, count + 1);

    coin1 = 0; coin2 = 0;
    // 왼쪽으로 이동 = 벽이 아닌 경우 움직임
    if(!map[coin1x][coin1y - 1]) coin1 = -1;
    if(!map[coin2x][coin2y - 1]) coin2 = -1;
    moveCoin(coin1x, coin1y + coin1, coin2x, coin2y + coin2, count + 1);

    coin1 = 0; coin2 = 0;
    // 오른쪽으로 이동 = 벽이 아닌 경우 움직임
    if(!map[coin1x][coin1y + 1]) coin1 = 1;
    if(!map[coin2x][coin2y + 1]) coin2 = 1;
    moveCoin(coin1x, coin1y + coin1, coin2x, coin2y + coin2, count + 1);
  }

  // 동전 몇 개 떨어졌는지 체크
  static int checkCoin(int coin1x, int coin1y, int coin2x, int coin2y) {
    int outCoin = 0;
    if(coin1x <= 0 || coin1x > N || coin1y <= 0 || coin1y > M)
      outCoin++;
      if(coin2x <= 0 || coin2x > N || coin2y <= 0 || coin2y > M)
      outCoin++;

    return outCoin;
  }
}
