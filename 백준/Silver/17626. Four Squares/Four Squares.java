import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 5;
		int a = (int)Math.sqrt(N);
		for (int i = a; i >= a / 2 - 1; i--) {
			int rest1 = N - i * i;
			if (rest1 == 0) {
				count = 1;
				break;
			}
			if (rest1 < 0) {
				break;
			}
			int limit1 = (int)Math.sqrt(rest1);
			for (int j = limit1; j >= limit1 / 2 - 1; j--) {
				int rest2 = rest1 - j * j;
				if (rest2 == 0) {
					count = 2;
					break;
				}
				if (rest2 < 0) {
					break;
				}
				int limit2 = (int)Math.sqrt(rest2);
				for (int k = limit2; k >= limit2 / 2 - 1; k--) {
					int rest3 = rest2 - k * k;
					if (rest3 == 0) {
						count = Math.min(count, 3);
						break;
					}
					if (rest3 < 0) {
						break;
					}
					int limit3 = (int)Math.sqrt(rest3);
					for (int h = limit3; h >= limit3 / 2 - 1; h--) {
						int rest4 = rest3 - h * h;
						if (rest4 == 0) {
							count = Math.min(count, 4);
							break;
						}
						if (rest4 < 0) {
							break;
						}
					}
				}

			}
		}

		System.out.println(count);
	}
}
