// 백준 - 다음 순열(10972)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_10972 {
    static int N;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int point = findSwapPoint();
        if(point == -1) { //마지막에 오는 순열인 경우
            System.out.print(-1);
        } else {
            int bigPoint = findBigPoint(point);

            int temp = num[point];
            num[point] = num[bigPoint];
            num[bigPoint] = temp;
            
            sort(point);

            StringBuilder printSet = new StringBuilder();
            for(int i = 0; i < N; i++) {
                printSet.append(num[i]).append(" ");
            }
            System.out.print(printSet);
        }
    }
    static int findSwapPoint() { // 숫자를 변경해야 하는 지점 찾기
        for(int i = N - 1; i > 0; i--) {
            if(num[i-1] < num[i]) return i-1;
        }
        return -1; //마지막에 오는 순열인 경우
    }
    static int findBigPoint(int point) { // point 뒤에 오는 숫자 중 point보다 큰 수 중에 최소값 찾기
        int check = point + 1;
        for(int i = point + 2; i < N; i++) {
            if(num[point] < num[i] && num[check] > num[i]) check = i;
        }
        return check;
    }
    static void sort(int point) { // 변경한 지점 이후 숫자들은 오름차순 정렬
        long end = Math.round(1.0 * (point + (N - point + 1) / 2.0));
        for(int i = point + 1; i <= end && i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }
}
/*
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3

*/