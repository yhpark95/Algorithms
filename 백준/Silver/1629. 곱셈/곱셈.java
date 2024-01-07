import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long result = divideConquer(A, B, C);
		System.out.println(result);

	}

	private static long divideConquer(int A, int B, int C) {
		if (B <= 1) {
			return A % C;
		}
		long multiplier = 0;
		int b = B / 2;
		multiplier = divideConquer(A, b, C);
		multiplier *= multiplier;
		multiplier %= C;
		if(B %2 != 0){
			multiplier *= A;
		}
		return multiplier % C;
	}
}
