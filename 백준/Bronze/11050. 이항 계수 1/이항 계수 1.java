import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int n = 1;
		for(int i = 1; i <= N; i++){
			n *= i;
		}
		int k = 1;
		for(int i = 1; i <= K; i++){
			k *= i;
		}

		int m = 1;
		for(int i = 1; i <= N-K; i++){
			m *= i;
		}
		System.out.println(n/(k*m));


	}

}
