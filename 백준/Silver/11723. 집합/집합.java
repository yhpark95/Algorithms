import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "add":
					set.add(Integer.parseInt(st.nextToken()));
					break;
				case "remove":
					set.remove(Integer.parseInt(st.nextToken()));
					break;
				case "check":
					if (set.contains(Integer.parseInt(st.nextToken()))) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "toggle":
					int n = Integer.parseInt(st.nextToken());
					if (set.contains(n)) {
						set.remove(n);
					} else {
						set.add(n);
					}
					break;
				case "all":
					IntStream.range(0, 21).forEach(set::add);
					break;
				case "empty":
					IntStream.range(0, 21).forEach(set::remove);
					break;
			}
		}
		System.out.print(sb);

	}
}
