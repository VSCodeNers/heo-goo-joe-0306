import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        Stack<Integer> boardStack[] = new Stack[size];
        // board에 쌓인 인형을 각 열마다 하나의 Stack에 쌓아줌
        for(int i = 0; i < size; i++) {
            boardStack[i] = new Stack<>();
            for(int j = size-1; j >= 0; j--) {
                if(board[j][i] != 0)boardStack[i].push(board[j][i]);
            }
        }
        
        // moves 배열의 내용대로 basket 스택 안에 인형을 쌓음
        Stack<Integer> basket = new Stack<>();
        for(int i = 0; i < moves.length; i++) {
            // 집어야 할 라인이 비어있는 경우 패스
            if(boardStack[moves[i] - 1].empty()) continue; 
            
            int dollNum = boardStack[moves[i] - 1].pop(); // 집은 인형의 번호
            if(!basket.empty()) { // 스택이 비어있지 않은 경우
                if(basket.peek() == dollNum) {
                    answer += 2;
                    basket.pop();
                    continue;
                }
            }
            basket.push(dollNum);
        }
        
        return answer;
    }
}