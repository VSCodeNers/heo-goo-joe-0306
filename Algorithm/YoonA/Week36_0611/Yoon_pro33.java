public class Yoon_pro33 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        // 경우의 수는 n! - n(3) = 3 * 2 * 1 = 6 => n이 3인 경우 나올 수 있는 경우의 수는 6가지
        // 배열에 숫자 넣고 + 경우의 수도 구함
        long f = 1;
        for(int i = 1; i <= n; i++) {
            list.add(i);
            f *= i;
        }
        
        // 배열 인덱스는 0부터 시작하니까 k에서 1 빼줌
        k--; 
        int idx = 0;
        while(idx < n) {
            // 각 자리에 들어갈 경우의 수
            f /= n - idx;
            answer[idx++] = list.remove((int) (k / f));
            // 다음 배열에 들어갈 수 구해야하니 k 변경
            k %= f;
        }
        return answer;
    }
}
