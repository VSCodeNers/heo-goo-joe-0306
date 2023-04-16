// 백준 - 트리 순회(1991)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_1991 {
  static int N;
  static char[][] nodes;
  static boolean[] visited;
  static StringBuilder preResult, inResult, postResult;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine()); // 노드의 개수
    nodes = new char[N][3];

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int index = st.nextToken().charAt(0) - 'A';
      nodes[index][0] = (char) (index + 'A');
      nodes[index][1] = st.nextToken().charAt(0);
      nodes[index][2] = st.nextToken().charAt(0);
    }

    // 전위 순회
    preResult = new StringBuilder();
    visited = new boolean[N];
    
    visited[0] = true;
    preResult.append('A');
    preorderTraversal(0);
    
    System.out.println(preResult);

    // 중위 순회
    inResult = new StringBuilder();
    visited = new boolean[N];
    inorderTraversal(0);
    System.out.println(inResult);

    // 후위 순회
    postResult = new StringBuilder();
    visited = new boolean[N];

    visited[0] = true;
    postorderTraversal(0);
    postResult.append('A');
    
    System.out.println(postResult);
  }

  // 전위 순회
  static void preorderTraversal(int prePosition) {
    // 왼쪽 자식 노드가 있는 경우
    if(nodes[prePosition][1] != '.') {
      int nextPosition = (int) (nodes[prePosition][1] - 'A');
      // 방문한 적이 없는 경우
      if(!visited[nextPosition]) {
        visited[nextPosition] = true;
        preResult.append(nodes[prePosition][1]);
        preorderTraversal(nextPosition); // 왼쪽 노드로 탐방
      }
    }

    // 오른쪽 자식 노드가 있는 경우
    if(nodes[prePosition][2] != '.') {
      int nextPosition = (int) (nodes[prePosition][2] - 'A');
      // 방문한 적이 없는 경우
      if(!visited[nextPosition]) {
        visited[nextPosition] = true;
        preResult.append(nodes[prePosition][2]);
        preorderTraversal(nextPosition); // 오른쪽 노드로 탐방
      }
    }
  }

  // 중위 순회
  static void inorderTraversal(int prePosition) {
    // 왼쪽 자식 노드가 있는 경우
    if(nodes[prePosition][1] != '.') {
      int nextPosition = (int) (nodes[prePosition][1] - 'A');
      // 방문한 적이 없는 경우
      if(!visited[nextPosition]) {
        visited[nextPosition] = true;
        inorderTraversal(nextPosition); // 왼쪽 노드로 탐방
      }
    }

    visited[prePosition] = true;
    inResult.append(nodes[prePosition][0]);

    // 오른쪽 자식 노드가 있는 경우
    if(nodes[prePosition][2] != '.') {
      int nextPosition = (int) (nodes[prePosition][2] - 'A');
      // 방문한 적이 없는 경우
      if(!visited[nextPosition]) {
        visited[nextPosition] = true;
        inorderTraversal(nextPosition); // 오른쪽 노드로 탐방
      }
    }
  }

  // 후위 순회
  static void postorderTraversal(int prePosition) {
    // 왼쪽 자식 노드가 있는 경우
    if(nodes[prePosition][1] != '.') {
      int nextPosition = (int) (nodes[prePosition][1] - 'A');
      // 방문한 적이 없는 경우
      if(!visited[nextPosition]) {
        visited[nextPosition] = true;
        postorderTraversal(nextPosition); // 왼쪽 노드로 탐방
        postResult.append(nodes[prePosition][1]);
      }
    }

    // 오른쪽 자식 노드가 있는 경우
    if(nodes[prePosition][2] != '.') {
      int nextPosition = (int) (nodes[prePosition][2] - 'A');
      // 방문한 적이 없는 경우
      if(!visited[nextPosition]) {
        visited[nextPosition] = true;
        postorderTraversal(nextPosition); // 오른쪽 노드로 탐방
        postResult.append(nodes[prePosition][2]);
      }
    }
  }
}