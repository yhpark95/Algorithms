import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] arr;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	static class Points {
		int x;
		int y;

		public Points(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		visited = new boolean[N][M];
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i].charAt(j) == 'I') {
					result = BFS(i, j);
				}
			}
		}
		if(result == 0){
			System.out.println("TT");
			return;
		}
		System.out.println(result);
	}

	private static int BFS(int n, int m) {
		Queue<Points> q = new ArrayDeque<>();
		q.add(new Points(n, m));
		int count = 0;
		while (!q.isEmpty()) {
			Points current = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (visited[nx][ny]) {
					continue;
				}
				if(arr[nx].charAt(ny) == 'X'){
					continue;
				}
				visited[nx][ny] = true;
				if(arr[nx].charAt(ny) == 'P'){
					count++;
				}
				q.add(new Points(nx, ny));
			}
		}
		return count;
	}
}
