// 프로그래머스 - [1차]프렌즈4블록(Lv.2)
import java.util.Queue;
import java.util.LinkedList;

class Solution {
  static boolean v[][];
  
  public int solution(int m, int n, String[] board) {
    int answer = 0;
    
    char blocks[][] = new char[m][n]; 
    for(int i = 0; i < m ; i++){
      blocks[i] = board[i].toCharArray();
    }
    
    boolean flag = true;
    while(flag){
      v = new boolean[m][n];
      flag = false;
      
      for(int i = 0; i < m-1; i++){
        for(int j = 0; j < n-1; j++){
          if(blocks[i][j] == '_') continue; // _ : 
          
          if(equalCheck(i, j, blocks)){ // 2*2
            v[i][j] = true;
            v[i][j+1] = true;
            v[i+1][j] = true;
            v[i+1][j+1] = true;
            
            flag = true;
          }
        }
      }
        
      answer += erase(m, n, blocks);
      v = new boolean[m][n];
    }
    
    return answer;
  }

  // 2*2가 같은지 확인
  public static boolean equalCheck(int x, int y, char[][] board){
    char check = board[x][y];
    
    if(check == board[x][y+1] && check == board[x+1][y] && check == board[x+1][y+1]){
      return true;
    }
    
    return false;
  }

  // 같은 블록 제거
  public static int erase(int m, int n, char[][] board){
    int cnt = 0;
    
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(v[i][j]) 
          board[i][j] = '.';
      }
    }
    
    // 수직 방향으로 제거
    for(int i = 0; i < n; i++){
      Queue<Character> q = new LinkedList<>();
      for(int j = m-1; j >= 0; j--){
        if(board[j][i] == '.'){ 
          cnt++;  // 지워진 블록 갯수
        } else{
          q.add(board[j][i]);
        }
      }
      
      int idx = m-1;
      // 삭제한 블록 위의 블록들 내리기
      while(!q.isEmpty()){
        board[idx--][i] = q.poll();
      }
      // 빈칸 채우기
      for(int j = idx; j >= 0; j--){
        board[j][i] = '_';
      }
    }

    return cnt;
  }
}