import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nanjang = new int[9];    //난쟁이 저장된 곳
        int sum = 0;    //난쟁이 키 총합
        int nonanjang1 = 0, nonanjang2 = 0;     //난쟁이 아닌 애들

        for (int i = 0; i < 9; i++) {
            nanjang[i] = Integer.parseInt(br.readLine());
            sum += nanjang[i];  //난쟁이 키를 sum 변수에 저장
        }

        Arrays.sort(nanjang);   //오름차순으로 정렬

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (nanjang[i] + nanjang[j] == sum - 100) { //키 총합 
                    nonanjang1 = nanjang[i];
                    nonanjang2 = nanjang[j];
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (nanjang[i] != nonanjang1 && nanjang[i] != nonanjang2)
                System.out.println(nanjang[i]);
        }
    }
}