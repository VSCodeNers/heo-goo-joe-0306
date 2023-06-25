import java.io.*;

public class BJ15552 {
    public static void main(String[] args) throws IOExceprion {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bw = new BufferedReader(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++) {
            String string = br.readLine();
            int a = Integer.parseInt(string.split(" ")[0]);
            int b = Integer.parseInt(string.split(" ")[1]);
            bw.write(a+b+"\n");
        }
        bw.flush();


    }
}
