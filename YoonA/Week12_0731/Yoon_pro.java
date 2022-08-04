public class Yoon_pro {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<Integer>(); // 인형 담을 바구니
        basket.push(0);

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] == 0) // 만약 인형이 없다면?
                    continue; // 인형이 없다는 것이므로 그냥 넘어감
                else {
                    // 같은 모양의 인형이 두 개 이상 바구니에 담기는 경우
                    if (board[j][moves[i] - 1] == basket.peek()) {
                        answer += 2; // 같은 모양 인형이 두 개 없어진다고 했으므로
                        basket.pop(); // 바구니에서 인형 없앰
                    } else {
                        basket.add(board[j][moves[i] - 1]);
                    }
                    board[j][moves[i] - 1] = 0; // 인형 뽑기
                    break;
                }
            }
        }
        return answer;
    }
}
