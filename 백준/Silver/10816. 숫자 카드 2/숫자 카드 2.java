import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			if (map.containsKey(a)) {
				sb.append(map.get(a)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}
}
