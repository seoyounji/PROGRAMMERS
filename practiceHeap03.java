package PROGRAMMERS;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//프로그래머스 코딩테스트 연습 / 힙 / 이중우선순위큐
public class practiceHeap03 {

	public int[] solution(String[] operations) {
		boolean flag = true;
		PriorityQueue<Integer> toBig = new PriorityQueue<>();
		PriorityQueue<Integer> toSmall = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < operations.length; i++) {
			String tmp = operations[i];
			StringTokenizer st = new StringTokenizer(tmp);
			String work = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(work.equals("I")) {
				if(flag) toBig.add(num);
				else toSmall.add(num);
			}
			
			else {
				if(num == 1) { 
					if(flag) { 
						if(toBig.isEmpty()) continue;
						while(!toBig.isEmpty()) {
							toSmall.add(toBig.poll());
						}
						toSmall.poll();
						flag = false;
					} else { 
						if(toSmall.isEmpty()) continue;
						toSmall.poll();
					}
				} else { 
					if(flag) { 
						if(toBig.isEmpty()) continue;
						toBig.poll();
					} else { 
						if(toSmall.isEmpty()) continue;
						while(!toSmall.isEmpty()) {
							toBig.add(toSmall.poll());
						}
						toBig.poll();
						flag = true;
					}
				}
			}
		}
		int[] answer = new int[2];
		if(toBig.isEmpty() && toSmall.isEmpty()) {
			answer[0] = 0; answer[1] = 0;
		} else {
			if(flag) {
				answer[1] = toBig.poll();
				while(!toBig.isEmpty()) toSmall.add(toBig.poll());
				answer[0] = toSmall.poll();
			} else {
				answer[0] = toSmall.poll();
				while(!toSmall.isEmpty()) toBig.add(toSmall.poll());
				answer[1] = toBig.poll();
			}
		}
		
		return answer;
	}

}
