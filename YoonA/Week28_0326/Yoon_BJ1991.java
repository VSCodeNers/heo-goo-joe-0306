import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ1991 {
    static int N;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new int[N][2];

        for (int i = 0; i < N; i++) {  
            String nodes[] = br.readLine().split(" ");
            int node = nodes[0].charAt(0) - 65;            // index로 전환해야 하니까 A(65) 뺌
            int leftNode = nodes[1].charAt(0) - 65;        // 왼쪽 노드
            int rightNode = nodes[2].charAt(0) - 65;       // 오른쪽 노드

            tree[node][0] = leftNode;
            tree[node][1] = rightNode;
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
    public static void preorder(int now) {
        // 현재 노드가 마지막 노드라면? => 마지막 노드 return
        if (now == -19)
            return;

        // 현재 노드가 마지막 노드가 아니라면?
        // 우선 현재 노드 출력함 => 출력할 땐 다시 문자로 변환하여 출력
        System.out.print((char)(now + 65));

        // 현재 노드의 왼쪽 노드[0]와 오른족 노드[1]를 또 전위 순회함
        preorder(tree[now][0]);
        preorder(tree[now][1]);
    }

    // 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
    public static void inorder(int now) {
        if (now == -19)
            return;

        inorder(tree[now][0]);
        System.out.print(((char)(now + 65)));
        inorder(tree[now][1]);
    }

    // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
    public static void postorder(int now) {
        if (now == -19)
            return;

        postorder(tree[now][0]);
        postorder(tree[now][1]);
        System.out.print((char)(now + 65));
    }
}