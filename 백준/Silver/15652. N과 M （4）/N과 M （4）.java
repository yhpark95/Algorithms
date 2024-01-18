import java.io.*;
import java.util.*;

public class Main {
	static int[] seq;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		seq = new int[M + 1];
		visited = new boolean[N + 1];
		backtracking(N, M, 1);
		System.out.println(sb.deleteCharAt(sb.length() - 1));

	}

	private static void backtracking(int N, int M, int length) {
		if (length > M) {
			for (int i = 1; i <= M; i++) {
				sb.append(seq[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (seq[length-1] <= i) {
				seq[length] = i;
				backtracking(N, M, length + 1);
			}
		}
	}
}
