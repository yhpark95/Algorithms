import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H;
	static int N;
	static int M;
	static int[] dn = {0, 0, 1, -1, 0, 0};
	static int[] dm = {1, -1, 0, 0, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static int[][][] arr;
	static boolean[][][] visited;
	static int max = 1;

	static class Points {
		int h;
		int n;
		int m;

		public Points(int h, int n, int m) {
			this.h = h;
			this.n = n;
			this.m = m;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		visited = new boolean[H][N][M];
		List<Points> pointsList = new ArrayList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 1) {
						pointsList.add(new Points(i, j, k));
					}
					arr[i][j][k] = n;
				}
			}
		}
		if (pointsList.isEmpty()) {
			System.out.println(-1);
			return;
		}
		BFS(pointsList);
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(max - 1);
	}

	private static void BFS(List<Points> pointsList) {
		Queue<Points> q = new ArrayDeque<>(pointsList);
		while (!q.isEmpty()) {
			Points current = q.poll();
			visited[current.h][current.n][current.m] = true;
			for (int i = 0; i < 6; i++) {
				int nh = current.h + dh[i];
				int nn = current.n + dn[i];
				int nm = current.m + dm[i];
				if (nh < 0 || nn < 0 || nm < 0 || nh >= H || nn >= N || nm >= M) {
					continue;
				}
				if (visited[nh][nn][nm] || arr[nh][nn][nm] == -1 || arr[nh][nn][nm] == 1) {
					continue;
				}
				int days = arr[current.h][current.n][current.m] + 1;
				arr[nh][nn][nm] = days;
				if (days > max) {
					max = days;
				}
				visited[nh][nn][nm] = true;
				q.add(new Points(nh, nn, nm));
			}
		}

	}
}
