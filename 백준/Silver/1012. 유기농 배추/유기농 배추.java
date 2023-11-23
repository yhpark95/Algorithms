import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] baechu;
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};

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
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			visited = new boolean[y + 1][x + 1];
			baechu = new int[y + 1][x + 1];
			List<Points> points = new ArrayList<>();
			for (int j = 0; j < g; j++) {
				st = new StringTokenizer(br.readLine());
				int vert = Integer.parseInt(st.nextToken());
				int horz = Integer.parseInt(st.nextToken());
				baechu[horz][vert] = 1;
				points.add(new Points(vert, horz));
			}
			int count = 0;
			for (int j = 0; j < points.size(); j++) {
				Points point = points.get(j);
				if (!visited[point.y][point.x]) {
					BFS(point);
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));

	}

	private static void BFS(Points point) {
		Queue<Points> q = new ArrayDeque<>();
		q.add(point);
		while (!q.isEmpty()) {
			Points points = q.poll();
			for (int i = 0; i < 4; i++) {
				Points newPoints = new Points(points.x + dx[i], points.y + dy[i]);
				if(newPoints.y > visited.length || newPoints.x > visited[0].length
				|| newPoints.x < 0 || newPoints.y < 0){
					continue;
				}
				if(visited[newPoints.y][newPoints.x]){
					continue;
				}
				visited[newPoints.y][newPoints.x] = true;
				if(baechu[newPoints.y][newPoints.x] == 1){
					q.add(newPoints);
				}

			}
		}
	}
}
