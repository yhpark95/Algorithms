import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int[][] path = new int[N][M];
		Queue<Points> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				arr[i][j] = n;
				path[i][j] = Integer.MAX_VALUE;
				if (n == 2) {
					q.add(new Points(i, j));
					path[i][j] = 0;
				}
			}
		}
		while (!q.isEmpty()) {
			Points current = q.poll();
			int cx = current.x;
			int cy = current.y;
			visited[cx][cy] = true;
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(arr[nx][ny] == 0){
					continue;
				}
				int a = path[cx][cy] + 1;
				if (path[nx][ny] > a) {
					path[nx][ny] = a;
					q.add(new Points(nx, ny));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0){
					sb.append(0).append(" ");
					continue;
				} else if (!visited[i][j] && arr[i][j] == 1) {
					sb.append(-1).append(" ");
					continue;
				}
				sb.append(path[i][j]).append(" ");
			}
			sb.deleteCharAt(sb.length()-1).append("\n");
		}
		System.out.println(sb);

	}
}
