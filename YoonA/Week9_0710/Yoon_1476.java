import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int year = 0; 
        int earth = 0, sun = 0, moon = 0;


        while (true) {
            if (E == earth && S == sun && M == moon) break;
            year++; earth++; sun++; moon++;

            if (earth == 16) earth = 1;
            if (sun == 29) sun = 1;
            if (moon == 20) moon = 1;
        }
        System.out.println(year);    
    }
}
