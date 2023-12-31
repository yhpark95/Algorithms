import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Map<String, Integer> mbti;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			if (N > 48) {
				sb.append(0).append("\n");
				continue;
			}
			boolean moreThanThree = false;
			mbti = new HashMap<>();
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				mbti.put(str, mbti.getOrDefault(str, 0) + 1);
			}
			for (Integer n : mbti.values()) {
				if (n >= 3) {
					moreThanThree = true;
					break;
				}
			}
			if (moreThanThree) {
				sb.append(0).append("\n");
				continue;
			}
			int result = calculate(mbti);
			sb.append(result).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

	private static int calculate(Map<String, Integer> mbti) {
		List<String> list = new ArrayList<>();
		for (String key : mbti.keySet()) {
			int count = mbti.get(key);
			while (count-- > 0) {
				list.add(key);
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int a = compare(list.get(i), list.get(j));
				for (int k = j + 1; k < list.size(); k++) {
					int b = compare(list.get(j), list.get(k));
					int c = compare(list.get(i), list.get(k));
					int ab = a + b + c;
					if (ab < result) {
						result = ab;
					}
				}
			}
		}
		return result;
	}

	private static int compare(String s, String s1) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s1.charAt(i)) {
				sum += 1;
			}
		}
		return sum;
	}
}
