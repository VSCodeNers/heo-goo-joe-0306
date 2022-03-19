import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_8958 {
    public static void main (String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int combo = 0, sum = 0;
            String st = br.readLine();

            for (int j = 0; j < st.length(); j++) {
                if (st.charAt(i) == 'O') {
                    combo ++;
                    sum += combo;
                }
                else if (st.charAt(i) == 'X')
                    combo = 1;
            }
            System.out.println(sum);
        }
        br.close();
    }
}
