//2주차 문제 - 이상한 곱셈(1225)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String A, B;
        A = st.nextToken();
        B = st.nextToken();

        long result = 0;
        for(int i = 0; i < A.length(); i++) {
            for(int j = 0; j < B.length(); j++) {
                result += Character.getNumericValue(A.charAt(i)) * Character.getNumericValue(B.charAt(j));
                //result += Integer.parseInt(A.charAt(i)+"") * Integer.parseInt(B.charAt(j)+"");
            }
        }

        System.out.print(result);
    }
}
