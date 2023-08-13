// 백준 - 적록색약(10026)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Baekjoon_10026 {
  static int N;
  static Character[][] weakMap;
  static Character[][] strongMap;
  static boolean[][] weakVisited;
  static boolean[][] strongVisited;
  static int weakCount = 0, strongCount = 0;
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    strongMap = new Character[N][N];
    weakMap = new Character[N][N];
    for(int i = 0; i < N; i++) {
      String str = br.readLine();
      for(int j = 0; j < N; j++) {
        strongMap[i][j] = str.charAt(j);
        weakMap[i][j] = str.charAt(j);
        if(weakMap[i][j] == 'G') weakMap[i][j] = 'R';
      }
    }

    weakVisited = new boolean[N][N];
    strongVisited = new boolean[N][N];

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(!weakVisited[i][j]) {
          checkColorWeak(i, j, weakMap[i][j]);
          weakCount++;
        }
        if(!strongVisited[i][j]) {
          checkColorStrong(i, j, strongMap[i][j]);
          strongCount++;
        }
      }
    }

    System.out.print(strongCount + " " + weakCount);
  }
  static void checkColorStrong(int x, int y, Character color) {
    // 좌
    if(x-1 >= 0 && strongMap[x-1][y] == color && !strongVisited[x-1][y]) {
      strongVisited[x-1][y] = true;
      checkColorStrong(x - 1, y, color);
    }
    // 우
    if(x+1 < N && strongMap[x+1][y] == color && !strongVisited[x+1][y]) {
      strongVisited[x+1][y] = true;
      checkColorStrong(x + 1, y, color);
    }
    // 상
    if(y-1 >= 0 && strongMap[x][y-1] == color && !strongVisited[x][y-1]) {
      strongVisited[x][y-1] = true;
      checkColorStrong(x, y-1, color);
    }
    // 하
    if(y+1 < N && strongMap[x][y+1] == color && !strongVisited[x][y+1]) {
      strongVisited[x][y+1] = true;
      checkColorStrong(x, y+1, color);
    }
  }

  static void checkColorWeak(int x, int y, Character color) {
    // 좌
    if(x-1 >= 0 && weakMap[x-1][y] == color && !weakVisited[x-1][y]) {
      weakVisited[x-1][y] = true;
      checkColorWeak(x - 1, y, color);
    }
    // 우
    if(x+1 < N && weakMap[x+1][y] == color && !weakVisited[x+1][y]) {
      weakVisited[x+1][y] = true;
      checkColorWeak(x + 1, y, color);
    }
    // 상
    if(y-1 >= 0 && weakMap[x][y-1] == color && !weakVisited[x][y-1]) {
      weakVisited[x][y-1] = true;
      checkColorWeak(x, y-1, color);
    }
    // 하
    if(y+1 < N && weakMap[x][y+1] == color && !weakVisited[x][y+1]) {
      weakVisited[x][y+1] = true;
      checkColorWeak(x, y+1, color);
    }
  }
}
