import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			list.add(a);
			if (set.add(a)) {
				map.put(a, 0);
				pq.add(a);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int x = pq.poll();
			map.put(x, pq.size());
		}
		for (int i = 0; i < list.size(); i++) {
			sb.append(map.get(list.get(i))).append(" ");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));

	}
}
