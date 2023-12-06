import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> stringList = new ArrayList<>();
		List<Deque<Integer>> dequeList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			stringList.add(br.readLine());
			int M = Integer.parseInt(br.readLine());
			dequeList.add(new ArrayDeque<>());
			String str = br.readLine();
			String noBrackets = str.substring(1, str.length() -1);
			String[] arr = noBrackets.split(",");
			for (int j = 0; j < M; j ++) {
				dequeList.get(i).add(Integer.parseInt(arr[j]));
			}
		}
		boolean isError = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			boolean isFirst = true;
			String str = stringList.get(i);
			Deque<Integer> deque = dequeList.get(i);
			for (int j = 0; j < str.length(); j++) {
				switch (str.charAt(j)) {
					case 'R':
						isFirst = !isFirst;
						break;
					case 'D':
						if (dequeList.get(i).isEmpty()) {
							isError = true;
							break;
						}
						if (isFirst) {
							deque.pollFirst();
						} else {
							deque.pollLast();
						}
						break;
				}
			}
			if (isError) {
				sb.append("error").append("\n");
			} else {
				sb.append("[");
				if(deque.isEmpty()){
					sb.append(",");
				}
				while (!deque.isEmpty()) {
					if (isFirst) {
						sb.append(deque.pollFirst());
					} else {
						sb.append(deque.pollLast());
					}
					sb.append(",");
				}
				sb.deleteCharAt(sb.length() - 1).append("]").append("\n");
			}
			isError = false;
		}
		System.out.println(sb);

	}
}
