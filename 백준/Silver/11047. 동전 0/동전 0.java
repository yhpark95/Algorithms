import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		list.sort(Collections.reverseOrder());
		int index = 0;
		int result = 0;
		while (true){
			int num = list.get(index);
			if(num > K){
				index++;
				continue;
			}
			result += K / num;
			K = K % num;
			if(K == 0){
				break;
			}
		}
		System.out.println(result);

	}

}
