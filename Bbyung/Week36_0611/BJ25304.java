import java.util.Scanner;

public class BJ25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int count = sc.nextInt();

        for(int i = 0; i<count; i++){
            int price = sc.nextInt();
            int num = sc.nextInt();
            
            total = total - (price*num);
        }
        if (total == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
    
}
