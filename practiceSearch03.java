package PROGRAMMERS;

//프로그래머스 코딩테스트 연습 / 완전탐색 / 카펫
public class practiceSearch03 {

	public int[] solution(int brown, int yellow) {
		int tmp = 3;
		while(true) {
			if((brown-(2*tmp))*(tmp-2) == 2*yellow) break;
			else tmp++;
		}
		int temp = (yellow/(tmp-2))+2;
		int[] answer = new int[2];
		if(tmp>temp) {
			answer[0] = tmp;
			answer[1] = temp;
		} else {
			answer[0] = temp;
			answer[1] = tmp;
		}
		return answer;
	}

}
