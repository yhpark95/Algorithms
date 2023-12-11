import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, Integer> treeMap;
		for (int i = 0; i < N; i++) {
			treeMap = new TreeMap<>();
			int T = Integer.parseInt(br.readLine());
			for (int j = 0; j < T; j++) {
				st = new StringTokenizer(br.readLine());
				String instruction = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				switch (instruction) {
					case "I":
						treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
						break;
					case "D":
						if (treeMap.isEmpty()) {
							break;
						}
						if (n == 1) {
							int max = treeMap.lastKey();
							if (treeMap.get(max) == 1) {
								treeMap.pollLastEntry();
								break;
							}
							treeMap.put(max, treeMap.get(max) - 1);
							break;
						}
						if (n == -1) {
							int min = treeMap.firstKey();
							if (treeMap.get(min) == 1) {
								treeMap.pollFirstEntry();
								break;
							}
							treeMap.put(min, treeMap.get(min) - 1);
							break;
						}
				}
			}
			if (treeMap.isEmpty()) {
				sb.append("EMPTY").append("\n");
				continue;
			}
			sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));

	}
}
