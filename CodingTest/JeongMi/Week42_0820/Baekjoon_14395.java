// 백준 - 4연산(14395)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;

public class Baekjoon_14395 {
  static class Node{
		long num;
		String cal; // 연산식
		Node(long num, String cal){
			this.num = num;
			this.cal = cal;
		}
	}
	
	static final long limit = 1000000000L;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long s = Integer.parseInt(st.nextToken());
    long t = Integer.parseInt(st.nextToken());

    if(s == t) {
      System.out.print(0);
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    HashSet<Long> check = new HashSet<Long>(); // 이미 이전에 도달한 값인지 확인  

    queue.add(new Node(s, ""));
    check.add(s);

    while(!queue.isEmpty()) {
      Node pre = queue.poll();
      long num = pre.num;
      String cal = pre.cal;

      if(num == t) {
        System.out.print(cal);
        return;
      }

      // *
      if(num != 0 && num*num <= limit && !check.contains(num*num)) {
        queue.add(new Node(num*num, cal + "*"));
        check.add(num*num);
      }
      // +
      if(num >= 0 && num+num <= limit && !check.contains(num+num)) {
        queue.add(new Node(num+num, cal + "+"));
        check.add(num+num);
      }
      // -
      if(!check.contains(0L)) {
        queue.add(new Node(0, cal + "-"));
        check.add(0L);
      }
      // /
      if(num != 0 && !check.contains(1L)) {
        queue.add(new Node(1, cal + "/"));
        check.add(1L);
      }
    }

    System.out.print(-1);
  }
}
