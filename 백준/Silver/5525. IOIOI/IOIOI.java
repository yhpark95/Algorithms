import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append("I");
		for (int i = 0; i < N; i++) {
			sb.append("OI");
		}
		String P = sb.toString();
		int count = 0;
		int a = P.length();
		int b = str.length();
		for (int i = 0; i <= b - a; i++) {
			if (str.charAt(i) == 'I') {
				String temp = str.substring(i, i + P.length());
				if(temp.equals(P)){
					count++;
				}
			}
		}
		System.out.println(count);

	}
}
