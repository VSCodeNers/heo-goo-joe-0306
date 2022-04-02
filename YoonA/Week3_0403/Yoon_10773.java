import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Yoon_10773 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        int N[] = new int[K];
        int sum = 0;

        for (int i = 0; i < K; i++) {
           N[i] = Integer.parseInt(br.readLine());

            if (N[i] == 0) 
                st.pop();
            else    
                st.push(N[i]); 
        }

        for (int j = 0; j < K; j++) {
            if (!st.isEmpty())
                sum += st.pop();
        }
        System.out.println(sum);
    }
}

}
