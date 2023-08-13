public class Yoon_pro24 {
    // a: 마트에 줘야 되는 병 수 
    // b: 마트가 주는 병 수
    // n: 상빈이가 갖고 있는 빈 병 수
    public int solution(int a, int b, int n) {
        // 상빈이가 받은 빈 병의 총 개수
        int answer = 0;
        
        // 빈 병 n이 a개 미만이 되면 마트에 줄 수가 없으니
        while (n >= a) {
            // 빈 병 n병을 a병씩 마트에 주면 총 10병(20(n)/2(a)*1(b) 받음 -> 받은만큼 answer에 플러스
            answer += n / a * b; 
            // 빈 병을 마트에 갖다주면서 수량이 바뀌었을테니 새로 n 구함
            // 아까 마트에서 받아온 10병(n/a*b) + 수량 a개가 안돼서 교환 못했던 나머지 병들(n%a)를 n에 추가
            n = n / a * b + n % a;
        }
        
        return answer;
    }
}
