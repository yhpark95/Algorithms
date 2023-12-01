import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position{
		int n;
		int m;

		public Position(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				String number = String.valueOf(str.charAt(j));
				arr[i][j] = Integer.parseInt(number);
			}
		}
		int depth = BFS(arr,N,M);

		System.out.println(depth);

	}

	private static int BFS(int[][] arr, int N, int M) {
		Queue<Position> q = new ArrayDeque<>();
		q.add(new Position(0,0));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		int depth = 1;
		int size = q.size();
		int count = 0;
		while(!q.isEmpty()){
			Position pos = q.poll();
			for(int i = 0; i < 4; i++){
				int nextPosN = pos.n + dx[i];
				int nextPosM = pos.m + dy[i];
				if(nextPosN >= N || nextPosN < 0 || nextPosM >= M ||nextPosM <0){
					continue;
				}
				if(visited[nextPosN][nextPosM]){
					continue;
				}
				if(arr[nextPosN][nextPosM] == 0){
					continue;
				}
				if(nextPosN == N -1 && nextPosM == M-1){
					return depth + 1 ;
				}
				visited[nextPosN][nextPosM] = true;
				q.add(new Position(nextPosN, nextPosM));
			}
			count++;
			if(count == size){
				depth++;
				size = q.size();
				count = 0;
			}
		}
		return depth;
	}

}
