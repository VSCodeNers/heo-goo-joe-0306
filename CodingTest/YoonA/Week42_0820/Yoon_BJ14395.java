import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoon_BJ14395 {
    static int S, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        BFS();
    }

    public static void BFS() {
        Queue<Oper> q = new LinkedList<>();
        HashSet<Long> set = new HashSet<>();
        String cal[] = new String[] {"*", "+", "-", "/"};

        q.add(new Oper(S, ""));
        set.add((long) S);

        if (S == T) {
            System.out.println(0);
            return;
        }
        
        while (!q.isEmpty()) {
            Oper o = q.poll();

            long nowNum = o.num;
            long nextNum = nowNum;
            String res = o.result;

            // 목표에 도달하면 계산한거 출력
            if (nowNum == T) {
                System.out.println(res);
                return;
            } 

            for (int i = 0; i < 4; i++) {
                switch(i) {
                    case 0:
                        nextNum = nowNum * nowNum;
                        break;
                    case 1:
                        nextNum = nowNum + nowNum;
                        break;
                    case 2:
                        nextNum = nowNum - nowNum;
                        break;
                    case 3:
                        if (nowNum != 0) nextNum = nowNum / nowNum;
                        break;
                }

                // 중복된 숫자 아니면  set, queue에 넣기
                if (!set.contains(nextNum)) {
                    set.add(nextNum);
                    q.add(new Oper(nextNum, res + cal[i]));
                }
            }
        }
        // 바꿀 수 없으면 -1
        System.out.println(-1);
        return;
    }

    static class Oper {
        long num;           // 숫자, int로 하니까 안됨
        String result;      // 연산 저장해두는 곳

        Oper(long num, String result) {
            this.num = num;
            this.result = result;
        }
    }
}
