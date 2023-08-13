public class Yoon_pro30 {
    public long solution(int n) {
        /* 
            1: 1 / 2: 2(1+1) / 3: 3(1+2) / 4: 5(2+3) / 5: 8(3+5)
            == 피보나치임.. 다음 n의 결과값을 얻으려면 n-1이랑 n-2번째 값을 더한 다음, %1234567하면 됨
        */
        long jump[] = new long[n+1];
            
        jump[0] = 1;
        jump[1] = 1;
            
        if (n == 1) return 1;           // 1 - 하나 밖에 없음
            
        for (int i = 2; i <= n; i++) {
            jump[i] = (jump[i-2] + jump[i-1]) % 1234567;
        }
        return jump[n];
    }
}
