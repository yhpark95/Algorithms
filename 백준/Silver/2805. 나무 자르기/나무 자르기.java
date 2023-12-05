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
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		Queue<Integer> q = new ArrayDeque<>();
		int result = 0;
		int index = arr.length - 1;
		int height = arr[index];
		q.add(arr[index]);
		while(index > 0 && arr[index] == arr[index - 1]){
			q.add(arr[--index]);
		}
		while (result < M) {
			if (index > 0 && arr[index - 1] == height) {
				index--;
				q.add(arr[index]);
				while(index > 0 && arr[index] == arr[index - 1]){
					q.add(arr[--index]);
				}
			}
			height--;
			result += q.size();
		}
		System.out.println(height);
	}
}
