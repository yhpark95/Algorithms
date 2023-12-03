import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[] color = new int[3];
	static int[] dx = {1, 0, 1};
	static int[] dy = {0, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int a = recursion(arr, N / 2, N / 2, N / 2);
		color[a]++;
		System.out.println(color[0] + "\n" + color[1]);
	}

	private static int recursion(int[][] arr, int x, int y, int N) {
		boolean same = true;
		int ref = arr[x][y];
		if (N == 1) {
			for (int i = 0; i < 3; i++) {
				if (ref != arr[x + dx[i]][y + dy[i]]) {
					same = false;
					break;
				}
			}
			if (!same) {
				color[ref]++;
				for (int i = 0; i < 3; i++) {
					color[arr[x + dx[i]][y + dy[i]]]++;
				}
				return 2;
			}
			return ref;
		}
		int a = recursion(arr, x - N / 2, y - N / 2, N / 2);
		int b = recursion(arr, x - N / 2, y + N / 2, N / 2);
		int c = recursion(arr, x + N / 2, y - N / 2, N / 2);
		int d = recursion(arr, x + N / 2, y + N / 2, N / 2);
		if(a == b && b==c & c==d){
			return a;
		}
		color[a]++;
		color[b]++;
		color[c]++;
		color[d]++;
		return 2;
	}
}
