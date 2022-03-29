//제로(10773)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
public class Num10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++) {
            int n = Integer.parseInt(bf.readLine());
            if(n == 0) stack.pop();
            else stack.push(n);
        }
        bf.close();

        int sum = 0;
        while(!stack.empty()) {
            sum += stack.pop();
        }

        System.out.print(sum);
    }
}
