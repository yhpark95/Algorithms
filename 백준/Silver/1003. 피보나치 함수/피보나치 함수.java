import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a > max) {
				max = a;
			}
			list.add(a);
		}
		StringBuilder sb = new StringBuilder();

		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		for (int i = 1; i < max + 1; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
		}
		for (int i : list) {
			sb.append(dp[i][0]).append(" ").append(dp[i][1]).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

}
