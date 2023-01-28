import java.util.*;

public class Yoon_pro16 {

    /* lost: 체육복을 도난당한 학생들 
       reserve: 체육복을 가져온 학생들 */
    public int solution(int n, int[] lost, int[] reserve) {
        // 체육복 갖고 온 학생 수 (전체 학생 - 체육복 잃어버린 학생)
        int possible = n - lost.length; 
        
        // 오름차순 정렬을 안해두니 실패 케이스 있길래 해둠
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여분의 체육복이 있어서 빌려주는게 가능한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] -1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    possible++;
                    reserve[j] = -1; // 또 빌려줄 순 없으니까 배열에 포함 안되도록
                    break;
                }
            }
        }
        
        // 체육복을 도난 당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    possible++;
                    lost[i] = -1;       // 또 빌려줄 순 없으니까 배열에 포함 안되도록
                    reserve[j] = -1;    // 위랑 같음
                    break;
                }
            }
        }
        return possible;
    }
}
