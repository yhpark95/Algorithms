import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0){
				sb.append(0).append("\n");
				continue;
			}
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String category = st.nextToken();
				map.put(category, map.getOrDefault(category, 1) + 1);
			}
			int result = 1;
			for (Integer number : map.values()) {
				result *= number;
			}
			sb.append(result - 1).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}
}
