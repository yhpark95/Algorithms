import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int count = 0;
		int plen = 2 * N + 1;
		int b = str.length();
		int index = 0;
		for (int i = 0; i <= b - plen; i++) {
			if (str.charAt(i) == 'I') {
				boolean isMatch = true;
				int temp = Math.max(i, index);
				while (temp < i + plen - 1) {
					if (!str.startsWith("OI", temp + 1)) {
						isMatch = false;
						break;
					}
					temp += 2;
				}
				if (isMatch) {
					index = i + plen - 1;
					count++;
				} else {
					i = temp;
				}
			}
		}
		System.out.println(count);

	}
}
