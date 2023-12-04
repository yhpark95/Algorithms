import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] arr;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					pq.add(BFS(i, j));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));

	}

	private static int BFS(int n, int m) {
		Queue<Integer> xq = new ArrayDeque<>();
		Queue<Integer> yq = new ArrayDeque<>();
		xq.add(n);
		yq.add(m);
		visited[n][m] = true;
		int count = 1;
		while (!xq.isEmpty() && !yq.isEmpty()) {
			int x = xq.poll();
			int y = yq.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (nextY < 0 || nextX < 0 || nextX >= N || nextY >= N) {
					continue;
				}
				if (visited[nextX][nextY] || arr[nextX][nextY] == 0) {
					continue;
				}
				visited[nextX][nextY] = true;
				xq.add(nextX);
				yq.add(nextY);
				count++;
			}

		}
		return count;
	}
}
