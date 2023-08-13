import java.util.Scanner;

public class BJ25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = "";
        sc.close();

        for(int i=1; i<=n/4; i++) {
            str += "long";
        }
        System.out.println(str + "int");
    }
    
}
