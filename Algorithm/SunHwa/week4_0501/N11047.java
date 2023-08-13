import java.util.Scanner;

public class N11047 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int co[]=new int[N];
        int count =0;

        for(int i=0; i<N;i++){
            co[i]=sc.nextInt();
        }
        sc.close();

        for(int i=N-1; i>=0; i--){
            if(co[i]<=K) {
                count+=(K/co[i]);
                K=K%co[i];
            }
           

        }
       
        System.out.println(count);
    }

}