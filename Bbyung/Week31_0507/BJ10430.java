import java.util.Scanner;

public class BJ10430 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        int A = a.nextInt();
        int B = a.nextInt();
        int C = a.nextInt();

        System.out.println((A+B)%C);
        System.out.println((A%C)+(B%C)%C);
        System.out.println((A*B%C));
        System.out.println((A%C)*(B%C)%C);


    }
    
}
