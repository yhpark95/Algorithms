import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> intMap = new HashMap<>();
		Map<String, Integer> stringMap = new HashMap<>();
		for(int i = 1; i<=N; i++){
			String name = br.readLine();
			intMap.put(i, name);
			stringMap.put(name, i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <M; i++){
			String input = br.readLine();
			try {
				int number = Integer.parseInt(input);
				sb.append(intMap.get(number)).append("\n");
			} catch (Exception e){
				sb.append(stringMap.get(input)).append("\n");
			}
		}
		System.out.println(sb.deleteCharAt(sb.length()-1));
	}
}
