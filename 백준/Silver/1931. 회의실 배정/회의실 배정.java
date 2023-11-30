import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static class MeetingTime implements Comparable<MeetingTime> {
		int start;
		int end;
		int length = 0;
		MeetingTime meetingTime;

		public MeetingTime(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingTime meetingTime) {
			if(this.end == meetingTime.end){
				return this.start - meetingTime.start;
			}
			return this.end - meetingTime.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		MeetingTime[] list = new MeetingTime[N];
		for(int i = 0; i< N; i++){
			st = new StringTokenizer(br.readLine());
			list[i] = new MeetingTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(list);
		Set<MeetingTime> set = new HashSet<>();
		set.add(list[0]);
		int k = 0;
		for(int i = 1; i <N; i++){
			if(list[i].start >= list[k].end){
				set.add(list[i]);
				k = i;
			}
		}

		System.out.println(set.size());
	}
}
