// 백준 - 일곱난쟁이(2309)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BeakJoon_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        int allSum = 0; // 9명의 난쟁이 키 총합
        for(int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(bf.readLine());
            allSum += height[i];
        }

        Arrays.sort(height); //오름차순 정렬

        // 9명 중 7명의 키의 합이 100이 되려면,
        // 일곱난쟁이가 아닌 2명의 키 합 = 9명의 키 총합 - 100
        int findSum = allSum - 100;
        int[] notDwarf = new int[2];
        for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if(height[i] + height[j] == findSum) {
                    notDwarf[0] = i;
                    notDwarf[1] = j;
                    break;
                }
            }
        }
        
        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            if(i != notDwarf[0] && i != notDwarf[1]) { // 일곱난쟁이가 아닌 두 명을 제외
                printSet.append(height[i]).append("\n");
            }
        }

        System.out.print(printSet);
    }
}
