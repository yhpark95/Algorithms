import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
	static int max = 10_000;

	static class NumberString {
		int n;
		String s;

		public NumberString(int n) {
			this.n = n;
			this.s = "";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<Function<Integer, Integer>> functionList = new ArrayList<>();
		functionList.add(Main::D);
		functionList.add(Main::S);
		functionList.add(Main::L);
		functionList.add(Main::R);
		List<String> functionNames = new ArrayList<>();
		functionNames.add("D");
		functionNames.add("S");
		functionNames.add("L");
		functionNames.add("R");
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Queue<NumberString> q = new ArrayDeque<>();
			q.add(new NumberString(A));
			boolean[] visited = new boolean[10000];
			while (!q.isEmpty()) {
				NumberString current = q.poll();
				visited[current.n] = true;
				for (int j = 0; j < 4; j++) {
					int next = functionList.get(j).apply(current.n);
					if (visited[next]) {
						continue;
					}
					visited[next] = true;
					NumberString nextNumberString = new NumberString(next);
					nextNumberString.s = current.s + functionNames.get(j);
					q.add(nextNumberString);
					if (next == B) {
						sb.append(nextNumberString.s).append("\n");
						q = new ArrayDeque<>();
						break;
					}
				}
			}

		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

	static int D(int n) {
		return n * 2 % max;
	}

	static int S(int n) {
		if (n == 0) {
			return 9999;
		}
		return n - 1;
	}

	static int L(int n) {
		int neo = n * 10;
		if (neo >= max) {
			int result = neo % max;
			result += neo / max;
			return result;
		}
		return neo;
	}

	static int R(int n) {
		int neo = n / 10;
		int remain = n % 10;
		return neo + remain * 1000;
	}
}
