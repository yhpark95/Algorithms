import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Map<Integer, Integer> map = new HashMap<>();
			map.put(n, x);
			map.put(m, y);
			int temp = Math.min(n,m);
			int denom = GDC(n,m);
			int count = 1;
			if(x==y && x <= n && y <= m){
				sb.append(x).append("\n");
				continue;
			}
			if(x == n){
				x = 0;
			}
			if(y == m){
				y = 0;
			}
			while (true) {
				int result = temp * count + map.get(temp);
				if(result % n == x && result % m == y){
					sb.append(result).append("\n");
					break;
				}
				count++;
				if(result > (n * m) /denom ){
					sb.append(-1).append("\n");
					break;
				}
			}
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

	private static int GDC(int n, int m) {
		int gcd = m;
		if (n % m != 0){
			gcd = GDC(m, n % m);
		}

		return gcd;
	}
}
