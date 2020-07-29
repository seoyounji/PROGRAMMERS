package PROGRAMMERS;

import java.util.PriorityQueue;

//프로그래머스 코딩테스트 연습 / 힙 / 더 맵게
public class practiceHeap01 {

	private static boolean judge(PriorityQueue<Integer> queue,int K) {
		int top = queue.peek();
		if(top >= K) return true;
		else return false;
	}
	
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			priorityQueue.add(scoville[i]);
		}
		int answer = 0;
		while(!judge(priorityQueue,K)) {
			if(priorityQueue.size() == 1) {
				answer = -1;
				break;
			}
			int tmp1 = priorityQueue.poll();
			int tmp2 = priorityQueue.poll();
			int tmp3 = tmp1 + (tmp2*2);
			answer++;
			priorityQueue.add(tmp3);
		}
		return answer;
	}

}
