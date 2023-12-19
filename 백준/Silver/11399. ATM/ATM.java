import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()){
			list.add(Integer.parseInt(st.nextToken()));
		}
		int time = 0;
		int result = 0;
		Collections.sort(list);
		for(int n : list){
			time += n;
			result += time;
		}
		System.out.println(result);
	}

}
