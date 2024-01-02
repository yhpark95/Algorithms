import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		Map<Integer, Set<Integer>> personPartyMap = new HashMap<>();
		Map<Integer, Set<Integer>> partyPersonMap = new HashMap<>();
		for(int i = 1; i <= N; i++){
			personPartyMap.put(i, new HashSet<>());
		}
		Set<Integer> truth = new HashSet<>();
		while (st.hasMoreTokens()){
			truth.add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i <= M; i++){
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			partyPersonMap.put(i, new HashSet<>());
			while(st.hasMoreTokens()){
				int person = Integer.parseInt(st.nextToken());
				personPartyMap.get(person).add(i);
				partyPersonMap.get(i).add(person);
			}
		}
		boolean changed = true;
		int count = 0;
		Set<Integer> truthParties = new HashSet<>();
		Set<Integer> newTruth = new HashSet<>();
		while(changed){
			changed = false;
			for(Integer person : truth){
				if(personPartyMap.containsKey(person)){
					Set<Integer> parties = personPartyMap.get(person);
					for(Integer party : parties){
						if(!truthParties.contains(party)){
							changed = true;
							count++;
							truthParties.add(party);
							newTruth.addAll(partyPersonMap.get(party));
						}

					}
				}
			}
			truth.addAll(newTruth);
		}
		int result = M - count;
		System.out.println(result);
	}
}
