import java.util.Scanner;

public class Min_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();
        int result = 0;

        for (int i=0; i<n; i++){
            result += input.charAt(i) - '0';
        }
        sc.close();
        System.out.println(result);
        
    }
}
