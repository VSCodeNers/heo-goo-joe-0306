import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ1080 {
    static int row, col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        char matrixA[][] = new char[row][col];
        char matrixB[][] = new char[row][col];

        // 기본 행렬
		for(int i = 0; i < row; i++) {
			String s = br.readLine();
            matrixA[i] = s.toCharArray();
		}

		// 바꾸고 싶은 행렬
		for(int i = 0; i < row; i++) {
			String s = br.readLine();
            matrixB[i] = s.toCharArray();
		}

        for(int i = 0; i < row - 2; i++){
            for(int j = 0; j < col - 2; j++) {
                // [i][j]번째에 든 숫자가 같은 경우는 넘어감
                if (matrixA[i][j] == matrixB[i][j])
                    continue;

                // 같지 않은 경우는 횟수+1 해주고, 1이면 0으로 / 0이면 1로 바꿔줌
                answer++;
                for(int a = i; a < i + 3; a++) {
                    for(int b = j; b < j + 3 ; b++){
                        matrixA[a][b] = matrixA[a][b] == '1' ? '0' : '1'; 
                    }
                }
            }
        }

        // for문 도는 동안 바뀔 수 있는 경우라면 다 바껴있겠죠? 아직도 안 바꼈다는건 못 바꾸는 것이다! 라는 뜻이므로 -1 출력
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrixA[i][j] != matrixB[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}
