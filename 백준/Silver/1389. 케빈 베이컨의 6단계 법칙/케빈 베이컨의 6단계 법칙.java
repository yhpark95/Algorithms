import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int count = BFS(i, N);
			if(count < min){
				min = count;
				result = i;
			}
		}
		System.out.println(result);

	}

	private static int BFS(int n, int N) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		boolean[] visited = new boolean[N + 1];
		int depth = 1;
		int size = q.size();
		int count = 0;
		int sum = 0;
		while (!q.isEmpty()) {
			int a = q.poll();
			visited[a] = true;
			for (Integer i : list.get(a)) {
				if (visited[i]) {
					continue;
				}
				visited[i] = true;
				sum += depth;
				q.add(i);
			}
			count++;
			if (count == size) {
				depth++;
				size = q.size();
				count = 0;
			}
		}
		return sum;
	}
}
