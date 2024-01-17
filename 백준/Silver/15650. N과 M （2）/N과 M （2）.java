
import java.io.*;
import java.util.*;

public class Main {
	static Set<Set<Integer>> alreadyCreated = new HashSet<>();
	static boolean[] visited;
	static int[] seq;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		seq = new int[M + 1];
		backtracking(N, M, 1);
		System.out.println(sb.deleteCharAt(sb.length()-1));

	}

	private static void backtracking(int N, int M, int length) {
		if (length > M) {
			Set<Integer> set = new HashSet<>();
			Arrays.stream(seq).forEach(set::add);
			if(alreadyCreated.contains(set)) return;
			for(int i = 1; i <= M; i++){
				sb.append(seq[i]).append(" ");
			}
			alreadyCreated.add(set);
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				seq[length] = i;
				backtracking(N, M, length + 1);
				visited[i] = false;
			}
		}
	}
}
