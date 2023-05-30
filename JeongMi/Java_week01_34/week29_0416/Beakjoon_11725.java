// 백준 - 트리의 부모 찾기(11725)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Beakjoon_11725 {
  static ArrayList<ArrayList<Integer>> tree;
  static int[] parentNode; // 부모 노드
  static boolean[] visited;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());

    // 트리 구조 표현을 위한 그래프 구현
		tree = new ArrayList<>();
		for (int i = 0; i < N; i++)
			tree.add(new ArrayList<>());

		// 그래프 입력
		for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
			tree.get(n1-1).add(n2-1);
			tree.get(n2-1).add(n1-1);
		}

    parentNode = new int[N + 1];
		visited = new boolean[N + 1];

    checkToBFS();

		StringBuilder printSet = new StringBuilder();
		for (int i = 1; i < N; i++)
      printSet.append(parentNode[i] + 1).append('\n');
    
    System.out.print(printSet);
  }

  static void checkToBFS() {
    Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int node : tree.get(v))
				if (!visited[node]) {
					visited[node] = true;
					queue.add(node);
					parentNode[node] = v; // 부모 노드 찾은 후 저장
				}
		}
  }
}
