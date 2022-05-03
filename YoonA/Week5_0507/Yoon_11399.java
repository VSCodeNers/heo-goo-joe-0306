package Week5_0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int people[] = new int[N];
        int total = 0;

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(people);

        int sum = 0;
        for (int i = 0; i < people.length; i++) {
            total += people[i] + sum;
            sum += people[i];
        }

        System.out.println(total);
    }
}
