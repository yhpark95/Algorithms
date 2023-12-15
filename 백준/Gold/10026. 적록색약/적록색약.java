import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dn = {0, 0, 1, -1};
	static int[] dm = {1, -1, 0, 0};
	static int T;

	static class Points {
		int n;
		int m;

		public Points(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

	static boolean[][] visited;
	static boolean[][] rvisited;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		visited = new boolean[T][T];
		rvisited = new boolean[T][T];
		map = new char[T][T];
		for (int i = 0; i < T; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
			}
		}
		Map<Character, Integer> result = new HashMap<>();
		result.put('B',0);
		result.put('R',0);
		result.put('G',0);
		result.put('C',0);
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T; j++) {
				char c = map[i][j];
				if (c == 'B') {
					if (visited[i][j]) {
						continue;
					}
					BFS(new Points(i, j));
					result.put(c, result.get(c) + 1);
				} else {
					if (!visited[i][j]) {
						RBFS(new Points(i, j));
						result.put(c, result.get(c) + 1);
					}
					if(!rvisited[i][j]){
						RGBFS(new Points(i, j));
						result.put('C', result.get('C') + 1);
					}
				}
			}
		}
		int rgb = result.get('B') + result.get('R') + result.get('G');
		int xb = result.get('B') + result.get('C');
		System.out.println(rgb + " " + xb);

	}

	private static void RGBFS(Points points) {
		Queue<Points> q = new ArrayDeque<>();
		q.add(points);
		while (!q.isEmpty()) {
			Points current = q.poll();
			rvisited[current.n][current.m] = true;
			for (int i = 0; i < 4; i++) {
				int nn = current.n + dn[i];
				int mm = current.m + dm[i];
				if (nn < 0 || mm < 0 || nn >= T || mm >= T) {
					continue;
				}
				if (rvisited[nn][mm]|| map[nn][mm] == 'B') {
					continue;
				}
				rvisited[nn][mm] = true;
				q.add(new Points(nn, mm));
			}
		}
	}

	private static void RBFS(Points points) {
		Queue<Points> q = new ArrayDeque<>();
		char c = map[points.n][points.m];
		q.add(points);
		while (!q.isEmpty()) {
			Points current = q.poll();
			visited[current.n][current.m] = true;
			for (int i = 0; i < 4; i++) {
				int nn = current.n + dn[i];
				int mm = current.m + dm[i];
				if (nn < 0 || mm < 0 || nn >= T || mm >= T) {
					continue;
				}
				if (visited[nn][mm]|| map[nn][mm] != c) {
					continue;
				}
				visited[nn][mm] = true;
				q.add(new Points(nn, mm));
			}
		}
	}

	private static void BFS (Points points){
		Queue<Points> q = new ArrayDeque<>();
		q.add(points);
		while (!q.isEmpty()) {
			Points current = q.poll();
			visited[current.n][current.m] = true;
			rvisited[current.n][current.m] = true;
			for (int i = 0; i < 4; i++) {
				int nn = current.n + dn[i];
				int mm = current.m + dm[i];
				if (nn < 0 || mm < 0 || nn >= T || mm >= T) {
					continue;
				}
				if (visited[nn][mm] || rvisited[nn][mm] || map[nn][mm] != 'B') {
					continue;
				}
				visited[nn][mm] = true;
				rvisited[nn][mm] = true;
				q.add(new Points(nn, mm));
			}
		}
	}
}
