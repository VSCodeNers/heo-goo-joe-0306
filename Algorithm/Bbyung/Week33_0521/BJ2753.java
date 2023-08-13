import java.util.Scanner;

public class BJ2753 {
    public static void main(String[] args) {
        Scanner in = new Scanner(Sytem.in);

        int x = in.nextInt();
        in.close();

        if (x%4==0) {
            if (x%400==0) {
                System.out.println("1");
            }
            else if (x%100==0) {
                System.out.println("0");
            }
            else {
                System.out.println("1");
            }
        }
        else {
            System.out.println("0");
        }
    }
    
}
