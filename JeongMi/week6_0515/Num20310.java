// 타노스(20310)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Num20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();
        char[] Schar = S.toCharArray(); //인덱스를 사용하기 위해 String을 Char형 배열로 변환

        int one = 0, zero = 0;

        for(int i = 0; i < Schar.length; i++) { //0, 1 각각 개수 카운트
            if(Schar[i] == '0') zero++;
            else one++;
        }
        
        // 절반을 지워야하므로 계산하기 쉽게 개수를 반으로 나눠주기
        one /= 2;
        zero /= 2;

        for(int i = 0; i < Schar.length; i++) { // 1은 앞에서부터 지워주기
            if(one == 0) break;
            if(Schar[i] == '1') {
                Schar[i] = '2'; // 지운 건 2로 표시
                one--;
            }
        }
        for(int i = Schar.length-1; i >= 0; i--) { // 0은 뒤에서부터 지워주기
            if(zero == 0) break;
            if(Schar[i] == '0') {
                Schar[i] = '2'; // 지운 건 2로 표시
                zero--;
            }
        }

        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < Schar.length; i++) {
            if(Schar[i] != '2') // 지우지 않은 부분만
                printSet.append(Schar[i]);
        }

        System.out.print(printSet);
    }
}