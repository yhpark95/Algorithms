import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] seq;
	static int[] values;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		seq = new int[M + 1];
		values = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(values);
		backtracking(N, M, 1);
		System.out.println(sb);
	}

	private static void backtracking(int N, int M, int length) {
		if (length > M) {
			for (int i = 1; i < M; i++) {
				if (seq[i + 1] < seq[i]) {
					return;
				}
			}
			for (int i = 1; i <= M; i++) {
				sb.append(seq[i]).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			seq[length] = values[i];
			backtracking(N, M, length + 1);
		}
	}
}
