package PROGRAMMERS;

//프로그래머스 코딩테스트 연습 / 완전탐색 / 소수 찾기
public class practiceSearch02 {

	private static int answer;
	private static boolean[] all;
	
	private static boolean judge(int[] output,int r) {
		int num = 0;
		int idx = 0;
		for (int i = r-1; i >= 0; i--) {
			num += output[i]*(Math.pow(10, idx++));
		}
		if(all[num]) return false;
		all[num] = true;
		if(num == 0 || num == 1) return false;
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		System.out.println(num);
		return true;
	}
	
	private static void perm(int[] arr,int[] output,boolean[] visited,int index,int n,int r) {
		if(index == r) {
			if(judge(output,r)) answer++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[index] = arr[i];
				perm(arr,output,visited,index+1,n,r);
				visited[i] = false;
			}
		}
	}
	public int solution(String numbers) {
		int N = numbers.length();
		char[] tmp = numbers.toCharArray();
		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = tmp[i] - '0';
		}
		answer = 0;
		all = new boolean[(int)Math.pow(10, N)];
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N];
			int[] output = new int[N];
			perm(number,output,visited,0,N,i);
		}
		return answer;
	}

}
